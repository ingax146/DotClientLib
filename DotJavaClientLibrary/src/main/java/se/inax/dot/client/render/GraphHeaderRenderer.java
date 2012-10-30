package se.inax.dot.client.render;

import java.io.PrintWriter;

import se.inax.dot.client.DotRenderer;
import se.inax.dot.client.Options;
import se.inax.dot.client.OptionsImpl;

public abstract class GraphHeaderRenderer implements DotRenderer {
	private final String name;
	private final OptionsRenderer options;

	public GraphHeaderRenderer(final String graphName) {
		this(graphName, new OptionsImpl());
	}

	public GraphHeaderRenderer(final String graphName, final Options graphOptions) {
		name = graphName;
		options = new OptionsRenderer(graphOptions);
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
