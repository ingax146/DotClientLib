package se.inax.dot.generator;


public class OptionsBuilder {
	Options options = new OptionsImpl();

	public void add(final Option attribute) {
		options.add(attribute);
	}

	public Options buildOptions() {
		return options;
	}

}
