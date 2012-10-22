package se.inax.dot.generator;

import java.util.List;

public interface Options {

	void add(Option attribute);

	List<Option> getOptions();

}
