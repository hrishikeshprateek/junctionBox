package com.aigs.junctionbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    ImageButton login;
    EditText userId, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.buttonLogin);
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userId.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(Login.this, "Userid and password cannot be empty !", Toast.LENGTH_SHORT).show();
                }else if (password.getText().toString().length() < 6){
                    Toast.makeText(Login.this, "Password length should be more then 6", Toast.LENGTH_SHORT).show();
                }else {
                    //FIREBASE LOGIC FOR LOGIN
                   AlertDialog alertDialog =  new AlertDialog.Builder(Login.this)
                            .setMessage("Logging you in")
                                    .setCancelable(false)
                                            .create();
                   alertDialog.show();
                    FirebaseAuth
                            .getInstance()
                            .signInWithEmailAndPassword(userId.getText().toString(),password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        alertDialog.dismiss();
                                        Toast.makeText(Login.this, "Welcome "+task.getResult().getUser().getEmail(), Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Login.this,MainActivity.class));
                                        finish();
                                    }else{
                                        Toast.makeText(Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        alertDialog.dismiss();
                                    }
                                }
                            });
                }
            }
        });

    }
}