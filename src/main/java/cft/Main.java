package cft;

import cft.logger.Logger;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Started");
		Fractal fractal = new Fractal();
		fractal.run();
		fractal.generateSVG();
		Logger.generateFile();
		System.out.println("Finished");
	}
	
}
