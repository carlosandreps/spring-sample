package br.carlosandre.formatter;

import java.util.List;

import br.carlosandre.formatter.entity.Line;

public interface FormatterService<T> {

	public List<Line> listOrderedLines(String source);

	public T getProcessedOutput(List<Line> lines);
}