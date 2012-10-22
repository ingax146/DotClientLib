package se.inax.dot.generator.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.DotGenerator;
import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.Options;
import se.inax.dot.generator.render.directed.DirectedGraphHeaderRenderer;
import se.inax.dot.generator.render.directed.DirectedLinkRenderer;

public class DirectedGraphGenerator extends DotGenerator {

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
