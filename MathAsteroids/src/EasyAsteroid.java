
public class EasyAsteroid extends Asteroid {

    
    public EasyAsteroid()
    {
   	 super();
   	 this.generator();
    }
    
    public void generator()
    {
   	 for (int i = 0; i < MAX_NUM; i++)
   	 {
   		 int ran = (int) (Math.random() * EASY_DIGITS + 1);
   		 numbers[i] = ran;
   	 }
    }
    
}