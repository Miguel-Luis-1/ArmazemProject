package com.example.armazemproject.dados;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.example.armazemproject.dados.Produto;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProdutoSharedPreferences {
    private static final String PREFS_NAME = "com.example.armazemproject.PRODUCTS";
    private static final String PRODUCTS_KEY = "PRODUCTS";

    private SharedPreferences sharedPreferences;
    private Gson gson;

    public ProdutoSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveProducts(List<Produto> produtos) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String json = gson.toJson(produtos);
        editor.putString(PRODUCTS_KEY, json);
        editor.apply();
    }

    public List<Produto> loadProducts() {
        String json = sharedPreferences.getString(PRODUCTS_KEY, null);
        Type type = new TypeToken<ArrayList<Produto>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
