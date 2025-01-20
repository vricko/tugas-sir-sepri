import java.util.Scanner;

class Pemain {
    String nama;
    int level = 1;
    int poin = 0;

    void tambahPoin() {
        poin += 20;
        if (poin >= level * 20) {
            level++;
            System.out.println("Naik ke level " + level);
        }
    }

    void tampilkanStatus() {
        System.out.println("Nama: " + nama + ", Level: " + level + ", Poin: " + poin);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pemain pemain = new Pemain();

        System.out.print("Nama pemain: ");
        pemain.nama = scanner.nextLine();

        String[] soal = {
            "Berapa hasil dari 2 + 5?",
            "Berapa hasil dari 8 x 5?",
            "Berapa hasil dari 12 / 4?",
            "Berapa hasil dari 15 - 10?",
            "Berapa hasil dari 2^2 ? "
        };
        int[] jawaban = {7, 40, 3, 5, 4};

        for (int i = 0; i < soal.length; i++) {
            System.out.println("Level " + (i + 1) + ": " + soal[i]);
            System.out.print("Answer: ");
            int jawabanPemain = scanner.nextInt();

            if (jawabanPemain == jawaban[i]) {
                System.out.println("Benar!");
                pemain.tambahPoin();
            } else {
                System.out.println("Salah.");
                System.out.print("Apakah ingin lanjut? (ya/tidak): ");
                scanner.nextLine();
                String pilihan = scanner.nextLine();
                if (pilihan.equalsIgnoreCase("tidak")) {
                    System.out.println("Terima kasih sudah bermain!");
                    break;
                }
            }

            pemain.tampilkanStatus();
            System.out.println("--------------------");
        }

        System.out.println("Game selesai. Terima kasih sudah bermain!");
    }
}
