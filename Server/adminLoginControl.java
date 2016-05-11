
public class adminLoginControl {
	private AdminLoginDataManager dm;

	public adminLoginControl(AdminLoginDataManager dm) {
		this.dm = dm;
	}

	public boolean processLogin(AdminObj admin) {
		AdminObj adminDB = dm.getAdminRecord();
		boolean result = false;

		if (admin.compare(adminDB)) {
			result = true;
		} 
		else {
			result = false;
		}
		return result;
	}

}
