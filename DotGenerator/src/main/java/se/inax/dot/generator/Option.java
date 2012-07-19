package se.inax.dot.generator;

import se.inax.dot.generator.render.AttributeRenderer;

public class Option {
	private final String key;
	private final String value;
	
	Option(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	public AttributeRenderer createRenderer() {
		return new AttributeRenderer(key, value);
	}
}
