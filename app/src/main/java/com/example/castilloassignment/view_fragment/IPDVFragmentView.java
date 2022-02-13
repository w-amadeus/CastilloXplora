package com.example.castilloassignment.view_fragment;

import com.example.castilloassignment.adapter.PDVAdapter;
import com.example.castilloassignment.pojo.PDV;

import java.util.ArrayList;

public interface IPDVFragmentView {

    public void generarLinearLayoutVertical();

    public PDVAdapter createAdapter(ArrayList<PDV> pdvs);

    public void inicializarAdapter(PDVAdapter pdvAdapter);

}
