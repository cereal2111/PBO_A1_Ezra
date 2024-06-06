public class Antrian {
    public enum TipePasien { BPJS, MANDIRI }

    private static int nomorUrut = 1;
    private String nomorAntrian;
    private Pasien pasien;
    private String keluhan;
    private Dokter dokter;
    private TipePasien tipePasien;

    public Antrian(Dokter dokter, Pasien pasien, String keluhan, TipePasien tipePasien) {
        this.dokter = dokter;
        this.pasien = pasien;
        this.keluhan = keluhan;
        this.tipePasien = tipePasien;
        this.nomorAntrian = dokter.getIdDokter() + "-" + nomorUrut++;
    }

    public Dokter getDokter() {
        return dokter;
    }

    @Override
    public String toString() {
        return "Nomor Antrian: " + nomorAntrian + ", Pasien: " + pasien.getNama() + ", Keluhan: " + keluhan + ", Tipe Pasien: " + tipePasien;
    }
}


