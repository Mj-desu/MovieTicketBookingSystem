package bookingsystem;
// CODE REVIEWED BY: KYLE ANGEL N. RAMIREZ
// ALL REQUIRED METHODS ARE PRESENT. NO CHECKSTYLE VIOLATIONS.

public abstract class BookingSystem {
  /**
   * Constructor for abstract class.
   */
  public BookingSystem() {

  }

  /**
   * Checks if there are available ticket for a show.
   * @param showTime
   * @return boolean
   */
  public abstract boolean checkAvailability(String showTime);

  /**
   * Books the specified number of tickets for a show time.
   * @param showTime
   * @param tickets
   * @return boolean true if booked
   */
  public abstract boolean bookTicket(String showTime, int tickets);

  /**
   * Cancels the specified number of tickets for a show time.
   * @param showTime
   * @param tickets
   * @return boolean true if cancelled
   */
  public abstract boolean cancelReservation(String showTime, int tickets);
}
