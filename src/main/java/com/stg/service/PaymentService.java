package com.stg.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.stg.entity.Payments;

public interface PaymentService {

	public abstract Payments checkPayment(UUID paymentUuid); // validation

	public abstract List<Payments> fetchPaymentList(); // read

	public abstract Payments addPayment(Payments payment); // add

	public abstract List<Payments> searchByPaymentDate(Date paymentDate); // search

	public abstract Payments updatePayment(Payments payment); // update

	public abstract void deleteByPaymentCustomerId(UUID paymentUuid); // delete

}
