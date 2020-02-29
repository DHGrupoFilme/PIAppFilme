package com.example.myapplication.view;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.example.myapplication.R;

public abstract class Menu extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
    }
    protected abstract int getLayoutResourceId();

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_favoritos:
                startActivity(new Intent(Menu.this, FavoritosActivity.class));
                finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
