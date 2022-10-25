package com.example.lanthoiba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class Photo extends AppCompatActivity {
    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        edit=findViewById(R.id.photo);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Photo.this,MainActivity5.class);
                startActivity(intent);
                Toast.makeText(Photo.this, "Edit photo", Toast.LENGTH_SHORT).show();
            }
        });
        String text="hello";
        MaterialToolbar toolbar=findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout=findViewById(R.id.drawer);
        NavigationView navigationView=findViewById(R.id.navigation);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.share:
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT,"check this cool app");
                        intent.putExtra(Intent.EXTRA_TEXT,"Application link here:- https://www.youtube.com/watch?v=ovD8zJKkgZ4");
                        startActivity(Intent.createChooser(intent,"Share via"));
                        break;
                    case R.id.setting:
                        Toast.makeText(Photo.this, "Setting is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.home:
                        Toast.makeText(Photo.this, "Home is clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.message:
                            Intent message=new Intent(Intent.ACTION_VIEW);
                            message.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+919863059696"+ "&text="+ text));
                            startActivity(message);
                            Toast.makeText(Photo.this, "Message is clicked", Toast.LENGTH_SHORT).show();
                     break;
                    case R.id.sync:
                        Toast.makeText(Photo.this, "Sync is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.trash:
                        Toast.makeText(Photo.this, "Trash is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(Photo.this, "Log out is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.account:
                        Toast.makeText(Photo.this, "Account is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.help:
                        Toast.makeText(Photo.this, "Help is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.feedback:
                        Intent intent1 =new Intent(Intent.ACTION_SENDTO);
                        String Uritext ="mailto:"+ Uri.encode("konthoujamlanthoiba@gmail.com")+"?subject="+
                                Uri.encode("Feedback ");
                        Uri uri=Uri.parse(Uritext);
                        intent1.setData(uri);
                        startActivity(Intent.createChooser(intent1,"send email"));
                        Toast.makeText(Photo.this, "Feedback is clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rate:
                        Toast.makeText(Photo.this, "Rate us is clicked", Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        return true;
                }
                return true;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.share:
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"check this cool app");
                intent.putExtra(Intent.EXTRA_TEXT,"Application link here:- https://www.youtube.com/watch?v=ovD8zJKkgZ4");
                startActivity(Intent.createChooser(intent,"Share via"));
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