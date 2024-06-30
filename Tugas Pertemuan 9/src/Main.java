public class Main {
    public static void main(String[] args) {
        Pegawai pegawai = new Pegawai("Budi", 5000000);
        pegawai.setNip(1);
        pegawai.tambahCuti(5);
        pegawai.cutiPernikahan();
        System.out.println(pegawai);

        Manager manager = new Manager("Andi", 10000000);
        manager.setNip("M001");
        manager.cutiPersalinanPria();
        System.out.println(manager);

        Salesman salesman = new Salesman("Siti", 7000000, 15000000, 10000000);
        salesman.setNip(2);
        System.out.println(salesman);
    }
}
