package se.inax.dot.generator.render.directed;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;

public class DirectedGraphHeaderRenderer implements DotRenderer {
	private final String name;
	public DirectedGraphHeaderRenderer(final String graphName) {
		name = graphName;
	}

	@Override
	public void render(final PrintWriter out) {
		out.print("digraph ");
		out.print(name);
		out.println(" {");
	}

}
