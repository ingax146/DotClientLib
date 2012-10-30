package se.inax.processxplorer.test.renderer;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import se.inax.dot.client.DotRenderer;
import se.inax.dot.client.render.NodeDefinitionRenderer;
import se.inax.dot.client.render.directed.DirectedLinkRenderer;

/**
 * These tests aim to test the dot generator classes, in order to
 * make sure that they provide the correct output. 
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class RenderTests {
	
	@Test 
	public void nodeDefinitionRenderer_0() throws UnsupportedEncodingException {
		DotRenderer renderer = new NodeDefinitionRenderer("A1");
		
		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		renderer.render(output);
		assertEquals("\tA1;"+System.getProperty("line.separator"), result.getBuffer().toString());
	}
	
	@Test
	public void directedLinkRenderer_0() throws UnsupportedEncodingException {
		String sourceName = "S1";
		String destName = "S2";
		DotRenderer renderer = new DirectedLinkRenderer(sourceName, destName);
		
		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		renderer.render(output);
		
		assertEquals("\tS1 -> S2;"+System.getProperty("line.separator"), result.getBuffer().toString());
	}
}
