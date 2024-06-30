class Salesman extends Pegawai {
    private double penjualan;
    private double targetPenjualan;

    public Salesman(String nama, double gaji, double penjualan, double targetPenjualan) {
        super(nama, gaji);
        this.penjualan = penjualan;
        this.targetPenjualan = targetPenjualan;
    }

    @Override
    public void setNip(String nip) {
        if (nip.startsWith("S")) {
            this.nip = nip;
        } else {
            throw new IllegalArgumentException("NIP salesman harus diawali dengan huruf S");
        }
    }

    @Override
    public void setNip(int urutanMasuk) {
        this.nip = "S" + String.format("%04d", urutanMasuk);
    }

    @Override
    public double hitungThr() {
        if (penjualan >= targetPenjualan) {
            return 2 * gaji;
        } else {
            return gaji;
        }
    }
}