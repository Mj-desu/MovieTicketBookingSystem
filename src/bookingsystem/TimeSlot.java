package bookingsystem;

public class TimeSlot {
  /**
   * Ticket count.
   */
  private int ticketCount;
  /**
   * Time slot.
   */
  private String timeSlot;
  /**
   * Booked ticket count.
   */
  private int bookedTicket;

  /**
   * Constructor for TimeSlot.
   * @param time
   * @param ticket
   */

  public TimeSlot(final String time, final int ticket) {
    setTimeSlot(time);
    setTicketCount(ticket);
  }


  /**
   * Setter for ticketCount.
   * @param ticket
   */
  public void setTicketCount(final int ticket) {
    this.ticketCount = ticket;
  }

  /**
   * Getter for time slot.
   * @return timeSlot
   */
  public String getTimeSlot() {
    return timeSlot;
  }

  /**
   * Setter for time slot.
   * @param time
   */
  public void setTimeSlot(final String time) {
    this.timeSlot = time;
  }

  /**
   * Getter for booked ticket.
   * @return bookedTicket
   */
  public int getBookedTicket() {
    return bookedTicket;
  }

  /**
   * Setter for bookedTicket.
   * @param bTicket
   */
  public void setBookedTicket(final int bTicket) {
    this.bookedTicket = bTicket;
  }

  /**
   * Returns the number of available tickets.
   * @return availableTicket
   */
  public int getAvailableTickets() {
     int availableTicket = ticketCount - bookedTicket;
     return availableTicket;
  }
}
