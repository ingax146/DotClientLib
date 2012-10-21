package se.inax.dot.generator.render.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.render.AttributeRenderer;
import se.inax.dot.generator.render.LinkRenderer;
import se.inax.dot.generator.render.OptionsRenderer;

/**
 * UndirectedLinkRenderer, use this class to render undirected links in a
 * directed link graph. It works by setting the arrowhead option.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public final class UndirectedLinkRenderer extends LinkRenderer {

	public UndirectedLinkRenderer(final String sourceName, final String destName) {
		this(sourceName, destName, new OptionsRenderer());
	}

	public UndirectedLinkRenderer(final String sourceName, final String destName, final OptionsRenderer or) {
		super(sourceName, destName, or);
		getOptionsRenderer().add(new AttributeRenderer("arrowhead", "none"));
	}

	@Override
	protected void renderLinkArrow(final PrintWriter out) {
		out.println("--");
	}
}
