package com.word.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {

	
	@Autowired
	@Qualifier("usedDao")
	// �� �� �����ϱ�... java.inject ����ٰ� ��� ���� ���� �� 
	private WordDao wordDao;

	// �����ڿ��� autowired�� �� �ְ�
	// �� ���� property���� �־� �� ���� �ְ�
	// �޼��忡�� �־� �� �� ���� (DI ���� ���̸� ����)
	// �ٵ� property�� �޼��忡 ���� ���� �⺻ ������ �ݵ�� ����� ��� 
	public WordRegisterService() {
		// �갡 �����Ǿ�� wordDao property�� ����� �� �ְ�...
	}
	
	// ���� ���� Autowired�� ����... 
	// �׷� �����Ϸ��� �� �� �� wordDao �� ã�ڳ� -> ����
	// ���� �����ڸ� �����ϰ� property�� �޼��忡 autowired�� �� ���� �� �⺻ ������!!
	//
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	// �ߺ� �ܾ� ��� x
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}