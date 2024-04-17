package com.example.armazemproject.dados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Criação da tabela
        String CREATE_TABLE_PRODUTO = "CREATE TABLE produto (" +
                "codigo TEXT PRIMARY KEY," +
                "nome TEXT," +
                "descricao TEXT," +
                "precoUnitario REAL," +
                "categoria TEXT," +
                "qtdUnidades REAL" + ")";
        db.execSQL(CREATE_TABLE_PRODUTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualização do banco de dados
        db.execSQL("DROP TABLE IF EXISTS produto");
        onCreate(db);
    }
}
