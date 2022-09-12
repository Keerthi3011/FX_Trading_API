package com.fxtrading.services;

import java.util.ArrayList;

import com.fxtrading.dao.Booking;
import com.fxtrading.dao.Printing;
import com.fxtrading.entity.BookTrade;
import com.fxtrading.entity.PrintTrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FXTradeService 
{
	@Autowired
	Booking booking;
	@Autowired
	Printing printing;

	public String bookTrade(BookTrade bookingDetails, String bookingconfirmation) {
		return booking.bookTrade(bookingDetails, bookingconfirmation);
	}


	public ArrayList<PrintTrade> printTrade() {
		return printing.printTrade();
	}
}
