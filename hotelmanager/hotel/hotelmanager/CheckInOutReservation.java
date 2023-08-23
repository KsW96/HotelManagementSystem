package hotelmanager;

import java.time.LocalDate;
import java.util.Scanner;

public class CheckInOutReservation {
	private final Scanner sc = new Scanner(System.in);
	ManagementSystem ms;

	public CheckInOutReservation(ManagementSystem ms) {
		this.ms = ms;
	}

	// 임태경 //방번호로 바로 들어오는 예약함수
	void inputReservation(int selNum, Floor floor) {
		int i = selNum / 100 - ms.whoFloor(floor);
		int j = selNum % 100 - 1;
		if (floor.room[i][j].isCheckIn() == false && floor.room[i][j].isPossible() == true) {
			System.out.println("예약할 고객의 정보를 아래에 입력해주세요.");
			System.out.println("이      름: ");
			String guestName = sc.nextLine();
			System.out.println("연 락 처 : ");
			String guestPhoneNum = UtilityHotelFuntion.phoneOirgin(sc.nextLine());
			System.out.println("머무를 일수를 입력하세요.");
			int stayDate = sc.nextInt();

			System.out.println("예약이 완료되었습니다.");
			floor.guest[i][j] = new Guest(guestName, guestPhoneNum, true, false, false);
			floor.room[i][j] = new RoomInfo(false, true, true, LocalDate.now(), LocalDate.now().plusDays(stayDate - 1),
					false);
			System.out.println("예약완료");
			System.out.println("첫 화면으로 돌아갑니다.\n");
			ms.menuSelect(floor);
		} else {
			System.out.println("예약이 불가능한 방입니다.");
			System.out.println("첫 화면으로 돌아갑니다.\n");
		}
		ms.menuSelect(floor);

	}

	// 정욱진
	// 방 번호를 검색 후 바로 체크인하기(현장결제)
	void checkIn(int selNum, Floor floor) { // ** 여기에서 예약자명단을 호출해 예약된사람인지 먼저체크한후
		// 예약된사람이면 예약한 방호수, 이름, 번호를 물어볼필요없이
		// 객실객체와, 고객객체의 상태를 나타내는 변수값을 변경해주면된다.
		// 변경해준후 예약자명단에서 예약자를 지워주는것
		// 예약자가 아니라면 현장결제이므로 호실,이름,번호를 물어보고 배열에 인스턴스를 추가해준다.
		int i = selNum / 100 - ms.whoFloor(floor);
		int j = selNum % 100 - 1;

		if ((UtilityHotelFuntion.checkRoomNum2(selNum, floor))) {
			if (floor.room[i][j].isCheckIn() == true) {
				System.out.println("이미 체크인 되어 있는 객실입니다.");
				System.out.println("첫 화면으로 돌아갑니다.\n");
				ms.menuSelect(floor);
			}
			if (floor.room[i][j].isCheckIn() == false && floor.room[i][j].isReservation() == false) {
				System.out.println("이름 입력 : ");
				String guestName = sc.nextLine();

				System.out.println("연락처 입력 : ");
				String guestPhoneNum = UtilityHotelFuntion.phoneOirgin(sc.nextLine());

				System.out.println("머무를 일수를 입력하세요.");
				int stayDate = sc.nextInt();

				System.out.println(" 체크인이 완료되었습니다. ");
				System.out.println("첫 화면으로 돌아갑니다.\n");

				floor.guest[i][j] = new Guest(guestName, guestPhoneNum, false, true, true);
				floor.room[i][j] = new RoomInfo(true, false, false, LocalDate.now(),
						LocalDate.now().plusDays(stayDate - 1), false);
			} else if (floor.room[i][j].isCheckIn() == false && floor.room[i][j].isReservation() == true) {
				System.out.println("본인 확인을 위해 이름, 연락처, 숙박일수를 입력하세요.");
				System.out.println("이름 입력 : ");
				String guestName = sc.nextLine();
				;
				System.out.println("연락처 입력 : ");
				String guestPhoneNum = UtilityHotelFuntion.phoneOirgin(sc.nextLine());
				System.out.println("머무를 일수를 입력하세요.");
				int stayDate = sc.nextInt();

				if ((floor.guest[i][j].getName()).equals(guestName)) {
					System.out.println("체크인이 완료되었습니다.");
					floor.guest[i][j] = new Guest(guestName, guestPhoneNum, false, true, true);
					floor.room[i][j] = new RoomInfo(true, false, false, LocalDate.now(),
							LocalDate.now().plusDays(stayDate - 1), false);
				} else {
					System.out.println("잘못된 입력입니다.");
				}
			} else {
				System.out.println("체크인이 불가능한 객실입니다.\n");
				System.out.println("첫 화면으로 돌아갑니다.\n");
			}
			ms.menuSelect(floor);
		} else {
			System.out.println("체크인이 불가능한 건물입니다.");
		}
		ms.menuSelect(floor);
	}

	// 정욱진
	// 체크인메뉴에서 이동
	void checkIn(Floor floor) {
		System.out.println("객실번호를 입력하세요.");
		int checkInNum = UtilityHotelFuntion.exceptionTest(floor);

		int i = (checkInNum / 100) - ms.whoFloor(floor);
		int j = (checkInNum % 100) - 1;
		if ((UtilityHotelFuntion.checkRoomNum2(checkInNum, floor))) {
			if (floor.room[i][j].isCheckIn() == true) {
				System.out.println("이미 체크인 되어 있는 객실입니다.");
				System.out.println("첫 화면으로 돌아갑니다.\n");
				ms.menuSelect(floor);
			}
			if (floor.room[i][j].isCheckIn() == false && floor.room[i][j].isReservation() == false) {
				System.out.println("이름 입력 : ");
				String guestName = sc.nextLine();

				System.out.println("연락처 입력 : ");
				String guestPhoneNum = UtilityHotelFuntion.phoneOirgin(sc.nextLine());

				System.out.println("머무를 일수를 입력하세요.");
				int stayDate = sc.nextInt();

				System.out.println(" 체크인이 완료되었습니다. ");
				System.out.println("첫 화면으로 돌아갑니다.\n");

				floor.guest[i][j] = new Guest(guestName, guestPhoneNum, false, true, true);
				floor.room[i][j] = new RoomInfo(true, false, false, LocalDate.now(),
						LocalDate.now().plusDays(stayDate - 1), false);
			} else {
				System.out.println("체크인이 불가능한 객실입니다.");
				System.out.println("첫 화면으로 돌아갑니다.\n");
			}
			ms.menuSelect(floor);
		} else {
			System.out.println("체크인이 불가능한 건물입니다.");
		}
		ms.menuSelect(floor);
	}

	// 정욱진
	// 체크아웃
	void checkOut(int selNum, Floor floor) {

		int i = selNum / 100 - ms.whoFloor(floor);
		int j = selNum % 100 - 1;
		if (floor.room[i][j].isCheckIn() == true) {
			floor.guest[i][j] = new Guest();
			floor.room[i][j] = new RoomInfo();
			floor.room[i][j].setClean(false);

			System.out.println(" 체크아웃 되었습니다. ");
			System.out.println("첫 화면으로 돌아갑니다.\n");
		} else {
			System.out.println("체크아웃 불가능한 객실입니다.\n");
			System.out.println("첫 화면으로 돌아갑니다.\n");
		}
		ms.menuSelect(floor);
	}

	// 정욱진
	// 체크아웃
	void checkOut(Floor floor) {
		System.out.println("객실번호를 입력하세요.");
		int checkOutNum = UtilityHotelFuntion.exceptionTest(floor);
		int i = (checkOutNum / 100) - ms.whoFloor(floor);
		int j = (checkOutNum % 100) - 1;

		if (floor.room[i][j].isCheckIn() == false) {
			System.out.println("체크아웃 불가능한 객실입니다.");
			System.out.println("첫 화면으로 돌아갑니다.\n");
			ms.menuSelect(floor);
		} else {
			floor.guest[i][j] = new Guest();
			floor.room[i][j] = new RoomInfo();
			floor.room[i][j].setClean(false);

			System.out.println(" 체크아웃 되었습니다. ");
			System.out.println("첫 화면으로 돌아갑니다.\n");
			ms.menuSelect(floor);
		}
	}

}
