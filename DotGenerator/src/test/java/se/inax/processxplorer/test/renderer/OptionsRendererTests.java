package se.inax.processxplorer.test.renderer;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import se.inax.dot.constants.EdgeOptions;
import se.inax.dot.constants.NodeOptions;
import se.inax.dot.generator.DotGenerator;
import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.Options;
import se.inax.dot.generator.render.NodeDefinitionRenderer;
import se.inax.dot.generator.render.directed.DirectedLinkRenderer;

public class OptionsRendererTests {

	/*
	 * A_Name [shape=plaintext, style=filled, fillcolor=red, label=\"1.0,1.1\"];
	 */
	@Test
	public void test0() throws UnsupportedEncodingException {
		String fillcolor="red";
		String versionlabel = "1.0,1.1";

		DotGenerator graph = DotGenerator.directedGraphGenerator();
		Options options = DotGenerator.createEmptyOptions();
		options.add(graph.createNodeOption(NodeOptions.shape, "plaintext"));
		options.add(graph.createNodeOption(NodeOptions.style, "filled"));
		options.add(graph.createNodeOption(NodeOptions.fillcolor, fillcolor));
		options.add(graph.createNodeOption(NodeOptions.label, versionlabel));
		
		DotRenderer aRenderer = new NodeDefinitionRenderer("A_Name", options);

		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		aRenderer.render(output);
		
		String wantedResult="\tA_Name [shape=plaintext, style=filled, fillcolor=red, label=\"1.0,1.1\"];";
		wantedResult += System.getProperty("line.separator");

		assertEquals(wantedResult, result.getBuffer().toString());
	}

	/*
	 * S1 -> S2 [label=\"a test value\", penwidth=3];
	 */
	@Test
	public void test1() throws UnsupportedEncodingException {
		String sourceName = "S1";
		String destName = "S2";

		DotGenerator graph = DotGenerator.directedGraphGenerator();
		Options options = DotGenerator.createEmptyOptions();
		options.add(graph.createEdgeOption(EdgeOptions.label, "a test value"));
		options.add(graph.createEdgeOption(EdgeOptions.penwidth, "3"));
		DotRenderer renderer = new DirectedLinkRenderer(sourceName, destName, options);
		
		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		renderer.render(output);

		String wantedResult = "\tS1 -> S2 [label=\"a test value\", penwidth=3];";
		wantedResult += System.getProperty("line.separator");
		
		assertEquals(wantedResult, result.getBuffer().toString());
	}
}
