package cft.helpers;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TextFormatter {
	
	private static DecimalFormat decimalFormat = new DecimalFormat("#.####");
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	
	public static String formatDouble(Double num) {
		return decimalFormat.format(num);
	}
	
	public static String formatDate(Date date) {
		return simpleDateFormat.format(date);
	}
	
}
