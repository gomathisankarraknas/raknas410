
import java.util.Random;
class Otp
{
		int ran()
		{
         Random rand = new Random();
        int rand_int2 = rand.nextInt(9999);
        
        return rand_int2;
		}
}