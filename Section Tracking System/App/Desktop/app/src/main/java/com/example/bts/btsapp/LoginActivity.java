package com.example.bts.btsapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class LoginActivity extends MainActivity{

    //Layoutdaki materiallerin tanımlamaları
    EditText userName,password;
    Button loginButonu;
    String giris ="Basarisiz";
    RequestQueue requestQueue;
    // veri tabanının ve php kodlarının bulundugu web sitesi
    String showUrl= "http://yalinkavak.com//login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Adreslerinin atandığı kısım
        userName = (EditText) findViewById(R.id.IDtext);
        password = (EditText) findViewById(R.id.passtext);
        loginButonu = (Button) findViewById(R.id.girisbutton);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        loginButonu.setOnClickListener(new View.OnClickListener() {
            //login butonuna basınca yapılacaklar
            @Override
            public void onClick(View view) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        showUrl, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Json Kütüphanesinden verileri pars etme fonksiyonu
                        try {
                            JSONArray users = response.getJSONArray("users");
                            for (int i = 0; i < users.length(); i++) {
                                JSONObject user = users.getJSONObject(i);

                                String gelenUserName = user.getString("username");
                                String gelenPassword = user.getString("password");

                                if(gelenUserName.equals(userName.getText().toString())  && gelenPassword.equals(password.getText().toString())     )
                                {//Girilen Kullanici adı ve şifre veritabanında var iste yeni açılacak olan sayfa
                                    Intent intent = new Intent(LoginActivity.this,UserActivity.class);
                                    giris = "Basarili";
                                    MainActivity.login="Success";
                                    startActivity(intent);
                                    finish();


                                }
                            }
                            if(giris.equals("Basarisiz"))
                            {
                                Toast.makeText(getApplicationContext(), "Kullanici adi veya şifreniz yanlış.Lütfen tekrar deneyiniz!", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}