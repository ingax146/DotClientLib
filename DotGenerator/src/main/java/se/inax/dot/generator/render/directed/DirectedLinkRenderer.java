package se.inax.dot.generator.render.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.render.LinkRenderer;
import se.inax.dot.generator.render.OptionsRenderer;

public class DirectedLinkRenderer extends LinkRenderer implements DotRenderer {
	
	public DirectedLinkRenderer(String sourceName, String destName) {
		super(sourceName, destName);
	}

	public DirectedLinkRenderer(String sourceName, String destName, OptionsRenderer or) {
		super(sourceName, destName, or);
	}

	@Override
	protected void renderLinkArrow(PrintWriter out) {
		out.print("->");
	}

}
