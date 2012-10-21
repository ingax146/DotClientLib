package se.inax.dot.generator;

import se.inax.dot.generator.render.AttributeRenderer;
import se.inax.dot.generator.render.StringAttributeRenderer;

public class StringOption extends Option {

	StringOption(final String key, final String value) {
		super(key, value);
	}

	@Override
	public AttributeRenderer createRenderer() {
		return new StringAttributeRenderer(getKey(), getValue());
	}

}
