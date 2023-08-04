package com.curvelo.bancodados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            val bancoDados = openOrCreateDatabase("DB_FORNECEDORES", MODE_PRIVATE,null)

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS fornecedores(id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR, telefone INT(15))")
           // bancoDados.execSQL("INSERT INTO fornecedores(nome,telefone) VALUES('MasterBoi',37214563)")
              //bancoDados.execSQL("INSERT INTO fornecedores(nome,telefone) VALUES('Mercadinho',37225489)")



            //Atualizar registro
          //  bancoDados.execSQL("UPDATE fornecedores SET telefone = 333333333 WHERE nome = 'Mercadinho'")
            // Remover tabela

           // bancoDados.execSQL("DROP TABLE fornecedores ")

            //Remover Registro

            bancoDados.execSQL("DELETE FROM fornecedores WHERE id = 1 ")

            val consultar = "SELECT id,nome, telefone FROM fornecedores"



            val cursor = bancoDados.rawQuery(consultar,null)

            val indceId = cursor.getColumnIndex("id")
            val indceNome = cursor.getColumnIndex("nome")
            val indceTelefone = cursor.getColumnIndex("telefone")
            cursor.moveToFirst()
            while (cursor!= null){

                val nome = cursor.getString(indceNome)
                val telefone = cursor.getString(indceTelefone)
                val id = cursor.getString(indceId)
                Log.i("RESULTADO - id", "$id /nome:$nome/ telefone: $telefone")
                cursor.moveToNext()

            }

        }catch(e:Exception){
            e.printStackTrace()

        }
    }
}