package com.fxtrading.dao;

import com.fxtrading.entity.BookTrade;

import org.springframework.stereotype.Component;
@Component
public class Booking {
	static int tradeno = 0;
	public String bookTrade(BookTrade bookingDetails, String bookingconfirmation) 
	{
		final double rate = 66.00;
		if (bookingDetails.getCustomerName().matches("^[A-Z a-z]*$")|| bookingDetails.getCustomerName().contains(" ")) 
		{
			if (bookingDetails.getCurrencyPair().equalsIgnoreCase("USDINR") ) 
			{
				double Amount = bookingDetails.getTransferAmount() * rate;
				if (bookingDetails.getGetRate().equalsIgnoreCase("Yes")) 
				{
					if (bookingconfirmation.equalsIgnoreCase("Book")) 
					{
						tradeno++;
						Printing.addBooking(tradeno, bookingDetails.getCurrencyPair(), bookingDetails.getCustomerName(), Amount, rate);
						return "You are transferring INR " + Amount + " to " + bookingDetails.getCustomerName();
					}else {
						return "Trade is Cancelled";
					}
				} else if (bookingDetails.getGetRate().equalsIgnoreCase("no")) {
					if (bookingconfirmation.equalsIgnoreCase("Book")) {
						tradeno++;
						Printing.addBooking(tradeno, bookingDetails.getCurrencyPair(), bookingDetails.getCustomerName(), Amount, rate);
						return "Trade for USDINR has been booked with rate " + rate + "," + "The amount of RS "+ Amount + " will be transferred in 2 working days to "+ bookingDetails.getCustomerName() + ".";
					}  else {
						return "Trade is Cancelled";
					}
				} else {
					return "Invalid option";
				}
			}
			else {
				return "Invalid Curency Pair";
			}
		} else {
			return "Invalid Customer Name";
		}
	}
}
