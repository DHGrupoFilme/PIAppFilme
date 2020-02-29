package com.example.myapplication.view;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.example.myapplication.R;

public class FiltroActivity extends AppCompatActivity {
    private CheckBox check50;
    private CheckBox check60;
    private CheckBox check70;
    private CheckBox check80;
    private CheckBox check90;
    private CheckBox check00;
    private CheckBox check10;
    private CheckBox checkAcao;
    private CheckBox checkFantasia;
    private CheckBox checkTerror;
    private CheckBox checkSuspense;
    private CheckBox checkDrama;
    private CheckBox checkRomance;
    private CheckBox checkFiccao;
    private Button botaoFiltro;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);
        initViews();

       botaoFiltro = findViewById(R.id.botaoFiltro);
               botaoFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SelecaoJogo.class));
            }
        });
    }

    public void initViews(){
        check00 = findViewById(R.id.check00);
        check10 = findViewById(R.id.check10);
        check90 = findViewById(R.id.check90);
        check80 = findViewById(R.id.check80);
        check70 = findViewById(R.id.check70);
        check60 = findViewById(R.id.check60);
        check50 = findViewById(R.id.check50);
        checkAcao = findViewById(R.id.checkAcao);
        checkFantasia = findViewById(R.id.checkFantasia);
        checkTerror = findViewById(R.id.checkTerror);
        checkSuspense = findViewById(R.id.checkSuspense);
        checkRomance = findViewById(R.id.checkRomance);
        checkDrama = findViewById(R.id.checkDrama);
        checkFiccao = findViewById(R.id.checkFiccao);
    }
}
