package ch.geekomatic.sjks;

import static org.apache.commons.codec.binary.Hex.decodeHex;
import static org.apache.commons.codec.binary.Hex.encodeHex;
import static org.apache.commons.io.FileUtils.readFileToByteArray;
import static org.apache.commons.io.FileUtils.writeStringToFile;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;

public class KeyStoreUtils
{
    private static final String ALGO = "AES";
    private static final int KEYSZ = 256;// 128 default; 192 and 256 also possible
    
    public static SecretKey generateKey() throws NoSuchAlgorithmException
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGO);
        keyGenerator.init(KEYSZ); 
        SecretKey key = keyGenerator.generateKey();
        return key;
    }
    
    public static void saveKey(SecretKey key, File file) throws IOException
    {
        byte[] encoded = key.getEncoded();
        char[] hex = encodeHex(encoded);
        String data = String.valueOf(hex);
        writeStringToFile(file, data);
    }
    
    public static SecretKey loadKey(File file) throws IOException
    {
        String data = new String(readFileToByteArray(file));
        char[] hex = data.toCharArray();
        byte[] encoded;
        try
        {
            encoded = decodeHex(hex);
        }
        catch (DecoderException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
        SecretKey key = new SecretKeySpec(encoded, ALGO);
        return key;
    }
}
