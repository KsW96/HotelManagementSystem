package hotelmanager;

public class Guest { // 임태경
	private String name;
	private String phoneNum;
	private boolean res;
	private boolean stay;
	private boolean payment;

	public Guest(String name, String phoneNum, boolean res, boolean stay, boolean payment) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.res = res;
		this.stay = stay;
		this.payment = payment;

	}

	public Guest() {
		this.name = "";
		this.phoneNum = "";
		this.res = false;
		this.stay = false;
		this.payment = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public boolean isRes() {
		return res;
	}

	public void setRes(boolean res) {
		this.res = res;
	}

	public boolean isStay() {
		return stay;
	}

	public void setStay(boolean stay) {
		this.stay = stay;
	}

	public boolean isPayment() {
		return payment;
	}

	public void setPayment(boolean payment) {
		this.payment = payment;
	}

}
