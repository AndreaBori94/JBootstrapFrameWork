package it.bori.jbfw.core.io.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserPattern {

	public static void main(String[] args) {
		String regex = "<tag>Ciccio</tag><tags>Ciccio3</tags><tag>Ciccio2</tag>";
		List<String> list = getTagValues(regex);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static Pattern TAG_REGEX = Pattern.compile("<tag>(.+?)</tag>");

	private static List<String> getTagValues(String str) {
		final List<String> tagValues = new ArrayList<String>();
		final Matcher matcher = TAG_REGEX.matcher(str);
		while (matcher.find()) {
			tagValues.add(matcher.group(1));
		}
		return tagValues;
	}
}