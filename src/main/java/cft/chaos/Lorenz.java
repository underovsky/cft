package cft.chaos;

public class Lorenz {
	
	private static final Double sig = 10.0D;
	private static final Double r = 28.0D;
	private static final Double b = 8.0 / 3.0;
	
	private static Double dx(Seed seed) {
	    return sig * seed.getY() - sig * seed.getX();
	}
	
	private static Double dy(Seed seed) {
	    return -seed.getX() * seed.getZ() + r * seed.getX() - seed.getY();
	}
	
	private static Double dz(Seed seed) {
	    return seed.getX() * seed.getY() - b * seed.getZ();
	}
	
	public static Seed getSeed(Seed seed, Double dt) {
		Double x = seed.getX() + dx(seed) * dt;
		Double y = seed.getY() + dy(seed) * dt;
		Double z = seed.getZ() + dz(seed) * dt;
		
		return new Seed(x, y, z);
	}
	
}
