package com.example.bts.btsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bts.btsapp.Fragment.MainFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Bulent on 14.12.2016.
 */

public class UserActivity extends LoginActivity{

    String acilacakSayfa="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);




        Button sinif = (Button) findViewById(R.id.sinif);
        //Login butonuna basınca açılacak sayfa
        sinif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this,UserRoomActivity.class);

                acilacakSayfa = "siniflar";
                intent.putExtra("acilacak_sayfa",acilacakSayfa);

                startActivity(intent);
            }
        });

        Button hocalarbuton = (Button) findViewById(R.id.hoca);
        //Akademik Personel butonuna basınca açılacak sayfa
        hocalarbuton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, UserRoomActivity.class);

                acilacakSayfa = "hocalar";
                intent.putExtra("acilacak_sayfa", acilacakSayfa);

                startActivity(intent);
            }





        });

        Button labbuton = (Button) findViewById(R.id.lab);
        //Laboratuvar butonuna basınca açılacak sayfa
        labbuton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, UserRoomActivity.class);

                acilacakSayfa = "labs";
                intent.putExtra("acilacak_sayfa", acilacakSayfa);

                startActivity(intent);
            }





        });
    }
}
