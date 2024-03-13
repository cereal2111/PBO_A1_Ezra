public class Main {
    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();

        // Menambahkan beberapa film
        Film avenger = new Film("Avengers: Endgame", "Action", 180, 50);
        Film joker = new Film("Joker", "Drama", 122, 60);
        movieApp.addFilm(avenger);
        movieApp.addFilm(joker);

        // Menampilkan seluruh list film
        movieApp.displayAllFilms();

        // Mencari film
        Film foundFilm = movieApp.searchFilm("Joker");
        if (foundFilm != null) {
            System.out.println("Film Tersedia");
        } else {
            System.out.println("Film Tidak Tersedia");
        }

        // Membuat pesanan
        int bookingId1 = movieApp.bookFilm(avenger, 2);
        if (bookingId1 != -1) {
            System.out.println("Pesanan berhasil dengan detail pesanan:");
            System.out.println("Film: " + avenger.getTitle());
            System.out.println("Jumlah Tiket: 2");
            System.out.println("Booking ID: " + bookingId1);
        } else {
            System.out.println("Pesanan tidak dapat diproses. Kursi tidak tersedia.");
        }

        // Memeriksa pesanan by booking id
        movieApp.displayBookingDetails(bookingId1);
        movieApp.displayBookingDetails(376); // Booking ID yang tidak ada

        // Menampilkan list film setelah pembelian tiket
        movieApp.displayAllFilms();
    }
}