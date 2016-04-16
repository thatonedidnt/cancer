public class HardAsteroid extends Asteroid {
	int pointVal=30;

    
    public HardAsteroid()
    {
   	 super();
   	 this.generator();
   	 this.doQuestion();
    }

    public void generator()
    {
   	 for (int i = 0; i < MAX_NUM; i++)
   	 {
   		 int ran = (int) (Math.random() * HARD_DIGITS + 1);
   		 numbers[i] = ran;
   	 }
    }
    public int getPoints(){
    	return pointVal;
    }
}