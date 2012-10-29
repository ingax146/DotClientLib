package se.inax.dot.client.render.directed;

import java.io.PrintWriter;

import se.inax.dot.client.DotRenderer;
import se.inax.dot.client.Options;
import se.inax.dot.client.render.LinkRenderer;

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
