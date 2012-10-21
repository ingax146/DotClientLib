package se.inax.processxplorer.test.renderer;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

import se.inax.dot.generator.render.LinkRenderer;
import se.inax.dot.generator.render.directed.DirectedLinkRenderer;
import se.inax.dot.generator.render.undirected.UndirectedLinkRenderer;

/**
 * Test the link rendition. Links should be generated on the same line if
 * possible, hence implementations should use the print() method instead of
 * println() method when rendering to the output writer.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class LinkRendererTests {

	@Test
	public void test() {
		LinkRenderer link = new UndirectedLinkRenderer(null, null);

		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result);
		
		link.render(out);
		
		assertEquals("\tnull -- null [arrowhead=none];"+System.getProperty("line.separator"), result.getBuffer().toString());
	}

	@Test
	public void test1() {
		LinkRenderer link = new DirectedLinkRenderer(null, null);

		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result);
		
		link.render(out);
		
		assertEquals("\tnull -> null;"+System.getProperty("line.separator"), result.getBuffer().toString());		
	}
}
