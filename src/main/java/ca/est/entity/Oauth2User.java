package ca.est.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Setter;

/**
 * @author Estevam Meneses
 */
@Setter
@Entity
@Table(name = "oauth2_user")
public class Oauth2User implements UserDetails{
	
	/**
	 * @author Estevam Meneses
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "password")
    private String password;

	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	
	@Column(name = "created")
	private LocalDateTime created;
	
	@Column(name = "oauth2_cliente_id")
    private Long Oauth2ClienteID;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "oauth2_user_authority",
	      joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_user"),
	      inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id_authority"))
	private Collection<Oauth2Authority> authorities;
	  
	@Column(name = "is_account_expired")
	  private boolean isAccountExpired;
	  private boolean isAccountLocked = false;
	  private boolean isCredentialsExpired = false;
	  private boolean isEnabled = false;

 	public Oauth2User() {
 		super();
 	}	
	/**
	 * 
	 * @param id_user
	 * @param username
	 * @param password
	 */
 	public Oauth2User(Long id_user, String username, String password) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
	}    
	
	/**
	 * 
	 * @param id_user
	 * @param username
	 * @param password
	 * @param created
	 */
	public Oauth2User(Long id_user, String username, String password, LocalDateTime created) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.created = created;
	}
	
	public Oauth2User(String username, String password, Collection<Oauth2Authority> authorities) {
		super();
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	/**
	 * 
	 * @param id_user
	 * @param username
	 * @param password
	 * @param created
	 */
	public Oauth2User(Long id_user, String username, String password, LocalDateTime created, LocalDateTime lastUpdate) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.created = created;
		this.lastUpdate = lastUpdate;
	}
	public Oauth2User(Long id_user, String username, String password, LocalDateTime lastUpdate, LocalDateTime created,
			Long oauth2ClienteID, Collection<Oauth2Authority> authorities, Boolean isAccountExpired, Boolean isAccountLocked,
			Boolean isCredentialsExpired, Boolean isEnabled) {
		super();
		this.id_user = id_user;
		this.username = username;
		this.password = password;
		this.lastUpdate = lastUpdate;
		this.created = created;
		Oauth2ClienteID = oauth2ClienteID;
		this.authorities = authorities;
		this.isAccountExpired = isAccountExpired;
		this.isAccountLocked = isAccountLocked;
		this.isCredentialsExpired = isCredentialsExpired;
		this.isEnabled = isEnabled;
	}
	 @Override
	  public boolean isAccountNonExpired() {
	    return !this.isAccountExpired;
	  }

	  @Override
	  public boolean isAccountNonLocked() {
	    return !this.isAccountLocked;
	  }

	  @Override
	  public boolean isCredentialsNonExpired() {
	    return !this.isCredentialsExpired;
	  }

	  @Override
	  public boolean isEnabled() {
	    return !this.isEnabled;
	  }
	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    return this.authorities;
	  }

	  @Override
	  public String getPassword() {
	    return this.password;
	  }

	  @Override
	  public String getUsername() {
	    return this.username;
	  }
}
