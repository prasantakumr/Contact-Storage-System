package beans;

public class LoginBean {
	
	private String user, pass;
	
	public LoginBean(String user, String pass) {
		this.setUser(user);
		this.setPass(pass);
	}

	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}


}
