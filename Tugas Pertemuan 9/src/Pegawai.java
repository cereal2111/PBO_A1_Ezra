class Pegawai {
    protected String nama;
    protected double gaji;
    protected String nip;
    protected int cuti = 12; // Jumlah cuti normal adalah 12

    public Pegawai(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }
    public void setNip(String nip) {
        if (nip.startsWith("P")) {
            this.nip = nip;
        } else {
            throw new IllegalArgumentException("NIP pegawai harus diawali dengan huruf P");
        }
    }

    public void setNip(int urutanMasuk) {
        this.nip = "P" + String.format("%04d", urutanMasuk);
    }

    public void tambahCuti(int hariTambahan) {
        this.cuti += hariTambahan;
    }

    public void cutiPernikahan() {
        this.cuti += 2;
    }

    public void cutiPersalinanWanita() {
        this.cuti += 90;
    }

    public void cutiPersalinanPria() {
        this.cuti += 3;
    }

    public double hitungThr() {
        return gaji;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Gaji: " + gaji + ", NIP: " + nip + ", Cuti: " + cuti + ", THR: " + hitungThr();
    }
}
