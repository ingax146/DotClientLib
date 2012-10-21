package se.inax.dot.generator.render.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;


public class UndirectedGraphHeader implements DotRenderer {
	private final String name;

	public UndirectedGraphHeader(final String graphName) {
		name = graphName;
	}

	@Override
	public void render(final PrintWriter out) {
		out.print("graph ");
		out.print(name);
		out.println(" {");
	}

}
