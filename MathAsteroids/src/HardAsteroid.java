public class HardAsteroid extends Asteroid {

    
    public HardAsteroid()
    {
   	 super();
   	 this.generator();
    }

    public void generator()
    {
   	 for (int i = 0; i < MAX_NUM; i++)
   	 {
   		 int ran = (int) (Math.random() * HARD_DIGITS + 1);
   		 numbers[i] = ran;
   	 }
    }
    
}