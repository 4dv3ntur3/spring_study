package lec01_pjt001;

import operator.CalcAdd;
import operator.CalcDiv;
import operator.CalcMul;
import operator.CalcSub;

public class MainClass {
	
	public static void main(String args[]) {
		MyCalculator calc;
		
		// 각각 덧셈 뺄쎔 곱셈 나눗셈
		// calculator라는 인터페이스 type으로 객체를 만들어 주고 있음
		// 이게 container=IoC의 개념
		// main class라는 큰 틀, 그 안에 mycalculator
		// mycalculator 안에 다른 객체 (calculator) 넣어 줌
		// 따라서 mycalculator가 하나의 컨테이너라고 볼 수 있다
		// 내가 필요한 객체들을 외부에 만들어 놓고
		// 그 외부에서 mycalculator에 주입한 것임 
		// 들어오는 calculator 객체에 따라서 사칙연산 -> result 결과 달라짐
		// 지금 여기서는 new라는 키워드로 따로 만들어서 넣어 주지만
		// srping 컨테이너를 따로 만들어 놓고 그 안에 xml 파일로 객체를 생성해서
		// 서로 join, 주입 등을 하게 된다 
		calc = new MyCalculator(10, 5, new CalcAdd());
		calc.result();
		
		calc = new MyCalculator(10, 5, new CalcSub());
		calc.result();
		
		calc = new MyCalculator(10, 5, new CalcMul());
		calc.result();
		
		calc = new MyCalculator(10, 5, new CalcDiv());
		calc.result();
	}
}
