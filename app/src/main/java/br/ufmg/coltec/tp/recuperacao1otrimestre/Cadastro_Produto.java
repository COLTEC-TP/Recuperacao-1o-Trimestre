package br.ufmg.coltec.tp.recuperacao1otrimestre;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cadastro_Produto extends Activity {


    private static int FOTO_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro__produto);


        //Cadastro de Produto

        Button Btn_Cadastra = findViewById(R.id.Btn_enviaDados);

        Btn_Cadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = findViewById(R.id.nome_Produto);
                EditText valor = findViewById(R.id.valor_Produto);
                EditText categoria = findViewById(R.id.categoria_Produto);

                String nomeTxt = nome.getText().toString();
                String categoriaTxt = categoria.getText().toString();

                Double valorTxt = 0.0;

                if(!valor.getText().toString().equals(""))
                    valorTxt =  Double.valueOf(valor.getText().toString());

                //Adiciona ao banco de dados

                ProdutoDAO dao = ProdutoDAO.getInstance();
                dao.adicionarProduto(new Produto(nomeTxt, categoriaTxt, valorTxt));

                //Armazenamento da Foto

                salvaFoto(nomeTxt);

                finish();
            }


        });

    }

    private void salvaFoto(String nome) {
        final ImageView foto = findViewById(R.id.foto);
        final String filename = nome+".png";
        final File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_DCIM), filename);  // /storage/0/android/data/package/files/dcim/foto.png


        if(((BitmapDrawable)foto.getDrawable())!=null){

            Bitmap bm=((BitmapDrawable)foto.getDrawable()).getBitmap(); //Extrair foto do imageview

            FileOutputStream out = null;
            try {

                out = new FileOutputStream(file);
                bm.compress(Bitmap.CompressFormat.PNG, 100, out);
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    //Parte lógica da foto tirada do produto na tela de cadastro
    //através do click no espaço da foto

    public void FotoTirada(View view) {
        Intent fotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(fotoIntent, FOTO_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView imageView = findViewById(R.id.foto);


        if (requestCode == FOTO_CODE && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

}
