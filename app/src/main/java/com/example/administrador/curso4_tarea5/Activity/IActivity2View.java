package com.example.administrador.curso4_tarea5.Activity;

import com.example.administrador.curso4_tarea5.adapter.MascotaAdaptador;
import com.example.administrador.curso4_tarea5.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by administrador on 27/05/17.
 */

public interface IActivity2View {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
