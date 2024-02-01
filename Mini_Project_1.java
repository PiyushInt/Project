//Piyush kumar 

//MINOR PROJECT

package Mini_Projects;

import java.util.Scanner;

public class Mini_Project_1 {
	    private static int key1;
	    private static int key2;
	    private static int mod = 26;
	   
	    public static void main(String[]Args){
	      System.out.print("\nOUTPUT :-\n\n");
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter plaintext : ");
	        String input_string = sc.nextLine();
	        String plaintext = input_string;
	        System.out.print("Enter multiplicative key (k1) : ");
	        key1 = sc.nextInt();
	        System.out.print("Enter additive key (k2) : ");
	        key2 = sc.nextInt();
	        sc.close();
	        
	      
	        String ciphertext = encrypt(plaintext);
	        String decrypted = decrypt(ciphertext);
	        System.out.println("\nEncsryption ...");
	        System.out.println("\n-> Ciphertext: " + ciphertext);
	        System.out.println("\nDecryption ...");
	        System.out.println("\n-> Decrypted text: " + decrypted);

	    }
	    

	    public static String encrypt(String plaintext) {
	 
	        char[]ciphertext = new char[plaintext.length()];
	       
	        for (int i = 0; i < plaintext.length(); i++) {
	          char character_check = plaintext.charAt(i); 
	          if (Character.isUpperCase(character_check)){
	            int k3 = plaintext.charAt(i) - 'A'; 
	            int encrypted = (k3 * key1 +key2) % mod; 
	            ciphertext[i] = (char)(encrypted + 'A');

	          } else {
	            int k3 = plaintext.charAt(i) - 'a';
	            int encrypted = (k3 * key1 +key2) % mod; 
	            ciphertext[i] = (char)(encrypted + 'a');
	          }
	        }
	        return new String(ciphertext);
	      }

	   
	    public static String decrypt(String ciphertext) {
	        
	        char[] plaintext = new char[ciphertext.length()];
	       
	        int k1_inverse = 0; 
	        for (int i = 0; i < mod; i++) {
	          if ((key1 * i) % mod == 1) {
	            k1_inverse = i;
	            break;
	          }
	        }
	       
	        for (int i = 0; i < ciphertext.length(); i++) {
	          char character_check = ciphertext.charAt(i); 
	          if (Character.isUpperCase(character_check)){
	            int k3 = ciphertext.charAt(i) - 'A'; 
	            int decrypted = ((k3 - key2 + mod)* k1_inverse) % mod; 
	            plaintext[i] = (char)(decrypted + 'A');

	          } else {
	            int k3 = ciphertext.charAt(i) - 'a';
	            int decrypted = ((k3 - key2 + mod)* k1_inverse) % mod; 
	            plaintext[i] = (char)(decrypted + 'a');
	          }
	        }
	        return new String(plaintext);
	   }
}
