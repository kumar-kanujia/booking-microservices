package service;

import org.jfs.drivein.bookingservice.dao.ParkingSlotDao;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.exception.UnavailableTitleException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.service.ParkingSlotServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ParkingSlotServiceImplTest {
    @Mock
    private ParkingSlotDao parkingSlotDao;
    @InjectMocks
    private ParkingSlotServiceImpl parkingSlotService;

    @Test
    public void testSaveSlot() {

        ParkingSlotServiceImpl service = new ParkingSlotServiceImpl(parkingSlotDao);
        ParkingSlot slot = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        when(parkingSlotDao.saveParkingSlot(slot)).thenReturn(slot);
        ParkingSlot savedSlot = service.saveSlot(slot);
        assertEquals(slot, savedSlot);
    }

    @Test
    public void testDeleteSlot() throws UnavailableSlotException {

        ParkingSlotServiceImpl service = new ParkingSlotServiceImpl(parkingSlotDao);
        ParkingSlot slot = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        when(parkingSlotDao.findParkingSlotById(slot.getId())).thenReturn(Collections.singletonList(slot));
        service.deleteSlot(slot.getId());
        verify(parkingSlotDao).deleteParkingSlot(slot);
    }

    @Test
    public void testFindParkingSlotByTitle() throws UnavailableTitleException {

        ParkingSlotServiceImpl service = new ParkingSlotServiceImpl(parkingSlotDao);
        ParkingSlot slot1 = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);
        ParkingSlot slot2 = new ParkingSlot("102" , "Civil" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        List<ParkingSlot> expectedSlots = Arrays.asList(slot1, slot2);
        when(parkingSlotDao.findParkingSlotByTitle("Avengers")).thenReturn(expectedSlots);
        List<ParkingSlot> actualSlots = service.findParkingSlotByTitle("Avengers");
        assertEquals(expectedSlots, actualSlots);
    }

    @Test
    public void testFindParkingSlotByTitleAndDate() throws UnavailableSlotException {

        ParkingSlotServiceImpl service = new ParkingSlotServiceImpl(parkingSlotDao);
        ParkingSlot slot1 = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);
        ParkingSlot slot2 = new ParkingSlot("102" , "Civil" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        List<ParkingSlot> expectedSlots = Arrays.asList(slot1, slot2);
        when(parkingSlotDao.findParkingSlotByTitleAndDate("Avengers", "02-01-2023")).thenReturn(expectedSlots);
        List<ParkingSlot> actualSlots = service.findParkingSlotByTitleAndDate("Avengers", "02-01-2023");
        assertEquals(expectedSlots, actualSlots);
    }

    @Test
    public void testFindParkingSlotByDate() throws UnavailableSlotException {

        ParkingSlotServiceImpl service = new ParkingSlotServiceImpl(parkingSlotDao);
        ParkingSlot slot1 = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);
        ParkingSlot slot2 = new ParkingSlot("102" , "Civil" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        List<ParkingSlot> expectedSlots = Arrays.asList(slot1, slot2);
        when(parkingSlotDao.findParkingSlotByDate("02-01-2023")).thenReturn(expectedSlots);
        List<ParkingSlot> actualSlots = service.findParkingSlotByDate("02-01-2023");
        assertEquals(expectedSlots, actualSlots);
    }

    @Test
    public void testFindParkingSlotByDateAndTime() throws UnavailableSlotException {

        ParkingSlotServiceImpl service = new ParkingSlotServiceImpl(parkingSlotDao);
        ParkingSlot slot = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        Optional<ParkingSlot> expectedSlot = Optional.of(slot);
        when(parkingSlotDao.findParkingSlotByDateAndTime("02-01-2023" , "12:00 AM")).thenReturn(expectedSlot);
        ParkingSlot actualSlot = service.findParkingSlotByDateAndTime("02-01-2023" ,  "12:00 AM");
        assertEquals(expectedSlot.get(), actualSlot);
    }

    @Test
    public void testFindParkingSlotById() throws UnavailableSlotException {

        ParkingSlot slot1 = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);
        ParkingSlot slot2 = new ParkingSlot("102" , "Civil" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        List<ParkingSlot> expectedSlots = Arrays.asList(slot1, slot2);
        when(parkingSlotDao.findParkingSlotById("101")).thenReturn(expectedSlots);
        List<ParkingSlot> actualSlots = parkingSlotService.findParkingSlotById("101");
        assertEquals(expectedSlots, actualSlots);
    }

    @Test
    public void testUpdateSlot() throws UnavailableSlotException {

        ParkingSlotServiceImpl service = new ParkingSlotServiceImpl(parkingSlotDao);
        ParkingSlot slot = new ParkingSlot("101" , "Avengers" , "02-01-2023" , "12:00 AM" , 20 , 20 , 20);

        when(parkingSlotDao.findParkingSlotById("101")).thenReturn(Collections.singletonList(slot));
        service.updateSlot("101", "Andaman");
        verify(parkingSlotDao).saveParkingSlot(slot);
        assertEquals("Andaman", slot.getTitle());
    }
}
