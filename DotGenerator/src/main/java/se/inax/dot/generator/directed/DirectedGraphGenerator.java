package se.inax.dot.generator.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.DotGenerator;
import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.render.OptionsRenderer;
import se.inax.dot.generator.render.directed.DirectedGraphHeaderRenderer;
import se.inax.dot.generator.render.directed.DirectedLinkRenderer;

public class DirectedGraphGenerator extends DotGenerator {

	@Override
	public void generateHeader(PrintWriter out, String graphName) {
		DotRenderer node = new DirectedGraphHeaderRenderer(graphName);
		node.render(out);
	}

	@Override
	public void generateEdge(PrintWriter out, String source, String destination) {
		DotRenderer node = new DirectedLinkRenderer(source, destination);
		node.render(out);
	}

	@Override
	public void generateEdge(PrintWriter out, String source, String destination, OptionsRenderer options) {
		DotRenderer node = new DirectedLinkRenderer(source, destination, options);
		node.render(out);
	}

}
