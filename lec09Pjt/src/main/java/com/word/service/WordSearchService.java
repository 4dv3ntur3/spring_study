package com.word.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchService {
	
	
	@Autowired
	@Qualifier("usedDao")
	private WordDao wordDao;
	
	// 단, 생성자에 autowired를 쓸 때는 이렇게 씀
	// 근데 메서드에 쓰고 싶다 (setter, getter) -> default 생성자 명시해야
	// 객체가 생성돼야 property에서 wordDao를 끌어올 수 있고 넣을 수 있다
	
	public WordSearchService() {
		
	}
	

	public WordSearchService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}