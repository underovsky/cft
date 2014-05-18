package cft;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import cft.base.Colour;
import cft.base.Config;
import cft.calc.Circle;
import cft.calc.Fibonacci;
import cft.chaos.Lorenz;
import cft.chaos.Seed;
import cft.logger.Logger;
import cft.path.Coord;
import cft.path.CoordGenerator;
import cft.path.Node;
import cft.path.Path;
import cft.svg.SVGBuilder;
import cft.svg.SVGGenerator;

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
	
	public void run() {
		createFirstSeed();
		
		Coord from = new Coord(Config.middlePoint, Config.middlePoint);
		
		Fibonacci.iterate();
		for (int i = 0; i < Config.startPathsNum; ++i) {
			createSeed();
			Node newNode = createNode(from);
			Path newPath = new Path();
			newPath.addNode(newNode);
			newPath.setParams(seed);
			paths.add(newPath);
		}
		
		boolean cont = true;
		boolean isPathAlive = false;
		long it = 0;
		
		while (cont) {
			Logger.log("Fractal.run, it: " + it + ", current paths size: " + paths.size());
			System.out.println("Fractal.run, it: " + it + ", current paths size: " + paths.size());
			Fibonacci.iterate();
			
			List<Path> newPaths = new LinkedList<Path>();
			
			for (Path path: paths) {
				if (!path.isAlive()) {
					continue;
				}
				
				isPathAlive = true;
				
				if (path.shouldBeBranched()) {
					System.out.println("Fractal.run, branching ratio: " + path.getBranchingRatio());
					Logger.log("Fractal.run, path should be branched");
					List<Path> branchedPaths = branchPath(path);
					for (Path branchedPath : branchedPaths) {
						branchedPath.setParams(seed);
					}
					newPaths.addAll(branchedPaths);
				}
				
				createSeed();
				from = path.getNodeFromEnd(0).getTo();
				Node node = createNode(from);
				
				if (!isCoordInside(node.getTo())) {
					path.setAlive(false);
					continue;
				}
				
				path.addNode(node);
				path.setParams(seed);
				
				if (path.isDead()) {
					Logger.log("Fractal.run, setting path.alive to false, path.livingRatio: " + path.getLivingRatio());
					path.setAlive(false);
				}
			}
			
			if (newPaths.size() > 0) {
				paths.addAll(newPaths);
			}
			
			newPaths.clear();

			if (++it > Config.maxIterations || !isPathAlive) {
				cont = false;
			}
			
			isPathAlive = false;
		}
	}
	
	public void generateSVG() {
		if (paths == null) {
			return;
		}
		
		for (Path path: paths) {
			for (Node node: path.getPath()) {
				svgBuilder.drawDot(node.getFrom(), node.getWidth() / 2);
				svgBuilder.drawLine(node.getFrom(), node.getTo(), node.getWidth());
				svgBuilder.drawDot(node.getTo(), node.getWidth() / 2);
			}
		}
		
		SVGGenerator.generateFile(svgBuilder.buildSVG());
	}

	// TODO: creating node should take previous node angle into account
	public Node createNode(Coord from) {
		Double priority = seed.getParam() + Fibonacci.getGoldenRatio();
		
		int angle = Circle.getAngle(seed.getParam() * 360);
		Double width = Config.fixedWidth;
		Double length = (double) Fibonacci.getCurrent();
		
		Coord[] tos = CoordGenerator.generateToCoords(from, angle, length);
		Coord to = null;
		
		if (Circle.getBoolean(seed.getParam() * 360)) {
			to = tos[0];
		} else {
			to = tos[1];
		}
		
		return new Node(from, to, priority, angle, width, length);
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
		
		Logger.log("Fractal.createFirstSeed, param: " + seed.getParam());
	}
	
	public void createSeed() {
		try {
			TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2));
		} catch (InterruptedException e) {
			// Ignore
		}
		
		long newTimestamp = Calendar.getInstance().getTimeInMillis();
		Double dt = new Double(newTimestamp - timestamp) / 100;
		Seed newSeed = Lorenz.getSeed(seed, dt);
		
		timestamp = newTimestamp;
		seed = newSeed;
		
		Logger.log("Fractal.createSeed, param: " + seed.getParam() + " for dt: " + dt);
	}
	
	public boolean isCoordInside(Coord coord) {
		if (coord.getX() > Config.canvasSize || coord.getX() < 0) {
			return false;
		}
		
		if (coord.getY() > Config.canvasSize || coord.getY() < 0) {
			return false;
		}
		
		return true;
	}
	
	public List<Path> branchPath(Path path) {
		path.setParamsAfterBranching(seed);
		
		List<Path> newPaths = new LinkedList<Path>();
		
		for (int i = 0; i < Config.branchNum; ++i) {
			createSeed();
			Coord from = path.getNodeFromEnd(0).getFrom();
			Node newNode = createNode(from);
			Path newPath = new Path();
			newPath.addNode(newNode);
			newPath.setParams(seed);
			newPaths.add(newPath);
		}
		
		return newPaths;
	}
	
}
