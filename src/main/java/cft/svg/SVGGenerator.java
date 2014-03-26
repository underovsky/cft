package cft.svg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import cft.helpers.TextFormatter;

public class SVGGenerator {
	
	private static String directory = "renders";
	private static String filename = "render_";
	private static String extension = ".svg";
	
	public static boolean generateFile(String content) {
		if (!generateFolder()) {
			return false;
		}
		
		try {
			File file = new File(directory + File.separator + filename + TextFormatter.formatDate(new Date()) + extension);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(content);
			output.close();
		} catch (IOException e) {
			 e.printStackTrace();
			 return false;
		}
		
		return true;
	}
	
	private static boolean generateFolder() {
		File file = new File(directory);
		if (!file.exists()) {
			return file.mkdir();
		}
		
		return true;
	}

}
