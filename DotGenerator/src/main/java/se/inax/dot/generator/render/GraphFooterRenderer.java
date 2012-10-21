package se.inax.dot.generator.render;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;

/**
 * Renders the footer of a DOT graph. Basically it renders the
 * ending '}' character at the end of the graph.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class GraphFooterRenderer implements DotRenderer {

	@Override
	public void render(final PrintWriter out) {
		out.println("}");
	}

}
