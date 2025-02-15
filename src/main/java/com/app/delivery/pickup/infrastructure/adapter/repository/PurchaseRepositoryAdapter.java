package com.app.delivery.pickup.infrastructure.adapter.repository;

import org.springframework.stereotype.Service;

import com.app.delivery.pickup.application.command.CommandConfirmPickUp;
import com.app.delivery.pickup.domain.ports.out.repository.IPurchaseRepository;
import com.app.delivery.pickup.infrastructure.persistence.entity.QPurchase;
import com.querydsl.jpa.impl.JPAUpdateClause;

import jakarta.persistence.EntityManager;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
@Service
public class PurchaseRepositoryAdapter implements IPurchaseRepository {

//	private JpaPurchaseRepository jpaPurchaseRepository;
	private EntityManager entityManager;
	
	
	
	public PurchaseRepositoryAdapter(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}



	@Override
	public void save(CommandConfirmPickUp command) {
		QPurchase purchase = QPurchase.purchase;
		JPAUpdateClause update = new JPAUpdateClause(entityManager, purchase)
				.where(purchase.code.eq(command.getPurchaseCode()))
				.set(purchase.pickUpDate, command.getPickUpDate())
				.set(purchase.status, command.getPruchaseStatus());
		update.execute();
	}

}
