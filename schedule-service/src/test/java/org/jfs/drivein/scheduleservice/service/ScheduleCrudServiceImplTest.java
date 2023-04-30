package org.jfs.drivein.scheduleservice.service;

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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
        schedule.setSlot1(new ScheduleMovie("Avengers", 14000, 10000, 5000));
        schedule.setSlot2(new ScheduleMovie("Civil War", 15000, 11000, 2000));
        schedule.setSlot3(new ScheduleMovie("Captain", 12000, 9000, 3000));
        schedule.setDate(date);
        propertiesConfig.setSlotTimeA(slotTimeA);
        propertiesConfig.setSlotTimeB(slotTimeB);
        propertiesConfig.setSlotTimeC(slotTimeC);
        scheduleCrudServiceImpl = new ScheduleCrudServiceImpl(scheduleDao, bookingClient , propertiesConfig);
    }

    @Test
    public void testAddSchedule() {

        scheduleCrudServiceImpl.addSchedule(schedule);

        verify(bookingClient).createSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeA());
        verify(bookingClient).createSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeB());
        verify(bookingClient).createSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeC());

        verify(scheduleDao).saveSchedule(schedule);
    }

    @Test
    public void testUpdateSchedule() throws InvalidScheduleDateException {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(new Schedule()));

        scheduleCrudServiceImpl.updateSchedule(date, schedule);

        verify(bookingClient).updateSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeA());
        verify(bookingClient).updateSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeB());
        verify(bookingClient).updateSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeC());

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

        verify(bookingClient , times(3)).deleteSlot(schedule.getDate(), propertiesConfig.getSlotTimeA());
        verify(bookingClient , times(3)).deleteSlot(schedule.getDate(), propertiesConfig.getSlotTimeB());
        verify(bookingClient , times(3)).deleteSlot(schedule.getDate(), propertiesConfig.getSlotTimeC());

        verify(scheduleDao).deleteSchedule(schedule);
    }

    @Test
    void testDeleteScheduleInvalidDate() {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.empty());

        assertThrows(InvalidScheduleDateException.class,
                () -> scheduleCrudServiceImpl.deleteSchedule(date));
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

    @Test
    void testGetPriceTierA() throws InvalidScheduleDateException {
        String id = "101";
        String tier = "a";

        when(scheduleDao.viewScheduleById(id)).thenReturn(Optional.of(schedule));
        when(propertiesConfig.getSlotTimeA()).thenReturn("12:00 AM");
        when(propertiesConfig.getSlotTimeB()).thenReturn("03:00 AM");

        double price1 = scheduleCrudServiceImpl.getPrice(id , tier , "12:00 AM");
        double price2 = scheduleCrudServiceImpl.getPrice(id , tier , "03:00 AM");
        double price3 = scheduleCrudServiceImpl.getPrice(id , tier , "09:00 AM");

        assertEquals(14000 , price1);
        assertEquals(15000 , price2);
        assertEquals(12000 , price3);
    }

    @Test
    void testGetPriceTierB() throws InvalidScheduleDateException {
        String id = "102";
        String tier = "b";

        when(scheduleDao.viewScheduleById(id)).thenReturn(Optional.of(schedule));
        when(propertiesConfig.getSlotTimeA()).thenReturn("12:00 AM");
        when(propertiesConfig.getSlotTimeB()).thenReturn("03:00 AM");

        double price1 = scheduleCrudServiceImpl.getPrice(id , tier , "12:00 AM");
        double price2 = scheduleCrudServiceImpl.getPrice(id , tier , "03:00 AM");
        double price3 = scheduleCrudServiceImpl.getPrice(id , tier , "09:00 AM");

        assertEquals(10000 , price1);
        assertEquals(11000 , price2);
        assertEquals(9000 , price3);
    }

    @Test
    void testGetPriceTierC() throws InvalidScheduleDateException {
        String id = "103";
        String tier = "c";

        when(scheduleDao.viewScheduleById(id)).thenReturn(Optional.of(schedule));
        when(propertiesConfig.getSlotTimeA()).thenReturn("12:00 AM");
        when(propertiesConfig.getSlotTimeB()).thenReturn("03:00 AM");

        double price1 = scheduleCrudServiceImpl.getPrice(id , tier , "12:00 AM");
        double price2 = scheduleCrudServiceImpl.getPrice(id , tier , "03:00 AM");
        double price3 = scheduleCrudServiceImpl.getPrice(id , tier , "09:00 AM");

        assertEquals(5000 , price1);
        assertEquals(2000 , price2);
        assertEquals(3000 , price3);
    }

    @Test
    void testGetPriceInvalidDate(){

        String id = "101";
        String tier = "a";

        when(scheduleDao.viewScheduleById(id)).thenReturn(Optional.empty());

        assertThrows(InvalidScheduleDateException.class,
                () -> scheduleCrudServiceImpl.getPrice(id , tier , propertiesConfig.getSlotTimeA()));
    }
}