package se.inax.dot.client;

import se.inax.dot.client.render.AttributeRenderer;

public class Option {
	private final String key;
	private final String value;

	Option(final String key, final String value) {
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
