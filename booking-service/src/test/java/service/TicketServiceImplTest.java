package service;

import org.jfs.drivein.bookingservice.client.ScheduleClient;
import org.jfs.drivein.bookingservice.dao.TicketDao;
import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.model.Ticket;
import org.jfs.drivein.bookingservice.service.ParkingSlotService;
import org.jfs.drivein.bookingservice.service.TicketServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {

    @Mock
    private TicketDao ticketDao;

    @Mock
    private ParkingSlotService parkingSlotService;

    @Mock
    private ScheduleClient scheduleClient;

    @InjectMocks
    private TicketServiceImpl ticketServiceImpl;

    @Test
    public void testCancelTicket() throws TicketNotFoundException, UnavailableSlotException {

        Ticket ticket = new Ticket();
        ticket.setSlotTime("12:00 AM");
        ticket.setDate("2023-06-04");
        ticket.setTier("a");
        ParkingSlot slot = new ParkingSlot();
        slot.setSlotTime("12:00 AM");
        slot.setDate("2023-06-04");
        slot.setTier1(1);
        slot.setTitle("Avengers");

        when(ticketDao.viewTicket("1")).thenReturn(Optional.of(ticket));
        when(parkingSlotService.findParkingSlotByDateAndTime("2023-06-04", "12:00 AM")).thenReturn(slot);

        ticketServiceImpl.cancelTicket("1");

        verify(ticketDao).cancelTicket("1");
        verify(parkingSlotService).saveSlot(slot);
        assertEquals(2, slot.getTier1());
    }

    @Test
    public void testCancelTicketTicketNotFound() {
        when(ticketDao.viewTicket("1")).thenReturn(Optional.empty());

        assertThrows(TicketNotFoundException.class, () -> ticketServiceImpl.cancelTicket("1"));
    }

    @Test
    public void testViewTicket() throws TicketNotFoundException {

        Ticket ticket = new Ticket("101" , "RJ25"  , "Avengers" , "02-01-2023" , "12:00 AM" , "a" , 20 , 14000);

        Optional<Ticket> expected = Optional.of(ticket);
        when(ticketDao.viewTicket("101")).thenReturn(expected);
        Ticket actual = ticketServiceImpl.viewTicket("101");
        assertEquals(expected.get(), actual);
    }

    @Test
    public void testBookTicketUnavailableSlot() throws UnavailableSlotException {

        ParkingSlot slot = new ParkingSlot();
        slot.setTier1(0);
        slot.setTier2(0);
        slot.setTier3(0);

        when(parkingSlotService.findParkingSlotById("1")).thenReturn(Collections.singletonList(slot));

        assertThrows(UnavailableSlotException.class, () -> ticketServiceImpl.bookTicket("1", "CAR-1234", "a"));
    }

/*
    @Test
    public void testBookTicketTierA() throws UnavailableSlotException {

        ParkingSlot parkingSlot = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        parkingSlots.add(parkingSlot);

        when(parkingSlotService.findParkingSlotById("101")).thenReturn(parkingSlots);
        when(scheduleClient.getPrice("02-01-2023", "a", "12:00 AM")).thenReturn(14000.0);

        TicketServiceImpl service = new TicketServiceImpl(ticketDao , parkingSlotService , scheduleClient);
        Ticket ticket = service.bookTicket("101", "RJ25", "a");

        verify(parkingSlotService).findParkingSlotById("101");
        verify(parkingSlotService).saveSlot(any());
        verify(ticketDao).saveTicket(any());
        assertEquals("Avengers", ticket.getTitle());
        assertEquals("02-01-2023", ticket.getDate());
        assertEquals("a", ticket.getTier());
        assertEquals(14000.0, ticket.getPrice());
        assertEquals("RJ25", ticket.getCarNumber());
    }
*/

}

