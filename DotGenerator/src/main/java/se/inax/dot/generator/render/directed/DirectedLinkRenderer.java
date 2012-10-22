package se.inax.dot.generator.render.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.Options;
import se.inax.dot.generator.render.LinkRenderer;

/**
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public final class DirectedLinkRenderer extends LinkRenderer implements DotRenderer {

	public DirectedLinkRenderer(final String sourceName, final String destName) {
		super(sourceName, destName);
	}

	public DirectedLinkRenderer(final String sourceName, final String destName, final Options os) {
		super(sourceName, destName, os);
	}

	@Override
	protected void renderLinkArrow(final PrintWriter out) {
		out.print("->");
	}

}
