package com.codefish.sandbox;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

/**
 * Created by haniabdallah on 7/4/16.
 */
public class SharedPreferencesHelper {


    private final String FINGER_PRINT_TOKEN_KEY = "FingerPrintTokenKey";
    private final String ENCRYPTION_IV = "EncryptionIV";


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public void setEditor(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public SharedPreferencesHelper(Context ctx){
        setContext(ctx);
        setSharedPreferences(getContext().getSharedPreferences("ImobilePrefs", Context.MODE_PRIVATE));
        setEditor(getSharedPreferences().edit());

    }


    public void setThirdPartyAppId(String value){

        getEditor().putString("", value);
        getEditor().commit();

    }
    public String getThirdPartyAppId(){

        return getSharedPreferences().getString("","");
    }


    public void setFingerprintToken(byte[] value){

        getEditor().putString(FINGER_PRINT_TOKEN_KEY, Base64.encodeToString(value, Base64.DEFAULT));
        getEditor().commit();

    }
    public byte[] getFingerprintToken(){

        return Base64.decode(getSharedPreferences().getString(FINGER_PRINT_TOKEN_KEY,""), Base64.DEFAULT);
    }


    public void setEncryptionIV(byte[] value){

        getEditor().putString(ENCRYPTION_IV, Base64.encodeToString(value, Base64.DEFAULT));
        getEditor().commit();

    }
    public byte[] getEncryptionIV(){

        return Base64.decode(getSharedPreferences().getString(ENCRYPTION_IV,""), Base64.DEFAULT);
    }




}
