package se.inax.dot.generator.render.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.render.AttributeRenderer;
import se.inax.dot.generator.render.LinkRenderer;
import se.inax.dot.generator.render.OptionsRenderer;

/**
 * UndirectedLinkRenderer, use this class to render undirected links in a
 * directed link graph. It works by setting the arrowhead option, and not 
 * by 
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class UndirectedLinkRenderer extends LinkRenderer {

	public UndirectedLinkRenderer(String sourceName, String destName) {
		super(sourceName, destName);
		getOptionsRenderer().add(new AttributeRenderer("arrowhead", "none"));
	}

	public UndirectedLinkRenderer(String sourceName, String destName, OptionsRenderer or) {
		super(sourceName, destName, or);
	}
	
	@Override
	protected void renderLinkArrow(PrintWriter out) {
		out.println("--");
	}
}
