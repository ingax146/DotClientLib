package se.inax.dot.client.directed;

import java.io.PrintWriter;

import se.inax.dot.client.DotClient;
import se.inax.dot.client.DotRenderer;
import se.inax.dot.client.Options;
import se.inax.dot.client.render.directed.DirectedGraphHeaderRenderer;
import se.inax.dot.client.render.directed.DirectedLinkRenderer;

public class DirectedGraphGenerator extends DotClient {

	@Override
	public void generateHeader(final PrintWriter out, final String graphName) {
		final DotRenderer node = new DirectedGraphHeaderRenderer(graphName);
		node.render(out);
	}

	@Override
	public void generateHeader(final PrintWriter out, final String graphName, final Options options) {
		final DotRenderer node = new DirectedGraphHeaderRenderer(graphName, options);
		node.render(out);
	}

	@Override
	public void generateEdge(final PrintWriter out, final String source, final String destination) {
		final DotRenderer node = new DirectedLinkRenderer(source, destination);
		node.render(out);
	}

	@Override
	public void generateEdge(final PrintWriter out, final String source, final String destination, final Options options) {
		final DotRenderer node = new DirectedLinkRenderer(source, destination, options);
		node.render(out);
	}

}
