package se.inax.dot.client;

import java.util.ArrayList;
import java.util.List;

public class OptionsImpl implements Options {
	List<Option> options = new ArrayList<Option>();
	
	@Override
	public void add(Option attribute) {
		options.add(attribute);
	}

	@Override
	public List<Option> getOptions() {
		return options;
	}

}
