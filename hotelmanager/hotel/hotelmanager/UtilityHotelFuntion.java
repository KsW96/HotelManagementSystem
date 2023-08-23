package hotelmanager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UtilityHotelFuntion {

	private static int roomNum;
	private static Scanner sc = new Scanner(System.in);

	// 임태경
	public static boolean checkRoomNum(int a, Floor selectFloor) { // **입력한 호수가 존재하는 호실인지 검사
		int floor = a / 100;
		int roomNum = a % 100;
		if (selectFloor.room[0].length == 20) {
			if (floor >= 2 && floor <= 5) {
				if (roomNum >= 1 && roomNum <= 20) {
					return true;
				}
			}
		} else {
			if (floor >= 1 && floor <= 3) {
				if (roomNum >= 1 && roomNum <= 10) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean checkRoomNum2(int a, Floor selectFloor) { // B동에서 체크인이 가능해지는 현상을 막기 위해 생성
		int floor = a / 100;
		int roomNum = a % 100;
		if (selectFloor.room[0].length == 20) {
			if (floor >= 2 && floor <= 5) {
				if (roomNum >= 1 && roomNum <= 20) {
					return true;
				}
			}
		}
		return false;
	}
	
	// _12 B동에서도 이메서드가 동작하려면 파라미터를 int a뿐만아니라 현재 운용중인 Floor객체의 소속을 받아와야한다.
		// A동을 파라미터로 받았으면 2중for문안에 쓰는 length를 통해 if문안에 숫자를 대입해줘야
		// B동을 운용중일때도 정상적으로 돌아갈것.

	/*
	 * _12 어디에서동작을하는 유틸리티 함수인가? public static boolean checkChoiceNum(int b, int c) {
	 * // 선택한 항목이 정수인지, 범위 안의 정수 인지. // 선택해야하는 범위값 설정마다 메소드 만들수 없어서 그냥 여긴 수동으로 입력 if
	 * (b > 0 && b <= c) { // 층 호실 출력 범위 설정 return true; } else { return false; }
	 * 
	 * }
	 */
	// 임태경
	public static int exceptionTest(int a, int b) {
		while (true) {
			try {
				roomNum = sc.nextInt();
				break;
			} catch (InputMismatchException ime) {
				sc = new Scanner(System.in);
				System.out.println("숫자만 입력 가능합니다.");
			}
		}
		if (!(roomNum >= a && roomNum <= b)) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력하세요.");
			exceptionTest(a, b);
		}
		return roomNum;
	}

	// 임태경
	public static int exceptionTest(Floor floor) {

		while (true) {
			try {
				roomNum = sc.nextInt();
				break;
			} catch (InputMismatchException ime) {
				sc = new Scanner(System.in);
				System.out.println("숫자만 입력 가능합니다.");
			}
		}
		if (!(checkRoomNum(roomNum, floor))) {
			System.out.println("잘못된 입력입니다.");
			System.out.println("다시 입력하세요.");
			exceptionTest(floor);
		}
		return roomNum;
	}

	public static String phone(String number) {

		String newStr = "";

		while(true) {
			if(number.length()==8) {
				//return number;
				newStr = "010-"+number.substring(0,4)+"-"+number.substring(4);
				return newStr;
			}else if(number.length() > 8&&number.length()==11&&number.substring(0,3).equals("010") ){
				//return number;
				newStr = number.substring(0,3)+"-"+number.substring(3,7)+"-"+number.substring(7);
				return newStr;
			}
		}

}
	
	public static String phoneOirgin(String number) {

		while (true) {
			String restr = number.replaceAll("[^0-9]", "");
			System.out.println(restr);
			if (restr.length() == 8) {
				return restr;
			} else if (restr.length() > 8&&restr.length() == 11 && restr.substring(0, 3).equals("010")) {
				return restr;
			} else {
				System.out.println("올바른 전화번호가 아닙니다. \n8자리 혹은 11자리의 전화번호를 입력하세요");
				number = sc.nextLine();
			}
		}
	}	

	public static String reNameFildCheckIn(boolean a) {
		String checkIn;
		if(a==true) {
			return checkIn = "체크인";
		}else {
			return checkIn = "체크아웃";
		}
	}

	public static String reNameFildClean(boolean a) {
		String clean;
		if(a==true) {
			return clean = "청소중";
		}else {
			return clean = "완료";
		}
	}
	
	public static String reNameFildReservation(boolean a) {
		String reservation;
		if(a==true) {
			return reservation = "예약불가";
		}else {
			return reservation = "예약가능";
		}
	}
	
	public static String reNameFildPeyment(boolean a) {
		String pay;
		if(a==true) {
			return pay = "결제완료";
		}else {
			return pay = "미결제";
		}
	}

	
}
