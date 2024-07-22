package com.learn.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class UTCToESTTime {
	    public static void main(String[] args) {
	        // Example UTC date time string
	        //String utcDateTimeStr = "2024/02/02-01:51:52.467";
	        String utcDateTimeStr = "2024/05/22-01:51:52.467";
	        
	        TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
	        
	        // Define the formatter to parse and format the date time strings
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss.SSS");
	        
	        // Parse the UTC date time string into a LocalDateTime object
	        LocalDateTime localDateTime = LocalDateTime.parse(utcDateTimeStr, formatter);
	        
	        // Create a ZonedDateTime in UTC
	        ZonedDateTime utcZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC"));
	        
	        // Convert the UTC ZonedDateTime to EST (US/Eastern)
	        ZonedDateTime estZonedDateTime = utcZonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
	        System.out.println("ZonedDateTime estZonedDateTime : " + estZonedDateTime);
	        
	        
	        Date date = Date.from(Instant.ofEpochMilli(estZonedDateTime.toInstant().toEpochMilli()));
	        System.out.println("Convert to date obj AS EST : " + date);
	        
	        // Format the EST ZonedDateTime to a string
	        String estDateTimeStr = estZonedDateTime.format(formatter);
	        
	        // Print the EST date and time string
	        System.out.println("EST date and time: " + estDateTimeStr);
	        
	    }
}
