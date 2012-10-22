package se.inax.dot.generator;

import java.io.PrintWriter;

import se.inax.dot.constants.ArrowType;
import se.inax.dot.constants.DirType;
import se.inax.dot.constants.GraphOptions;
import se.inax.dot.constants.DotPolygonBasedShapes;
import se.inax.dot.constants.EdgeOptions;
import se.inax.dot.constants.NodeOptions;
import se.inax.dot.generator.directed.DirectedGraphGenerator;
import se.inax.dot.generator.render.GraphFooterRenderer;
import se.inax.dot.generator.render.NodeDefinitionRenderer;
import se.inax.dot.generator.undirected.UndirectedGraphGenerator;
import se.inax.dot.propertymodel.DotEscapedString;

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
	public abstract void generateHeader(final PrintWriter out, final String graphName);

	/**
	 * 
	 * @param out
	 * @param graphName
	 * @param options
	 */
	public abstract void generateHeader(final PrintWriter out, final String graphName, final Options options);

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
	public void generateNode(final PrintWriter out, final String name, final Options options) {
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
	public abstract void generateEdge(PrintWriter out, String source, String destination, Options options);

	/**
	 * Generate a note. This is a helper method creating a node definition using the note shape.
	 *
	 * @param out
	 * @param name
	 */
	public void generateNote(final PrintWriter out, final String name) {
		final OptionsBuilder options = createOptionsBuilder();
		options.add(new Option(NodeOptions.shape.toString(), DotPolygonBasedShapes.note.toString()));

		final DotRenderer node = new NodeDefinitionRenderer(name, options.buildOptions());
		node.render(out);
	}

	/**
	 * Generate a note.
	 *
	 * @param out
	 * @param name
	 * @param or
	 */
	public void generateNote(final PrintWriter out, final String name, final Options os) {
		os.add(new Option("shape", DotPolygonBasedShapes.note.toString()));

		final DotRenderer node = new NodeDefinitionRenderer(name, os);
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
		final Option anOption = new Option(NodeOptions.shape.toString(), aShape.toString());
		return anOption;
	}

	public Option createEdgeOption(final EdgeOptions key, final ArrowType value) {
		return createEdgeOption(key, value.toString());
	}

	public Option createEdgeOption(final EdgeOptions key, final DirType value) {
		return createEdgeOption(key, value.toString());
	}

	public Option createEdgeOption(final EdgeOptions key, final String value) {
		if (isStringTypeOption(key.getType())) {
			return new StringOption(key.toString(), value);
		}
		return new Option(key.toString(), value);
	}

	public Option createNodeOption(final NodeOptions key, final String value) {
		if (isStringTypeOption(key.getType())) {
			return new StringOption(key.toString(), value);
		}
		return new Option(key.toString(), value);
	}

	private boolean isStringTypeOption(Class<?> keyType) {
		if (keyType == null) {
			return false;
		}
		return keyType.equals(DotEscapedString.class);
	}


	public static Options createEmptyOptions() {
		return new OptionsImpl();
	}

	public Option createGraphStringOption(GraphOptions key, String value) {
		return new StringOption(key.toString(), value);
	}
}
