package se.inax.dot.generator.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.DotGenerator;
import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.render.OptionsRenderer;
import se.inax.dot.generator.render.undirected.UndirectedGraphHeader;
import se.inax.dot.generator.render.undirected.UndirectedLinkRenderer;

public class UndirectedGraphGenerator extends DotGenerator {

	@Override
	public void generateHeader(PrintWriter out, String graphName) {
		DotRenderer header = new UndirectedGraphHeader(graphName);
		header.render(out);
	}

	@Override
	public void generateEdge(PrintWriter out, String source, String destination) {
		DotRenderer node = new UndirectedLinkRenderer(source, destination);
		node.render(out);
	}

	@Override
	public void generateEdge(PrintWriter out, String source, String destination, OptionsRenderer options) {
		DotRenderer node = new UndirectedLinkRenderer(source, destination, options);
		node.render(out);
	}

}
