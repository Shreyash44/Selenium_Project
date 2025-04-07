package com_ShoppersStack_GenericUtility;

import java.time.LocalDate;
import java.util.Random;

public class Java_Utility {

	public int generateRandomNumber() {
		Random r = new Random();
		int num = r.nextInt(1000);
		return num;

	}

	public String getLocalDateTime() {
		String dateTime = LocalDate.now().toString().replace("_", "").replace(":", "").replace(".", "");

		return dateTime;
	}
}