package Sorting;

import java.text.*;
import java.time.*;
import java.util.*;

public class ExceptionExample {

    public static void main(String[] args) throws ParseException {

        /*String date = "2020-10-31 08:10:00";
        String format = "yyyy-MM-dd'T'HH:mm:ss";
        final DateFormat dateFormat = new SimpleDateFormat( format );
        dateFormat.setLenient( false );

        Date date1=dateFormat.parse(date);
        System.out.println("Date::"+ date1);
        String format1 = "yyyy-MM-dd'T'HH:mm:ss";
        ZoneId zoneId = ZoneId.of("America/Chicago");
        final DateFormat simpleDateFormat = new SimpleDateFormat(format1);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(zoneId));
        System.out.println("Date1111::"+ date1);*/

        Clock clock = Clock.system(ZoneId.of("America/Chicago"));
        System.out.println(clock.instant());
        //LocalDateTime currentTime =  LocalDateTime.now(clock);

        //LocalDateTime time = currentTime.plusMinutes(0);
        //Date date2 = Date.from(time.atZone(clock.getZone()).toInstant());
        //System.out.println("Date22::"+ date2);

        LocalDateTime currentTime =  LocalDateTime.now(clock);
        LocalDateTime startDateTime = currentTime.minusMinutes(1);
        Date startDate = Date.from(startDateTime.atZone(clock.getZone()).toInstant());
        LocalDateTime time = currentTime.plusMinutes(30);
        Date endDate = Date.from(time.atZone(clock.getZone()).toInstant());

        LocalDateTime time1 = currentTime.plusMinutes(25);
        Date actualDate = Date.from(time1.atZone(clock.getZone()).toInstant());

        if(actualDate.compareTo(startDate) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if(actualDate.compareTo(startDate) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if(actualDate.compareTo(startDate) == 0) {
            System.out.println("Both dates are equal");
        }

        if(actualDate.compareTo(endDate) > 0) {
            System.out.println("Date 1 occurs after Date 2");
        } else if(actualDate.compareTo(endDate) < 0) {
            System.out.println("Date 1 occurs before Date 2");
        } else if(actualDate.compareTo(endDate) == 0) {
            System.out.println("Both dates are equal");
        }

        System.out.println("startDate::"+ startDate);
        System.out.println("endDate::"+ endDate);

        int i = 6;
        if(i>7) {
            System.out.println("i::"+ i);
        } else if(i>5) {
            System.out.println("i2::"+ i);
        } else if(i<17) {
            System.out.println("i3::"+ i);
        }

    }
}
