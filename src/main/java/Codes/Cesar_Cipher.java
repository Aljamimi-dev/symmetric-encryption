
package Codes;

public class Cesar_Cipher {
    
    public String encryption(String plaintext,  int shiftKey){
        String ciphertext = "";
        char ch;
        boolean upper;
        
        for(int i =0; i<plaintext.length(); ++i){
            ch = plaintext.charAt(i);
            //to check if the character is a letter or not
            if(ch >= 97 && ch <= 122 || ch >= 65 && ch <= 90){
                ch = (char)(ch + shiftKey);
                //if the character is upper case
                upper = ch >= 65 + shiftKey && ch <= 90 + shiftKey;
                
                if(ch > 122){
                    ch = (char)(((ch-97)%26)+97);
                }
                else if(ch > 90 && upper){
                    ch = (char)(((ch-65)%26)+65);
                }
                ciphertext += ch;
            }
            else{
                ciphertext += ch;
            }
        }
        return ciphertext;
    }
    
    public String decryption(String cipherText,  int shiftKey){
        String plaintext = "";
        char ch;
        shiftKey = 0 - shiftKey;
        boolean lower;
        for(int i=0; i<cipherText.length(); ++i){
            ch = cipherText.charAt(i);
            //to check if the character is a letter or not
            if(ch >= 97 && ch <= 122 || ch >= 65 && ch <= 90){
                ch = (char)(ch + shiftKey);
                //if the character is lower case
                lower = ch >= 97 + shiftKey && ch <= 122 + shiftKey;
                
                if(ch < 97 && lower){
                    ch = (char)(ch + 26);
                }
                else if(ch < 65){
                    ch = (char)(ch+26);
                }
                plaintext += ch;
            }
            else{
                plaintext += ch;
            }
        }
        return plaintext;
    }
    
    
}
