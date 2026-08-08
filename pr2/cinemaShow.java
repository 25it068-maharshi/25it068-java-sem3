package pr2;

class cinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    public cinemaShow(String title, int capacity) {
        this.title = title;
        this.seatsAvailable = capacity;
        this.capacity = capacity;
    }

    public cinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        } else {
            return false;
        }
    }

    void cancel(int n) {
        seatsAvailable += n;
        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    public static int getTotalBooked() {
        return totalBooked;
    }

    // Moved the main method inside the correct cinemaShow class
    public static void main(String[] args) {
        cinemaShow s1 = new cinemaShow("Avengers", 50);

        System.out.println("Book 20 seats: " + s1.book(20));
        System.out.println("Seats Available: " + s1.getSeatsAvailable());

        System.out.println("Book 15 seats: " + s1.book(15));
        System.out.println("Seats Available: " + s1.getSeatsAvailable());

        System.out.println("Book 20 seats: " + s1.book(20));
        System.out.println("Seats Available: " + s1.getSeatsAvailable());

        s1.cancel(10);
        System.out.println("After cancelling 10 seats:");
        System.out.println("Seats Available: " + s1.getSeatsAvailable());

        s1.cancel(50);
        System.out.println("After cancelling 50 seats:");
        System.out.println("Seats Available: " + s1.getSeatsAvailable());

        System.out.println("Total Booked: " + cinemaShow.getTotalBooked());
    }
}
