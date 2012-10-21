package se.inax.dot.generator.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.DotGenerator;
import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.render.OptionsRenderer;
import se.inax.dot.generator.render.undirected.UndirectedGraphHeader;
import se.inax.dot.generator.render.undirected.UndirectedLinkRenderer;

public class UndirectedGraphGenerator extends DotGenerator {

	@Override
	public void generateHeader(final PrintWriter out, final String graphName) {
		final DotRenderer header = new UndirectedGraphHeader(graphName);
		header.render(out);
	}

	@Override
	public void generateEdge(final PrintWriter out, final String source, final String destination) {
		final DotRenderer node = new UndirectedLinkRenderer(source, destination);
		node.render(out);
	}

	@Override
	public void generateEdge(final PrintWriter out, final String source, final String destination, final OptionsRenderer options) {
		final DotRenderer node = new UndirectedLinkRenderer(source, destination, options);
		node.render(out);
	}

}
