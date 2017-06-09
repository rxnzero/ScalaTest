package java8.examples;

import java.util.Base64;
import java.util.UUID;

public class Base64Example {

	public static void main(String[] args) throws Exception {
		// Basic Encode 
		String asB64 = Base64.getEncoder().encodeToString("some string".getBytes("euc-kr"));
		System.out.println(asB64); 

		// Basic Decode
		byte[] asBytes = Base64.getDecoder().decode(asB64);
		System.out.println(new String(asBytes, "euc-kr"));
		
		
		String basicEncoded = Base64.getEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
		System.out.println("Using Basic Alphabet: " + basicEncoded);
		
		// URL safe encoding
		String urlEncoded = Base64.getUrlEncoder().encodeToString("subjects?abcd".getBytes("utf-8"));
		System.out.println("Using URL Alphabet: " + urlEncoded);
		
		
		// MIME encoding
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 10; ++t) {
		 sb.append(UUID.randomUUID().toString());
		}

		byte[] toEncode = sb.toString().getBytes("utf-8");
		String mimeEncoded = Base64.getMimeEncoder().encodeToString(toEncode);
		System.out.println(mimeEncoded);
	}
}
