package lec01_pjt001;

import operator.CalcAdd;
import operator.CalcDiv;
import operator.CalcMul;
import operator.CalcSub;

public class MainClass {
	
	public static void main(String args[]) {
		MyCalculator calc;
		
		// ���� ���� ���� ���� ������
		// calculator��� �������̽� type���� ��ü�� ����� �ְ� ����
		// �̰� container=IoC�� ����
		// main class��� ū Ʋ, �� �ȿ� mycalculator
		// mycalculator �ȿ� �ٸ� ��ü (calculator) �־� ��
		// ���� mycalculator�� �ϳ��� �����̳ʶ�� �� �� �ִ�
		// ���� �ʿ��� ��ü���� �ܺο� ����� ����
		// �� �ܺο��� mycalculator�� ������ ���� 
		// ������ calculator ��ü�� ���� ��Ģ���� -> result ��� �޶���
		// ���� ���⼭�� new��� Ű����� ���� ���� �־� ������
		// srping �����̳ʸ� ���� ����� ���� �� �ȿ� xml ���Ϸ� ��ü�� �����ؼ�
		// ���� join, ���� ���� �ϰ� �ȴ� 
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
