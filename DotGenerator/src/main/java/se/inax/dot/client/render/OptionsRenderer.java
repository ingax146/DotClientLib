package se.inax.dot.client.render;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import se.inax.dot.client.DotRenderer;
import se.inax.dot.client.Option;
import se.inax.dot.client.Options;

public class OptionsRenderer implements DotRenderer {
	private final List<AttributeRenderer> attributeRenderers = new ArrayList<AttributeRenderer>();

	public OptionsRenderer() {
	}

	public OptionsRenderer(Options options) {
		if (options == null) {
			return;
		}
		for(Option option : options.getOptions()) {
			attributeRenderers.add(option.createRenderer());
		}
	}

	public void add(final AttributeRenderer attribute) {
		attributeRenderers.add(attribute);
	}

	@Override
	public void render(final PrintWriter out) {
		if (attributeRenderers.isEmpty()) {
			return;
		}
		renderPrologue(out);
		renderAttributes(out);
		renderEpilogue(out);
	}

	private void renderEpilogue(final PrintWriter out) {
		out.print("]");
	}

	private void renderPrologue(final PrintWriter out) {
		out.print(" [");
	}

	private void renderAttributes(final PrintWriter out) {
		boolean first = true;
		for(final AttributeRenderer ar : attributeRenderers) {
			if (first) {
				first = false;
			} else {
				renderAttributeSeparator(out);
			}
			ar.render(out);
		}
	}

	private void renderAttributeSeparator(final PrintWriter out) {
		out.print(", ");
	}

}
