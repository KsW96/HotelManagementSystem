package hotelmanager;

public class Floor {

	Guest[][] guest;
	RoomInfo[][] room;
	// generateArray genGuest_array;

	public Floor() {
		this.guest = new Guest[0][0];
		this.room = new RoomInfo[0][0];
	}

	public Floor(Guest[][] guest, RoomInfo[][] room) {
		this.guest = guest;
		this.room = room;
		// this.genGuest_array = genGuest_array;
	}

	public Guest[][] getGuest() {
		return guest;
	}

	public void setGuest(Guest[][] guest) {
		this.guest = guest;
	}

	public RoomInfo[][] getRoom() {
		return room;
	}

	public void setRoom(RoomInfo[][] room) {
		this.room = room;
	}

}
