package hotelmanager;
/*
	B동
	1층 ~ 3층 객실. 층 10개
	앞 5객실 싱글, 뒤 5객실은 더블
	예약제로만 운영
*/

import java.time.LocalDate;
import java.util.Scanner;

public class ManagementSystem {

	Floor floorA;
	Floor floorB;
	private generateArray gArray;
	ThrowObj throwObj;
	Search search;
	EditArrayElementData editDataObj;
	PrintEmptyState emptyState;
	CheckInOutReservation inOutRes;

	private final Scanner sc = new Scanner(System.in);

	public ManagementSystem() {
	}

	// 임태경
	Floor generateHotelReturn(int num) {
		if (num == 1) {
			gArray = new generateArray(num);
			floorA = gArray.returnFloor();
			return floorA;
		} else {
			gArray = new generateArray(num);
			floorB = gArray.returnFloor();
			return floorB;
		}
	}

	// 임태경
	void hotelOpen() { // 호텔이 오픈하면 A,B동 둘다 초기화한다.
		for (int i = 0; i < floorA.guest.length; i++) {
			for (int j = 0; j < floorA.guest[i].length; j++) {
				floorA.guest[i][j] = new Guest();
				floorA.room[i][j] = new RoomInfo();
			}
		}
		for (int i = 0; i < floorB.guest.length; i++) {
			for (int j = 0; j < floorB.guest[i].length; j++) {
				floorB.guest[i][j] = new Guest();
				floorB.room[i][j] = new RoomInfo();
			}
		}
	}

	// 임태경 // A,B동에 따라 메소드에 들어가는 인덱스값을 리턴할때 사용
	int whoFloor(Floor floor) {
		if (floor.equals(floorA)) {
			return 2;
		} else
			return 1;
	}

	// 선보라
	void setHotelInfo(Floor floor) {
		// 정보를 바꿀 필드를 체크
		System.out.println("변경할 정보를 확인하고 입력해주세요.");
		System.out.println("[1] 고 객 전 화 번 호");
		System.out.println("[2] 결  제");
		System.out.println("[3] 예  약  취  소");
		System.out.println("[4] 날  짜  변  경");
		System.out.println("[5] 청소상태변경");
		System.out.println("변경을 원치 않으시면 0을 입력해주세요");
		int a = UtilityHotelFuntion.exceptionTest(0, 5);
		switch (a) {
		case 1:
			editDataObj.setHotelPhoneNumber(floor);
			break;
		case 2:
			editDataObj.setHotelPay(floor);
			break;
		case 3:
			editDataObj.setHotelReservation(floor);
			break;
		case 4:
			editDataObj.setHotelStay(floor);
			break;
		case 5:
			editDataObj.setHotelClean(floor);
			break;
		case 0:
			menuSelect(floor);
			break;
		}
	}

	// 임태경
	void setMenu(int a, Floor floor) {
		System.out.println("\n[1] 예          약\n[2] 체    크    인\n[3] 체  크  아  웃\n[4] 이  전  메  뉴");
		switch (UtilityHotelFuntion.exceptionTest(1, 4)) {
		case 1:
			inOutRes.inputReservation(a, floor);
			break;
		case 2:
			inOutRes.checkIn(a, floor);
			break;
		case 3:
			inOutRes.checkOut(a, floor);
			break;
		case 4:
			menuSelect(floor);
			break;
		}
	}

	// 김성우 // 객실현황 //
	void stateView(Floor floor) {
		System.out.println("[1] 층  별  검  색\n[2] 방 번 호 검 색");
		switch (UtilityHotelFuntion.exceptionTest(1, 2)) {
		// 층 선택 및 호출
		case 1:
			emptyState.selectFloor(floor);
			// 방 번호로 방 상태 검색
			break;
		case 2:
			emptyState.roomView(floor);
			break;
		}
	}

	// 임태경
	// 메뉴 선택
	void guestSearch(Floor floor) {
		System.out.println("\n[1] 이  름  검  색\n[2] 번  호  검  색\n[3] 이  전  메  뉴");
		switch (UtilityHotelFuntion.exceptionTest(1, 3)) {
		case 1:
			search.guestNameSearch(floor);
			break;
		case 2:
			search.guestPhoneNumSearch(floor);
			break;
		case 3:
			menuSelect(floor);
			break;
		}
	}

	// 임태경
	// 호텔 예약,투숙,빈객실 현황 출력
	void statHotel(Floor floor) {
		int emptyRoomCnt = floor.guest.length * floor.guest[0].length;
		int reservationRoomCnt = 0;
		int checkInRoomCnt = 0;
		for (int i = 0; i < floor.room.length; i++) {
			for (int j = 0; j < floor.room[i].length; j++) {
				if (floor.room[i][j].isReservation() == true) {
					reservationRoomCnt++;
				}  
				if (floor.room[i][j].isCheckIn() == true) {
					checkInRoomCnt++;
				}
			}
		}
		emptyRoomCnt -= (reservationRoomCnt + checkInRoomCnt);
		System.out.println("x  빈   객   실 : " + emptyRoomCnt);
		System.out.println("o 예  약  객  실 : " + reservationRoomCnt);
		System.out.println("● 투  숙  객  실 : " + checkInRoomCnt);
	}

	// 임태경
	void menuSelect(Floor selectFloor) {
		if (selectFloor.equals(this.floorA)) {
			System.out.println("<<A동>>");
			statHotel(selectFloor);
			System.out.println("\n[1] 객  실  현  황\n[2] 객  실  관  리\n[3] 고  객  정  보\n[4] 체  크  인\n[5] 체  크  아  웃\n[6] 호  텔  변  경\n[0] 프 로 그 램  종 료");

			switch (UtilityHotelFuntion.exceptionTest(0, 6)) {
			case 1:
				stateView(selectFloor);
				break;
			case 2:
				setHotelInfo(selectFloor);
				break;
			case 3:
				guestSearch(selectFloor);
				break;
			case 4:
				inOutRes.checkIn(selectFloor);
				break;
			case 5:
				inOutRes.checkOut(selectFloor);
				break;
			case 6:
				firstFloorMenu();
				break;
			case 0:
				break;
			}
		} else {
			System.out.println("<<B동>>");
			statHotel(selectFloor);
			System.out.println("\n[1] 객  실  현  황\n[2] 객  실  관  리\n[3] 고  객  정  보\n[4] 체   크   인\n[5] 체  크  아  웃\n[6] 호  텔  변  경\n[0] 프 로 그 램  종 료");

			switch (UtilityHotelFuntion.exceptionTest(0, 6)) {
			case 1:
				stateView(selectFloor);
				break;
			case 2:
				setHotelInfo(selectFloor);
				break;
			case 3:
				guestSearch(selectFloor);
				break;
			case 4:
				inOutRes.checkIn(selectFloor);
				break;
			case 5:
				inOutRes.checkOut(selectFloor);
				break;
			case 6:
				firstFloorMenu();
				break;
			case 0:
				break;
			}
		}
	}

	// 임태경
	void firstFloorMenu() {
		System.out.print("업무를 시작할 동 선택 : 1. A동      2. B동\n");
		Floor selectFloor = selectHotelReturn(UtilityHotelFuntion.exceptionTest(1, 2));
		menuSelect(selectFloor);
	}

	private Floor selectHotelReturn(int num) {
		if (num == 1) {
			return floorA;
		} else {
			return floorB;
		}
	}
	
	void startViwe() {
		System.out.println("◆◇===================◇◆");
		System.out.println("호텔 관리 프로그램을 시작합니다.");
		System.out.println("◆◇===================◇◆");
	}
	
	void endViwe() {
		System.out.println("◆◇===================◇◆");
		System.out.println("호텔 관리 프로그램을 종료합니다.");
		System.out.println("◆◇===================◇◆");
	}

	// 임태경
	// 테스트 인스턴스
	private void defaultSetting() {
		floorA.guest[0][0] = new Guest("임태경", "01088209684", false, true, true); // 예약 , 체크인 ,지불      // 체크인 청소 예약
		floorA.room[0][0] = new RoomInfo(true, false, false, LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 20), false);  //1
		// 임태경 입실자 . 방 상태 체크인 o 
		floorA.guest[1][7] = new Guest("강아지", "01088888888", false, true, true);
		floorA.room[1][7] = new RoomInfo(true, false, false, LocalDate.of(2023, 5, 2), LocalDate.of(2023, 7, 1), false);   //2
		// 강아지 체크인 . 방 상태 체크인 o
		floorA.guest[2][13] = new Guest("고양이", "01033333333", true, false, true);
		floorA.room[2][13] = new RoomInfo(false, true, true, LocalDate.of(2023, 5, 3), LocalDate.of(2023, 11, 10),false);  //3
		// 고양이 예약 . 방 상태 예약 o
		floorA.guest[3][19] = new Guest("성우", "01011111111", false, true, true);
		floorA.room[3][19] = new RoomInfo(true, false, false, LocalDate.of(2023, 5, 8), LocalDate.of(2023, 9, 1), false);  //4
		// 성우 체크인 . 방 상태 체크인 o
		floorA.guest[0][5] = new Guest("정욱진", "01058000085", true, false, true);
		floorA.room[0][5] = new RoomInfo(false, true, true, LocalDate.of(2023, 5, 10), LocalDate.of(2023, 5, 21), false);  //5
		// 정욱진 예약 . 방 상태 예약 o
		floorA.guest[1][10] = new Guest("SEA", "01012345678", false, true, true);
		floorA.room[1][10] = new RoomInfo(true, false, false, LocalDate.of(2023, 4, 25), LocalDate.of(2023, 6, 1), false); //6
		// sea  체크인 . 방 상태 체크인 o
		floorA.guest[2][3] = new Guest("Will smith", "08015155", false, true, true);
		floorA.room[2][3] = new RoomInfo(true, false, false, LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 22), false);  //7
		// 윙스미스 체크인 . 방 상태 체크인 o0
		floorA.guest[3][6] = new Guest("손손님", "01176181", false, true, true);
		floorA.room[3][6] = new RoomInfo(true, false, false, LocalDate.of(2023, 2, 15), LocalDate.of(2023, 6, 25),false);  //8
		// 손손님 체크인 . 방상태 체크인 
		floorA.guest[0][18] = new Guest("선생님", "01089460541", true, false, false);
		floorA.room[0][18] = new RoomInfo(false, true, true, LocalDate.of(2023, 1, 28), LocalDate.of(2023, 9, 1), false);  //9
		// 선샌님 예약 . 예약 o
		
	}


	public void start(ThrowObj throwObj) {
		this.throwObj = throwObj;
		emptyState = throwObj.returnEmptyState();
		search = throwObj.returnSearch();
		editDataObj = throwObj.returnEdit();
		inOutRes = throwObj.CheckInOutReservation();

		generateHotelReturn(1);
		generateHotelReturn(2);
		hotelOpen();
		defaultSetting();
		menuSelect(floorA);
	}
}
