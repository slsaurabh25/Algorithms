import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Package {
    private int invoiceNumber;
    private String fromCity;
    private String toCity;
    private String orderDate;
    private String deliveryDate;
    private double price;

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(final int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(final String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(final String toCity) {
        this.toCity = toCity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(final String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(final String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }
}

public class MyClass {

    public static void main(String[] args) throws IOException {

        Package package1 = new Package();
        //write all setters
        Package package2 = new Package();
        //write all setters

        Package[] packages = new Package[10];
        packages[0] = package1;
        packages[1] = package2;

        int result = countOrdersDeliveredInAWeek(packages, "Paris");

        if(result > 0) {
            System.out.println(result);
        } else {
            System.out.println("No Packages delivered within a week from the giver city");
        }

    }

    public static int countOrdersDeliveredInAWeek(Package[] packages, String parameter) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int count = 0;
        try {
            for (int i = 0; i < packages.length; i++) {
                if (packages[i].getToCity().equals(parameter)) {
                    LocalDate date1 = LocalDate.parse(packages[i].getOrderDate(), dtf);
                    LocalDate date2 = LocalDate.parse(packages[i].getDeliveryDate(), dtf);
                    long daysBetween = Duration.between(date1, date2).toDays();
                    if (daysBetween < 8) {
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
