package se.inax.dot.client.render.undirected;

import java.io.PrintWriter;

import se.inax.dot.client.Options;
import se.inax.dot.client.render.GraphHeaderRenderer;


public class UndirectedGraphHeaderRenderer extends GraphHeaderRenderer {

	public UndirectedGraphHeaderRenderer(final String graphName) {
		super(graphName);
	}

	public UndirectedGraphHeaderRenderer(String graphName, Options graphOptions) {
		super(graphName, graphOptions);
	}

	@Override
	protected void renderGraphType(PrintWriter out) {
			out.print("graph");
	}

}
