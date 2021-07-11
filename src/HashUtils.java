import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

// Hash utility class
    public static String sha256Hash(String input){
        String hex;
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(input.getBytes(StandardCharsets.UTF_8));
            byte[]digest = md.digest();
            hex = String.format("%02x", new BigInteger(1,digest));

        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
        return hex;
    }

}
