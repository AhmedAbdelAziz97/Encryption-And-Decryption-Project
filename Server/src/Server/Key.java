
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Key {
    public SecretKey key() throws NoSuchAlgorithmException{

    KeyGenerator generator=KeyGenerator.getInstance("AES");
    generator.init(128);
    SecretKey Key=generator.generateKey();
            MessageDigest m=MessageDigest.getInstance("SHA-256");
        m.update((Key.toString()).getBytes());
        String hashed=new String(m.digest());
        return null;
    }
}
