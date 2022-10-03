package selenium.webdriver.basics;

import org.apache.commons.codec.binary.Base64;

// Encode and decode password
public class EncodeDecodePassword {

	public static void main(String[] args) {
		
		String str="admin123";
		byte[] encoded=Base64.encodeBase64(str.getBytes());
		//System.out.println(encoded);
		System.out.println(new String(encoded));
		
		// decode
		
		byte[] decoded=Base64.decodeBase64(encoded);
		System.out.println(new String(decoded));
	}

}
