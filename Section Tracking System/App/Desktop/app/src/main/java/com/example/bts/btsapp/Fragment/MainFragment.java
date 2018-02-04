package com.example.bts.btsapp.Fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.bts.btsapp.R;

public class MainFragment extends FragmentActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_frag);
        //Sayfa geçişi için gereken yardımcılar
        ViewPager sayfaGecisi = (ViewPager) findViewById(R.id.viewPager);
        sayfaGecisi.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }
    //Sayfa geçişinin yapıldığı sınıf
    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int pos) {

            Bundle extras = getIntent().getExtras();
            String yeniAcilacakSayfa = extras.getString("acilacak_sayfa");

            switch(pos) {

                case 0: return PazartesiGunu.newInstance(yeniAcilacakSayfa);
                case 1: return SaliGunu.newInstance(yeniAcilacakSayfa);
                case 2: return CarsambaGunu.newInstance(yeniAcilacakSayfa);
                case 3: return PersembeGunu.newInstance(yeniAcilacakSayfa);
                case 4: return CumaGunu.newInstance(yeniAcilacakSayfa);
                default: return PazartesiGunu.newInstance(yeniAcilacakSayfa);
            }
        }
        //Kullandığımız fragment sayısı kadar dönüş yapıyoruz
        @Override
        public int getCount() {
            return 5;
        }
    }
}