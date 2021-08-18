import java.util.Scanner;

public class KonversiNilai {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] data = new double[10];
        char [] keluar;
        int i=0;
        while (i<10){
            System.out.print("data ke-"+(i+1)+":");
            data[i] = scan.nextDouble();
            i++;
        }
        System.out.println("=====================");
        System.out.println("|   Hasil Konversi  |");
        System.out.println("=====================");
        keluar = konversiNilai(data);
        //tampil hasil
        i=0;
        while (i<10){
            System.out.println(data[i]+"  "+keluar[i]);
            i++;
        }
    }

    public static char[] konversiNilai(double[] x) {
        int n = x.length;
        char hasil[] = new char[n];
        int i = 0;


        while(i < n) {
            int num=0;

            num = (x[i] > 80) && (x[i] <= 100) ? 1 : -1;
            num = (x[i] > 60) && (x[i] <= 80) ? 2 : num;
            num = (x[i] > 40) && (x[i] <= 60) ? 3 : num;
            num = (x[i] > 20) && (x[i] <= 40) ? 4 : num;
            num = (x[i] <= 20) ? 5 : num;

            switch(num){
                case 1 : hasil[i] = 'A'; break;
                case 2 : hasil[i] = 'B'; break;
                case 3 : hasil[i] = 'C'; break;
                case 4 : hasil[i] = 'D'; break;
                case 5 : hasil[i] = 'E'; break;
                default:
                    throw new IllegalStateException("Unexpected value: " + num);
            }


            i++;
        }
        return hasil;
    }
}
