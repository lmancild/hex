package com.app.delivery.pickup.infrastructure.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "PURCHASE")
@Getter
@Setter
public class Purchase  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;
	
	@Column(name="PURCHASE_CODE")
	private String code;
	
	@Column(name="PURCHASE_PICKUP_DATE")
	private Date pickUpDate;
	
	@Column(name="PURCHASE_SATUS")
	private String status;

	@Override
	public String toString() {
		return "Purchase [id=" + id + ", client=" + client + ", code=" + code + ", pickUpDate=" + pickUpDate
				+ ", status=" + status + "]";
	}
	
	
}
