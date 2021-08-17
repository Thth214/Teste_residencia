package teste.residencia.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;	
	@Column(name = "login", nullable = false)
	private String login;	
	@Column(name = "password", nullable = false)
	private String password;	
	@Column(name = "last_login_date", nullable = false)
	private Timestamp last_login_date;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(Integer id, String login, String password, Timestamp last_login_date) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.last_login_date = last_login_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Timestamp last_login_date) {
		this.last_login_date = last_login_date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
