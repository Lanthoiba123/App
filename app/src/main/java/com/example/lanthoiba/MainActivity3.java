package com.example.lanthoiba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.toolbarmenu,menu);
            return super.onCreateOptionsMenu(menu);
        }
        @Override
        public boolean onOptionsItemSelected(@NonNull  MenuItem item) {

            switch (item.getItemId()){
                case R.id.share:
                    Intent intent= new Intent(Intent.ACTION_SEND);
                    intent.setType("Text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Check out this cool Application");
                    intent.putExtra(Intent.EXTRA_TEXT,"Your Application Link here");
                    startActivity(Intent.createChooser(intent,"share via"));
                    Toast.makeText(getApplicationContext(),"Share",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.about:
                    Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.exit:
                    Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.search:

                    Toast.makeText(getApplicationContext(),"Search",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.setting:
                    Toast.makeText(getApplicationContext(),"Setting",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

}