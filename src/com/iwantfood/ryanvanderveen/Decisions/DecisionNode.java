package com.iwantfood.ryanvanderveen.Decisions;

import java.util.LinkedList;

public class DecisionNode<T> {
	private T decision;
	public LinkedList<DecisionNode<T>> children;
	
	public DecisionNode(T decision) {
		this.decision = decision;
	}
	
	public LinkedList<DecisionNode<T>> getChildren() {
		return children;
	}
	
	public boolean isLeaf() {
		return this.getChildren().isEmpty() ? true : false;
	}

	
}
