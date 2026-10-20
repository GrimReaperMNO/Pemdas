import java.util.Scanner;

public class Segitiga {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan nilai n = ");
        int n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) {   // spasi
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {       // bintang
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}