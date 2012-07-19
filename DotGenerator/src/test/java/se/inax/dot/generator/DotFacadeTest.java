package se.inax.dot.generator;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.Test;

import se.inax.dot.constants.DotEdgeOptions;
import se.inax.dot.constants.DotNodeOptions;

/**
 * These test cases aim to test the functionality of the DotFacade, that
 * it the external API for others to use.
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 *
 */
public class DotFacadeTest {

	private Reader loadExpectedResult(String testName) throws FileNotFoundException {
		String resourceFolder = "src/test/resources";
		String classPathName = DotFacadeTest.class.getCanonicalName().toLowerCase().replace(".", "/");
		String resourceName = resourceFolder + "/" + classPathName + "/" + testName + ".txt";
		InputStream resourceStream = new FileInputStream(resourceName);
		return new InputStreamReader(resourceStream);
	}
	
	@Test 
	public void test1() throws IOException {
		
		DotGenerator graphUtil = DotGenerator.directedGraphGenerator();
		OptionsBuilder options = graphUtil.createOptionsBuilder();
		options.add(graphUtil.createStringOption(DotNodeOptions.label, "Hello world"));

		StringWriter output = new StringWriter();
		PrintWriter out = new PrintWriter(output);
		graphUtil.generateNode(out, "A0");

		String wantedResult = "\tA0;" + System.getProperty("line.separator");
		assertEquals(wantedResult, output.getBuffer().toString());
		
	}
	
	@Test
	public void test0() throws IOException {

		StringWriter result = new StringWriter();
		PrintWriter out = new PrintWriter(result);
		DotGenerator graph = DotGenerator.directedGraphGenerator();

		graph.generateHeader(out, "graphName");
		
		graph.generateNode(out, "NodeName");

		OptionsBuilder nodeOptions = graph.createOptionsBuilder();
		nodeOptions.add(graph.createNodeOption(DotNodeOptions.shape, "rectangle"));
		nodeOptions.add(graph.createStringOption(DotNodeOptions.label, "Hej kom å hjälp mig"));
		graph.generateNode(out, "NodeName2", nodeOptions.createRenderer());
		
		graph.generateEdge(out, "NodeName", "NodeName2");

		OptionsBuilder edgeOptions = graph.createOptionsBuilder();
		edgeOptions.add(graph.createEdgeOption(DotEdgeOptions.arrowhead, "none"));
		graph.generateEdge(out, "NodeName", "NodeName2", edgeOptions.createRenderer());
		
		graph.generateNote(out, "NoteName");
		
		graph.generateFooter(out);

		Reader resultReader = new StringReader(result.getBuffer().toString());
		Reader expectedReader = loadExpectedResult("test0");
		
		assertReaderEquals(expectedReader, resultReader);
	}

	private void assertReaderEquals(Reader expectedReader, Reader resultReader) throws IOException {
		boolean done = false;
		while(!done) {
			int expected = expectedReader.read();
			int given = resultReader.read();
			if (expected != given) {
				System.out.println(Integer.toString(expected) + "=" + Integer.toString(given));
				throw new RuntimeException("expected reader not equal given reader");
			}
			if (expected == -1 || given == -1) {
				done = true;
			}
		}
	}
}
