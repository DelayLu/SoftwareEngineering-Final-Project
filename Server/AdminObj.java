
public class AdminObj {
	public String AdminId;
	public String Password;
	
	public void putData(String id, String pw){
		this.AdminId = id;
		this.Password = pw;
	}
	
	public boolean compare(AdminObj admin){
		return (admin.AdminId.equals(this.AdminId)&&admin.Password.equals(this.Password));
	}
}
