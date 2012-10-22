package se.inax.dot.generator.render.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.Options;
import se.inax.dot.generator.render.AttributeRenderer;
import se.inax.dot.generator.render.LinkRenderer;

/**
 * UndirectedLinkRenderer, use this class to render undirected links in a
 * directed link graph. It works by setting the arrowhead option.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public final class UndirectedLinkRenderer extends LinkRenderer {

	public UndirectedLinkRenderer(final String sourceName, final String destName) {
		this(sourceName, destName, null);
	}

	public UndirectedLinkRenderer(final String sourceName, final String destName, final Options os) {
		super(sourceName, destName, os);
		getOptionsRenderer().add(new AttributeRenderer("arrowhead", "none"));
	}

	@Override
	protected void renderLinkArrow(final PrintWriter out) {
		out.print("--");
	}
}
