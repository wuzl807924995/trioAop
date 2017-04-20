package test.path.business;

public class UserBean {

	private int id;

	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserBean() {
	}

	public UserBean(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", userName=" + userName + "]";
	}

}
