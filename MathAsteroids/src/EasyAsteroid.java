
public class EasyAsteroid extends Asteroid {
int pointVal=10;
    public EasyAsteroid()
    {
   	 super();
   	 this.generator();
   	this.doQuestion();
    
    }
    
    public void generator()
    {
   	 for (int i = 0; i < MAX_NUM; i++)
   	 {
   		 int ran = (int) (Math.random() * EASY_DIGITS + 1);
   		 numbers[i] = ran;
   	 }
    }
    public int getPoints(){
    	return pointVal;
    }
}