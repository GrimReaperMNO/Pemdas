import java.util.Locale;
import java.util.Scanner;

public class IMT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.print("Berat badan (kg)  : ");
        double b = in.nextDouble();
        System.out.print("Tinggi badan (m)  : ");
        double t = in.nextDouble();

        double imt = b / (t * t);
        String kriteria;
        if (imt <= 18.5) {
            kriteria = "kurus";
        } else if (imt <= 25) {
            kriteria = "normal";
        } else if (imt <= 30) {
            kriteria = "gemuk";
        } else {
            kriteria = "kegemukan";
        }
        System.out.printf(Locale.forLanguageTag("id-ID"), "IMT = %.2f  Termasuk %s%n", imt, kriteria);
        in.close();
    }
}