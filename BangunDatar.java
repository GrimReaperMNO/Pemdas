import java.util.Scanner;

public class BangunDatar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pilihan;
        double p, l, t, r;

        do {
            System.out.println("\nMenu");
            System.out.println("0. KELUAR");
            System.out.println("1. HITUNG VOLUME BALOK");
            System.out.println("2. HITUNG VOLUME BOLA");
            System.out.println("3. HITUNG VOLUME KERUCUT");
            System.out.println("4. HITUNG VOLUME SILINDER");
            System.out.println("5. HITUNG VOLUME LIMAS SEGITIGA");
            System.out.print("\nMASUKKAN PILIHAN ANDA: ");
            pilihan = in.nextInt();

            switch (pilihan) {
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                case 1:
                    System.out.print("Masukkan panjang: ");
                    p = in.nextDouble();
                    System.out.print("Masukkan lebar: ");
                    l = in.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    t = in.nextDouble();
                    System.out.printf("Volume Balok          : %.2f cm3%n", p * l * t);
                    break;
                case 2:
                    System.out.print("Masukkan r: ");
                    r = in.nextDouble();
                    System.out.printf("Volume Bola           : %.2f cm3%n", 4.0 / 3 * Math.PI * r * r * r);
                    break;
                case 3:
                    System.out.print("Masukkan r: ");
                    r = in.nextDouble();
                    System.out.print("Masukkan t: ");
                    t = in.nextDouble();
                    System.out.printf("Volume Kerucut        : %.2f cm3%n", 1.0 / 3 * Math.PI * r * r * t);
                    break;
                case 4:
                    System.out.print("Masukkan r: ");
                    r = in.nextDouble();
                    System.out.print("Masukkan t: ");
                    t = in.nextDouble();
                    System.out.printf("Volume Silinder       : %.2f cm3%n", Math.PI * r * r * t);
                    break;
                case 5:
                    System.out.print("Masukkan alas segitiga: ");
                    p = in.nextDouble();
                    System.out.print("Masukkan tinggi segitiga: ");
                    l = in.nextDouble();
                    System.out.print("Masukkan tinggi limas: ");
                    t = in.nextDouble();
                    System.out.printf("Volume Limas Segitiga : %.2f cm3%n", 1.0 / 3 * (0.5 * p * l) * t);
                    break;
                default:
                    System.out.println("Data tak ditemukan.");
                }
        } while (pilihan != 0);

        in.close();
    }
}