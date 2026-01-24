package custom_executor;

import java.util.LinkedList;

public class CustomExecutorService {
	
	WorkerThread[] workerThreads;
	LinkedList<Runnable> queue;
	int pool;
	private volatile boolean isShutdown = false;
	public CustomExecutorService(int pool) {
		this.pool = pool;
		queue = new LinkedList<>();
		this.workerThreads = new WorkerThread[pool];
		
		for(int i = 0; i< pool ; i++) {
			workerThreads[i] = new WorkerThread("Worker Executor Thread" + i);
			workerThreads[i].start();
		}
		
	}
	
	public synchronized void put(Runnable t) throws InterruptedException {
		while(queue.size() == pool)
			wait();
		
		queue.offer(t);
		notifyAll();
	}
	
	public synchronized Runnable take() throws InterruptedException {
		while(queue.size() == 0 && !isShutdown)
			wait();
		
		Runnable t = queue.poll();
		notifyAll();
		
		return t;
	}
	
	public void submit(Runnable task) throws InterruptedException {
		put(task);
	}
	
	 public void shutdown() {
	        isShutdown = true;
	        synchronized (queue) {
	            queue.notifyAll(); // wake up all workers to terminate
	        }
	    }
	
	private class WorkerThread extends Thread {
		
		String name;
		public WorkerThread(String name) {
			super(name);
			this.name = name;
		}

		@Override
		public void run() {
			Runnable task;
			while(true) {
				//synchronized (queue) {
					
					if (isShutdown && queue.isEmpty()) {
                        break;
                    }

						try {
							System.out.println(name + ": ");
							task = take();
							task.run();
							//new Thread(task).start();
						}
						catch(Exception e) {
							
						}
					
				//}
				
				
			}
		}
	}
}
