package se.inax.dot.generator.render;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.Options;
/**
 * NodeDefinitionRenderer is a renderer designed to render a node definition.
 * 
 * A node definition contains a node name (this is a dot-name) and a set of
 * node options. Notice that the dot-name is not shown if there is a 'label'
 * option present. Hence the graph library uses labels for all output.
 * Dot-names are only used internally by the library, this to make processing
 * and generation of graphs easier and faster.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class NodeDefinitionRenderer implements DotRenderer {
	final OptionsRenderer options;
	final String nodeName;

	public NodeDefinitionRenderer(final String name) {
		nodeName = name;
		options = new OptionsRenderer();
	}

	public NodeDefinitionRenderer(final String name, final Options os) {
		nodeName = name;
		options = new OptionsRenderer(os);
	}

	@Override
	public void render(final PrintWriter out) {
		renderIndentation(out);
		renderNodeName(out);
		options.render(out);
		renderNodeEnd(out);
	}

	private void renderIndentation(final PrintWriter out) {
		out.print("\t");
	}

	private void renderNodeName(final PrintWriter out) {
		out.print(nodeName);
	}

	private void renderNodeEnd(final PrintWriter out) {
		out.println(";");
	}
}
