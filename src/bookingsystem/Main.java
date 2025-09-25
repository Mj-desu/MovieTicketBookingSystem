package bookingsystem;

public final class Main {
  private Main() {

  };
  /**
   * Ticket count 2.
   */
  static final int TICKETCOUNT2 = 2;

  /**
   * Ticket count 3.
   */
  static final int TICKETCOUNT3 = 3;
  /**
   * Ticket count 5.
   */
  static final int TICKETCOUNT5 = 5;
  /**
   * Ticket count 5.
   */
  static final int TICKETCOUNT100 = 100;

  /**
   * Main class.
   * @param args
   */
  public static void main(final String[] args) {
    MovieBookingSystem eigakan = new MovieBookingSystem();

    eigakan.bookTicket("10:00 AM", TICKETCOUNT5);
    eigakan.bookTicket("10:00 AM", TICKETCOUNT100);
    eigakan.cancelReservation("10:00 AM", TICKETCOUNT3);
    eigakan.bookTicket("10:00 AM", TICKETCOUNT2);
    eigakan.cancelReservation("10:00 AM", TICKETCOUNT5);

  }
}
