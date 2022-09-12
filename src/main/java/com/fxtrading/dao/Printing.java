package com.fxtrading.dao;

import java.util.ArrayList;

import com.fxtrading.entity.PrintTrade;

import org.springframework.stereotype.Component;
@Component
public class Printing {

		static ArrayList<PrintTrade> bookedTradeList = new ArrayList<>();

		public static void addBooking(int tradeNo, String currencyPair, String customerName, double amount, double rate) {
			bookedTradeList.add(new PrintTrade(tradeNo, currencyPair, customerName, amount, rate));
		}

		public ArrayList<PrintTrade> printTrade() {
			return bookedTradeList;
		}

}
