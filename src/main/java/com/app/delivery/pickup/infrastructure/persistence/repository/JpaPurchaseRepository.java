package com.app.delivery.pickup.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.app.delivery.pickup.infrastructure.persistence.entity.Purchase;

/**
 * 
 * 
 * @author lmancild
 * @version 1.0.0
 * @since 1.0.0
 */
public interface JpaPurchaseRepository
		extends JpaRepository<Purchase, Long>, QuerydslPredicateExecutor<Purchase> {

}
