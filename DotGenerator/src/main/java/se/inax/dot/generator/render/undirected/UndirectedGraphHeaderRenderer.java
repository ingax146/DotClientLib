package se.inax.dot.generator.render.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.render.GraphHeaderRenderer;
import se.inax.dot.generator.render.OptionsRenderer;


public class UndirectedGraphHeaderRenderer extends GraphHeaderRenderer {

	public UndirectedGraphHeaderRenderer(final String graphName) {
		super(graphName);
	}

	public UndirectedGraphHeaderRenderer(String graphName, OptionsRenderer graphOptions) {
		super(graphName, graphOptions);
	}

	@Override
	protected void renderGraphType(PrintWriter out) {
			out.print("graph");
	}

}
