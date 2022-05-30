package com.stg.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Payments;
import com.stg.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/checkpayment", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payments> checkPayment(@RequestParam UUID paymentUuid) {

		Payments payment = paymentService.checkPayment(paymentUuid);

		return new ResponseEntity<Payments>(payment, HttpStatus.OK);
	}

	@GetMapping(value = "/checkpayment", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payments> fetchPaymentList() {

		List<Payments> payment = paymentService.fetchPaymentList();

		return new ResponseEntity<Payments>((Payments) payment, HttpStatus.OK);
	}

	@PostMapping(value = "/addpayment", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payments> addPayment(@RequestParam Payments payment) {

		Payments payments = paymentService.addPayment(payment);

		return new ResponseEntity<Payments>(payments, HttpStatus.OK);
	}

	@GetMapping(value = "/searchpayment", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payments> searchByPaymentDate(@RequestParam Date paymentDate) {

		List<Payments> payment = paymentService.searchByPaymentDate(paymentDate);

		return new ResponseEntity<Payments>((Payments) payment, HttpStatus.OK);
	}

	@PutMapping(value = "/updatepayment", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payments> updatePayment(@RequestParam Payments payment) {

		Payments payments = paymentService.updatePayment(payment);

		return new ResponseEntity<Payments>(payments, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletepayment", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payments> deleteByPaymentCustomerId(@RequestParam UUID paymentUuid) {

		paymentService.deleteByPaymentCustomerId(paymentUuid);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
