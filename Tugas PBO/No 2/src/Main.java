import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama siswa: ");
        String namaSiswa = scanner.nextLine();

        System.out.print("Masukkan nilai Matematika: ");
        double nilaiMatematika = scanner.nextDouble();

        System.out.print("Masukkan nilai IPA: ");
        double nilaiIPA = scanner.nextDouble();

        System.out.print("Masukkan nilai Bahasa Inggris: ");
        double nilaiBahasaInggris = scanner.nextDouble();

        System.out.print("Masukkan nilai Bahasa Indonesia: ");
        double nilaiBahasaIndonesia = scanner.nextDouble();

        double rataRata = (nilaiMatematika + nilaiIPA + nilaiBahasaInggris + nilaiBahasaIndonesia) / 4;

        if (rataRata > 50) {
            System.out.println( namaSiswa + " Dengan rata-rata nilai " + rataRata + " Dinyatakan Lulus");
        } else {
            System.out.println( namaSiswa + " Dengan rata-rata nilai " + rataRata + " Dinyatakan Tidak Lulus");
        }
    }
}
