package com.example.bts.btsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bulent on 14.12.2016.
 */

public class UploadActivity extends UserRoomActivity{

    String insertUrl = "http://yalinkavak.com//update.php";

    String gun=""; //Degisecek Gunu tutan değişken



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);


        Bundle extras = getIntent().getExtras();
        final String gelenSinif = extras.getString("acilacak_sayfa");


        //Degisecek verinin yazıldığı edittext
        final EditText degisecekVeri = (EditText)findViewById(R.id.degisecekVeri);
        //Hangi saatin değişecegini belirten butonlar
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button) findViewById(R.id.b2);
        Button b3 = (Button) findViewById(R.id.b3);
        Button b4 = (Button) findViewById(R.id.b4);
        Button b5 = (Button) findViewById(R.id.b5);
        Button b6 = (Button) findViewById(R.id.b6);
        Button b7 = (Button) findViewById(R.id.b7);
        Button b8 = (Button) findViewById(R.id.b8);
        Button b9 = (Button) findViewById(R.id.b9);
        Button b10 = (Button) findViewById(R.id.b10);
        Button b11 = (Button) findViewById(R.id.b11);
        Button b12 = (Button) findViewById(R.id.b12);
        Button b13 = (Button) findViewById(R.id.b13);
        Button b14 = (Button) findViewById(R.id.b14);
        //Hangi günün değişecegini belirten butonlar
        Button bpazartesi = (Button) findViewById(R.id.bpazartesi);
        Button bsali = (Button) findViewById(R.id.bsali);
        Button bcarsamba = (Button) findViewById(R.id.bcarsamba);
        Button bpersembe = (Button) findViewById(R.id.bpersembe);
        Button bcuma = (Button) findViewById(R.id.bcuma);

        bpazartesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gun = "Pazartesi";
                Toast.makeText(getApplicationContext(),gun +" gunu Secildi",Toast.LENGTH_SHORT).show();
            }
        });

        bsali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gun = "Sali";
                Toast.makeText(getApplicationContext(),gun +" gunu Secildi",Toast.LENGTH_SHORT).show();
            }
        });

        bcarsamba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gun = "Carsamba";
                Toast.makeText(getApplicationContext(),gun +" gunu Secildi",Toast.LENGTH_SHORT).show();
            }
        });

        bpersembe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gun = "Persembe";
                Toast.makeText(getApplicationContext(),gun +" gunu Secildi",Toast.LENGTH_SHORT).show();
            }
        });

        bcuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gun = "Cuma";
                Toast.makeText(getApplicationContext(),gun +" gunu Secildi",Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        //bu kısımda butonlara tıklandıkca verileri servere yolluyor
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","1");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","2");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","3");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","4");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","5");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","6");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","7");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","8");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","9");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","10");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","11");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","12");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","13");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!gun.equals(""))
                {

                    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            System.out.println(response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();

                            parameters.put("degiseceksutun","14");
                            parameters.put("yazilacakmetin",degisecekVeri.getText().toString());
                            parameters.put("degisecekgun",gun.toString());
                            parameters.put("degiseceksinifno",gelenSinif);


                            return parameters;
                        }
                    };
                    requestQueue.add(request);
                    Toast.makeText(getApplicationContext(),"Guncelleme yapıldı",Toast.LENGTH_SHORT).show();



                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Lütfen bi gün seçiniz!!",Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
