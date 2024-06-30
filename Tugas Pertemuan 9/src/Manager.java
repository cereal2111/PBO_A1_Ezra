class Manager extends Pegawai {
    public Manager(String nama, double gaji) {
        super(nama, gaji);
    }

    @Override
    public void setNip(String nip) {
        if (nip.startsWith("M")) {
            this.nip = nip;
        } else {
            throw new IllegalArgumentException("NIP manager harus diawali dengan huruf M");
        }
    }

    @Override
    public void setNip(int urutanMasuk) {
        this.nip = "M" + String.format("%04d", urutanMasuk);
    }

    @Override
    public double hitungThr() {
        return 2 * gaji;
    }
}
