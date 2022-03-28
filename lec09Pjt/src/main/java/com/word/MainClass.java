package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.word.service.WordRegisterService;
import com.word.service.WordSearchService;

// ������ �ܾ� �˻� ������Ʈ 
// �ܾ ���� ���� 
public class MainClass {

	public static void main(String[] args) {
		
		// DB
		String[] keyWords = {"c", "c++", "java", "jsp",  "spring"};
		String[] values = {"C�� 1972�� �� �轼�� ���Ͻ� ��ġ�� ���н� � ü������ ����ϱ� ���� ������ ���α׷��� ����̴�.", 
				"C++�� AT&T �� �������� ��߳� ��Ʈ�ӽ�Ʈ���� 1983�� ��ǥ�Ͽ� ������ ���α׷��� ����̴�.", 
				"�ڹٴ� �� ����ũ�νý������� ���ӽ� ������(James Gosling)�� �ٸ� ���������� ������ ��ü ������ ���α׷��� ����̴�.", 
				"JSP�� HTML���� �ڹ� �ڵ带 �����Ͽ� �� �������� �������� �� �������� �����Ͽ� �� �������� �����ִ� ����̴�.", 
				"������ �����ӿ�ũ�� �ڹ� �÷����� ���� ���¼ҽ� ���ø����̼� �����ӿ�ũ�μ� ������ �������̶���� �Ҹ���."};
		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		// wordset�̶�� ��ü�� ���� (�ܾ� key-value)
		WordRegisterService registerService = 
				ctx.getBean("registerService", WordRegisterService.class);
		for (int i = 0; i < values.length; i++) {
			WordSet wordSet = new WordSet(keyWords[i], values[i]);
			registerService.register(wordSet);
		}
		
		WordSearchService searchService = 
				ctx.getBean("searchService", WordSearchService.class);
		
		// search�� �� 
		System.out.println("\n\n------------------------------------");
		for (int i = 0; i < keyWords.length; i++) {
			WordSet wordSet = searchService.searchWord(keyWords[i]);
			System.out.print(wordSet.getWordKey() + "\t: ");
			System.out.println(wordSet.getWordValue());
			System.out.println("[��ó:��Ű�ǵ��(https://www.wikipedia.org/)]");
			System.out.println("------------------------------------");
		}
		System.out.println("\n\n");
		
		ctx.close();
		
	}
	
}