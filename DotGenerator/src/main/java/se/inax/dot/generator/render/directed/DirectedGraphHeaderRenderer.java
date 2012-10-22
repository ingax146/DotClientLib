package se.inax.dot.generator.render.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.Options;
import se.inax.dot.generator.render.GraphHeaderRenderer;

/**
 * Render a directed graph header.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class DirectedGraphHeaderRenderer extends GraphHeaderRenderer {

	public DirectedGraphHeaderRenderer(final String graphName) {
		super(graphName);
	}

	public DirectedGraphHeaderRenderer(final String graphName, final Options graphOptions) {
		super(graphName, graphOptions);
	}

	@Override
	protected void renderGraphType(PrintWriter out) {
		out.print("digraph");
	}

}
