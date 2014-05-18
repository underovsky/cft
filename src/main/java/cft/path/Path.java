package cft.path;

import java.util.LinkedList;
import java.util.List;

import cft.base.Config;
import cft.chaos.Seed;

public class Path {
	
	private List<Node> path;
	private Double branchingRatio;
	private Double livingRatio;
	private boolean alive;
	
	public Path() {
		this.path = new LinkedList<Node>();
		this.branchingRatio = 0.0D;
		this.livingRatio = Config.startingLivingRatio;
		this.alive = true;
	}

	public void addNode(Node node) {
		path.add(node);
	}
	
	public Node getNodeFromStart(int index) {
		if (path == null || path.isEmpty()) {
			return null;
		}
		
		if (index >= path.size()) {
			return null;
		}
		
		return path.get(index);
	}
	
	public Node getNodeFromEnd(int subIndex) {
		if (path == null || path.isEmpty()) {
			return null;
		}
		
		if (subIndex >= path.size()) {
			return null;
		}
		
		return path.get(path.size() - 1 - subIndex);
	}
	
	public boolean isDead() {
		if (livingRatio < Config.livingRatioIndex) {
			return true;
		}
		
		return false;
	}
	
	public boolean shouldBeBranched() {
		if (branchingRatio > Config.branchingRatioIndex) {
			return true;
		}
		return false;
	}
	
	// FIXME
	public void setParams(Seed seed) {
		Double livingRatio = 0.0D;
		Double branchingRatio = 0.0D;
		for (int i = 0; i < Config.subIndex; ++i) {
			if (getNodeFromEnd(i) == null) {
				break;
			}
			livingRatio += getNodeFromEnd(i).getPriority();
			branchingRatio += getNodeFromEnd(i).getPriority();
		}
		
		this.livingRatio -= livingRatio + seed.getParam() / Config.subIndex;
		this.branchingRatio = branchingRatio + seed.getParam() / Config.subIndex;
	}
	
	// FIXME
	public void setParamsAfterBranching(Seed seed) {
		this.livingRatio -= getNodeFromEnd(0).getPriority() + seed.getParam() / Config.subIndex;
		this.branchingRatio = seed.getParam() / Config.subIndex;
	}
	
	public int size() {
		if (path == null || path.isEmpty()) {
			return 0;
		}
		
		return path.size();
	}

	public Double getBranchingRatio() {
		return branchingRatio;
	}

	public void setBranchingRatio(Double branchingRatio) {
		this.branchingRatio = branchingRatio;
	}

	public Double getLivingRatio() {
		return livingRatio;
	}

	public void setLivingRatio(Double livingRatio) {
		this.livingRatio = livingRatio;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public List<Node> getPath() {
		return path;
	}
	
}
