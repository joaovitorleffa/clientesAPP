package com.example.clientesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.activity_update.FABUpdate
import kotlinx.android.synthetic.main.activity_update.edtFone
import kotlinx.android.synthetic.main.activity_update.edtIdade
import kotlinx.android.synthetic.main.activity_update.edtNome

class UpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val cliente = intent.getParcelableExtra<Cliente>("cliente")

        edtFone.setText(cliente.fone.toString())
        edtNome.setText( cliente.nome.toString())
        edtIdade.setText( cliente.idade.toString())
        editEmpresa.setText(cliente.empresa.toString())


        FABRemove.setOnClickListener {
            val clienteDao = ClienteDao(this)
            clienteDao.remove(cliente)
            onBackPressed()

        }

        FABUpdate.setOnClickListener {
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
                editEmpresa.text.toString().isEmpty() -> {
                    Toast.makeText(this, "Preencha o nome da empresa", Toast.LENGTH_LONG).show()
                }
                else -> {
                    var clienteUP = Cliente(cliente.id,edtNome.text.toString(),edtFone.text.toString(),(edtIdade.text.toString().toInt()), editEmpresa.text.toString())
                    var clienteDao = ClienteDao(this)
                    clienteDao.update(clienteUP)
                    onBackPressed()
                }
            }
        }

        FABBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


    }





}
