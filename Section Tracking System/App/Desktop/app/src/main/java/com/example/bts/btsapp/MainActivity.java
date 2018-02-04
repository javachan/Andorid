package com.example.bts.btsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    //Hangi sayfanın açılacağını belirleyen string ifade
    String acilacaksayfa = "";
    //1 kere login olunduysa aynı sayfanın tekrar açıklamaması için oluşturulan string ifade
    public static String login="NULL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Action Bar Saklama fonksiyonu
        getSupportActionBar().hide();


        Button loginbuton = (Button) findViewById(R.id.loginbutton);
        //Login butonuna basınca açılacak sayfa
        loginbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(login.equals("NULL"))
                {
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button siniflarbuton = (Button) findViewById(R.id.classbutton);
        //Sınıflar butonuna basınca açılacak sayfa
        siniflarbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RoomClass.class);

                acilacaksayfa = "siniflar";
                intent.putExtra("acilacak_sayfa",acilacaksayfa);

                startActivity(intent);
            }
        });

        Button hocalarbuton = (Button) findViewById(R.id.teacherbutton);
        //Akademik Personel butonuna basınca açılacak sayfa
        hocalarbuton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoomClass.class);

                acilacaksayfa = "hocalar";
                intent.putExtra("acilacak_sayfa", acilacaksayfa);

                startActivity(intent);
            }





        });

        Button labbuton = (Button) findViewById(R.id.labbuton);
        //Laboratuvar butonuna basınca açılacak sayfa
        labbuton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RoomClass.class);

                acilacaksayfa = "labs";
                intent.putExtra("acilacak_sayfa", acilacaksayfa);

                startActivity(intent);
            }
        });
    }
}