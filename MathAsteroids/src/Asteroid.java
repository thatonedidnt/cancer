
public class Asteroid {
	protected final int MAX_NUM = 4;
	protected final int ADD = 0;
	protected final int SUB = 1;
	protected final int MULT = 2;
	protected final int DIV = 3;

	protected final int EASY_DIGITS = 9;
	protected final int MEDIUM_DIGITS = 99;
	protected final int HARD_DIGITS = 999;

	public int answer;
	public int pointVal;//lol

		
	public int[] numbers = new int[MAX_NUM];
	public int operations;

	public Asteroid()
	{
		this.operationGenerator();

	}
	public void operationGenerator()
	{
		int ran = (int) (Math.random() * 2);
		operations = ran;
	}

	public String stringOperation()
	{
		if (operations == 0)
			return "+";
		else if (operations == 1)
			return "-";
		else
			return "ERROR";
	}
	public void doQuestion()
	{
		int num1 = numbers[0];
		int num2 = numbers[1];

		if (operations == ADD)
			answer = (num1 + num2);
		else if (operations == SUB)
			answer =  (num1 - num2);
	}
	public int getAnswer()
	{
		return answer;
	}
	public boolean checkAnswer(int userAnswer)
	{
		if (userAnswer == answer)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return "" + numbers[0] + " " + this.stringOperation()
				+ " " + numbers[1];
	}
}
