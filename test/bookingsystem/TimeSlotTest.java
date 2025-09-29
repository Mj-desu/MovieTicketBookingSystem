package bookingsystem;
//CODE REVIEWED BY: KYLE ANGEL N. RAMIREZ
//ALL REQUIRED METHODS ARE PRESENT. NO CHECKSTYLE VIOLATIONS.

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeSlotTest {
  /**
   * Ticket count 20.
   */
  static final int TICKETCOUNT20 = 20;

  /**
   * Time slot object.
   */
  private TimeSlot time1;

  @BeforeEach
  void setup() {
    time1 = new TimeSlot("10:00 AM", TICKETCOUNT20);
  }

  @Test
  void testShouldReturnAvailableTickets() {
    final int expectedOutput = 10;
    final int input = 10;
    int actualOutput;
    time1.setBookedTicket(input);
    actualOutput = time1.getAvailableTickets();

    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  void testShouldReturnTimeSlotValue() {
    assertEquals("10:00 AM", time1.getTimeSlot());
  }

}
