package se.inax.dot.generator.render;

import java.io.PrintWriter;

/**
 * Null object implementation of the OptionsRenderer. This class does
 * not render anything. Use this instead of passing null around.
 * 
 * @author Ingemar Axelsson<ingemar.axelsson@gmail.com>
 *
 */
public class NoOptionsRenderer extends OptionsRenderer {

	@Override
	public void render(final PrintWriter out) {}
}
