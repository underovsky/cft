package cft.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import cft.helpers.TextFormatter;

public class Logger {
	
	private static final String directory = "logs";
	private static final String filename = "log_";
	private static final String extension = ".log";
	
	private static StringBuffer logs = new StringBuffer();
	
	public static void log(String message) {
		// System.out.println(message);
		logs.append(TextFormatter.formatDate(new Date()) + " " + message + "\n");
	}
	
	public static void generateFile() {
		if (!generateFolder()) {
			return;
		}
		
		try {
			File file = new File(directory + File.separator + filename + TextFormatter.formatDate(new Date()) + extension);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(logs.toString());
			output.close();
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	private static boolean generateFolder() {
		File file = new File(directory);
		if (!file.exists()) {
			return file.mkdir();
		}
		
		return true;
	}
	
}
