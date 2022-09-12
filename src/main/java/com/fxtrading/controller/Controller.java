package com.fxtrading.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fxtrading.entity.BookTrade;
import com.fxtrading.entity.PrintTrade;
import com.fxtrading.services.FXTradeService;

@RestController
public class Controller {
	@Autowired
	FXTradeService fxTradeService;

	@PostMapping("booktrade/{bookingconfirmation}")
	public String bookTrade(@RequestBody BookTrade bookingDetails, @PathVariable String bookingconfirmation) {
		return fxTradeService.bookTrade(bookingDetails, bookingconfirmation);
	}

	@GetMapping("printtrade")
	public ArrayList<PrintTrade> printTrade() {
		return fxTradeService.printTrade();
	}
	
}
