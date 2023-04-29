package org.jfs.drivein.scheduleservice.service;

import org.jfs.drivein.scheduleservice.client.BookingClient;
import org.jfs.drivein.scheduleservice.dao.ScheduleDao;
import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.model.ScheduleMovie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
    @InjectMocks
    private ScheduleCrudServiceImpl scheduleCrudServiceImpl;

    @BeforeEach
    public void setup() {
        date = "2023-05-03";
        schedule = new Schedule();
        schedule.setSlot1(new ScheduleMovie("Avengers", 14000, 10000, 5000));
        schedule.setSlot2(new ScheduleMovie("Civil War", 15000, 11000, 2000));
        schedule.setSlot3(new ScheduleMovie("Captain", 12000, 9000, 3000));
        schedule.setDate(date);
        scheduleDao = Mockito.mock(ScheduleDao.class);
        bookingClient = Mockito.mock(BookingClient.class);
        scheduleCrudServiceImpl = new ScheduleCrudServiceImpl(scheduleDao, bookingClient);
    }

    @Test
    public void testAddSchedule() {

        scheduleCrudServiceImpl.addSchedule(schedule);

        verify(bookingClient).createSlot("Avengers", date, "A");
        verify(bookingClient).createSlot("Civil War", date, "B");
        verify(bookingClient).createSlot("Captain", date, "C");

        verify(scheduleDao).saveSchedule(schedule);
    }

    @Test
    public void testUpdateSchedule() throws InvalidScheduleDateException {

        when(scheduleDao.viewSchedule(date)).thenReturn(Optional.of(new Schedule()));

        scheduleCrudServiceImpl.updateSchedule(date, schedule);

        verify(bookingClient).updateSlot("Avengers", date, "A");
        verify(bookingClient).updateSlot("Civil War", date, "B");
        verify(bookingClient).updateSlot("Captain", date, "C");

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

        verify(bookingClient).deleteSlot(date, "A");
        verify(bookingClient).deleteSlot(date, "B");
        verify(bookingClient).deleteSlot(date, "C");

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

}