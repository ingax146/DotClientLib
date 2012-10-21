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
 * These test cases aim to be a short tutorial of how to use this library as
 * well as good examples of usage but also a test suite for the functionality of
 * the DotGenerator library. This basically shows how to use the library, not
 * how to extend or modify it.
 * 
 * The test code uses a StringWriter as output, this is to capture the text
 * within memory to make it easier to verify the test result. Any class that can
 * be wrapped by a PrintWriter can be used as a rendering back end.
 * 
 * This test suite starts from scratch and shows how a turn pile finite state
 * machine DOT-diagram is built up from scratch. Each test will show an
 * additional feature of the DotGenerator library. This to make it easy to
 * follow. The tests will become more complex and include more details. When
 * reading the tests, notice how the enumerations are used to make it easier to
 * find and set the correct value.
 * 
 * Each test also has the corresponding StringBuilder creation of the DOT-code
 * representing the same result. This is useful to verify correctness of the
 * library, but it also shows the complexity of the DOT-language and also the
 * features of the DotGenerator library.
 * 
 * One of the biggest features so far is the options enumerations, it allows one
 * to find the correct option fast and it also removes a lot of misspelled
 * options in the generated graph since the value can be selected appropriately
 * by the IDE code completion algorithms.
 * 
 * Additional library features would be reduced complexity in building and
 * generating graphs.
 * 
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@gmail.com>
 * 
 */
public class DotFacadeTest {

	private static final String	newline	= System.getProperty("line.separator");

	private Reader loadExpectedResult(final String testName) throws FileNotFoundException {
		final String resourceFolder = "src/test/resources";
		final String classPathName = DotFacadeTest.class.getCanonicalName().toLowerCase().replace(".", "/");
		final String resourceName = resourceFolder + "/" + classPathName + "/" + testName + ".txt";
		final InputStream resourceStream = new FileInputStream(resourceName);
		return new InputStreamReader(resourceStream);
	}

	private String writerToString(final StringWriter result) {
		return result.getBuffer().toString();
	}

	/*
	 * Then it creates the directed graph header given a diagram name, and the
	 * ending graph footer.
	 */
	@Test
	public void directed_graph_create_graph() {
		final StringWriter result = new StringWriter();
		final PrintWriter out = new PrintWriter(result);

		final DotGenerator graphGen = DotGenerator.directedGraphGenerator();
		graphGen.generateHeader(out, "Turnpile");
		// Generate graph objects here..
		graphGen.generateFooter(out);

		/*
		 * Creating the same output with the StringBuilder (and knowledge of the
		 * DOT language).
		 */
		final StringBuilder expectedGraph = new StringBuilder();
		expectedGraph.append("digraph Turnpile {" + newline);
		expectedGraph.append("}" + newline);

		assertEquals(expectedGraph.toString(), writerToString(result));
	}

	/*
	 *
	 */
	@Test
	public void directed_graph_adding_edges() {
		final StringWriter result = new StringWriter();
		final PrintWriter out = new PrintWriter(result);

		final DotGenerator graphGen = DotGenerator.directedGraphGenerator();
		graphGen.generateHeader(out, "Turnpile");
		graphGen.generateEdge(out, "A", "B");
		graphGen.generateEdge(out, "B", "A");
		graphGen.generateFooter(out);

		final StringBuilder expectedGraph = new StringBuilder();
		expectedGraph.append("digraph Turnpile {" + newline);
		expectedGraph.append("\tA -> B;" + newline);
		expectedGraph.append("\tB -> A;" + newline);
		expectedGraph.append("}" + newline);

		assertEquals(expectedGraph.toString(), writerToString(result));
	}

	@Test
	public void directed_graph_node_labels() {
		final StringWriter result = new StringWriter();
		final PrintWriter out = new PrintWriter(result);

		final DotGenerator graphGen = DotGenerator.directedGraphGenerator();
		graphGen.generateHeader(out, "Turnpile");
		final OptionsBuilder coinBuilder = graphGen.createOptionsBuilder();
		coinBuilder.add(graphGen.createStringNodeOption(DotNodeOptions.label, "Closed"));
		graphGen.generateNode(out, "A", coinBuilder.createRenderer());
		final OptionsBuilder passBuilder = graphGen.createOptionsBuilder();
		passBuilder.add(graphGen.createStringNodeOption(DotNodeOptions.label, "Open"));
		graphGen.generateNode(out, "B", passBuilder.createRenderer());
		graphGen.generateEdge(out, "A", "B");
		graphGen.generateEdge(out, "B", "A");
		graphGen.generateFooter(out);

		final StringBuilder expectedGraph = new StringBuilder();
		expectedGraph.append("digraph Turnpile {" + newline);
		expectedGraph.append("\tA [label=\"Closed\"];" + newline);
		expectedGraph.append("\tB [label=\"Open\"];" + newline);
		expectedGraph.append("\tA -> B;" + newline);
		expectedGraph.append("\tB -> A;" + newline);
		expectedGraph.append("}" + newline);

		assertEquals(expectedGraph.toString(), writerToString(result));
	}

	@Test
	public void directed_graph_edge_labels() {
		final StringWriter result = new StringWriter();
		final PrintWriter out = new PrintWriter(result);

		final DotGenerator graphGen = DotGenerator.directedGraphGenerator();

		graphGen.generateHeader(out, "Turnpile");

		final OptionsBuilder closedBuilder = graphGen.createOptionsBuilder();
		closedBuilder.add(graphGen.createStringNodeOption(DotNodeOptions.label, "Closed"));
		graphGen.generateNode(out, "A", closedBuilder.createRenderer());

		final OptionsBuilder openBuilder = graphGen.createOptionsBuilder();
		openBuilder.add(graphGen.createStringNodeOption(DotNodeOptions.label, "Open"));
		graphGen.generateNode(out, "B", openBuilder.createRenderer());

		final OptionsBuilder coinBuilder = graphGen.createOptionsBuilder();
		coinBuilder.add(graphGen.createStringEdgeOption(DotEdgeOptions.label, "coin"));
		graphGen.generateEdge(out, "A", "B", coinBuilder.createRenderer());

		final OptionsBuilder passBuilder = graphGen.createOptionsBuilder();
		passBuilder.add(graphGen.createStringEdgeOption(DotEdgeOptions.label, "pass"));
		graphGen.generateEdge(out, "B", "A", passBuilder.createRenderer());

		graphGen.generateFooter(out);

		final StringBuilder expectedGraph = new StringBuilder();
		expectedGraph.append("digraph Turnpile {" + newline);
		expectedGraph.append("\tA [label=\"Closed\"];" + newline);
		expectedGraph.append("\tB [label=\"Open\"];" + newline);
		expectedGraph.append("\tA -> B [label=\"coin\"];" + newline);
		expectedGraph.append("\tB -> A [label=\"pass\"];" + newline);
		expectedGraph.append("}" + newline);

		assertEquals(expectedGraph.toString(), writerToString(result));
	}

	@Test
	public void test1() throws IOException {

		final DotGenerator graphUtil = DotGenerator.directedGraphGenerator();
		final OptionsBuilder options = graphUtil.createOptionsBuilder();
		options.add(graphUtil.createStringNodeOption(DotNodeOptions.label, "Hello world"));

		final StringWriter output = new StringWriter();
		final PrintWriter out = new PrintWriter(output);
		graphUtil.generateNode(out, "A0");

		final String wantedResult = "\tA0;" + System.getProperty("line.separator");
		assertEquals(wantedResult, writerToString(output));

	}

	@Test
	public void test0() throws IOException {

		final StringWriter result = new StringWriter();
		final PrintWriter out = new PrintWriter(result);
		final DotGenerator graph = DotGenerator.directedGraphGenerator();

		graph.generateHeader(out, "graphName");

		graph.generateNode(out, "NodeName");

		final OptionsBuilder nodeOptions = graph.createOptionsBuilder();
		nodeOptions.add(graph.createNodeOption(DotNodeOptions.shape, "rectangle"));
		nodeOptions.add(graph.createStringNodeOption(DotNodeOptions.label, "Hej kom å hjälp mig"));
		graph.generateNode(out, "NodeName2", nodeOptions.createRenderer());

		graph.generateEdge(out, "NodeName", "NodeName2");

		final OptionsBuilder edgeOptions = graph.createOptionsBuilder();
		edgeOptions.add(graph.createEdgeOption(DotEdgeOptions.arrowhead, "none"));
		graph.generateEdge(out, "NodeName", "NodeName2", edgeOptions.createRenderer());

		graph.generateNote(out, "NoteName");

		graph.generateFooter(out);

		final Reader resultReader = new StringReader(writerToString(result));
		final Reader expectedReader = loadExpectedResult("test0");

		assertReaderEquals(expectedReader, resultReader);
	}

	private void assertReaderEquals(final Reader expectedReader, final Reader resultReader) throws IOException {
		boolean done = false;
		while (!done) {
			final int expected = expectedReader.read();
			final int given = resultReader.read();
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
