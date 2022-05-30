package com.stg.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.stg.entity.Payments;
import com.stg.exception.PaymentException;
import com.stg.repository.PaymentRepository;

public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payments checkPayment(UUID paymentUuid) {

		Payments payment = paymentRepository.findByPaymentId(paymentUuid);
		if (payment == null) {
			throw new PaymentException("Payment not found!");
		} else {
			return payment;
		}

	}

	@Override
	public List<Payments> fetchPaymentList() {

		return paymentRepository.findAll();
	}

	@Override
	public Payments addPayment(Payments payment) {

		return paymentRepository.save(payment);
	}

	@Override
	public List<Payments> searchByPaymentDate(Date paymentDate) {

		return paymentRepository.findByPaymentDate(paymentDate);
	}

	@Override
	public Payments updatePayment(Payments payment) {

		return paymentRepository.save(payment);
	}

	@Override
	public void deleteByPaymentCustomerId(UUID paymentUuid) {
		paymentRepository.deleteByPaymentCustomerId(paymentUuid);

	}

}
