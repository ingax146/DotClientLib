package se.inax.processxplorer.test.renderer;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.render.AttributeRenderer;
import se.inax.dot.generator.render.NodeDefinitionRenderer;
import se.inax.dot.generator.render.OptionsRenderer;
import se.inax.dot.generator.render.StringAttributeRenderer;
import se.inax.dot.generator.render.directed.DirectedLinkRenderer;

/**
 * These tests aim to test the dot generator classes, in order to
 * make sure that they provide the correct output. 
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class RenderTests {

	@Test
	public void test0() throws UnsupportedEncodingException {
		String fillcolor="red";
		String versionlabel = "1.0,1.1";

		OptionsRenderer or = new OptionsRenderer();
		or.add(new AttributeRenderer("shape", "plaintext"));
		or.add(new AttributeRenderer("style", "filled"));
		or.add(new AttributeRenderer("fillcolor", fillcolor));
		or.add(new StringAttributeRenderer("label", versionlabel));
		
		DotRenderer aRenderer = new NodeDefinitionRenderer("A_Name", or);

		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		aRenderer.render(output);
		
		String wantedResult="\tA_Name [shape=plaintext, style=filled, fillcolor=red, label=\"1.0,1.1\"];";
		wantedResult += System.getProperty("line.separator");
		assertEquals(wantedResult, result.getBuffer().toString());
	}
	
	@Test 
	public void test1() throws UnsupportedEncodingException {
		DotRenderer renderer = new NodeDefinitionRenderer("A1");
		
		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		renderer.render(output);
		assertEquals("\tA1;"+System.getProperty("line.separator"), result.getBuffer().toString());
	}
	
	@Test
	public void test2() throws UnsupportedEncodingException {
		String sourceName = "S1";
		String destName = "S2";
		DotRenderer renderer = new DirectedLinkRenderer(sourceName, destName);
		
		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		renderer.render(output);
		
		assertEquals("\tS1 -> S2;"+System.getProperty("line.separator"), result.getBuffer().toString());
	}
	
	@Test
	public void test3() throws UnsupportedEncodingException {
		String sourceName = "S1";
		String destName = "S2";
		OptionsRenderer or = new OptionsRenderer();
		or.add(new StringAttributeRenderer("label", "a test value"));
		or.add(new AttributeRenderer("penwidth", "3"));
		DotRenderer renderer = new DirectedLinkRenderer(sourceName, destName, or);
		
		StringWriter result = new StringWriter();
		PrintWriter output = new PrintWriter(result);
		renderer.render(output);

		String wantedResult = "\tS1 -> S2 [label=\"a test value\", penwidth=3];";
		wantedResult += System.getProperty("line.separator");
		assertEquals(wantedResult, result.getBuffer().toString());
	}
}
