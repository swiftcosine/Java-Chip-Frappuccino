package crypto;

/*
 * Class: CMSC203 
 * Instructor: Prof. Tarek
 * Description: Implement a simple encryption and decryption system using Caesar and Bellaso ciphers in Java with a test suite to validate the functionality of these encryption methods against specified input cases and expected outputs.
 * Due: 10/15/2024
 * Platform/compiler: Eclipse IDE
	 * I pledge that I have completed the programming assignment independently. 
	 * I have not copied the code from a student or any source. 
	 * I have not given my code to any student.
 * Print your Name here: Ash Ibasan
 */

public class CryptoManager {

    private static final int LOWER_BOUND = 32;  // start of valid ASCII range (space character)
    private static final int UPPER_BOUND = 95;  // end of valid ASCII range ('_')
    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;  // total range of valid characters

    // This method checks if every character in the string is within allowed ASCII bounds.

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            
            // If we find a character that's out of the allowed range, or if it’s a number, we return false.
            if (ch < LOWER_BOUND || ch > UPPER_BOUND || Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

 // Caesar encryption shifts characters by a key. If out of range, wrap around.
    
    public static String caesarEncryption(String plainText, int key) {
        // input validation
        if (!isStringInBounds(plainText)) {
            return "Selected string is not in bounds. Please try again!";
        }

        StringBuilder encryptedText = new StringBuilder();

        // shift each character by the key
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            int newChar = ch + key;

            // wrap back within allowed range if beyond upper bound 
            if (newChar > UPPER_BOUND) {
                newChar = LOWER_BOUND + (newChar - UPPER_BOUND - 1);
            }

            encryptedText.append((char) newChar); // add new encrypted character to result
        }

        return encryptedText.toString(); // return final encrypted string
    }

    
  // Caesar decryption reverses Caesar encryption by shifting characters back by the key.
    
    public static String caesarDecryption(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();

        // reversing shift applied in encryption
        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            int newChar = ch - key;

            // wrap back around if below lower bound
            while (newChar < LOWER_BOUND) {
                newChar += RANGE;
            }
            decryptedText.append((char) newChar); // add decrypted character to result
        }

        return decryptedText.toString(); // return final decrypted string
    }

    
 // Bellaso encryption is where each character is shifted by the corresponding character in the key string.

    public static String bellasoEncryption(String plainText, String bellasoStr) {
        StringBuilder encryptedText = new StringBuilder();

        // check bounds of the plain text before proceeding
        if (!isStringInBounds(plainText)) {
            return "Selected string is not in bounds. Please try again!";
        }

        // repeat the key until same length as plain text
        String extendedKey = "";
        while (extendedKey.length() < plainText.length()) {
            extendedKey += bellasoStr;
        }
        extendedKey = extendedKey.substring(0, plainText.length());

        // encrypt by shifting characters based on corresponding key characters
        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char bellasoChar = extendedKey.charAt(i);
            int newChar = plainChar + bellasoChar;

            // wrap around if new character exceeds upper bound
            if (newChar > UPPER_BOUND) {
                newChar -= RANGE;
            }

            encryptedText.append((char) newChar); // add encrypted character to result
        }

        return encryptedText.toString(); // return final encrypted text
    }

    
 // Bellaso decryption reverses the Bellaso encryption using the same key.
    
    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();

        // repeat key to match the length of encrypted text
        String extendedKey = bellasoStr.repeat((encryptedText.length() / bellasoStr.length()) + 1)
                                          .substring(0, encryptedText.length());

        // decrypt by reversing the shifts
        for (int i = 0; i < encryptedText.length(); i++) {
            char encryptedChar = encryptedText.charAt(i);
            char keyChar = extendedKey.charAt(i);
            int newChar = encryptedChar - keyChar;

            // adjust for wrapping if new character falls below lower bound
            if (newChar < LOWER_BOUND) {
                newChar += RANGE;
            }

            decryptedText.append((char) newChar); // add decrypted character to result
        }

        return decryptedText.toString(); // return final decrypted plain text
    }
}
