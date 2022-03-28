package com.word.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {

	
	@Autowired
	@Qualifier("usedDao")
	// 고를 때 조심하기... java.inject 골랐다가 계속 에러 났네 ㅠ 
	private WordDao wordDao;

	// 생성자에도 autowired할 수 있고
	// 저 위에 property에도 넣어 줄 수도 있고
	// 메서드에도 넣어 줄 수 있음 (DI 들어가는 곳이면 어디든)
	// 근데 property나 메서드에 붙일 때는 기본 생성자 반드시 명시해 줘야 
	public WordRegisterService() {
		// 얘가 생성되어야 wordDao property도 끌어올 수 있고...
	}
	
	// 여기 지금 Autowired가 없음... 
	// 그럼 생성하려고 할 때 이 wordDao 못 찾겠네 -> 에러
	// 따라서 생성자를 제외하고 property나 메서드에 autowired를 걸 때는 꼭 기본 생성자!!
	//
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	// 중복 단어 등록 x
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