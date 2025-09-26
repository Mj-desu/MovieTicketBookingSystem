package bookingsystem;

import java.util.HashMap;

public class MovieBookingSystem extends BookingSystem {
  /**
   * Hash map of time slots.
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
   * Placeholder for the current time slot.
   */
  private TimeSlot current;
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

  /**
   * Checks if input is a valid time slot.
   * @param showTime
   * @return TimeSlot
   */
  public TimeSlot checkTimeSlot(final String showTime) {
    TimeSlot result = showTimes.get(showTime);
    if (result == null) {
      throw new RuntimeException("Invalid time slot!");
    }
    return result;

  }

  @Override
  public final boolean checkAvailability(final String showTime) {
    try {
      current = checkTimeSlot(showTime);
      if (current.getAvailableTickets() > 0) {
        System.out
            .println(current.getAvailableTickets() + " tickets available.");
        return true;
      }
      System.out.println("Not enough tickets available for this showtime.");
      return false;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public final boolean bookTicket(final String showTime, final int tickets) {
    try {
      current = checkTimeSlot(showTime);
      if (current.getAvailableTickets() < tickets) {
        System.out.println("Not enough tickets available for this showtime.");
        return false;
      }

      current.setBookedTicket(tickets);
      System.out
          .println(tickets + " tickets successfully booked for " + showTime);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public final boolean cancelReservation(final String showTime,
      final int tickets) {
    try {
      current = checkTimeSlot(showTime);
      if (current.getBookedTicket() < tickets) {
        System.out.println(
            "Invalid operation (Attempt to cancel more tickets than booked)");
        return false;
      }

      current.setBookedTicket(current.getBookedTicket() - tickets);
      System.out
          .println(tickets + " tickets successfully canceled for " + showTime);
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }

  }

}
