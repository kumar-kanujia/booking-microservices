package org.jfs.drivein.scheduleservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.jfs.drivein.scheduleservice.client.BookingClient;
import org.jfs.drivein.scheduleservice.config.PropertiesConfig;
import org.jfs.drivein.scheduleservice.dao.ScheduleDao;
import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.model.ScheduleMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ScheduleCrudServiceImplTest {

    private String date;
    private Schedule schedule;
    @Mock
    private ScheduleDao scheduleDao;
    @Mock
    private BookingClient bookingClient;
    @Mock
    private PropertiesConfig propertiesConfig;
    @InjectMocks
    private ScheduleCrudServiceImpl scheduleCrudServiceImpl;

    @BeforeEach
    public void setup() {
        date = "2023-05-03";
        String slotTimeA = "12:00 AM";
        String slotTimeB = "03:00 AM";
        String slotTimeC = "09:00 PM";
        schedule = new Schedule();
        schedule.setSlot1(new ScheduleMovie("101" , "Avengers", 14000, 10000, 5000));
        schedule.setSlot2(new ScheduleMovie("102" , "Civil War", 15000, 11000, 2000));
        schedule.setSlot3(new ScheduleMovie("103" , "Captain", 12000, 9000, 3000));
        schedule.setDate(date);
        propertiesConfig.setSlotTimeA(slotTimeA);
        propertiesConfig.setSlotTimeB(slotTimeB);
        propertiesConfig.setSlotTimeC(slotTimeC);
        scheduleCrudServiceImpl = new ScheduleCrudServiceImpl(scheduleDao, bookingClient , propertiesConfig);
    }

    @Test
    void testViewSchedule() throws InvalidScheduleDateException {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(new Schedule()));

        scheduleCrudServiceImpl.viewSchedule(date);

        verify(scheduleDao).viewSchedule(date);
    }

    @Test
    void testViewScheduleInvalidDate() {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.empty());

        assertThrows(InvalidScheduleDateException.class,
                () -> scheduleCrudServiceImpl.viewSchedule(date));
    }

/*
    @Test
    public void testAddSchedule() {
        scheduleCrudServiceImpl.addSchedule(schedule);

		verify(bookingClient).createSlot(new ParkingSlot(schedule.getSlot1().getSlotId(),
				schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeA(), 20, 20, 20));
		verify(bookingClient).createSlot(new ParkingSlot(schedule.getSlot2().getSlotId(),
				schedule.getSlot2().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeB(), 20, 20, 20));
		verify(bookingClient).createSlot(new ParkingSlot(schedule.getSlot3().getSlotId(),
				schedule.getSlot3().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeC(), 20, 20, 20));

        verify(scheduleDao).saveSchedule(schedule);
    }
*/

    @Test
    public void testUpdateSchedule() throws InvalidScheduleDateException {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(schedule));

        scheduleCrudServiceImpl.updateSchedule(date, schedule);

        verify(bookingClient).updateSlot(schedule.getSlot1().getSlotId(),schedule.getSlot1().getTitle());
        verify(bookingClient).updateSlot(schedule.getSlot2().getSlotId(),schedule.getSlot2().getTitle());
        verify(bookingClient).updateSlot(schedule.getSlot3().getSlotId(),schedule.getSlot3().getTitle());

        verify(scheduleDao).saveSchedule(schedule);
    }

    @Test
    void testUpdateScheduleInvalidDate() {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.empty());

        assertThrows(InvalidScheduleDateException.class,
                () -> scheduleCrudServiceImpl.updateSchedule(date, schedule));
    }

    @Test
    void testDeleteSchedule() throws InvalidScheduleDateException {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(schedule));

        scheduleCrudServiceImpl.deleteSchedule(date);

        verify(bookingClient).deleteSlot(schedule.getSlot1().getSlotId());
        verify(bookingClient).deleteSlot(schedule.getSlot2().getSlotId());
        verify(bookingClient).deleteSlot(schedule.getSlot3().getSlotId());

        verify(scheduleDao).deleteSchedule(schedule);
    }

    @Test
    void testDeleteScheduleInvalidDate() {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.empty());

        assertThrows(InvalidScheduleDateException.class,
                () -> scheduleCrudServiceImpl.deleteSchedule(date));
    }

    @Test
    void testGetPriceTierA() throws InvalidScheduleDateException {
        String tier = "a";

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(schedule));
        when(propertiesConfig.getSlotTimeA()).thenReturn("12:00 AM");
        when(propertiesConfig.getSlotTimeB()).thenReturn("03:00 AM");

        double price1 = scheduleCrudServiceImpl.getPrice(date , tier , "12:00 AM");
        double price2 = scheduleCrudServiceImpl.getPrice(date , tier , "03:00 AM");
        double price3 = scheduleCrudServiceImpl.getPrice(date , tier , "09:00 AM");

        assertEquals(14000 , price1);
        assertEquals(15000 , price2);
        assertEquals(12000 , price3);
    }

    @Test
    void testGetPriceTierB() throws InvalidScheduleDateException {
        String tier = "b";

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(schedule));
        when(propertiesConfig.getSlotTimeA()).thenReturn("12:00 AM");
        when(propertiesConfig.getSlotTimeB()).thenReturn("03:00 AM");

        double price1 = scheduleCrudServiceImpl.getPrice(date , tier , "12:00 AM");
        double price2 = scheduleCrudServiceImpl.getPrice(date , tier , "03:00 AM");
        double price3 = scheduleCrudServiceImpl.getPrice(date , tier , "09:00 AM");

        assertEquals(10000 , price1);
        assertEquals(11000 , price2);
        assertEquals(9000 , price3);
    }

    @Test
    void testGetPriceTierC() throws InvalidScheduleDateException {
        String tier = "c";

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(schedule));
        when(propertiesConfig.getSlotTimeA()).thenReturn("12:00 AM");
        when(propertiesConfig.getSlotTimeB()).thenReturn("03:00 AM");

        double price1 = scheduleCrudServiceImpl.getPrice(date , tier , "12:00 AM");
        double price2 = scheduleCrudServiceImpl.getPrice(date , tier , "03:00 AM");
        double price3 = scheduleCrudServiceImpl.getPrice(date , tier , "09:00 AM");

        assertEquals(5000 , price1);
        assertEquals(2000 , price2);
        assertEquals(3000 , price3);
    }

    @Test
    void testGetPriceInvalidDate(){

        String tier = "a";

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.empty());

        assertThrows(InvalidScheduleDateException.class,
                () -> scheduleCrudServiceImpl.getPrice(date , tier , propertiesConfig.getSlotTimeA()));
    }
}