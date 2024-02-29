import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan angka pertama: ");
        int angka1 = scanner.nextInt();

        System.out.print("Masukkan angka kedua: ");
        int angka2 = scanner.nextInt();

        if (angka1 % 2 == 0) {
            System.out.println(angka1 + " adalah bilangan genap.");
        } else {
            System.out.println(angka1 + " adalah bilangan ganjil.");
        }

        if (angka2 % 2 == 0) {
            System.out.println(angka2 + " adalah bilangan genap.");
        } else {
            System.out.println(angka2 + " adalah bilangan ganjil.");
        }

        if (angka1 > 0) {
            System.out.println(angka1 + " adalah bilangan positif.");
        } else if (angka1 < 0) {
            System.out.println(angka1 + " adalah bilangan negatif.");
        } else {
            System.out.println(angka1 + " adalah nol.");
        }

        if (angka2 > 0) {
            System.out.println(angka2 + " adalah bilangan positif.");
        } else if (angka2 < 0) {
            System.out.println(angka2 + " adalah bilangan negatif.");
        } else {
            System.out.println(angka2 + " adalah nol.");
        }

        int digitAngka1 = String.valueOf(Math.abs(angka1)).length();
        int digitAngka2 = String.valueOf(Math.abs(angka2)).length();

        System.out.println("Jumlah digit angka pertama: " + digitAngka1);
        System.out.println("Jumlah digit angka kedua: " + digitAngka2);

        int selisih = Math.abs(angka1 - angka2);
        System.out.println("Selisih kedua angka: " + selisih);
    }
}

