package com.example.fragemnts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragment_inicial fragmentInicial = new fragment_inicial();
        transaction.add(R.id.LinearLayoutContenedorDeFragments, fragmentInicial);
        transaction.commit();
    }

    public void seleccionarFragmento(View v) {
        Fragment miFragmento;
        int aux=0;
        if (v == findViewById(R.id.btnFragmentInicial)) {
            miFragmento = new fragment_inicial();
            aux=1;
        } else if (v == findViewById(R.id.btnFragmentSegundo)) {
            miFragmento = new fragment_segundo();
            aux=1;
        } else if (v == findViewById(R.id.btnFragmentTercero)) {
            miFragmento = new fragment_tercero();
            aux=2;
        } else {
            miFragmento = new fragment_inicial();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (aux==1){
            transaction.replace(R.id.LinearLayoutContenedorDeFragments, miFragmento);
        }else{
            transaction.replace(R.id.LinearLayoutContenedorDeFragments2, miFragmento);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}