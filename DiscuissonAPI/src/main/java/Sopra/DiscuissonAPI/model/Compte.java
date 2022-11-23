package Sopra.DiscuissonAPI.model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('Admin','Nutritionist','User')")
@Table(name="compte")
public class Compte implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero")
	@JsonView(JsonViews.Common.class)
	protected Integer id;
	
	@Column(length = 50,nullable = false,unique = true)
	@JsonView(JsonViews.Common.class)
	protected String login;
	
	@Column(length = 255,nullable = false)
	protected String password;
	
	public Compte() {
	}

	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public Compte(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
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

	@Override
	public String toString() {
		return "Compte [id=" + id + ", login=" + login + ", password=" + password + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role=null;
		if(this instanceof User) {
			role="ROLE_USER";
		}
			else if(this instanceof Admin) {
			role="ROLE_ADMIN";
		}
			else if(this instanceof Nutritionist){	
				role="ROLE_NUTRITIONIST";
		}
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}
	
	@JsonView(JsonViews.Common.class)
	public String getROLE() {
		String role=null;
		if(this instanceof User) {
			role="ROLE_USER";
		}
			else if(this instanceof Admin) {
			role="ROLE_ADMIN";
		}
			else if(this instanceof Nutritionist){	
				role="ROLE_NUTRITIONIST";
		}
		return role;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
