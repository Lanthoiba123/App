package com.example.lanthoiba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private Button check;
    private Button log;
    private Button pass;
    TextInputLayout inputEmail,inputPassword;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEmail=findViewById(R.id.Username);
        inputPassword=findViewById(R.id.checkbox);
        check=findViewById(R.id.button);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performlogin();
            }
        });
        log=findViewById(R.id.signup);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        pass=findViewById(R.id.forgot);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityf();
            }
        });
    }

    private void performlogin() {
        String email=inputEmail.getEditText().getText().toString().trim();
        String password =inputPassword.getEditText().getText().toString().trim();
        if(email.isEmpty()){
            inputEmail.setError("Please Enter email");
        }else if(password.isEmpty()){
            Toast.makeText(this, "Please enter the password ", Toast.LENGTH_SHORT).show();
        }else{
            progressDialog.setMessage("Please Wait While Login");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        openActivity();
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    } else{
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void openActivityf(){
        Intent intent=new Intent(MainActivity.this,MainActivity4.class);
        startActivity(intent);
    }
    public void openActivity(){
        Intent intent= new Intent(MainActivity.this,Photo.class);
        startActivity(intent);
    }
}