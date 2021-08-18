package teste.residencia.shared;

import teste.residencia.model.User;

public class LoginResponse {

	private User user;

	public LoginResponse(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
