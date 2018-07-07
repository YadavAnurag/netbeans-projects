package BillingSystem;
import java.security.SecureRandom;

public class PasswordGenerator {
    public static String generatePass(int num){
        SecureRandom random = new SecureRandom();
        int count = num,c =0;
        String p ="";
        while(count>0){
            while(true){
                c = random.nextInt(126);
                if((c>47 && c<58) || (c>64 && c<91) || (c>96 && c<123)){
                    break;
                }
            }
            p += String.valueOf(Character.toChars(c));
            count--;
        }
        return p;
    }
}
