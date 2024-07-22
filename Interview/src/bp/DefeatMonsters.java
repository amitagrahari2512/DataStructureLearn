package bp;


/*
 * 
 * Array of Monsters -

A brave Knight "A" has an array of monsters to face, and will use a combination of might and magic to defeat as many as possible. In this challenge we'd like to know if the knight is successful at defeating them all, and if not, how many monsters are defeated.

A can see the monsters and their order ahead of time.  Despite being evil monsters they will politely queue and challenge A in the current order.  Knowing this, A can plan what to do so that it is optimal.
* The first monster will always be defeated by A's squires while A prepares for battle
* For each other monster there are two possibilities :

1) If the current monster is weaker than the previous one (i.e. enemies[curr] < enemies[curr-1]), The enemy surrenders - what goblin would face someone who has just defeated a dragon?
2) If the current monster is stronger than the previous one (i.e. enemies[curr] > enemies[curr-1]), then A has two options :
2.1) Might!  A fights the monster taking damage (reducing hitpoints by the difference between the current and the previous monster).
2.2) Magic!  A can drink an invulnerability potion, defeating the monster without taking damage.

Write a function that takes as initial parameters

* A list of monsters in order of how A will face them, with their strength as values;
* A’s initial hit points;
* A’s amount of invulnerability potions.

And returns

* The 0-based index of the last monster A defeated

Constraints:

* 0 <= enemies.length <= 10e6
* 1 <= enemies[i] <= 10e4
* 1 <= hp <= 10e5
* 0 <= potions <= 10e4
 * 
 * 
 * 
 */
public class DefeatMonsters {

	public static void main(String[] args) {
		int[] monsters = {3, 4, 2, 5, 10};
		int hitPoint = 10;
		int potions = 5;
		System.out.println("Monsters Defeated : " + defeatMonsters(monsters, hitPoint, potions));
	}

	private static int defeatMonsters(int[] monsters, int hitPoint, int potions) {
		int defeated = 1;
		int previousMonsters = monsters[0];
		for(int i = 1 ; i <  monsters.length ; i++ ) {
			int currentMonsters = monsters[i];
			if(currentMonsters < previousMonsters) {
				defeated +=1;
			}
			else
			{
				if(currentMonsters - previousMonsters <= hitPoint)
				{
					hitPoint -= currentMonsters - previousMonsters;
					defeated +=1;
				}
				else if(potions > 0){
					potions -=1;
					defeated +=1;
				}
				else {
					break;
				}
			}
			previousMonsters = currentMonsters;
		}
		//System.out.println(hitPoint  + "::" + potions);
		return defeated;
	}	

}
