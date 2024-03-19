package com.food.util;

import java.util.Calendar;

public class OrderIdGenerator {
	 public  int generateOrderId() {
	        int randomDigits = (int) (Math.random() * 1000);
	        Calendar currentDate = Calendar.getInstance();
	        int year = currentDate.get(Calendar.YEAR);
	        int month = currentDate.get(Calendar.MONTH) + 1; 

	        int generatedOrderId = Integer.parseInt(String.format("%d%02d%d", year, month, randomDigits));

	        return generatedOrderId;

}
}