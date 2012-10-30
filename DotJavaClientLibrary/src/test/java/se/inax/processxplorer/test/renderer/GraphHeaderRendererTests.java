package se.inax.processxplorer.test.renderer;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

import se.inax.dot.client.DotClient;
import se.inax.dot.client.OptionsBuilder;
import se.inax.dot.client.render.GraphHeaderRenderer;
import se.inax.dot.client.render.directed.DirectedGraphHeaderRenderer;
import se.inax.dot.client.render.undirected.UndirectedGraphHeaderRenderer;
import se.inax.dot.constants.GraphOptions;

public class GraphHeaderRendererTests {

	private final String newline = System.getProperty("line.separator");

	@Test
	public void directed_graph_0() {
		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result);

		GraphHeaderRenderer header = new DirectedGraphHeaderRenderer("A");
		header.render(out);

		assertEquals("digraph A {"+ newline, result.getBuffer().toString());
	}

	@Test
	public void undirected_graph_0() {
		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result);

		GraphHeaderRenderer header = new UndirectedGraphHeaderRenderer("A");
		header.render(out);

		assertEquals("graph A {"+ newline, result.getBuffer().toString());
	}

	@Test
	public void directed_graph_1() {
		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result);

		DotClient graph = DotClient.directedGraphGenerator();
		OptionsBuilder options = graph.createOptionsBuilder();
		options.add(graph.createGraphStringOption(GraphOptions.comment, "A comment"));
		graph.generateHeader(out, "A", options.buildOptions());

		assertEquals("digraph A [comment=\"A comment\"] {"+ newline, result.getBuffer().toString());
	}
}
