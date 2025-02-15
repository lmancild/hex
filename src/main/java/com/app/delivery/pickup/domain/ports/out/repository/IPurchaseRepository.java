package com.app.delivery.pickup.domain.ports.out.repository;

import com.app.delivery.pickup.application.command.CommandConfirmPickUp;

/**
 * @author lmancild
 * @since 1.0.0
 *
 */
public interface IPurchaseRepository {

	/**
	 * 
	 * @param command
	 */
	void save(CommandConfirmPickUp command);
}
