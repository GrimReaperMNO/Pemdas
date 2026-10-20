import java.util.Scanner;

public class ParkirV3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int menu = 0;

        // Array 1D untuk riwayat transaksi
        final int MAX_TRANSAKSI = 10;
        String[] platNomor = new String[MAX_TRANSAKSI];
        String[] jenisKendaraanStr = new String[MAX_TRANSAKSI];
        int[] lamaParkir = new int[MAX_TRANSAKSI];
        int[] totalBiaya = new int[MAX_TRANSAKSI];
        int jumlahTransaksi = 0;

        // Array 2D - Denah slot parkir (0 = kosong, 1 = terisi)
        int[][] slotParkir = {
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1}
        };

        do {
            System.out.println("\n=== SISTEM SMART BRAWIJAYA PARKIR V3 ===");
            System.out.println("1. Input Transaksi Parkir Keluar");
            System.out.println("2. Tampilkan Rekap & Riwayat Transaksi (Array 1D)");
            System.out.println("3. Cari Transaksi Parkir Paling Lama & Mahal");
            System.out.println("4. Cari Transaksi berdasarkan Plat Nomor (Linear Search)");
            System.out.println("5. Lihat Denah Slot Parkir Kampus (Array 2D)");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            menu = input.nextInt();
            input.nextLine(); // ambil newline dari nextInt

            switch (menu) {
                case 1 -> {
                    // Guard: cegah index out of bounds
                    if (jumlahTransaksi >= platNomor.length) {
                        System.out.println("[WARNING] Kapasitas memori riwayat transaksi penuh!");
                        break;
                    }

                    System.out.print("Masukkan Plat Nomor (contoh: N1234AB): ");
                    String plat = input.nextLine();

                    System.out.print("Masukkan Jenis Kendaraan (1=Motor, 2=Mobil): ");
                    int jenis = input.nextInt();

                    System.out.print("Masukkan Lama Parkir (jam): ");
                    int jam = input.nextInt();
                    input.nextLine();

                    // Guard clause & validasi input
                    if (jam <= 0 || (jenis != 1 && jenis != 2)) {
                        System.out.println("[ERROR] Input jenis kendaraan atau lama parkir invalid!");
                        break;
                    }

                    // Hitung biaya tarif progresif
                    int total;
                    int tarifDasar = (jenis == 1) ? 2000 : 5000;
                    int tarifLanjut = (jenis == 1) ? 1000 : 2000;
                    int denda = (jam > 24) ? 50000 : 0;
                    if (jam == 1) {
                        total = tarifDasar + denda;
                    } else {
                        total = tarifDasar + ((jam - 1) * tarifLanjut) + denda;
                    }

                    // Simpan ke array 1D
                    platNomor[jumlahTransaksi] = plat;
                    jenisKendaraanStr[jumlahTransaksi] = (jenis == 1) ? "Motor" : "Mobil";
                    lamaParkir[jumlahTransaksi] = jam;
                    totalBiaya[jumlahTransaksi] = total;

                    System.out.printf("--> Transaksi Berhasil Disimpan di Indeks [%d]! Total Biaya: Rp %d\n",
                            jumlahTransaksi, total);
                    jumlahTransaksi++;
                }

                case 2 -> {
                    System.out.println("\n--- REKAP RIWAYAT TRANSAKSI ---");
                    if (jumlahTransaksi == 0) {
                        System.out.println("Belum ada transaksi recorded.");
                    } else {
                        System.out.printf("%-5s %-12s %-10s %-10s %-12s\n",
                                "No", "Plat Nomor", "Jenis", "Lama(Jam)", "Total Biaya");
                        for (int i = 0; i < jumlahTransaksi; i++) {
                            System.out.printf("%-5d %-12s %-10s %-10d Rp %-10d\n",
                                    (i + 1), platNomor[i], jenisKendaraanStr[i],
                                    lamaParkir[i], totalBiaya[i]);
                        }
                    }
                }

                case 3 -> {
                    if (jumlahTransaksi == 0) {
                        System.out.println("Belum ada data transaksi.");
                        break;
                    }

                    int maxJam = lamaParkir[0];
                    int maxBiaya = totalBiaya[0];
                    int idxMax = 0;

                    for (int i = 1; i < jumlahTransaksi; i++) {
                        if (lamaParkir[i] > maxJam) {
                            maxJam = lamaParkir[i];
                            maxBiaya = totalBiaya[i];
                            idxMax = i;
                        }
                    }

                    System.out.println("\n--- KENDARAAN PARKIR TERLAMA ---");
                    System.out.printf("Plat Nomor  : %s (%s)\n", platNomor[idxMax], jenisKendaraanStr[idxMax]);
                    System.out.printf("Lama Parkir : %d Jam\n", maxJam);
                    System.out.printf("Total Biaya : Rp %d\n", maxBiaya);
                }

                case 4 -> {
                    // TUGAS: Linear Search berdasarkan plat nomor
                    if (jumlahTransaksi == 0) {
                        System.out.println("Belum ada data transaksi.");
                        break;
                    }

                    System.out.print("Masukkan Plat Nomor yang dicari: ");
                    String cari = input.nextLine().trim();

                    boolean ditemukan = false;
                    for (int i = 0; i < jumlahTransaksi; i++) {
                        if (platNomor[i].equalsIgnoreCase(cari)) {
                            if (!ditemukan) {
                                System.out.println("\n--- HASIL PENCARIAN ---");
                                System.out.printf("%-5s %-12s %-10s %-10s %-12s\n",
                                        "No", "Plat Nomor", "Jenis", "Lama(Jam)", "Total Biaya");
                            }
                            System.out.printf("%-5d %-12s %-10s %-10d Rp %-10d\n",
                                    (i + 1), platNomor[i], jenisKendaraanStr[i],
                                    lamaParkir[i], totalBiaya[i]);
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Plat nomor " + cari + " tidak ditemukan di riwayat parkir.");
                    }
                }

                case 5 -> {
                    System.out.println("\n--- DENAH SLOT PARKIR KAMPUS (3x4) ---");
                    System.out.println("[0 = Kosong/Tersedia | 1 = Terisi]");
                    int slotKosong = 0;

                    for (int b = 0; b < slotParkir.length; b++) {
                        System.out.print("Lantai/Baris " + b + " : | ");
                        for (int c = 0; c < slotParkir[b].length; c++) {
                            System.out.print(slotParkir[b][c] + " | ");
                            if (slotParkir[b][c] == 0) slotKosong++;
                        }
                        System.out.println();
                    }
                    System.out.println("Sisa Slot Parkir Kosong: " + slotKosong + " Slot");
                }

                case 0 -> System.out.println("Terima kasih telah menggunakan Sistem Smart Brawijaya 3.");
                default -> System.out.println("Pilihan menu tidak valid!");
            }
        } while (menu != 0);

        input.close();
    }
}