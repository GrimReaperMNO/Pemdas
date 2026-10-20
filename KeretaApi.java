import java.util.Scanner;
public class KeretaApi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Melihat Daftar Kereta Api");
        System.out.println("2. Melihat Daftar Kereta Api yang ada AC");
        System.out.println("3. Melihat Daftar Kereta Api yang ada Colokan");
        System.out.println("4. Memesan Tiket Kereta Api");
        System.out.println("5. Melihat Pesanan Tiket");
        System.out.println("0. Keluar");
        System.out.print("Masukkan nilai: ");
        int angka = input.nextInt();
    }
}