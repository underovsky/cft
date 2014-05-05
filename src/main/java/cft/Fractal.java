package cft;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import cft.base.Colour;
import cft.base.Config;
import cft.chaos.Lorenz;
import cft.chaos.Seed;
import cft.path.Coord;
import cft.path.Node;
import cft.path.Path;
import cft.svg.SVGBuilder;

public class Fractal {
	
	private SVGBuilder svgBuilder;
	private Colour colour;
	
	private List<Path> paths;

	private Seed seed;
	private long timestamp;
	
	
	public Fractal() {
		colour = new Colour(0, 0, 0);
		svgBuilder = new SVGBuilder(Config.canvasSize, Config.canvasSize, colour);
	
		paths = new LinkedList<Path>();
	}
	
	// TODO: the magic will happen here
	// end conditions: no more paths alive or > maxIterations
	public void generate() {
	}
	
	// TODO: branching ratio and living ratio have to be generated in some sophisticated way, but I'm too tired to think now
	// ratio must be based on Config.subIndex
	public void addNodeToPath(Path path, Node node) {
	}
	
	/* TODO: generate angle, generate length and set width 
	 * use Config, Fibonacci, Circle and CoordGenerator
	 * generate new seed every time
	 * */
	public Node createNode(Coord from) {
		return null;
	}
	
	// TODO: set livingRatio and branchingRatio
	public void setPathParams(Path path) {
		
	}
	
	public void createFirstSeed() {
		Double x, y, z;
		x = y = z = 0.0D;
		
		boolean cont = true;
		while (cont) {
			timestamp = Calendar.getInstance().getTimeInMillis();
			x = Math.pow(timestamp % 1000, -1) * 100;
			y = Math.pow(timestamp % 1000000 / 1000, -1) * 100;
			z = Math.pow(timestamp % 1000000000 / 1000000, -1) * 100;
			
			if (Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z)) {
				cont = true;
			} else {
				cont = false;
			}
		}
		
		seed = new Seed(x, y, z);
	}
	
	public void createSeed() {
		long newTimestamp = Calendar.getInstance().getTimeInMillis();
		Double dt = new Double(newTimestamp - timestamp) / 100;
		Seed newSeed = Lorenz.getSeed(seed, dt);
		
		timestamp = newTimestamp;
		seed = newSeed;
	}
	
	public boolean isPathDead(Path path) {
		if (path.getLivingRatio() < Config.livingRatioIndex) {
			return true;
		}
		
		return false;
	}
	
	public boolean shouldPathBeBranched(Path path) {
		if (path.getBranchingRatio() > Config.branchingRatioIndex) {
			return true;
		}
		return false;
	}
	
	public void branchPath(Path path) {
		if (path.size() == 0) {
			return;
		}
		
		path.setBranchingRatio(0.0D);
		Node node = path.getNodeFromEnd(0);
		Coord from = node.getFrom();
		
		Node newNode = createNode(from);
		Path newPath = new Path();
		newPath.addNode(newNode);
		setPathParams(newPath);
		
		paths.add(newPath);
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	public SVGBuilder getSvgBuilder() {
		return svgBuilder;
	}

	public void setSvgBuilder(SVGBuilder svgBuilder) {
		this.svgBuilder = svgBuilder;
	}
	
}
