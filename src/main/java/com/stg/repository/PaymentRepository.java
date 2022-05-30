package com.stg.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stg.entity.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Integer> {

	public List<Payments> findByPaymentDate(Date paymentDate);

	public Payments findByPaymentId(UUID paymentUuid);

	public void deleteByPaymentCustomerId(UUID paymentUuid);

}
