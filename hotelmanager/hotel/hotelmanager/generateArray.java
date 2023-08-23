package hotelmanager;

public class generateArray {
	Floor generateFloor = new Floor();
	ManagementSystem m;
	Guest[][] guest;
	RoomInfo[][] room;

	public generateArray(int num) {

		generateFloor.guest = selectGuestArray(num);
		generateFloor.room = selectRoomArray(num);
	}

	public Guest[][] selectGuestArray(int num) {
		if (num == 1) {
			Guest[][] guestA = new Guest[4][20];
			return guestA;
		} else {
			Guest[][] guestB = new Guest[3][10];
			return guestB;
		}
	}

	public RoomInfo[][] selectRoomArray(int num) {
		if (num == 1) {
			RoomInfo[][] roomA = new RoomInfo[4][20];
			return roomA;
		} else {
			RoomInfo[][] roomB = new RoomInfo[3][10];
			return roomB;
		}
	}

	public Floor returnFloor() {
		return generateFloor;
	}
}
