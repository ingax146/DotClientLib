package se.inax.dot.generator.render;

import java.io.PrintWriter;

/**
 * Renders apostrophes around the value. This is useful for
 * rendering string labels.
 * 
 * @author Ingemar Axelsson<ingemar.axelsson@gmail.com>
 *
 */
public class StringAttributeRenderer extends AttributeRenderer {

	/**
	 * 
	 * @param key
	 * @param value
	 */
	public StringAttributeRenderer(final String key, final String value) {
		super(key, value);
	}

	/*
	 * (non-Javadoc)
	 * @see se.inax.dot.generator.render.AttributeRenderer#preRenderValue(java.io.PrintWriter)
	 */
	@Override
	protected void preRenderValue(final PrintWriter out) {
		out.print("\"");
	}

	/*
	 * (non-Javadoc)
	 * @see se.inax.dot.generator.render.AttributeRenderer#postRenderValue(java.io.PrintWriter)
	 */
	@Override
	protected void postRenderValue(final PrintWriter out) {
		out.print("\"");
	}
}
