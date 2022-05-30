package com.stg.controller;

import java.time.LocalDate;
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

import com.stg.entity.Sales;
import com.stg.service.SalesService;

@RestController
public class SalesController {

	@Autowired
	private SalesService salesService;

	@GetMapping(value = "/checksales", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> checkSales(@RequestParam UUID saleId) {

		Sales sales = salesService.checkSales(saleId);

		return new ResponseEntity<Sales>(sales, HttpStatus.OK);
	}

	@GetMapping(value = "/salecount", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> countSalesFromDateUntilNow(@RequestParam LocalDate orderDate) {

		long saleCount = salesService.countSalesFromDateUntilNow(orderDate);

		return new ResponseEntity<Long>(saleCount, HttpStatus.OK);
	}

	@GetMapping(value = "/searchbysaletype", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> searchBySaleType(@RequestParam String saleType) {

		List<Sales> sales = salesService.searchBySaleType(saleType);

		return new ResponseEntity<Sales>((Sales) sales, HttpStatus.OK);
	}

	@PostMapping(value = "/addsales", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> addSales(@RequestParam Sales sales) {

		Sales sales1 = salesService.addSales(sales);
		return new ResponseEntity<Sales>(sales1, HttpStatus.OK);
	}

	@PutMapping(value = "/updatesales", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> updateSales(@RequestParam Sales sales) {
		Sales sales2 = salesService.updateSales(sales);
		return new ResponseEntity<Sales>(sales2, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletebysaleid", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sales> deleteBySaleId(@RequestParam UUID saleId) {

		salesService.deleteBySaleId(saleId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
