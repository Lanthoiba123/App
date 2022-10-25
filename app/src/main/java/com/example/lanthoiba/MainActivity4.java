package com.example.lanthoiba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity4 extends AppCompatActivity {
    private Button move;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        move = findViewById(R.id.reset);
        EditText email=findViewById(R.id.pass);
        fAuth=FirebaseAuth.getInstance();
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                   if(task.isSuccessful()) {
                       Toast.makeText(MainActivity4.this, "Password send to your email", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(MainActivity4.this, MainActivity.class);
                       startActivity(intent);
                   }
                   else{
                       Toast.makeText(MainActivity4.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                   }
                    }
                });

            }
        });
    }
}