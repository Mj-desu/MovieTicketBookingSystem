package bookingsystem;
//CODE REVIEWED BY: KYLE ANGEL N. RAMIREZ
//ALL REQUIRED METHODS ARE PRESENT. NO CHECKSTYLE VIOLATIONS.

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieBookingSystemTest {
  /**
   * Movie booking system instance.
   */
  private MovieBookingSystem eigakan;

  /**
   * Data initialization.
   */
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @BeforeEach
  void setup() {
    eigakan = new MovieBookingSystem();

    outContent.reset();
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void testShouldDisplayRightMessageIfAvailable() {
    final int tickets = 10;
    String expectedOutput = "10 tickets successfully booked for 10:00 AM\r\n"
        + "10 tickets available.";

    eigakan.bookTicket("10:00 AM", tickets);
    eigakan.checkAvailability("10:00 AM");

    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfTimeSlotInvalid() {
    String expectedOutput = "Invalid time slot!";

    eigakan.checkAvailability("11:00 AM");

    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfNotAvailable() {
    final int tickets = 20;
    String expectedOutput = "20 tickets successfully booked for 10:00 AM\r\n"
        + "Not enough tickets available for this showtime.";

    eigakan.bookTicket("10:00 AM", tickets);
    eigakan.checkAvailability("10:00 AM");

    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfTicketBooked() {
    final int tickets = 20;
    String expectedOutput = "20 tickets successfully booked for 10:00 AM";
    eigakan.bookTicket("10:00 AM", tickets);
    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfTicketNotBooked() {
    final int tickets = 40;
    String expectedOutput = "Not enough tickets available for this showtime.";

    eigakan.bookTicket("10:00 AM", tickets);

    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfInvalidBookingTimeSlot() {
    final int tickets = 20;
    eigakan.bookTicket("11:00 AM", tickets);

    String expectedOutput = "Invalid time slot!";

    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfTicketCancelled() {
    final int tickets = 10;
    final int ticketsToBeCancelled = 5;
    String expectedOutput = "10 tickets successfully booked for 10:00 AM\r\n"
        + "5 tickets successfully canceled for 10:00 AM";

    eigakan.bookTicket("10:00 AM", tickets);
    eigakan.cancelReservation("10:00 AM", ticketsToBeCancelled);

    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfTicketNotCancelled() {
    final int ticketsToBeCancelled = 5;
    String expectedOutput = "Invalid operation (Attempt to cancel"
        + " more tickets than booked)";
    eigakan.cancelReservation("10:00 AM", ticketsToBeCancelled);

    assertEquals(expectedOutput, outContent.toString().trim());

  }

  @Test
  void testShouldDisplayRightMessageIfInvalidCancellingTimeSlot() {
    final int tickets = 20;
    eigakan.cancelReservation("11:00 AM", tickets);

    String expectedOutput = "Invalid time slot!";

    assertEquals(expectedOutput, outContent.toString().trim());

  }
}
