package se.inax.dot.generator.render;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;

public abstract class GraphHeaderRenderer implements DotRenderer {
	private final String name;
	private final OptionsRenderer options;

	public GraphHeaderRenderer(final String graphName) {
		this(graphName, new NoOptionsRenderer());
	}

	public GraphHeaderRenderer(String graphName, OptionsRenderer graphOptions) {
		name = graphName;
		options = graphOptions;
	}

	@Override
	public void render(PrintWriter out) {
		renderGraphType(out);
		out.print(" ");
		out.print(name);
		options.render(out);
		out.println(" {");
	}

	protected abstract void renderGraphType(PrintWriter out);
}
