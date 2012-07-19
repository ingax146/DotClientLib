package se.inax.dot.generator.render.undirected;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;


public class UndirectedGraphHeader implements DotRenderer {
	private final String name;
	
	public UndirectedGraphHeader(String graphName) {
		name = graphName;
	}
	
	@Override
	public void render(PrintWriter out) {
		out.print("graph ");
		out.print(name);
		out.println(" {");
	}

}
