package Codes;

public class OTP_Cipher {
    String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String alphaL = "abcdefghijklmnopqrstuvwxyz";
    
    //Encrypt the plain text and return the cipher text
    public String encryption(String plaintext, String key) {
        int len = plaintext.length();

        String ciphertext = "";
        for (int x = 0; x < len; x++) {
            char get_pt = plaintext.charAt(x);
            char keyget = key.charAt(x);
            //to check if the character is upper/lower case
            if (Character.isUpperCase(get_pt)) {
                int index = alphaU.indexOf(get_pt);
                int keydex = alphaU.indexOf(Character.toUpperCase(keyget));

                int total = (index + keydex) % 26;
                
                //append the character in ciphertext
                ciphertext = ciphertext + alphaU.charAt(total);
            } 
            else if (Character.isLowerCase(get_pt)) {
                int index = alphaL.indexOf(get_pt);
                int keydex = alphaU.indexOf(Character.toLowerCase(keyget));

                int total = (index + keydex) % 26;
                
                //append the character in ciphertext
                ciphertext = ciphertext + alphaL.charAt(total);
            } 
            else {
                //in case of any character than letters
                ciphertext = ciphertext + get_pt;
            }
        }

        return ciphertext;
    }
    
    
    //Decrypt the cipher text and return the plain text
    public String decryption(String ciphertext, String key) {
        int len = ciphertext.length();

        String plainText = "";
        for (int x = 0; x < len; x++) {
            char get_ct = ciphertext.charAt(x);
            char keyget = key.charAt(x);
            //to check if the character is upper/lower case
            if (Character.isUpperCase(get_ct)) {
                int index = alphaU.indexOf(get_ct);
                int keydex = alphaU.indexOf(Character.toUpperCase(keyget));

                int total = (index - keydex) % 26;
                
                //if the total of calculation less than 0
                total = (total < 0) ? total + 26 : total;
                
                //append the character in plaintext
                plainText = plainText + alphaU.charAt(total);
            } 
            else if (Character.isLowerCase(get_ct)) {
                int index = alphaL.indexOf(get_ct);
                int keydex = alphaU.indexOf(Character.toLowerCase(keyget));

                int total = (index - keydex) % 26;
                
                //if the total of calculation less than 0
                total = (total < 0) ? total + 26 : total;
                
                //append the character in plaintext
                plainText = plainText + alphaL.charAt(total);
            } 
            else {
                //in case of any character than letters
                plainText = plainText + get_ct;
            }
        }

        return plainText;
    }
    
}
