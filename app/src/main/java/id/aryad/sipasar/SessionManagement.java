package id.aryad.sipasar;

import android.content.Context;
import android.content.SharedPreferences;

import id.aryad.sipasar.models.AdminModel;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHAREPREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHAREPREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(AdminModel adminModels){
        int id = adminModels.getId_pegawai();
        editor.putInt(SESSION_KEY, id).commit();
    }

    public int getSession(){
        return sharedPreferences.getInt(SESSION_KEY, -1);
    }

    public void removeSession(){
        editor.putInt(SESSION_KEY, -1).commit();
    }
}
