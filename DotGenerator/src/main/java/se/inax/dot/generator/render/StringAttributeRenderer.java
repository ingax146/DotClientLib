package se.inax.dot.generator.render;

import java.io.PrintWriter;

/**
 * Renders apostrophes around the value. 
 * 
 * @author Ingemar Axelsson<ingemar.axelsson@emc.com>
 *
 */
public class StringAttributeRenderer extends AttributeRenderer {

	public StringAttributeRenderer(String key, String value) {
		super(key, value);
	}

	protected void preRenderValue(PrintWriter out) {
		out.print("\"");
	}
	
	protected void postRenderValue(PrintWriter out) {
		out.print("\"");
	}
}
