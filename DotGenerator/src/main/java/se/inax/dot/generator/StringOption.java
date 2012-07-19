package se.inax.dot.generator;

import se.inax.dot.generator.render.AttributeRenderer;
import se.inax.dot.generator.render.StringAttributeRenderer;

public class StringOption extends Option {

	StringOption(String key, String value) {
		super(key, value);
	}

	public AttributeRenderer createRenderer() {
		return new StringAttributeRenderer(getKey(), getValue());
	}

}
