package hotelmanager;

public class ThrowObj { // 임태경

	Search search;
	EditArrayElementData editDataObj;
	PrintEmptyState emptyState;
	CheckInOutReservation inOutRes;

	ManagementSystem ms;

	ThrowObj() {

	}

	EditArrayElementData returnEdit() {
		this.editDataObj = new EditArrayElementData(ms);
		return editDataObj;
	}

	PrintEmptyState returnEmptyState() {
		this.emptyState = new PrintEmptyState(ms);
		return emptyState;
	}

	Search returnSearch() {
		this.search = new Search(ms, emptyState);
		return search;
	}

	CheckInOutReservation CheckInOutReservation() {
		this.inOutRes = new CheckInOutReservation(ms);
		return inOutRes;
	}
}
