package beans;

public class DashBean {
	
	private String name, mobile, nick, mail, gender, note, userName;
	private java.sql.Date dob;
	public String checkName, checkMobile;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public java.sql.Date getDOB() {
		return dob;
	}
	
	public void setDOB(java.sql.Date dob) {
		this.dob = dob;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	
	public void setCheckMobile(String checkMobile) {
		this.checkMobile = checkMobile;
	}
}
