public class Pasien extends Orang {
    private String pekerjaan;
    private String domisili;
    private Antrian antrianAktif;

    public Pasien(String nama, String tanggalLahir, JenisKelamin jenisKelamin, String pekerjaan, String domisili) {
        super(nama, tanggalLahir, jenisKelamin);
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.TipePasien tipePasien) {
        Dokter dokter = rumahSakit.cariDokter(namaDokter);
        if (dokter != null) {
            antrianAktif = new Antrian(dokter, this, keluhan, tipePasien);
            rumahSakit.tambahAntrian(antrianAktif);
            dokter.tambahAntrian(antrianAktif);
        } else {
            System.out.println("Dokter tidak ditemukan: " + namaDokter);
        }
    }

    public void periksa(RumahSakit rumahSakit) {
        if (antrianAktif != null && rumahSakit.hapusAntrian(antrianAktif)) {
            antrianAktif.getDokter().hapusAntrian(antrianAktif);
            antrianAktif = null;
            System.out.println("Pasien " + getNama() + " telah diperiksa.");
        } else {
            System.out.println("Pasien " + getNama() + " tidak memiliki antrian aktif.");
        }
    }
}
