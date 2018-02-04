package com.example.bts.btsapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bts.btsapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CumaGunu extends Fragment {

    RequestQueue requestQueue;
    // veri tabanının ve php dosyalarının bulundugu web sitesi
    String showUrl= "http://yalinkavak.com//siniflargun.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Sayfa geçişi yapıldığında açılacak layout
        View v = inflater.inflate(R.layout.pazartesi, container, false);
        //Hangi günün açık olduğunu gösteren başlık
        TextView gunlerinBasligi = (TextView) v.findViewById(R.id.birincifrag);
        gunlerinBasligi.setText(getArguments().getString("baslık"));
        final String sinifadi = gunlerinBasligi.getText().toString();
        gunlerinBasligi.setText("Cuma");
        //Bir gün içindeki saatleri gösteren TextViewler
        final TextView b8_9 = (TextView) v.findViewById(R.id.b8_9);
        final TextView b9_10 = (TextView) v.findViewById(R.id.b9_10);
        final TextView b10_11 = (TextView) v.findViewById(R.id.b10_11);
        final TextView b11_12 = (TextView) v.findViewById(R.id.b11_12);
        final TextView b13_14 = (TextView) v.findViewById(R.id.b13_14);
        final TextView b14_15 = (TextView) v.findViewById(R.id.b14_15);
        final TextView b15_16 = (TextView) v.findViewById(R.id.b15_16);
        final TextView b16_17 = (TextView) v.findViewById(R.id.b16_17);
        final TextView i17_18 = (TextView) v.findViewById(R.id.i17_18);
        final TextView i18_19 = (TextView) v.findViewById(R.id.i18_19);
        final TextView i19_20 = (TextView) v.findViewById(R.id.i19_20);
        final TextView i20_21 = (TextView) v.findViewById(R.id.i20_21);
        final TextView i21_22 = (TextView) v.findViewById(R.id.i21_22);
        final TextView i22_23 = (TextView) v.findViewById(R.id.i22_23);

        requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                showUrl, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //Json Kütüphanesinden verileri pars etme fonksiyonu
                try {
                    JSONArray datas = response.getJSONArray("sinifg");
                    for (int i = 0; i < datas.length(); i++) {

                        JSONObject room = datas.getJSONObject(i);
                        //Ekrana getirelecek gunu ve sinifadini kontrol eden kısım
                        if(room.getString("gun").equals("Cuma") && room.getString("sinifadi").equals(sinifadi))
                        {//Gelen Gun ve sinif için verilerin text viewlere yazıldığı  yer
                            b8_9.setText(room.getString("gun1"));
                            b9_10.setText(room.getString("gun2"));
                            b10_11.setText(room.getString("gun3"));
                            b11_12.setText(room.getString("gun4"));
                            b13_14.setText(room.getString("gun5"));
                            b14_15.setText(room.getString("gun6"));
                            b15_16.setText(room.getString("gun7"));
                            b16_17.setText(room.getString("gun8"));
                            i17_18.setText(room.getString("gun9"));
                            i18_19.setText(room.getString("gun10"));
                            i19_20.setText(room.getString("gun11"));
                            i20_21.setText(room.getString("gun12"));
                            i21_22.setText(room.getString("gun13"));
                            i22_23.setText(room.getString("gun14"));
                            break;
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
        return v;
    }

    public static CumaGunu newInstance(String text) {
        //Burada oluşturduğumuz constructor sayesinde mainfragmentten aldığımız isimler başlığa setlenir.
        CumaGunu fragmentismi2 = new CumaGunu();
        Bundle b = new Bundle();
        b.putString("baslık", text);

        fragmentismi2.setArguments(b);

        return fragmentismi2;
    }
}

