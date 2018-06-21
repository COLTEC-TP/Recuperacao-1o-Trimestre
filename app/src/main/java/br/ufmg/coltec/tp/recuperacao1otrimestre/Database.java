package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by a2015951487 on 21/06/18.
 */

public class Database extends SQLiteOpenHelper {
    private static String DB_NAME = "Database.sqlite";
    private static final int DB_VERSION = 1;
    private static final String SCRIPT_CREATE ="CREATE TABLE IF EXISTS produtos (nome TEXT, categoria TEXT, preco REAL);";

    //"id INTEGER PRIMARY KEY AUTOINCREMENT, " +
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insereProduto(Produto produto) {

        SQLiteDatabase db = getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put("nome", produto.getNome());
            values.put("categoria", produto.getCategoria());
            values.put("preco", produto.getPreco());
            db.insert("produtos", null, values);
        } catch(Exception e) {
        } finally {
            db.close();
        }
        db.close();

    }

    public ArrayList<Produto> obterProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();   // lista que será retornada como resposta
        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor c = db.query("produtos", null, null, null,
                    null, null, null);

            if(c.moveToFirst()) {
                do {
                    String nome = c.getString(c.getColumnIndex("nome"));
                    String categoria = c.getString(c.getColumnIndex("categoria"));
                    Double preco = Double.parseDouble(c.getString(c.getColumnIndex("preco")));


                    Produto produto = new Produto(nome, categoria, preco);

                    produtos.add(produto);
                } while(c.moveToNext());
            }
        } catch (Exception e) {
            // trata exceção
        } finally {
            db.close();
        }

        return produtos;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        // executado no momento em que o banco é criado pela primeira vez
        db.execSQL(SCRIPT_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
