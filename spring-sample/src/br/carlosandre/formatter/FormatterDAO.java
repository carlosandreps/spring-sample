package br.carlosandre.formatter;

import java.util.List;

import br.carlosandre.formatter.entity.Line;

public interface FormatterDAO {

	public List<Line> listLines(String path);

}