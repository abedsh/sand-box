package com.codefish.sandbox;

import java.security.KeyStore;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/**
 * Created by abedch on 9/20/2017.
 */

public class Decryptor {

    private static final String TRANSFORMATION = "AES/GCM/NoPadding";
    private static final String ANDROID_KEY_STORE = "AndroidKeyStore";

    private KeyStore keyStore;

    Decryptor() throws Exception {
        initKeyStore();
    }

    private void initKeyStore() throws Exception {
        keyStore = KeyStore.getInstance(ANDROID_KEY_STORE);
        keyStore.load(null);
    }

    String decryptData(final String alias, final byte[] encryptedData, final byte[] encryptionIv)
            throws Exception {




        final Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        final GCMParameterSpec spec = new GCMParameterSpec(128, encryptionIv);
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(alias), spec);

        return new String(cipher.doFinal(encryptedData), "UTF-8");
    }

    private SecretKey getSecretKey(final String alias) throws Exception {
        return ((KeyStore.SecretKeyEntry) keyStore.getEntry(alias, null)).getSecretKey();
    }
}
