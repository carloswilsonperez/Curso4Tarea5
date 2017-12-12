package com.example.administrador.curso4_tarea5.presentador;

import android.content.Context;
import com.example.administrador.curso4_tarea5.Activity.IMasVotatosActivityView;
import com.example.administrador.curso4_tarea5.bd.ConstructorMascotas;
import com.example.administrador.curso4_tarea5.pojo.Mascota;
import java.util.ArrayList;

/**
 * Created by administrador on 27/05/17.
 */

public class Activity2Presenter implements IActivity2Presenter {

    private IMasVotatosActivityView iMasVotatosActivityView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public Activity2Presenter(IMasVotatosActivityView iMasVotatosActivityView, Context context) {
        this.iMasVotatosActivityView = iMasVotatosActivityView;
        this.context = context;
        obtener5MascotasBaseDatos();
    }

    @Override
    public void obtener5MascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtener5Datos(); //***** Aquí es donde se juntan los datos con la presentación ******
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        // Hay que inicializar el adaptador, para ello primero se debe crear el adaptador y pasarele el ArrayList contactos
        iMasVotatosActivityView.inicializarAdaptadorRV(iMasVotatosActivityView.crearAdaptador(mascotas));
        // Luego se debe indicar que genere el LinearLayoutVertical
        iMasVotatosActivityView.generarLinearLayoutVertical();
    }


}
