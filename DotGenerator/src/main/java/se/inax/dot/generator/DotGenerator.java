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
	 * 
	 * @param graphName
	 * @return
	 */
	public abstract void generateHeader(PrintWriter out, String graphName);

	public void generateFooter(PrintWriter out) {
		DotRenderer node = new GraphFooterRenderer();
		node.render(out);
	}
	
	public void generateNode(PrintWriter out, String name) {
		DotRenderer node = new NodeDefinitionRenderer(name);
		node.render(out);
	}

	public void generateNode(PrintWriter out, String name, OptionsRenderer options) {
		DotRenderer node = new NodeDefinitionRenderer(name, options);
		node.render(out);
	}

	/**
	 * 
	 * @param source
	 * @param destination
	 */
	public abstract void generateEdge(PrintWriter out, String source, String destination);

	/**
	 * 
	 * @param source
	 * @param destination
	 * @param options
	 */
	public abstract void generateEdge(PrintWriter out, String source, String destination, OptionsRenderer options);

	public void generateNote(PrintWriter out, String name) {
		OptionsBuilder options = createOptionsBuilder();
		options.add(new Option(DotNodeOptions.shape.toString(), DotPolygonBasedShapes.note.toString()));

		DotRenderer node = new NodeDefinitionRenderer(name, options.createRenderer());
		node.render(out);
	}
	
	public void generateNote(PrintWriter out, String name, OptionsRenderer or) {
		or.add(new AttributeRenderer("shape", DotPolygonBasedShapes.note.toString()));
		
		DotRenderer node = new NodeDefinitionRenderer(name, or);
		node.render(out);
	}
	
	public OptionsBuilder createOptionsBuilder() {
		return new OptionsBuilder();
	}

	public Option createShapeOption(DotPolygonBasedShapes aShape) {
		Option anOption = new Option(DotNodeOptions.shape.toString(), aShape.toString());
		return anOption;
	}
	
	public Option createEdgeOption(DotEdgeOptions key, String value) {
		return new Option(key.toString(), value);
	}

	public Option createNodeOption(DotNodeOptions key, String value) {
		return new Option(key.toString(), value);
	}

	public Option createStringOption(DotNodeOptions key, String value) {
		return new StringOption(key.toString(), value);
	}
}
