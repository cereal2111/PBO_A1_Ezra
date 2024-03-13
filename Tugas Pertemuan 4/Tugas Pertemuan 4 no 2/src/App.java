import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class MovieApp {
    private List<Film> films;
    private List<Booking> bookings;

    public MovieApp() {
        this.films = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void displayAllFilms() {
        System.out.println("List of Films:");
        for (Film film : films) {
            System.out.println(film.getTitle());
            System.out.println(film.getGenre());
            System.out.println("Duration: " + film.getDuration() + " mins");
            System.out.println("Available Seats: " + film.getAvailableSeats());
            System.out.println();
        }
    }

    public Film searchFilm(String title) {
        for (Film film : films) {
            if (film.getTitle().equals(title)) {
                return film;
            }
        }
        return null;
    }

    public int bookFilm(Film film, int numberOfTickets) {
        if (film.getAvailableSeats() >= numberOfTickets) {
            int bookingId = generateBookingId();
            bookings.add(new Booking(bookingId, film));
            film.setAvailableSeats(film.getAvailableSeats() - numberOfTickets);
            return bookingId;
        } else {
            return -1; // Indicates failure due to insufficient seats
        }
    }

    public void displayBookingDetails(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                System.out.println("Pesanan berhasil dengan detail pesanan:");
                System.out.println("Film: " + booking.getFilm().getTitle());
                System.out.println("Jumlah Tiket: " + 1); // Assuming each booking is for one ticket
                System.out.println("Booking ID: " + booking.getBookingId());
                return;
            }
        }
        System.out.println("Pesanan tidak ditemukan.");
    }

    private int generateBookingId() {
        Random random = new Random();
        return random.nextInt(1000); // Generates a random booking ID
    }
}