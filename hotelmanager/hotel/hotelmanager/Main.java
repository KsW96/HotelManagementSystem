package hotelmanager;

public class Main {
	public static void main(String[] args) {
		ManagementSystem manageSystem = new ManagementSystem();
		ThrowObj throwObj = new ThrowObj();
		throwObj.ms = manageSystem;
		manageSystem.startViwe();
		manageSystem.start(throwObj);
		manageSystem.endViwe();
	}
}
