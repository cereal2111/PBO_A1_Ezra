import java.util.ArrayList;

class Keranjang {
    ArrayList<Barang> barangDiKeranjang;

    public Keranjang() {
        barangDiKeranjang = new ArrayList<>();
    }
    public void tambahBarang(Barang barang) {
        if (getTotalItems() < 5) {
            barangDiKeranjang.add(barang);
            System.out.println("Berhasil memasukkan ke keranjang");
        } else {
            System.out.println("Sudah mencapai batas maksimal, keranjang penuh!");
        }
    }

    public void printHasil() {

        System.out.println("Jumlah Barang Di Keranjang Saat Ini : " + getTotalItems());
        System.out.println("Barang Pada Keranjang:");
        for (Barang barang : barangDiKeranjang) {
            System.out.println("# " + barang.namaBarang + ", jumlah : " + barang.jumlahBarang);
        }
        System.out.println("Total Harga Yang Harus Dibayar : " + getTotalPrice());
    }

    private int getTotalItems() {
        int totalItems = 0;
        for (Barang barang : barangDiKeranjang) {
            totalItems += barang.jumlahBarang;
        }
        return totalItems;
    }

    private double getTotalPrice() {
        double totalPrice = 0;
        for (Barang barang : barangDiKeranjang) {
            totalPrice += barang.hargaBarang * barang.jumlahBarang;
        }
        return totalPrice;
    }
}

