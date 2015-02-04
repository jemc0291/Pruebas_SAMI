package co.edu.sena.sami.jsf.controllers.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;


/**
 *
 * @author sami
 */
public class DigestUtil {
    private static final Logger logger = Logger.getLogger("DigestUtil");

    public static String generateDigest(String value)
        throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes("UTF-8"));

            byte[] byteData = md.digest();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);

                if (hex.length() == 1) {
                    sb.append('0');
                }

                sb.append(hex);
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            logger.warning("No such algorithm.");

            return null;
        } catch (UnsupportedEncodingException ex) {
            logger.warning("Usupported encoding.");

            return null;
        }
    }
}