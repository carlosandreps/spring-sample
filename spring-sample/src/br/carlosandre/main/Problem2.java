package br.carlosandre.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.carlosandre.formatter.FormatterService;
import br.carlosandre.formatter.entity.Line;

public class Problem2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		@SuppressWarnings("unchecked")
		FormatterService<String> formatterService = (FormatterService<String>) context.getBean("htmlFormatterService");
		List<Line> lines = formatterService.listOrderedLines("resources/data.txt");

		System.out.println(formatterService.getProcessedOutput(lines));
	}
}