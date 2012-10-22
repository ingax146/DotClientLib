package se.inax.dot.generator.render;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;
import se.inax.dot.generator.Options;

/**
 * The LinkRenderer class is an abstract class implementing the most
 * basic link behavior.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public abstract class LinkRenderer implements DotRenderer {
	private final String source;
	private final String destination;
	private OptionsRenderer options = new OptionsRenderer();

	public LinkRenderer(final String sourceName, final String destName) {
		this(sourceName, destName, null);
	}

	public LinkRenderer(final String sourceName, final String destName, Options os) {
		options = new OptionsRenderer(os);
		source = sourceName;
		destination = destName;
	}

	@Override
	public void render(final PrintWriter out) {
		if (out == null) {
			return;
		}
		renderIndentation(out);
		renderSource(out);
		renderLink(out);
		renderDestination(out);
		renderOptions(out);
		renderLinkEnd(out);
	}

	protected void renderOptions(final PrintWriter out) {
		options.render(out);
	}

	protected void renderDestination(final PrintWriter out) {
		out.print(destination);
	}

	protected void renderSource(final PrintWriter out) {
		out.print(source);
	}

	protected void renderLinkEnd(final PrintWriter out) {
		out.println(";");
	}

	protected void renderLink(final PrintWriter out) {
		renderPreLink(out);
		renderLinkArrow(out);
		renderPostLink(out);
	}

	protected void renderPostLink(final PrintWriter out) {
		out.print(" ");
	}

	protected abstract void renderLinkArrow(PrintWriter out);

	protected void renderPreLink(final PrintWriter out) {
		out.print(" ");
	}

	protected void renderIndentation(final PrintWriter out) {
		out.print("\t");
	}

	protected OptionsRenderer getOptionsRenderer() {
		return options;
	}
}
