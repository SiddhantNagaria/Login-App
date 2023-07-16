package com.example.myauthenticationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.Group
import androidx.databinding.DataBindingUtil
import com.example.myauthenticationapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() , View.OnClickListener{
    val binding by lazy { DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.forgetPasswordtext="Forget Password?"

        binding.btnLogin.setOnClickListener(this)
        binding.signUp.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v == binding.btnLogin){
            binding.groupSignup.visibility=View.INVISIBLE

            validateCredentials()
        }
        else if(v == binding.signUp){
            navigatetosignupscreen()
        }

    }
    private fun validateCredentials(){
        val usernameEditText = findViewById<EditText>(R.id.edittext_username)
        val passwordEditText = findViewById<EditText>(R.id.edittext_password)

        if(usernameEditText.text.toString().isEmpty() || passwordEditText.text.toString().isEmpty()){
            Toast.makeText(this, R.string.field_empty,Toast.LENGTH_SHORT).show()
        }
        else if(usernameEditText.text.toString() == "admin" && passwordEditText.text.toString() == "admin"){
            Toast.makeText(this, R.string.msg_Login_Successful,Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,R.string.err_invalid_credentials ,Toast.LENGTH_SHORT).show()
        }
    }
    private fun navigatetosignupscreen(){
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
    }
}
