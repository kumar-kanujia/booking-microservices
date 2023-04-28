package org.jfs.drivein.scheduleservice.client;

public interface BookingClient {

	public void createSlot(String title, String date, String slotTime);

	public void updateSlot(String title, String date, String slotTime);

	public void deleteSlot(String title, String date, String slotTime);

}
