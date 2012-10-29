package se.inax.dot.client;

import java.io.PrintWriter;

/**
 * DotRenderer is an interface describing what a Dot Renderer
 * should support. Basically it supports to write stuff to an
 * OutputStream.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public interface DotRenderer {

	/**
	 * 
	 * @param out PrintWriter to render to.
	 */
	public void render(final PrintWriter out);
}
