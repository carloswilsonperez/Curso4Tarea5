package com.example.administrador.curso4_tarea5.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.administrador.curso4_tarea5.R;
import com.example.administrador.curso4_tarea5.adapter.PageAdapter;
import com.example.administrador.curso4_tarea5.vista_fragment.HomeFragment;
import com.example.administrador.curso4_tarea5.vista_fragment.PerfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Verifica la si la versión del SO soporta las transiciones
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //***** Transició de entrada ****
            Transition transitionEnter = TransitionInflater.from(this)
                    .inflateTransition(R.transition.transition_enter);
            getWindow().setEnterTransition(transitionEnter);
            //**** Transición de retorno *******
            Transition transitionReturn = TransitionInflater.from(this)
                    .inflateTransition(R.transition.transition_return);
            getWindow().setReturnTransition(transitionReturn);
            //*****  Transición de reentrada  *****
            Transition transitionReenter = TransitionInflater.from(this)
                    .inflateTransition(R.transition.transition_reenter);
            getWindow().setReenterTransition(transitionReenter);
        }
        setContentView(R.layout.activity_main);

        toolbar     = (Toolbar)findViewById(R.id.miActionbar);
        tabLayout   = (TabLayout)findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Oculta el titulo del ToolBar
        }

        ImageView imgFavotitas = (ImageView)findViewById(R.id.imgFaboritas);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.mContacto:
                Intent intent1 = new Intent(this, FormularioActivity.class);
                //Verifica si esta corriendo en una version igual o mayor a lollipop
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Transition exitTransition = TransitionInflater.from(this).
                            inflateTransition(R.transition.transition_exit);
                    getWindow().setExitTransition(exitTransition);
                    startActivity(intent1,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                }else {
                    startActivity(intent1);
                }
                break;

            case R.id.mAcercaDe:
                Intent intent2 = new Intent(this, AcercadeActivity.class);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Transition exitTransition = TransitionInflater.from(this).
                            inflateTransition(R.transition.transition_exit);
                    getWindow().setExitTransition(exitTransition);
                    startActivity(intent2,
                            ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
                }else {
                    startActivity(intent2);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    // Abre el activity_favotiras con las 5 mascotas favoritas
    public void irFavoritas(View view){
        Intent intent = new Intent(this, MasVotatosActivityView.class);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Transition exitTransition = TransitionInflater.from(this).
                    inflateTransition(R.transition.transition_exit);
            getWindow().setExitTransition(exitTransition);
            startActivity(intent,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        }else {
            startActivity(intent);
        }
    }

    // Método para cargar el ArrayList con los fragments existentes
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        // Cargo los fragments en el órden que los quiero mostrar
        fragments.add(new HomeFragment());
        fragments.add(new PerfilFragment());
        return  fragments;
    }

    // Método para poner en orvita los fragments
    private void setUpViewPager(){
        // Se inicializa el viewPager con una instancia de la clase PageAdapter, se le pasa el manejador de fragments y
        // por último se llama a la funcion agregarFragments que devuelve el ArrayList con los fragments.
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perro);
    }


}
