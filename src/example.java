import java.text.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class example {

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int i=0;i<testCases;i++) {
            int n = sc.nextInt();

            ArrayList<Integer> strengthVillains = new ArrayList();
            ArrayList<Integer> strengthPlayers = new ArrayList();

            for (int j=0;j<n;j++) {
                strengthVillains.add(sc.nextInt());
            }

            for (int j=0;j<n;j++) {
                strengthPlayers.add(sc.nextInt());
            }

            Collections.sort(strengthVillains, Collections.reverseOrder());
            Collections.sort(strengthPlayers, Collections.reverseOrder());

            boolean flag = true;

            for (int j=0;j<n;j++) {
                if (strengthVillains.get(j)> strengthPlayers.get(j)) {
                    flag = false;
                }
            }
            if(flag==true) {
                System.out.println("WIN");
            } else {
                System.out.println("LOSE");
            }
        }

        /*US/Alaska ----> AKST
        US/Aleutian ----> HAST
        US/Pacific ----> PST
        US/Mountain ----> MST
        US/Eastern ----> EST
        US/Central ----> CST*/

        String s1 = TimeZone.getTimeZone("US/Central")
                .getDisplayName(false, TimeZone.SHORT);

        String s2 = TimeZone.getTimeZone("US/Eastern")
                .getDisplayName(false, TimeZone.SHORT);

        String s3 = TimeZone.getTimeZone("US/Mountain")
                .getDisplayName(false, TimeZone.SHORT);

        String s4 = TimeZone.getTimeZone("US/Pacific")
                .getDisplayName(false, TimeZone.SHORT);

        String s5 = TimeZone.getTimeZone("US/Aleutian")
                .getDisplayName(false, TimeZone.SHORT);

        String s6 = TimeZone.getTimeZone("US/Alaska")
                .getDisplayName(false, TimeZone.SHORT);

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        Date date = Date.from(localDateTime.atZone(ZoneId.of("America/Los_Angeles")).toInstant());

        final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("US/Central"));
        String s = simpleDateFormat.format(date);

        System.out.println("WIN:::"+s1);
        System.out.println("WIN:::"+s2);
        System.out.println("WIN:::"+s3);
        System.out.println("WIN:::"+s4);
        System.out.println("WIN:::"+s5);
        System.out.println("WIN:::"+s6);

        System.out.println("WIN:::"+localDateTime);
        System.out.println("WIN:::"+date);
        System.out.println("WIN:::"+s);

        //calculateProfit(l, F, P, F1, P1, F2, P2, s1, s2);
    }

    private static void calculateProfit(double l, double f, double p, double f1, double p1, double f2, double p2, double s1, double s2) {

        Scanner sc = new Scanner(System.in);

        double L = sc.nextDouble();
        double F = sc.nextDouble();
        double P = sc.nextDouble();

        double F1 = sc.nextDouble();
        double P1 = sc.nextDouble();

        double F2 = sc.nextDouble();
        double P2 = sc.nextDouble();

        double S1 = sc.nextDouble();
        double S2 = sc.nextDouble();

        double profit=0, wheatArea=0, riceArea=0;

        double totalWheatUnit = Math.min(f/f1, p/p1);

        double totalRiceUnit = Math.min(f/f2, p/p2);

        double profit1 = totalWheatUnit * s1;
        double profit2 = totalRiceUnit * s2;

        double x1 = ((p*f2) - (f*p2))/((p1*f2)-(f1*p2));
        double y1 = (f-(f1*x1))/f2;

        double profit3 = (s1*x1)+(s2*y1);

        double profit4 = Math.max(profit1, profit2);

        profit = Math.max(profit3, profit4);

        if(profit == profit1) {
            wheatArea = totalWheatUnit;
            riceArea = 0;
        } else if(profit == profit2) {
            wheatArea = 0;
            riceArea = totalRiceUnit;
        } else {
            wheatArea = x1;
            riceArea = y1;
        }

        System.out.println(df2.format(profit)+ " " + df2.format(wheatArea)+ " "+ df2.format(riceArea));
    }



    public static char[] konversiNilai (double[] x) {
        int n = x.length;
        char[] hasil = new char [n];

        for (int i = 0; i < n; i++) {
            if (x[i] > 80) {
                hasil[i] = 'A';
            } else if(x[i] > 60) {
                hasil[i] = 'B';
            } else if(x[i] > 40) {
                hasil[i] = 'C';
            } else if(x[i] > 20) {
                hasil[i] = 'D';
            } else {
                hasil[i] = 'E';
            }
        }
        return hasil;
    }
}