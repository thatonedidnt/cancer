public class MediumAsteroid extends Asteroid {
	int pointVal=20;

	public MediumAsteroid()
	{
		super();
		this.generator();
		this.doQuestion();
		   
	}

	public void generator()
	{
		for (int i = 0; i < MAX_NUM; i++)
		{
			int ran = (int) (Math.random() * MEDIUM_DIGITS + 1);
			numbers[i] = ran;
		}
	}
	public int getPoints(){
		return pointVal;
	}
}
