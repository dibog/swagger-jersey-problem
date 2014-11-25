package net.bogdoll.resA;

import java.util.Date;

public class DataResourceImpl implements DataResource {
	@Override
	public String getData() {
		return new Date().toString();
	}
}
