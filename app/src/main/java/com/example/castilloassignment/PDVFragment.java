package com.example.castilloassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.castilloassignment.adapter.PDVAdapter;
import com.example.castilloassignment.pojo.PDV;
import com.example.castilloassignment.presenter.IPDVFragmentPresenter;
import com.example.castilloassignment.presenter.PDVFragmentPresenter;
import com.example.castilloassignment.view_fragment.IPDVFragmentView;

import java.util.ArrayList;

public class PDVFragment extends Fragment implements IPDVFragmentView {

    private RecyclerView recyclerView;
    private IPDVFragmentPresenter iPDVFragmentPresenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.pdv_fragment, container, false);
        getActivity().setTitle(R.string.punto_venta);

        recyclerView = root.findViewById(R.id.rvPdvs);

        iPDVFragmentPresenter = new PDVFragmentPresenter(this, getContext());


        return root;
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public PDVAdapter createAdapter(ArrayList<PDV> pdvs) {
        PDVAdapter pdvAdapter = new PDVAdapter(pdvs, getActivity());
        return pdvAdapter;

    }

    @Override
    public void inicializarAdapter(PDVAdapter pdvAdapter) {

        recyclerView.setAdapter(pdvAdapter);
    }
}
