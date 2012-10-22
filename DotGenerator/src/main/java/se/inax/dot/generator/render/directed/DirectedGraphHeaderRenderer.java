package se.inax.dot.generator.render.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.render.GraphHeaderRenderer;
import se.inax.dot.generator.render.OptionsRenderer;

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

	public DirectedGraphHeaderRenderer(String graphName, OptionsRenderer graphOptions) {
		super(graphName, graphOptions);
	}

	@Override
	protected void renderGraphType(PrintWriter out) {
		out.print("digraph");
	}

}
