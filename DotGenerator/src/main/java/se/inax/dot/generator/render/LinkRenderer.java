package se.inax.dot.generator.render;

import java.io.PrintWriter;

import se.inax.dot.generator.DotRenderer;

public abstract class LinkRenderer implements DotRenderer {
	private final String source;
	private final String destination;
	private OptionsRenderer options = new OptionsRenderer();
	
	public LinkRenderer(String sourceName, String destName) {
		this(sourceName, destName, new OptionsRenderer());
	}

	public LinkRenderer(String sourceName, String destName, OptionsRenderer or) {
		source = sourceName;
		destination = destName;
		options = or;
	}

	@Override
	public void render(PrintWriter out) {
		renderIndentation(out);
		renderSource(out);
		renderLink(out);
		renderDestination(out);
		renderOptions(out);
		renderLinkEnd(out);
	}

	protected void renderOptions(PrintWriter out) {
		options.render(out);
	}

	protected void renderDestination(PrintWriter out) {
		out.print(destination);
	}

	protected void renderSource(PrintWriter out) {
		out.print(source);
	}

	protected void renderLinkEnd(PrintWriter out) {
		out.println(";");
	}

	protected void renderLink(PrintWriter out) {
		renderPreLink(out);
		renderLinkArrow(out);
		renderPostLink(out);
	}

	protected void renderPostLink(PrintWriter out) {
		out.print(" ");
	}

	protected abstract void renderLinkArrow(PrintWriter out);

	protected void renderPreLink(PrintWriter out) {
		out.print(" ");
	}

	protected void renderIndentation(PrintWriter out) {
		out.print("\t");
	}
	
	protected OptionsRenderer getOptionsRenderer() {
		return options;
	}
}
