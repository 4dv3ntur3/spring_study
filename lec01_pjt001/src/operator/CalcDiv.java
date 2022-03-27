package operator;

public class CalcDiv implements Calculator {

	@Override
	public int sum(int firstNum, int secondNum) {
		// TODO Auto-generated method stub
		return secondNum != 0? (firstNum/secondNum): 0;
	}

}
