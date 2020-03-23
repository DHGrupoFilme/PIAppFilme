package com.example.myapplication.view;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.os.Build.VERSION_CODES.P;

public class FiltroActivity extends AppCompatActivity implements Serializable {
    private List<String> listaCheck;
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
               botaoFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testCheckBox();
                Intent intent =  new Intent(getApplicationContext(), SelecaoJogo.class);
                intent.putExtra("check", (Serializable) listaCheck);
                startActivity(intent);
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
        botaoFiltro = findViewById(R.id.botaoFiltro);
    }

    public List<String> testCheckBox(){
        listaCheck = new ArrayList<>();
        if (check00.isChecked())
            listaCheck.add("00");
        if (check10.isChecked())
            listaCheck.add("10");
        if (check90.isChecked())
            listaCheck.add("90");
        if (check80.isChecked())
            listaCheck.add("80");
        if (check70.isChecked())
            listaCheck.add("70");
        if (check60.isChecked())
            listaCheck.add("60");
        if (check50.isChecked())
            listaCheck.add("50");
        if (checkAcao.isChecked())
            listaCheck.add("acao");
        if (checkFantasia.isChecked())
            listaCheck.add("fantasia");
        if (checkTerror.isChecked())
            listaCheck.add("terror");
        if (checkSuspense.isChecked())
            listaCheck.add("suspense");
        if (checkRomance.isChecked())
            listaCheck.add("romance");
        if (checkDrama.isChecked())
            listaCheck.add("drama");
        if (checkFiccao.isChecked())
            listaCheck.add("ficcao");
        return listaCheck;
        }

}

