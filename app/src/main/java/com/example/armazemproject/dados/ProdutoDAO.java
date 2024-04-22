package com.example.armazemproject.dados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final SQLiteDatabase db;

    public ProdutoDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public void inserir(Produto produto) {
        ContentValues values = new ContentValues();
        values.put("codigo", produto.getCodigo());
        values.put("nome", produto.getNome());
        values.put("descricao", produto.getDescricao());
        values.put("precoUnitario", produto.getPrecoUnitario());
        values.put("categoria", produto.getCategoria());
        values.put("qtdUnidades", produto.getQuantidadeUnidades());

        db.insert("produto", null, values);
    }

    public List<Produto> listarTodos() {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = db.query("produto", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String codigo = cursor.getString(cursor.getColumnIndex("codigo"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String descricao = cursor.getString(cursor.getColumnIndex("descricao"));
            double precoUnitario = cursor.getDouble(cursor.getColumnIndex("precoUnitario"));
            String categoria = cursor.getString(cursor.getColumnIndex("categoria"));
            double qtdUnidades = cursor.getDouble(cursor.getColumnIndex("qtdUnidades"));

            Produto produto = new Produto(codigo, nome, descricao, precoUnitario, categoria, qtdUnidades);
            produtos.add(produto);
        }

        cursor.close();
        return produtos;
    }
    public void deletar(Produto produto) {
        String whereClause = "codigo = ?";
        String[] whereArgs = { produto.getCodigo() };
        db.delete("produto", whereClause, whereArgs);
    }

    public void limparTodos() {
        db.delete("produto", null, null);
    }


}




