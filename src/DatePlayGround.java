import java.text.*;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

public class DatePlayGround {

    public static void main(String args[] ) throws ParseException {

        final String DATE_FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ssZ";
        final String BUSINESS_TIME_OUTPUT_FORMAT="h:mm aa";
        final String BUSINESS_DATE_OUTPUT_FORMAT="M/d";

        String zoneId = "America/Chicago";
        String userOrderZoneId = "US/Eastern";

        String DateInString = "2021-04-05T14:00:00Z";

        final DateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date orderDate = simpleDateFormat.parse(DateInString);

        System.out.println("orderDate::"+orderDate);

        LocalDateTime currentDateTimeCST = getCurrentLocalDateTime(ZoneId.of(zoneId));

        System.out.println("currentDateTimeCST::"+currentDateTimeCST);

        LocalDateTime currentDateTime = getCurrentLocalDateTime(ZoneId.of(userOrderZoneId));

        System.out.println("currentDateTime::"+currentDateTime);

        LocalDateTime pickupStartTime = LocalDateTime
                .ofInstant(orderDate.toInstant(), ZoneId.of(userOrderZoneId));

        System.out.println("pickupStartTime::"+pickupStartTime);

        Duration between = Duration.between(currentDateTime, pickupStartTime);

        System.out.println("between::"+between);

        long differenceInMinutes = between.toMinutes();

        System.out.println("differenceInMinutes::"+differenceInMinutes);

        Date currentDateTime1 = getCurrentDateInUTC();
        String businessTime = dateToString(BUSINESS_TIME_OUTPUT_FORMAT, currentDateTime1,
                TimeZone.getTimeZone(userOrderZoneId));
        String businessDate = dateToString(BUSINESS_DATE_OUTPUT_FORMAT, currentDateTime1,
                TimeZone.getTimeZone(userOrderZoneId));

        String businessWholeDate = dateToString(DATE_FORMAT_ISO_8601, currentDateTime1,
                TimeZone.getTimeZone(zoneId));

        System.out.println("businessTime::"+businessTime);
        System.out.println("businessDate::"+businessDate);
        System.out.println("businessWholeDate::"+businessWholeDate);

        //isLate();

        System.out.println(changeTimeTo24Hour("12:00 AM"));
        System.out.println(changeTimeTo24Hour("11:59 PM"));
        System.out.println(changeTimeTo24Hour("02:00 PM"));
        System.out.println(changeTimeTo24Hour("02:00 AM"));

        LocalTime.parse(changeTimeTo24Hour("12:00 AM"));

        System.out.println(changeDayFormat(changeTimeTo24Hour("12:00 AM")));
        System.out.println(changeDayFormat(changeTimeTo24Hour("11:59 PM")));
        System.out.println(changeDayFormat(changeTimeTo24Hour("02:00 PM")));
        System.out.println(changeDayFormat(changeTimeTo24Hour("02:00 AM")));



    }

    private static void isLate() {

        DateTime dateTime = new DateTime("08:00 AM", "02:30 AM");
        DateTime dateTime1 = new DateTime("08:00 AM", "12:00 PM");
        DateTime dateTime2 = new DateTime("08:00 AM", "12:00 AM");

        List<DateTime> dateTimeList = new ArrayList<>();

        dateTimeList.add(dateTime);
        dateTimeList.add(dateTime1);
        dateTimeList.add(dateTime2);

        NestedDateTime nestedDateTime = new NestedDateTime(dateTimeList);
        NestedDateTime nestedDateTime1 = new NestedDateTime(dateTimeList);
        NestedDateTime nestedDateTime2 = new NestedDateTime(dateTimeList);

        List<NestedDateTime> NestedDateTimeList = new ArrayList<>();
        NestedDateTimeList.add(nestedDateTime);
        NestedDateTimeList.add(nestedDateTime1);
        NestedDateTimeList.add(nestedDateTime2);


        NestedDateTimeList.forEach(nestedDate -> nestedDate.getNestedDateTime().stream()
                .map(u -> {
                    LocalTime startTime = null;
                    LocalTime endTime = null;
                    try {
                        startTime = LocalTime.parse(changeTimeTo24Hour(u.startTime));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    try {
                        endTime = LocalTime.parse(changeTimeTo24Hour(u.endTime));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    //LocalTime endTime = LocalTime.parse(u.endTime);
                    if (endTime.isBefore(startTime)) {
                        u.setEndTime("23:59");
                    }
                    return u;
                })
                .collect(Collectors.toList()));


    }

    public static LocalDateTime getCurrentLocalDateTime(ZoneId zoneId) {
        return LocalDateTime.now(zoneId);
    }

    public static Date getCurrentDateInUTC(){
        return Date.from(Instant.now());
    }

    public static boolean isToday(Date date)
    {
        return isSameDay(getCurrentDateInUTC(),date);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            return isSameDay(cal1, cal2);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 != null && cal2 != null) {
            return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
        } else {
            throw new IllegalArgumentException("The date must not be null");
        }
    }

    public static String dateToString( final String dateFormat, final Date date, TimeZone tz ) {
        final DateFormat simpleDateFormat = new SimpleDateFormat( dateFormat );
        simpleDateFormat.setTimeZone(tz);
        return simpleDateFormat.format( date );
    }

    public static Date stringToDate( final String date, final String format ) throws ParseException {
        final DateFormat dateFormat = new SimpleDateFormat( format );
        dateFormat.setLenient( false );
        return dateFormat.parse( date );

    }


    static class DateTime {
        private String startTime;
        private String endTime;

        public DateTime(final String startTime, final String endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(final String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(final String endTime) {
            this.endTime = endTime;
        }
    }

    static class NestedDateTime {
        private List<DateTime> nestedDateTime;

        public NestedDateTime(final List<DateTime> nestedDateTime) {
            this.nestedDateTime = nestedDateTime;
        }

        public List<DateTime> getNestedDateTime() {
            return nestedDateTime;
        }

        public void setNestedDateTime(final List<DateTime> nestedDateTime) {
            this.nestedDateTime = nestedDateTime;
        }
    }

    private static String changeTimeTo24Hour(String time) throws ParseException {

        Date date = stringToDate(time, "hh:mm a");
        String dateResult = new SimpleDateFormat("HH:mm").format(date);

        return dateResult;
    }

    private static String changeDayFormat(String time) throws ParseException {

        Date date = stringToDate(time, "H:mm");
        String dateResult = new SimpleDateFormat("K:mm a").format(date);

        return dateResult;
    }

}
