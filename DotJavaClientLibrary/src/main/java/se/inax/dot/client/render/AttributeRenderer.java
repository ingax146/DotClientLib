package se.inax.dot.client.render;

import java.io.PrintWriter;

import se.inax.dot.client.DotRenderer;

/**
 * The AttributeRenderer class knows how DOT attributes are rendered.
 * 
 * For rendering string attributes, see the StringAttributeRenderer which
 * implements correct escaping of the string value.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class AttributeRenderer implements DotRenderer {
	String key;
	String value;

	/**
	 * Constructor, the AttributeRenderer can not render attributes without
	 * a given key-value pair to render.
	 * 
	 * @param key	Attribute name
	 * @param value	Attribute value
	 */
	public AttributeRenderer(final String key, final String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * This method knows how to render a DOT attribute.
	 */
	@Override
	public void render(final PrintWriter out) {
		if (out == null) {
			return;
		}
		renderKey(out);
		out.print("=");
		renderValue(out);
	}

	/**
	 * Render the key of the attribute.
	 * 
	 * @param out	PrintWriter which is never null, this is checked by the render() method.
	 */
	protected void renderKey(final PrintWriter out) {
		out.print(key);
	}

	/**
	 * Method for rendering the value of an attribute.
	 * 
	 * @param out	PrintWriter which is never null, this is checked by the render() method.
	 */
	protected void renderValue(final PrintWriter out) {
		preRenderValue(out);
		out.print(value);
		postRenderValue(out);
	}

	/**
	 * Hook method invoked just before the value is rendered to
	 * the given PrintWriter.
	 * 
	 * Subclasses may use this method to render something before the
	 * value is rendered, such as a '\"' for example
	 * 
	 * @param out	PrintWriter which is never null, this is checked by the render() method.
	 */
	protected void preRenderValue(final PrintWriter out) {}

	/**
	 * Hook method invoked just after the value is rendered to
	 * the given PrintWriter.
	 * 
	 * Subclasses may use this method to render something right after
	 * the value is rendered, such as a '\"' for example.
	 * 
	 * @param out	PrintWriter which is never null, this is checked by the render() method.
	 */
	protected void postRenderValue(final PrintWriter out) {}
}
