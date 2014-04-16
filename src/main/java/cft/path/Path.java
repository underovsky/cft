package cft.path;

import java.util.LinkedList;
import java.util.List;

public class Path {
	
	private List<Node> path;
	private Double branchingRatio;
	private Double livingRatio;
	
	public Path() {
		this.path = new LinkedList<Node>();
		this.branchingRatio = 0.0D;
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
	
}
