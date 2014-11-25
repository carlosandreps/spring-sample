package br.carlosandre.formatter.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.carlosandre.formatter.FormatterDAO;
import br.carlosandre.formatter.entity.Line;

public class FormatterDAOImpl implements FormatterDAO {

	@Override
	public List<Line> listLines(String path) {
		List<Line> lines = new ArrayList<Line>();
		BufferedReader br = null;
		try {

			br = new BufferedReader(new FileReader(path));

			String readLine = br.readLine();
			while (readLine != null) {
				lines.add(getLineFromString(readLine));
				readLine = br.readLine();
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lines;
	}

	private Line getLineFromString(String string) {
		String[] words = string.split(" ");
		int longestSize = 0;
		for (String str : words) {
			int size = str.length();

			if (longestSize < size) {
				longestSize = size;
			}
		}
		Line line = new Line(string, longestSize);
		return line;
	}
}