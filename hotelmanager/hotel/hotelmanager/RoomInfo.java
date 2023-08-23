package hotelmanager;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RoomInfo { // 임태경

	private boolean checkIn;
	private boolean clean;
	private boolean reservation;
	private LocalDate checkInTime;
	private LocalDate checkOutTime;
	private boolean possible;
	public int length; 		// b동 건물 체크인을 불가능하게 하기 위한 필드

	public RoomInfo(boolean checkIn, boolean clean, boolean reservation, LocalDate checkInTime, LocalDate checkOutTime,
			boolean possible) {
		super();
		this.checkIn = checkIn;
		this.clean = clean;
		this.reservation = reservation;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.possible = possible;

	}

	public RoomInfo() {
		this.checkIn = false;
		this.clean = true;
		this.reservation = false;
		this.checkInTime = checkInTime.now();
		this.checkOutTime = checkOutTime.now();
		this.possible = true;

	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(LocalDate checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

	public LocalDate getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(LocalDate checkInTime) {
		this.checkInTime = checkInTime;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}

	public boolean isClean() {
		return clean;
	}

	public void setClean(boolean clean) {
		this.clean = clean;
	}

	public boolean isReservation() {
		return reservation;
	}

	public void setReservation(boolean reservation) {
		this.reservation = reservation;
	}

	public boolean isPossible() {
		return possible;
	}

	public void setPossible(boolean possible) {
		this.possible = possible;
	}

	@Override
	public String toString() {
		return "RoomInfo [checkIn=" + checkIn + ", clean=" + clean + ", reservation=" + reservation + ", checkInTime="
				+ checkInTime + ", possible=" + possible + "]";
	}

}
	


