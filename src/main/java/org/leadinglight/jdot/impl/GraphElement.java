package org.leadinglight.jdot.impl;


public abstract class GraphElement {
	public GraphElement() {
		_options = new Options();
	}
	
	public Options getOptions() {
		return _options;
	}
	
	public abstract String toDot();
	
	private Options _options;
}