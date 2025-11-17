package com.example.menu1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void cargarBoton(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this::onMenuItemClick);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.show();
    }


    public boolean onMenuItemClick(MenuItem item) {
        Intent i;
        int itemid = item.getItemId();
        if (itemid == R.id.itemGatos) {
            i = new Intent("android.intent.action.VIEW", Uri.parse("https://www.marca.com"));
            startActivity(i);
        }
        if (itemid == R.id.itemPerros) {
            i = new Intent("android.intent.action.VIEW", Uri.parse("https://www.as.com"));
            startActivity(i);
        }
        return true;
    }
}






