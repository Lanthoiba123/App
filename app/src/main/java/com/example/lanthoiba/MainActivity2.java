package com.example.lanthoiba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity2 extends AppCompatActivity {
    private TextInputLayout Username,Contact,Email,Password,ConfirmPassword;
    private Button move;
    String username,email,contact,password,confirm;
    int flag=1;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Username=findViewById(R.id.user);
        Contact=findViewById(R.id.cont);
        Email=findViewById(R.id.mail);
        Password=findViewById(R.id.enter);
        ConfirmPassword=findViewById(R.id.word);
        move=findViewById(R.id.Signin);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        move.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                username=Username.getEditText().getText().toString().trim();
                contact=Contact.getEditText().getText().toString().trim();
                email=Email.getEditText().getText().toString().trim();
                password=Password.getEditText().getText().toString().trim();
                confirm=ConfirmPassword.getEditText().getText().toString().trim();

               if(username.isEmpty())
               {
                 Username.setError("Field can't be empty");

               }
               else
                {
                    if(username.isEmpty())
                    {
                        Username.setError("Field can't be empty");

                    }
                    else {
                        if (contact.length() < 10 && contact.length() > 10) {
                            Contact.setError("");
                        }
                        else
                        {
                            if(email.isEmpty())
                            {
                                Email.setError("Field can't be empty");
                            }
                            else
                            {
                                if(password.isEmpty())
                                {
                                    Password.setError("Field can't be empty");
                                }
                                else
                                {
                                    if(password.length()<8)
                                    {
                                        Password.setError("Password should be at least 8 character");
                                    }
                                    else
                                    {
                                        if(confirm.isEmpty())
                                        {
                                            ConfirmPassword.setError("Field cannot be empty");
                                        }
                                         else
                                        {
                                            flag=password.compareTo(confirm);
                                            if(flag!=0)
                                            {
                                                ConfirmPassword.setError("Passwords must be same");
                                            }
                                            else
                                            {
                                                progressDialog.setMessage("Please wait while Registration....");
                                                progressDialog.setTitle("Registration");
                                                progressDialog.setCanceledOnTouchOutside(false);
                                                progressDialog.show();

                                                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if(task.isSuccessful()){
                                                            progressDialog.dismiss();
                                                            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                                                            startActivity(intent);
                                                            Toast.makeText(MainActivity2.this, "Registration is succesfull", Toast.LENGTH_SHORT).show();
                                                        }
                                                        else{
                                                            progressDialog.dismiss();
                                                            Toast.makeText(MainActivity2.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                });

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

    }
    }