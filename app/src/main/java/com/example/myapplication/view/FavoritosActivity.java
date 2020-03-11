package com.example.myapplication.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;

public class FavoritosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(FavoritosActivity.this, SelecaoJogo.class));
        finishAffinity();
    }
}
