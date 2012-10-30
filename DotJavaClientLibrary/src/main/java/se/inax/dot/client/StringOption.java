package se.inax.dot.client;

import se.inax.dot.client.render.AttributeRenderer;
import se.inax.dot.client.render.StringAttributeRenderer;

public class StringOption extends Option {

	StringOption(final String key, final String value) {
		super(key, value);
	}

	@Override
	public AttributeRenderer createRenderer() {
		return new StringAttributeRenderer(getKey(), getValue());
	}

}
