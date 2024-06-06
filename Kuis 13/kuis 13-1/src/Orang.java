public abstract class Orang {
    public enum JenisKelamin { LAKI_LAKI, PEREMPUAN }

    private String nama;
    private String tanggalLahir;
    private JenisKelamin jenisKelamin;

    public Orang(String nama, String tanggalLahir, JenisKelamin jenisKelamin) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
    }

    public String getNama() {
        return nama;
    }
}

