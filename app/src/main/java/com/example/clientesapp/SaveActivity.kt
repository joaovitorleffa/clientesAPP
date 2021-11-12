package com.example.clientesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_save.FABBack
import kotlinx.android.synthetic.main.activity_save.FABSave
import kotlinx.android.synthetic.main.activity_save.edtEmpresa
import kotlinx.android.synthetic.main.activity_save.edtFone
import kotlinx.android.synthetic.main.activity_save.edtIdade
import kotlinx.android.synthetic.main.activity_save.edtNome
import kotlinx.android.synthetic.main.activity_update.*

class SaveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)


        FABBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


        FABSave.setOnClickListener(View.OnClickListener {
            when {
                edtNome.text.toString().isEmpty() -> {
                    Toast.makeText(this, "Preencha o nome", Toast.LENGTH_LONG).show()
                    print("teste")
                }
                edtFone.text.toString().isEmpty() -> {
                    Toast.makeText(this, "Preencha a idade", Toast.LENGTH_LONG).show()
                }
                edtFone.text.toString().length < 11 -> {
                    Toast.makeText(this, "Preencha um número de telefone válido", Toast.LENGTH_LONG).show()
                }
                edtIdade.text.toString().isEmpty() -> {
                    Toast.makeText(this, "Preencha a idade", Toast.LENGTH_LONG).show()
                }
                edtIdade.text.toString().toInt() < 12 -> {
                    Toast.makeText(this, "A idade deve ser maior que 12", Toast.LENGTH_LONG).show()
                }
                edtEmpresa.text.toString().isEmpty() -> {
                    Toast.makeText(this, "Preencha o nome da empresa", Toast.LENGTH_LONG).show()
                }
                else -> {
                    var cliente = Cliente(null,edtNome.text.toString(),edtFone.text.toString(),(edtIdade.text.toString().toInt()), edtEmpresa.text.toString())
                    var clienteDao = ClienteDao(this)
                    clienteDao.insert(cliente)
                    onBackPressed()
                }
            }
        })
    }


}
