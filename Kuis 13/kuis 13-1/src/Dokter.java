import java.util.ArrayList;
import java.util.List;

public class Dokter extends Orang {
    private String idDokter;
    private String nomorSTR;
    private String spesialisasi;
    private List<Antrian> antrianPasien;

    public Dokter(String nama, String tanggalLahir, JenisKelamin jenisKelamin, String nomorSTR, String spesialisasi) {
        super(nama, tanggalLahir, jenisKelamin);
        this.nomorSTR = nomorSTR;
        this.spesialisasi = spesialisasi;
        this.antrianPasien = new ArrayList<>();
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void tambahAntrian(Antrian antrian) {
        antrianPasien.add(antrian);
    }

    public void hapusAntrian(Antrian antrian) {
        antrianPasien.remove(antrian);
    }

    public void tampilkanAntrian() {
        for (Antrian antrian : antrianPasien) {
            System.out.println(antrian);
        }
    }
}

