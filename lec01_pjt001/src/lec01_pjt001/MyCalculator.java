package lec01_pjt001;

import operator.Calculator;

public class MyCalculator {
	
	public int fNum, sNum;
	public Calculator calculator;
	
	public MyCalculator(int fNum, int sNum, Calculator calculator) {
		this.fNum = fNum;
		this.sNum = sNum;
		this.calculator = calculator;
	}
	
	public void result() {
		int value = calculator.sum(this.fNum, this.sNum);
		System.out.println("result: " + value);
		
	}
	

	public int getfNum() {
		return fNum;
	}

	public void setfNum(int fNum) {
		this.fNum = fNum;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calc) {
		this.calculator = calc;
	}
	
	

}
