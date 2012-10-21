package se.inax.dot.generator.render.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.render.LinkRenderer;
import se.inax.dot.generator.render.OptionsRenderer;

/**
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public final class DirectedLinkRenderer extends LinkRenderer implements DotRenderer {

	public DirectedLinkRenderer(final String sourceName, final String destName) {
		super(sourceName, destName);
	}

	public DirectedLinkRenderer(final String sourceName, final String destName, final OptionsRenderer or) {
		super(sourceName, destName, or);
	}

	@Override
	protected void renderLinkArrow(final PrintWriter out) {
		out.print("->");
	}

}
