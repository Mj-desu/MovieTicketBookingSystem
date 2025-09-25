package bookingsystem;

import java.util.HashMap;

public class MovieBookingSystem extends BookingSystem {
  /**
   * Array of time slots.
   */
  private HashMap<String, TimeSlot> showTimes;
  /**
   * Time slot 1.
   */
  private TimeSlot time1;
  /**
   * Time slot 2.
   */
  private TimeSlot time2;
  /**
   * Time slot 3.
   */
  private TimeSlot time3;

  /**
   * Initial ticket count.
   */
  static final int TICKETCOUNT = 20;

  /**
   * Constructor for movie booking system.
   */
  public MovieBookingSystem() {
    time1 = new TimeSlot("10:00 AM", TICKETCOUNT);
    time2 = new TimeSlot("1:00 PM", TICKETCOUNT);
    time3 = new TimeSlot("5:00 PM", TICKETCOUNT);

    this.showTimes = new HashMap<>();
    showTimes.put("10:00 AM", time1);
    showTimes.put("1:00 PM", time2);
    showTimes.put("5:00 PM", time3);

  }

  @Override
  public final boolean checkAvailability(final String showTime) {
    TimeSlot current;
    current = showTimes.get(showTime);
    if (current.getAvailableTickets() > 0) {
      System.out.println(current.getAvailableTickets() + " tickets available.");
      return true;
    }
    System.out.println("Not enough tickets available for this showtime.");
    return false;
  }

  @Override
  public final boolean bookTicket(final String showTime, final int tickets) {
    TimeSlot current;
    current = showTimes.get(showTime);
    if (current.getAvailableTickets() < tickets) {
      System.out.println("Not enough tickets available for this showtime.");
      return false;
    }

    current.setBookedTicket(tickets);
    System.out
        .println(tickets + " tickets successfully booked for " + showTime);
    return true;
  }

  @Override
  public final boolean cancelReservation(final String showTime,
      final int tickets) {
    TimeSlot current;
    current = showTimes.get(showTime);
    if (current.getBookedTicket() < tickets) {
      System.out.println(
          "Invalid operation (Attempt to cancel more tickets than booked)");
      return false;
    }

    current.setBookedTicket(current.getBookedTicket() - tickets);
    System.out
        .println(tickets + " tickets successfully canceled for " + showTime);
    return true;

  }

}
