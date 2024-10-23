package crypto;

import static org.junit.Assert.*;
import org.junit.Test;

public class CryptoManagerTestStudent {

    @Test
    public void testIsStringInBounds() {
        // Testing if string stays within allowed ASCII bounds
        assertTrue(CryptoManager.isStringInBounds("BANANA"));  // normal string, should pass
        assertTrue(CryptoManager.isStringInBounds("EXCALIBUR"));  // all characters valid, in range
        assertFalse(CryptoManager.isStringInBounds("GOODBYE123"));  // contains numbers; should fail
    }

    @Test
    public void testCaesarEncryption() {
        // Testing Caesar Cipher encryption
        assertEquals("EDQDQD", CryptoManager.caesarEncryption("BANANA", 3));  // simple shift by 3
        assertEquals("YTFXYJW", CryptoManager.caesarEncryption("TOASTER", 5));  // shift by 5, result should match
        assertEquals("\\UPJVYU", CryptoManager.caesarEncryption("UNICORN", 7));  // shift by 7 for UNICORN
        assertEquals("Selected string is not in bounds. Please try again!", CryptoManager.caesarEncryption("GOODBYE123", 4));  // out of bounds input; expect error message
        assertEquals("GZECNKDWT", CryptoManager.caesarEncryption("EXCALIBUR", 2));  // shift by 2 for EXCALIBUR; should work fine
    }

    @Test
    public void testCaesarDecryption() {
        // Testing Caesar Cipher decryption
        assertEquals("BANANA", CryptoManager.caesarDecryption("EDQDQD", 3));  // reversing the shift by 3
        assertEquals("TOASTER", CryptoManager.caesarDecryption("YTFXYJW", 5));  // reversing shift by 5
        assertEquals("UNICORN", CryptoManager.caesarDecryption("\\UPJVYU", 7));  // decrypting UNICORN with shift 7
        // Skipping GOODBYE123 because invalid input
        assertEquals("EXCALIBUR", CryptoManager.caesarDecryption("GZECNKDWT", 2));  // decrypting EXCALIBUR; should work with shift 2
    }

    @Test
    public void testBellasoEncryption() {
        // Testing Bellaso Cipher encryption
        assertEquals("CQ^MSB", CryptoManager.bellasoEncryption("BANANA", "APPLE"));  // encrypt with Bellaso using key APPLE
        assertEquals("aXMWaN^", CryptoManager.bellasoEncryption("TOASTER", "MILD"));  // encrypt TOASTER with MILD as key
        assertEquals("bOPLRS[", CryptoManager.bellasoEncryption("UNICORN", "MAGICA"));  // Bellaso encryption for UNICORN with key MAGICA
        assertEquals("Selected string is not in bounds. Please try again!", CryptoManager.bellasoEncryption("GOODBYE123", "FLIGHT"));  // out of bounds input; expect error
        assertEquals("QgQHNUCYW", CryptoManager.bellasoEncryption("EXCALIBUR", "LONGBLADE"));  // encrypt EXCALIBUR with LONGBLADE
    }

    @Test
    public void testBellasoDecryption() {
        // Testing Bellaso Cipher decryption
        assertEquals("BANANA", CryptoManager.bellasoDecryption("CQ^MSB", "APPLE"));  // decrypt BANANA using APPLE
        assertEquals("TOASTER", CryptoManager.bellasoDecryption("aXMWaN^", "MILD"));  // decrypt TOASTER using MILD
        assertEquals("UNICORN", CryptoManager.bellasoDecryption("bOPLRS[", "MAGICA"));  // decrypt UNICORN with MAGICA
        // skipping GOODBYE123 because invalid input
        assertEquals("EXCALIBUR", CryptoManager.bellasoDecryption("QgQHNUCYW", "LONGBLADE"));  // decrypt EXCALIBUR using LONGBLADE
    }
}
