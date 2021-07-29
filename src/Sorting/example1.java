package Sorting;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.*;
import java.util.*;


enum AgeRestrictedItemTypeEnum {
    Tobacco("Tobacco"),

    Alcohol("Alcohol");

    private String value;

    AgeRestrictedItemTypeEnum(String value) {
        this.value = value;
    }

    public static AgeRestrictedItemTypeEnum fromValue(String text) {
        for (AgeRestrictedItemTypeEnum b : AgeRestrictedItemTypeEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}


public class example1 {

    public static void main(String[] args) throws ParseException {


        String environmentType = "test";

        BigDecimal orderTotal1 = new BigDecimal(1.2);

        BigDecimal orderTotal = "production".equals(environmentType) ? orderTotal1:
                orderTotal1.setScale(0, RoundingMode.UP);

        System.out.println(orderTotal);

        //String pattern = "Order extraordinaire coming up! We cant wait to see you at {0}.";

        String pattern = "Order extraordinaire coming up! We can''t wait to see you at {0}.";

        final DateFormat dateFormat = new SimpleDateFormat( "yyyy-mm-dd hh:mm:ss" );
        dateFormat.setLenient( false );
        Date date = dateFormat.parse( "2020-11-20 05:30:00" );

        Object[] arguments= new Object[] {getPickupTime(date)};
        MessageFormat messageFormat = new MessageFormat( pattern );

        System.out.println(messageFormat.format(arguments));


        Long value = null;

        String value1 = null;

        String calories = null;

        if (null != value && null != value1) {
            calories = value + " " +value1;
        } else if(null != value) {
            calories = value.toString();
        } else if (null != value1) {
            calories = value1;
        }

        System.out.println(calories);

        Map<Long, Set<String>> discountMap= new HashMap<>();

        List<Long> keys = Arrays.asList(1L, 2L, 3L, 4L);

        List<String> values = Arrays.asList("1", "2", "3", "4", "1", "2", "3", "4");

        HashMap<Long,Set<String>> vocabulary = new HashMap<>();

        for (int i =0 ; i<keys.size();i++) {
            for (int j=0; j< 2;j++) {
                Set<String> data = vocabulary.get(keys.get(i));

                if (data == null) {
                    data = new HashSet<>();
                    vocabulary.put(keys.get(i), data);
                }
                data.add(values.get(j));
            }
        }

        vocabulary.forEach((id, name) -> {
            System.out.println("Key : " + id + " value : " + name);
        });

        Store store = new Store();

        /*List<Object> objects = null;
        for (Object object:objects) {

        }*/
        for (int i=0; i<2;i++) {
            List<Integer> stores = new ArrayList<>();
            stores.add(1);
            stores.add(2);
            if (store.getStoreId() ==null || store.getStoreId().isEmpty()) {
                store.setStoreId(stores);
            } else {
                store.getStoreId().addAll(stores);
            }
        }

        Store store1 = new Store();

        store1.setRequireBottleDeposit(false);

        if(store1 == null || !store1.getRequireBottleDeposit()) {
            System.out.println("Hello Saurabh");
        }

        Store store2 = null;

        if(store2 == null || !store2.getRequireBottleDeposit()) {
            System.out.println("Hello Saurabh1111");
        }

        Store store3 = new Store();
        store3.setRequireBottleDeposit(true);
        if(store3 == null || !store3.getRequireBottleDeposit()) {
            System.out.println("Hello Saurabh2222");
        }


        String asd = "0421";
        String expirtDate = asd.substring(0,2) + "/" + asd.substring(2,4);
        System.out.println("expirtDate" + expirtDate);


        AgeRestrictedItemTypeEnum ageRestrictedItemTypeEnum;
        ageRestrictedItemTypeEnum = null;

    }

    private static String getPickupTime(Date date) {

        final DateFormat simpleDateFormat = new SimpleDateFormat( "h:mma" );
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
        return simpleDateFormat.format( date );
    }
}
