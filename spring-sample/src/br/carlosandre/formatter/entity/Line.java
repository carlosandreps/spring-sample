package br.carlosandre.formatter.entity;

import java.util.Comparator;

public class Line {

	private String value;
	private Integer longestWordSize;

	public Line(String value, Integer longestWordSize) {
		super();
		this.value = null != value ? value.trim() : null;
		this.longestWordSize = longestWordSize;
	}

	public String getValue() {
		return value;
	}

	public Integer getLongestWordSize() {
		return longestWordSize;
	}

	public static Comparator<Line> LONGEST_WORD_COMPARATOR = new Comparator<Line>() {

		@Override
		public int compare(Line line1, Line line2) {
			return line1.getLongestWordSize().compareTo(line2.getLongestWordSize());
		}
	};

	@Override
	public String toString() {
		return getValue();
	}
}
