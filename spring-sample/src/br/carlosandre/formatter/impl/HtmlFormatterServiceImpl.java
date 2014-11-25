package br.carlosandre.formatter.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.carlosandre.constants.Constants;
import br.carlosandre.formatter.FormatterService;
import br.carlosandre.formatter.FormatterDAO;
import br.carlosandre.formatter.entity.Line;

public class HtmlFormatterServiceImpl implements FormatterService<String> {

	@Autowired
	private FormatterDAO tableFormatterDAO;

	@Override
	public List<Line> listOrderedLines(String source) {
		List<Line> lines = tableFormatterDAO.listLines(source);
		Collections.sort(lines, Collections.reverseOrder(Line.LONGEST_WORD_COMPARATOR));

		return lines;
	}

	@Override
	public String getProcessedOutput(List<Line> lines) {
		int i = 1;

		StringBuilder sb = new StringBuilder();
		sb.append("<h1>Ordered result:</h1>").append(breakLine());
		sb.append("<html>").append(breakLine());
		sb.append(" <body>").append(breakLine());
		sb.append("  <table border=1 cellpadding=4 cellspacing=0 style=\" font-family:Arial, sans-serif;font-size:10pt;\">").append(breakLine());
		sb.append("   <tr style=\"font-weight: bold\">").append(breakLine());
		sb.append("    <td>#</td>").append(breakLine());
		sb.append("    <td>String</td>").append(breakLine());
		sb.append("    <td>Longest Word</td").append(breakLine());
		sb.append("   </tr>").append(breakLine());

		for (Line line : lines) {
			sb.append("   <tr>").append(breakLine());
			sb.append("    <td>" + i++ + "</td>").append(breakLine());
			sb.append("    <td>" + line.getValue() + "</td>").append(breakLine());
			sb.append("    <td>" + line.getLongestWordSize() + "</td>").append(breakLine());
			sb.append("   </tr>").append(breakLine());
		}

		sb.append("  </table>").append(breakLine());
		sb.append(" </body>").append(breakLine());
		sb.append("</html>").append(breakLine());

		return sb.toString();
	}

	private String breakLine() {
		return Constants.BREAK_LINE.getValue();
	}
}