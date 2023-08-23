package hotelmanager;

import java.util.Scanner;

public class Search { // 임태경
	private final Scanner sc = new Scanner(System.in);
	ManagementSystem ms;
	PrintEmptyState emptyState;

	public Search(ManagementSystem ms, PrintEmptyState emptyState) {
		this.ms = ms;
		this.emptyState = emptyState;
	}

	// 임태경
	void guestNameSearch(Floor floor) {
		System.out.println("정보를 원하는 고객의 성함을 아래에 입력해주세요.");
		System.out.print("이     름 : ");
		
		String str = sc.nextLine();
		for (int i = 0; i < floor.guest.length; i++) {
			for (int j = 0; j < floor.guest[i].length; j++) {
				if (floor.guest[i][j].getName().equals(str)) {
					//System.out.println("test");
					//System.out.println(i +" "+j+" ");
					emptyState.roomView(i, j, floor);
					
					// ms.menuSelect(floor); 5/13 2pm 수정

				} else {
				}
			}
		}
		System.out.println(str + "님에 대한 정보를 찾을 수 없습니다. 다시 입력해주세요.");
		ms.menuSelect(floor); // search안에 선언되어있는 새로만든 ms변수에있는 ManagementSystem 메소드를 사용한것같다.

	}

	// 임태경
	// 폰번호로 검색
	void guestPhoneNumSearch(Floor floor) {
		System.out.println("정보를 원하는 고객의 연락처를 아래에 입력해주세요.");
		System.out.print("연 락 처 : ");
		String str = sc.nextLine();

		for (int i = 0; i < floor.guest.length; i++) {
			for (int j = 0; j < floor.guest[i].length; j++) {
				if (floor.guest[i][j].getPhoneNum().equals(str)) {
					emptyState.roomView(i, j, floor);
					//ms.menuSelect(floor);
				}
			}
		}
		System.out.println(str + ", 해당 연락처의 고객에 대한 정보를 찾을 수 없습니다.");
		ms.menuSelect(floor);
	}

}
