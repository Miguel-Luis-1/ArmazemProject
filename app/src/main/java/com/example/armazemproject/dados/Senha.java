package com.example.armazemproject.dados;
import android.content.Context;
import android.content.SharedPreferences;

public class Senha {

    private static final String PREFS_NAME = "com.example.armazemproject";
    private static final String PREFS_KEY = "senha";

    private String senha;

    public Senha(){
        this.senha = senha;
    }

    public void addSenha(Context context, String senha){
        this.senha = senha;
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PREFS_KEY, senha);
        editor.commit();
    }

    public String getSenha(Context context) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        this.senha = settings.getString(PREFS_KEY, null);
        return this.senha;
    }
}

