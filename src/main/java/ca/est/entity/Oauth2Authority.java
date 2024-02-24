package ca.est.entity;

import java.time.LocalDateTime;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
/**
 * @author Estevam Meneses
 */
@Getter
@Setter
@Entity
@Table(name = "oauth2_authority")
public class Oauth2Authority implements GrantedAuthority {
	/**
	 * @author Estevam Meneses
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @author Estevam Meneses
	 */
	
	@Id
	@Column(name = "id_authority")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_authority;
	
	@Column(name = "authority")
    private String authority;	
	
	@Column(name = "created")
	private LocalDateTime created;
  
	//@JsonBackReference //is the back part of reference; it’ll be omitted from serialization.
	//@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	//@JoinColumn(name = "id_user")
    //private Oauth2User oauth2User;
    
	public Oauth2Authority() {
		super();
	}
	
	/**
	 * @param id_role
	 * @param role
	 * @param created
	 */
	public Oauth2Authority(Long id_role, String authority, LocalDateTime created) {
		super();
		this.id_authority = id_role;
		this.authority = authority;
		this.created = created;
	}
	    
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
}