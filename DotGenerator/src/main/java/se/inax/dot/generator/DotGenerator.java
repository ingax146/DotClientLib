package se.inax.dot.generator;

import java.io.PrintWriter;

import se.inax.dot.constants.DotEdgeOptions;
import se.inax.dot.constants.DotNodeOptions;
import se.inax.dot.constants.DotPolygonBasedShapes;
import se.inax.dot.generator.directed.DirectedGraphGenerator;
import se.inax.dot.generator.render.AttributeRenderer;
import se.inax.dot.generator.render.GraphFooterRenderer;
import se.inax.dot.generator.render.NodeDefinitionRenderer;
import se.inax.dot.generator.render.OptionsRenderer;
import se.inax.dot.generator.undirected.UndirectedGraphGenerator;

/**
 * The DotGenerator is a streaming api for generate DOT graphs. That is
 * it does provide functionality to generate the different artifacts of
 * a DOT graph, but it still requires the artifacts to be generated in a
 * specific order. This requires the client to know the structure of the
 * DOT-graph in order to generate items in correct order. This limitation
 * is only to make it possible to generate larger graphs without consuming
 * large amount of memory.
 *
 * The basic structure of a graph is as follows:
 * header options {
 *		node-definitions options
 *
 *		edge-definitions options
 * footer }
 *
 * Just make sure nodes are defined before used in edges, otherwise edge
 * definitions will cause new nodes to appear in the graph.
 *
 * TODO: Create a generator that builds an in memory graph that can be
 *		 used to generate a DOT graph without the need for ordering.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public abstract class DotGenerator {

	/**
	 *
	 * @return a facade used for generating directed graphs.
	 */
	public static DotGenerator directedGraphGenerator() {
		return new DirectedGraphGenerator();
	}

	/**
	 *
	 * @return a facade used for generating undirected graphs.
	 */
	public static DotGenerator undirectedGraphGenerator() {
		return new UndirectedGraphGenerator();
	}

	/**
	 * Generate a header for the graph.
	 *
	 * TODO: Options? There are some graph options that can be added to the graph as well.
	 *
	 * @param graphName
	 * @return
	 */
	public abstract void generateHeader(PrintWriter out, String graphName);

	/**
	 * Generate the footer of the graph definition.
	 *
	 * @param out
	 */
	public void generateFooter(final PrintWriter out) {
		final DotRenderer node = new GraphFooterRenderer();
		node.render(out);
	}

	/**
	 * Generate a node definition in the graph.
	 * @param out
	 * @param name
	 */
	public void generateNode(final PrintWriter out, final String name) {
		final DotRenderer node = new NodeDefinitionRenderer(name);
		node.render(out);
	}

	/**
	 * Generate a node definition in the graph with given options.
	 *
	 * @param out
	 * @param name
	 * @param options
	 */
	public void generateNode(final PrintWriter out, final String name, final OptionsRenderer options) {
		final DotRenderer node = new NodeDefinitionRenderer(name, options);
		node.render(out);
	}

	/**
	 * Generate an edge between a source and a destination.
	 *
	 * @param out
	 * @param source 		Name of source node, or a new name if new node should be created.
	 * @param destination	Name of destination node, or new name if new node should be created.
	 */
	public abstract void generateEdge(PrintWriter out, String source, String destination);

	/**
	 *
	 * @param out
	 * @param source 		Name of source node, or a new name if new node should be created.
	 * @param destination	Name of destination node, or new name if new node should be created.
	 * @param options		Edge options.
	 */
	public abstract void generateEdge(PrintWriter out, String source, String destination, OptionsRenderer options);

	/**
	 * Generate a note. This is a helper method creating a node definition using the note shape.
	 *
	 * @param out
	 * @param name
	 */
	public void generateNote(final PrintWriter out, final String name) {
		final OptionsBuilder options = createOptionsBuilder();
		options.add(new Option(DotNodeOptions.shape.toString(), DotPolygonBasedShapes.note.toString()));

		final DotRenderer node = new NodeDefinitionRenderer(name, options.createRenderer());
		node.render(out);
	}

	/**
	 * Generate a note.
	 *
	 * @param out
	 * @param name
	 * @param or
	 */
	public void generateNote(final PrintWriter out, final String name, final OptionsRenderer or) {
		or.add(new AttributeRenderer("shape", DotPolygonBasedShapes.note.toString()));

		final DotRenderer node = new NodeDefinitionRenderer(name, or);
		node.render(out);
	}

	/**
	 * Factory method for creating an options builder. This builder is used to create an
	 * options renderer which defines how options are rendered.
	 * @return
	 */
	public OptionsBuilder createOptionsBuilder() {
		return new OptionsBuilder();
	}

	public Option createShapeOption(final DotPolygonBasedShapes aShape) {
		final Option anOption = new Option(DotNodeOptions.shape.toString(), aShape.toString());
		return anOption;
	}

	public Option createEdgeOption(final DotEdgeOptions key, final String value) {
		return new Option(key.toString(), value);
	}

	public Option createStringEdgeOption(final DotEdgeOptions key, final String value) {
		return new StringOption(key.toString(), value);
	}

	public Option createNodeOption(final DotNodeOptions key, final String value) {
		return new Option(key.toString(), value);
	}

	public Option createStringNodeOption(final DotNodeOptions key, final String value) {
		return new StringOption(key.toString(), value);
	}
}
