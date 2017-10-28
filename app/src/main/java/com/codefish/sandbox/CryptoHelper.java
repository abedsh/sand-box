package com.codefish.sandbox;

import android.annotation.TargetApi;
import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

/**
 * Created by abedch on 9/21/2017.
 */
@TargetApi(23)
public class CryptoHelper {


    public static final String KEY_1 = "Key1";

    public void createKey() {
        final KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(KEY_1,
                KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .build();
    }

    public void processEncryption(Context ctx,String textToEncrypt) throws Exception
    {
        createKey();

        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(ctx);
        Encryptor encryptor = new Encryptor();
        sharedPreferencesHelper.setFingerprintToken(encryptor.encryptText(KEY_1, textToEncrypt));
        sharedPreferencesHelper.setEncryptionIV(encryptor.getIv());

    }


    public String processDecryption(Context ctx) throws Exception
    {
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(ctx);

        Decryptor decryptor = new Decryptor();

        byte[] encryptedValue = sharedPreferencesHelper.getFingerprintToken();
        String value = decryptor.decryptData(KEY_1, encryptedValue, sharedPreferencesHelper.getEncryptionIV());

        return value;
    }






}
