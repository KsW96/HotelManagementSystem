package hotelmanager;

import java.time.LocalDate;
import java.util.Scanner;

public class EditArrayElementData { // 임태경
	private final Scanner sc = new Scanner(System.in);
	ManagementSystem ms;

	public EditArrayElementData(ManagementSystem ms) {
		this.ms = ms;
	}

	// 선보라//이식완
	void setHotelReservation(Floor floor) {
		while (true) {
			System.out.println("방 번호를 입력하세요.");
			int roomNum = UtilityHotelFuntion.exceptionTest(floor);
			int selFloorNum = (roomNum / 100) - ms.whoFloor(floor);
			int selRoomNum = (roomNum % 100) - 1;
			if (floor.room[selFloorNum][selRoomNum].isReservation() == true) {
				System.out.print("\n선택하신 객실은 [" + roomNum + "호]이며,");
				System.out.println(" 예약 중 입니다.");
				floor.guest[selFloorNum][selRoomNum] = new Guest();
				floor.room[selFloorNum][selRoomNum] = new RoomInfo();
				System.out.println("예약이 취소되었습니다.");
				break;
			} else {
				System.out.println("\n선택하신 객실은 [" + roomNum + "호] 입니다.");
				System.out.println("현재 이 방은 현재 예약상태가 아닙니다.");
				break;
			}
		}
		ms.menuSelect(floor);
	}

	// 선보라 //이식완
	void setHotelPhoneNumber(Floor floor) {
		// 방번호 입력

		while (true) {
			System.out.println("객실번호를 입력하세요.");
			int roomNum = UtilityHotelFuntion.exceptionTest(floor);
			int selFloorNum = (roomNum / 100) - ms.whoFloor(floor);
			int selRoomNum = (roomNum % 100) - 1;
			if (floor.guest[selFloorNum][selRoomNum].getPhoneNum() != "") {
				System.out.println("\n선택하신 객실은 [" + roomNum + "호] 입니다.");
				System.out.println("현재 객실을 이용중인 고객님의 연락처는 "
						+ UtilityHotelFuntion.phone(floor.guest[selFloorNum][selRoomNum].getPhoneNum()) + "입니다.");
				System.out.println("변경 할 번호를 입력하세요");
				String setNum = UtilityHotelFuntion.phone(sc.nextLine());
				floor.guest[selFloorNum][selRoomNum].setPhoneNum(setNum);
				System.out.println("변경이 완료되었습니다.");
				break;
			} else {
				System.out.println("고객정보가 없습니다. 고객님이 이용중인 방 번호를 다시 입력해주세요.");
			}
		}
		ms.menuSelect(floor);
	}

	// 선보라 //이식완
	void setHotelPay(Floor floor) {

		while (true) {
			System.out.println("객실번호를 입력하세요.");
			int roomNum = UtilityHotelFuntion.exceptionTest(floor);
			int selFloorNum = (roomNum / 100) - ms.whoFloor(floor);
			int selRoomNum = (roomNum % 100) - 1;

			// if 하나 줄였어용
			if (floor.guest[selFloorNum][selRoomNum].getName() != "") {
				if (floor.guest[selFloorNum][selRoomNum].isPayment() == false) {
					System.out.println("\n선택하신 객실은 [" + roomNum + "호] 입니다.");
					System.out.println("해당 객실은 미결제 상태 입니다.");
					floor.guest[selFloorNum][selRoomNum].setPayment(true);
					System.out.println("변경이 완료되었습니다.");
					break;
				} else {
					System.out.println("\n선택하신 객실은 [" + roomNum + "호] 입니다.");
					System.out.println("이미 객실의 모든 결제가 완료된 상태입니다.");
					break;
				}
			} else {
				System.out.println("고객정보가 없습니다. 방 번호를 다시 입력해주세요.");
			}
		}
		ms.menuSelect(floor);
	}

	// 선보라 //이식완
	void setHotelClean(Floor floor) {
		// 방번호 입력
		while (true) {
			System.out.println("객실번호를 입력하세요.");
			int roomNum = UtilityHotelFuntion.exceptionTest(floor);
			int selFloorNum = (roomNum / 100) - ms.whoFloor(floor);
			int selRoomNum = (roomNum % 100) - 1;
			if (floor.room[selFloorNum][selRoomNum].isClean() == false) {
				System.out.println("\n선택하신 객실은 [" + roomNum + "호] 입니다.");
				System.out.println("현재 지시하신 청소가 모두 완료되었습니다.");
				floor.guest[selFloorNum][selRoomNum].setPayment(true);
				break;
			} else {
				System.out.println("\n선택하신 객실은 [" + roomNum + "호] 입니다.");
				System.out.println("이미 청소가 완료된 상태입니다.");
				break;
			}
		}
		ms.menuSelect(floor);
	}

	// 선보라 //이식완
	void setHotelStay(Floor floor) {
	      while (true) {
	         System.out.println("객실번호를 입력하세요.");
	         int roomNum = UtilityHotelFuntion.exceptionTest(floor);
	         int selFloorNum = (roomNum / 100) - ms.whoFloor(floor);
	         int selRoomNum = (roomNum % 100) - 1;

	         if ((UtilityHotelFuntion.checkRoomNum2(roomNum, floor))) {
	            System.out.println("\n선택하신 객실은 [" + roomNum + "호] 입니다.");
	            System.out.println("체크아웃 날짜를 언제로 변경하시겠습니까?");
	            System.out.println("변경하고자 하는 년,월,일을 차례대로 입력해주세요.");
	            while (true) {
	               int y = sc.nextInt();
	               int m = sc.nextInt();
	               int d = sc.nextInt();
	               System.out.println("머무를 일수를 입력해주세요.");
	               int stayDate = sc.nextInt();
	               if (LocalDate.now().isBefore(LocalDate.of(y, m, d))) {
	                  floor.room[selFloorNum][selRoomNum].setCheckInTime(LocalDate.of(y, m, d));
	                  floor.room[selFloorNum][selRoomNum].setCheckOutTime(LocalDate.of(y, m, d));
	                  System.out.println("입실 날짜: " + floor.room[selFloorNum][selRoomNum].getCheckInTime() + "입니다.");
	                  System.out.println("퇴실 날짜: "+ (floor.room[selFloorNum][selRoomNum].getCheckOutTime()).plusDays(stayDate)+ " 입니다.");
	                  System.out.println("변경이 완료되었습니다.");
	                  ms.menuSelect(floor);
	               } else {
	                  System.out.println("현재의 날짜보다 과거입니다. 다시 확인하고 입력해주세요.");
	               }
	            }
	         } else {
	            System.out.println("체크인이 불가능한 건물입니다.");
	            ms.menuSelect(floor);
	         }
	      }
	   }
	}