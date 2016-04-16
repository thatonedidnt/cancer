public class MediumAsteroid extends Asteroid {
    
    public MediumAsteroid()
    {
   	 super();
   	 this.generator();
    }

    public void generator()
    {
   	 for (int i = 0; i < MAX_NUM; i++)
   	 {
   		 int ran = (int) (Math.random() * MEDIUM_DIGITS + 1);
   		 numbers[i] = ran;
   	 }
    }
}
