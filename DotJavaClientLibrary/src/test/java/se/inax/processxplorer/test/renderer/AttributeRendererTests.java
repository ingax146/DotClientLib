package se.inax.processxplorer.test.renderer;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

import se.inax.dot.client.render.AttributeRenderer;
import se.inax.dot.client.render.StringAttributeRenderer;

public class AttributeRendererTests {
	
	@Test
	public void test0() {
		AttributeRenderer attribute = new AttributeRenderer(null, null);

		StringWriter result = new StringWriter();
		renderAttribute(attribute, result);
		
		assertEquals("null=null", result.getBuffer().toString());
	}

	@Test
	public void test1() {
		AttributeRenderer attribute = new AttributeRenderer("A", null);

		StringWriter result = new StringWriter();
		renderAttribute(attribute, result);
		
		assertEquals("A=null", result.getBuffer().toString());
	}

	@Test
	public void test2() {
		AttributeRenderer attribute = new AttributeRenderer("A", "1");

		StringWriter result = new StringWriter();
		renderAttribute(attribute, result);
		
		assertEquals("A=1", result.getBuffer().toString());
	}
	
	/*
	 * Simple test for verifying null output.
	 */
	@Test
	public void test3() {
		AttributeRenderer attribute = new AttributeRenderer("A", "1");
		
		attribute.render(null);
	}
	
	private void renderAttribute(AttributeRenderer attribute, StringWriter result) {
		PrintWriter out = new PrintWriter(result);
		attribute.render(out);
	}
	
	@Test
	public void test4() {
		AttributeRenderer attribute = new StringAttributeRenderer(null, null);

		StringWriter result = new StringWriter();
		renderAttribute(attribute, result);
		
		assertEquals("null=\"null\"", result.getBuffer().toString());
	}

	@Test
	public void test5() {
		AttributeRenderer attribute = new StringAttributeRenderer("A", null);

		StringWriter result = new StringWriter();
		renderAttribute(attribute, result);
		
		assertEquals("A=\"null\"", result.getBuffer().toString());
	}
	
	@Test
	public void test6() {
		AttributeRenderer attribute = new StringAttributeRenderer("A", "1");

		StringWriter result = new StringWriter();
		renderAttribute(attribute, result);
		
		assertEquals("A=\"1\"", result.getBuffer().toString());
	}
}
