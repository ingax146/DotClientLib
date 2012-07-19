package se.inax.dot.generator.render;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;


public class GraphFooterRenderer implements DotRenderer {

	@Override
	public void render(PrintWriter out) {
		out.println("}");
	}

}
