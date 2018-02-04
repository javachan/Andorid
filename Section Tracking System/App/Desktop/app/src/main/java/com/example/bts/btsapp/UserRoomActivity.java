package com.example.bts.btsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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

/**
 * Created by Bulent on 14.12.2016.
 */

public class UserRoomActivity extends UserActivity {

    RequestQueue requestQueue;
    String showUrl= "http://yalinkavak.com//siniflar.php";   // veri tabanının bulundugu web sitesi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        //MainActivtyden gelen acilacak olan sayfayi belirleyen string ifade
        Bundle extras = getIntent().getExtras();
        String yeniacilacaksayfa = extras.getString("acilacak_sayfa");


        if(yeniacilacaksayfa.equals("siniflar"))
        //Sınıflar butonuna tıklanırsa çalışacak kod parcası
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    showUrl, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    //Json Kütüphanesinden verileri pars etme fonksiyonu
                    try {
                        JSONArray datas = response.getJSONArray("classes");
                        for (int i = 0; i < datas.length(); i++) {

                            JSONObject sinif = datas.getJSONObject(i);
                            //Veri tabanının tur adlı sütünundan gelen verinin kontrolüne göre işlem yapılan kısım
                            if(sinif.getString("tur").equals("sinif"))
                            {
                                final String gelensinifadi = sinif.getString("sinifadi");
                                final String gelensinifNo = sinif.getString("sinifno");
                                final Button myButton = new Button(getBaseContext());

                                myButton.setId(i);
                                myButton.setText(gelensinifadi);
                                myButton.setTextSize(25);
                                myButton.setBackgroundResource(R.drawable.button);

                                LinearLayout scroll = (LinearLayout)findViewById(R.id.scrollLayout);
                                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                scroll.addView(myButton, lp);

                                myButton.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        Intent intent = new Intent(UserRoomActivity.this,UploadActivity.class);
                                        intent.putExtra("acilacak_sayfa",gelensinifNo);
                                        startActivity(intent);
                                    }
                                });
                            }
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

        else if(yeniacilacaksayfa.equals("hocalar"))
        //Hocalar butonuna tıklanırsa çalışacak kod parcası
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    showUrl, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //Json Kütüphanesinden verileri pars etme fonksiyonu
                    try {
                        JSONArray lecturer = response.getJSONArray("classes");
                        for (int i = 0; i < lecturer.length(); i++) {

                            JSONObject hoca = lecturer.getJSONObject(i);
                            //Veri tabanının tur adlı sütünundan gelen verinin kontrolüne göre işlem yapılan kısım
                            if(hoca.getString("tur").equals("akademik"))
                            {
                                final String gelenhocaadi = hoca.getString("sinifadi");
                                final String gelensinifNo = hoca.getString("sinifno");
                                final Button myButton = new Button(getBaseContext());

                                myButton.setId(i);
                                myButton.setText(gelenhocaadi);
                                myButton.setTextSize(25);
                                myButton.setBackgroundResource(R.drawable.button);

                                LinearLayout scroll = (LinearLayout)findViewById(R.id.scrollLayout);
                                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                scroll.addView(myButton, lp);

                                myButton.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        Intent intent = new Intent(UserRoomActivity.this,UploadActivity.class);
                                        intent.putExtra("acilacak_sayfa",gelensinifNo);
                                        startActivity(intent);
                                    }
                                });
                            }
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

        else if(yeniacilacaksayfa.equals("labs"))
        //Laboratuvarlar butonuna tıklanırsa çalışacak kod parcası
        {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    showUrl, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    //Json Kütüphanesinden verileri pars etme fonksiyonu
                    try {
                        JSONArray datas = response.getJSONArray("classes");
                        for (int i = 0; i < datas.length(); i++) {
                            JSONObject lab = datas.getJSONObject(i);
                            //Veri tabanının tur adlı sütünundan gelen verinin kontrolüne göre işlem yapılan kısım
                            if(lab.getString("tur").equals("lab"))
                            {
                                final String gelenlab = lab.getString("sinifadi");
                                final String gelensinifNo = lab.getString("sinifno");

                                final Button myButton = new Button(getBaseContext());
                                myButton.setId(i);
                                myButton.setText(gelenlab);
                                myButton.setTextSize(25);
                                myButton.setBackgroundResource(R.drawable.button);

                                LinearLayout scroll = (LinearLayout)findViewById(R.id.scrollLayout);
                                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                scroll.addView(myButton, lp);

                                myButton.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View view) {
                                        Intent intent = new Intent(UserRoomActivity.this,UploadActivity.class);
                                        intent.putExtra("acilacak_sayfa",gelensinifNo);
                                        startActivity(intent);
                                    }
                                });
                            }
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
    }
}












