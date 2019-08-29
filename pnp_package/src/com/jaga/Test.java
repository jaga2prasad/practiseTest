package com.jaga;

import java.util.Calendar;

public class Test {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		//calendar.setTimeInMillis(1518487010783);

		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
	}
}
