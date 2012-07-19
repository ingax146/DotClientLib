package se.inax.dot.generator.render;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;

public class AttributeRenderer implements DotRenderer {
	String key;
	String value;
	public AttributeRenderer(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public void render(PrintWriter out) {
		out.print(key);
		out.print("=");
		preRenderValue(out);
		renderValue(out);
		postRenderValue(out);
	}

	protected void renderValue(PrintWriter out) {
		out.print(value);
	}

	protected void preRenderValue(PrintWriter out) {}
	
	protected void postRenderValue(PrintWriter out) {}
}
