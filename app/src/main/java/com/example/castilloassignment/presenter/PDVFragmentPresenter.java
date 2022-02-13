package com.example.castilloassignment.presenter;

import android.content.Context;

import com.example.castilloassignment.db.ConstructorPDVs;
import com.example.castilloassignment.pojo.PDV;
import com.example.castilloassignment.view_fragment.IPDVFragmentView;

import java.util.ArrayList;

public class PDVFragmentPresenter implements IPDVFragmentPresenter {

    private IPDVFragmentView IPDVFragmentView;
    private Context context;
    private ConstructorPDVs constructorPDVs;
    private ArrayList<PDV> pdvs;


    public PDVFragmentPresenter(IPDVFragmentView IPDVFragmentView, Context context) {
        this.IPDVFragmentView = IPDVFragmentView;
        this.context = context;
        obtenerPDVs();
    }

    @Override
    public void obtenerPDVs() {

        constructorPDVs = new ConstructorPDVs(context);
        pdvs = constructorPDVs.obtenerData();

        mostrarPDVs();

    }

    @Override
    public void mostrarPDVs() {

        IPDVFragmentView.inicializarAdapter(IPDVFragmentView.createAdapter(pdvs));
        IPDVFragmentView.generarLinearLayoutVertical();

    }
}
