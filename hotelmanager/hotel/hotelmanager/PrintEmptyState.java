package hotelmanager;

import java.util.Scanner;

public class PrintEmptyState {
	private final Scanner sc = new Scanner(System.in);
	ManagementSystem ms;

	public PrintEmptyState(ManagementSystem ms) {
		this.ms = ms;
	}

	// 김성우 // 룸 상태 출력
	int roomView(Floor floor) {
		System.out.println("객실번호를 입력하세요.");
		int roomNumber = UtilityHotelFuntion.exceptionTest(floor);
		int i = roomNumber / 100 - ms.whoFloor(floor); // i 는 층의 넘버
		int j = roomNumber % 100 - 1; // j 는 호실 넘버
		if(floor.room[i][j].isCheckIn() == true){// 출력
			System.out.println("\n선택하신 객실은 [" + roomNumber + "호] 입니다.");

			if (floor.guest[0].length == 20) {
				if (j % 2 == 0) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			} else {
				if (j < 5) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			}
			System.out.println("----------- 투 숙 객 -----------");
			System.out.println("성         함 : " + floor.guest[i][j].getName());
			System.out.println("연   락   처 : " + UtilityHotelFuntion.phone(floor.guest[i][j].getPhoneNum()));
			System.out.println("입 실 일 자 : " + floor.room[i][j].getCheckInTime());
			System.out.println("퇴 실 일 자 : " + floor.room[i][j].getCheckOutTime());
			System.out.println("결 제 여 부 : " + UtilityHotelFuntion.reNameFildPeyment(floor.guest[i][j].isPayment()));
			System.out.println("----------- 방 상 태 -----------");
			System.out.println("청 소 여 부 : " + UtilityHotelFuntion.reNameFildClean(floor.room[i][j].isClean()));
			System.out.println("예 약 여 부 : 예약 불가");// + UtilityHotelFuntion.reNameFildReservation(floor.room[i][j].isReservation()));
		} else if (floor.room[i][j].isPossible() == true && floor.room[i][j].isCheckIn() == false && floor.room[i][j].isReservation() == false) {
			System.out.println("\n선택하신 객실은 [" + roomNumber + "호] 입니다.");
			if (floor.guest[0].length == 20) {
				if (j % 2 == 0) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			} else {
				if (j < 5) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			}
			System.out.println("----------- 방 상 태 -----------");
			System.out.println("청 소 여 부 : " + floor.room[i][j].isClean());
			System.out.println("예 약 여 부 : " + floor.room[i][j].isPossible());

		} else if (floor.room[i][j].isPossible() == false && floor.room[i][j].isReservation() == true) {
			System.out.println("\n선택하신 객실은 [" + roomNumber + "호] 입니다.");
			if (floor.guest[0].length == 20) {
				if (j % 2 == 0) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			} else {
				if (j < 5) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			}
			System.out.println("----------- 예 약 고 객 -----------");
			System.out.println("성         함 : " + floor.guest[i][j].getName());
			System.out.println("연   락   처 : " + UtilityHotelFuntion.phone(floor.guest[i][j].getPhoneNum()));
			System.out.println("입 실 일 자 : " + floor.room[i][j].getCheckInTime());
			System.out.println("퇴 실 일 자 : " + floor.room[i][j].getCheckOutTime());
			System.out.println("결 제 여 부 : " + UtilityHotelFuntion.reNameFildPeyment(floor.guest[i][j].isPayment()));
			System.out.println("----------- 방  상  태 -----------");
			System.out.println("청 소 여 부 : " + UtilityHotelFuntion.reNameFildClean(floor.room[i][j].isClean()));
			System.out.println(
					"예 약 여 부 : " + UtilityHotelFuntion.reNameFildReservation(floor.room[i][j].isReservation()));
		}
		ms.setMenu(roomNumber, floor);
		return roomNumber;
	}

	// roomView Overloading
	// 김성우
	void roomView(int i, int j, Floor floor) {
		// System.out.println("test");
		if (floor.room[i][j].isCheckIn() == true && floor.room[i][j].isPossible() == false) { // 체크인 되있고, 예약이 불가
			// System.out.println("test");
			System.out.print("\n선택하신 객실은 [");
			System.out.println((i + ms.whoFloor(floor)) * 100 + j + 1 + "호] 입니다.");
			if (floor.guest[0].length == 20) {
				if (j % 2 == 0) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			} else {
				if (j < 5) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			}
			System.out.println("----------- 투 숙 객 -----------");
			System.out.println("성         함 : " + floor.guest[i][j].getName());
			System.out.println("연   락   처 : " + UtilityHotelFuntion.phone(floor.guest[i][j].getPhoneNum()));
			System.out.println("입 실 일 자 : " + floor.room[i][j].getCheckInTime());
			System.out.println("퇴 실 일 자 : " + floor.room[i][j].getCheckOutTime());
			System.out.println("결 제 여 부 : " + UtilityHotelFuntion.reNameFildPeyment(floor.guest[i][j].isPayment()));
			System.out.println("----------- 방 상 태 -----------");
			System.out.println("청 소 여 부 : " + UtilityHotelFuntion.reNameFildClean(floor.room[i][j].isClean()));
			System.out.println(
					"예 약 여 부 : 예약 불가");// + UtilityHotelFuntion.reNameFildReservation(floor.room[i][j].isReservation()));

		} else if (floor.room[i][j].isPossible() == true && floor.room[i][j].isCheckIn() == false) {
			System.out.print("\n선택하신 객실은 [");
			System.out.println((i + ms.whoFloor(floor)) * 100 + j + 1 + "호] 입니다.");
			if (floor.guest[0].length == 20) {
				if (j % 2 == 0) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			} else {
				if (j < 5) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			}
			System.out.println("----------- 방 상태 -----------");
			System.out.println("청 소 여 부 : " + floor.room[i][j].isClean());
			System.out.println("예 약 여 부 : " + floor.room[i][j].isPossible());

		} else if (floor.room[i][j].isPossible() == false && floor.room[i][j].isCheckIn() == false) {
			System.out.print("\n선택하신 객실은 [");
			System.out.println((i + ms.whoFloor(floor)) * 100 + j + 1 + "호] 입니다.");
			if (floor.guest[0].length == 20) {
				if (j % 2 == 0) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			} else {
				if (j < 5) {
					System.out.println("룸 타입: 싱글 룸");
				} else {
					System.out.println("룸 타입: 더블 룸");
				}
			}

			System.out.println("----------- 예 약 고 객 -----------");
			System.out.println("성         함 : " + floor.guest[i][j].getName());
			System.out.println("연   락   처 : " + UtilityHotelFuntion.phone(floor.guest[i][j].getPhoneNum()));
			System.out.println("입 실 일 자 : " + floor.room[i][j].getCheckInTime());
			System.out.println("퇴 실 일 자 : " + floor.room[i][j].getCheckOutTime());
			System.out.println("결 제 여 부 : " + UtilityHotelFuntion.reNameFildPeyment(floor.guest[i][j].isPayment()));
			System.out.println("----------- 방  상  태 -----------");
			System.out.println("청 소 여 부 : " + UtilityHotelFuntion.reNameFildClean(floor.room[i][j].isClean()));
			System.out.println(
					"예 약 여 부 : " + UtilityHotelFuntion.reNameFildReservation(floor.room[i][j].isReservation()));
		}

		ms.menuSelect(floor);
	}

	// 김성우 // 호실 출력과 입실 유무 출력
	// B동도 A동 처럼 2층에서 5층까지 나오는걸 1 ~ 3 으로 수정
	// B동은 1~5 싱글 6~10 더블인데 이 부분도 수정

	void selectFloor(Floor floor) {
		if (floor.guest[0].length == 20) {
			System.out.println("1. 2층  2. 3층  3. 4층   4. 5층 ");
			System.out.println("객실 full (o)\t예약 full(Δ)\t객실 empty 예약 empty (x)");
			System.out.println("\n[1]   2  층\n[2]   3  층\n[3]   4  층\n[4]   5  층");
			int selectFloor = UtilityHotelFuntion.exceptionTest(1, floor.room.length);

			for (int i = 0; i < floor.room[selectFloor - 1].length; i++) {
				System.out.print((selectFloor + ms.whoFloor(floor) - 1) * 100 + i + 1 + " "); // 호실 출력
			}
			System.out.println();
			System.out.print(" ");
			char ox;
			for (int j = 0; j < floor.room[selectFloor - 1].length; j++) { // 입실 유무 체크

				if (floor.room[selectFloor - 1][j].isCheckIn() == true
						&& floor.room[selectFloor - 1][j].isPossible() == false) {
					ox = 'o';
				} else if (floor.room[selectFloor - 1][j].isCheckIn() == false
						&& floor.room[selectFloor - 1][j].isReservation() == true) {
					ox = 'Δ';
				} else {
					ox = 'x';
				}
				System.out.print("" + ox + "   ");
			}
		} else {
			System.out.println("예약 full(o)\tempty(x)");
			System.out.println("\n[1]   1  층\n[2]   2  층\n[3]   3  층");
			int selectFloor = UtilityHotelFuntion.exceptionTest(1, floor.room.length);

			for (int i = 0; i < floor.room[selectFloor - 1].length; i++) {
				System.out.print((selectFloor + ms.whoFloor(floor) - 1) * 100 + i + 1 + " "); // 호실 출력
			}
			System.out.println();
			System.out.print(" ");
			char ox;
			for (int j = 0; j < floor.room[selectFloor - 1].length; j++) { // 입실 유무 체크
				if (floor.room[selectFloor - 1][j].isCheckIn() == true
						|| floor.room[selectFloor - 1][j].isReservation() == true) {
					ox = 'o';
				} else {
					ox = 'x';
				}
				System.out.print(ox + "   ");
			}
		}

		System.out.println();
		roomView(floor);
	}
}
