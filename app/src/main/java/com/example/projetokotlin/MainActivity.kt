package projetokotlin

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etSenha: EditText
    private lateinit var btnEntrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.etEmail)
        etSenha = findViewById(R.id.etSenha)
        btnEntrar = findViewById(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            realizarLogin()
        }
    }

    private fun realizarLogin() {
        val email = etEmail.text.toString().trim()
        val senha = etSenha.text.toString()

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, getString(R.string.preencha_campos), Toast.LENGTH_SHORT).show()
            return
        }

        if (validarCredenciais(email, senha)) {
            Toast.makeText(this, getString(R.string.login_sucesso), Toast.LENGTH_LONG).show()
            // Aqui você pode abrir outra Activity, por exemplo
        } else {
            Toast.makeText(this, getString(R.string.login_erro), Toast.LENGTH_SHORT).show()
        }
    }

    private fun validarCredenciais(email: String, senha: String): Boolean {
        val emailValido = "usuario@email.com"
        val senhaValida = "123456"
        return email == emailValido && senha == senhaValida
    }
}
