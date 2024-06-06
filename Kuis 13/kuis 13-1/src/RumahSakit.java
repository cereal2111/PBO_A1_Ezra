import java.util.ArrayList;
import java.util.List;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private List<Dokter> listDokter;
    private List<Antrian> listAntrian;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.listDokter = new ArrayList<>();
        this.listAntrian = new ArrayList<>();
    }

    public void tambahDokter(Dokter dokter) {
        if (!listDokter.contains(dokter)) {
            dokter.setIdDokter("D" + (listDokter.size() + 1));
            listDokter.add(dokter);
            System.out.println("Dokter " + dokter.getNama() + " berhasil ditambahkan dengan ID: " + dokter.getIdDokter());
        } else {
            System.out.println("Dokter " + dokter.getNama() + " sudah terdaftar.");
        }
    }

    public void cekListDokter() {
        for (Dokter dokter : listDokter) {
            System.out.println("Dokter ID: " + dokter.getIdDokter() + ", Nama: " + dokter.getNama() + ", Spesialisasi: " + dokter.getSpesialisasi());
        }
    }

    public Dokter cariDokter(String namaDokter) {
        for (Dokter dokter : listDokter) {
            if (dokter.getNama().equalsIgnoreCase(namaDokter)) {
                return dokter;
            }
        }
        return null;
    }

    public void tambahAntrian(Antrian antrian) {
        listAntrian.add(antrian);
    }

    public boolean hapusAntrian(Antrian antrian) {
        return listAntrian.remove(antrian);
    }

    public void cekAntrianPasien() {
        for (Antrian antrian : listAntrian) {
            System.out.println(antrian);
        }
    }
}

