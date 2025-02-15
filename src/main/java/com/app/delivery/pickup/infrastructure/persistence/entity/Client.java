package com.app.delivery.pickup.infrastructure.persistence.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 
 * @author lmancild
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
@Table(name = "CLIENT")
@Getter
@Setter
public class Client  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="CLIENT_ID")
	private String clientId;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Purchase> pruchases;
	
}
