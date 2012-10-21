package se.inax.dot.generator;

import java.util.ArrayList;
import java.util.List;

import se.inax.dot.generator.render.OptionsRenderer;

public class OptionsBuilder {
	List<Option> renderers = new ArrayList<Option>();

	public void add(final Option attribute) {
		renderers.add(attribute);
	}

	public OptionsRenderer createRenderer() {
		final OptionsRenderer or = new OptionsRenderer();
		for(final Option option : renderers) {
			or.add(option.createRenderer());
		}
		return or;
	}

}
