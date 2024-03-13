class Booking {
    private int bookingId;
    private Film film;

    public Booking(int bookingId, Film film) {
        this.bookingId = bookingId;
        this.film = film;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Film getFilm() {
        return film;
    }
}
