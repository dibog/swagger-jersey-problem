package net.bogdoll.resB.impl;

import java.util.Date;

import net.bogdoll.resB.DataResource;

public class DataResourceImpl implements DataResource {
	@Override
	public String getData() {
		return new Date().toString();
	}
}
