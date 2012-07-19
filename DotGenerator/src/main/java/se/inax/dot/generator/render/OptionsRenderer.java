package se.inax.dot.generator.render;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import se.inax.dot.generator.DotRenderer;

public class OptionsRenderer implements DotRenderer {
	private List<AttributeRenderer> attributeRenderers = new ArrayList<AttributeRenderer>();
	
	public void add(AttributeRenderer attribute) {
		attributeRenderers.add(attribute);
	}

	public void render(PrintWriter out) {
		if (attributeRenderers.isEmpty()) {
			return;
		}
		renderPrologue(out);
		renderAttributes(out);
		renderEpilogue(out);
	}

	private void renderEpilogue(PrintWriter out) {
		out.print("]");
	}

	private void renderPrologue(PrintWriter out) {
		out.print(" [");
	}

	private void renderAttributes(PrintWriter out) {
		boolean first = true;
		for(AttributeRenderer ar : attributeRenderers) {
			if (first) {
				first = false;
			} else {
				renderAttributeSeparator(out);
			}
			ar.render(out);
		}
	}

	private void renderAttributeSeparator(PrintWriter out) {
		out.print(", ");
	}

}
