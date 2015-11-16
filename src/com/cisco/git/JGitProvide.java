package com.cisco.git;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class JGitProvide {
	public static void test()
	{
		//String epoch="1355371390142";

		Date date = new Date(1415165081);
		Calendar cal = new GregorianCalendar();
		
		cal.setTime(date);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		String str = df.format(date);
		System.out.println(str);
		}
	
	public static void main(String[]args)
	{
		test();
	}

}
