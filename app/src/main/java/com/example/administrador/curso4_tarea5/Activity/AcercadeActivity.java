package com.example.administrador.curso4_tarea5.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;

import com.example.administrador.curso4_tarea5.R;

public class AcercadeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //***** Transició de entrada de abajo hacia arriba****
            Transition enterSlide = new Slide(Gravity.RIGHT);
            enterSlide.setDuration(500);
            getWindow().setEnterTransition(enterSlide);
            // **** Transición de salida de abajo hacia arriba *********
            getWindow().setExitTransition(enterSlide);
            //**** Transición de retorno *******
            getWindow().setReturnTransition(enterSlide);
            //*****  Transición de reentrada  *****
            getWindow().setReenterTransition(enterSlide);
        }

        setContentView(R.layout.activity_acercade);
        toolbar = (Toolbar) findViewById(R.id.miActionbar);
        if (toolbar!=null){
            setSupportActionBar(toolbar);
            //    getSupportActionBar().setDisplayShowTitleEnabled(false); // Oculta el titulo del ToolBar
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);   // boton para atras
        }
    }

    // Abre el activity_favotiras con las 5 mascotas favoritas
    public void irFavoritas(View view) {
        Intent intent = new Intent(this, MasVotatosActivityView.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition exitTransition = TransitionInflater.from(this).
                    inflateTransition(R.transition.transition_exit);
            getWindow().setExitTransition(exitTransition);
            startActivity(intent,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        } else {
            startActivity(intent);
        }
    }

}
