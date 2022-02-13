package com.example.castilloassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.castilloassignment.adapter.ListAdapter;
import com.example.castilloassignment.db.ConstructorProductos;
import com.example.castilloassignment.pojo.Producto;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView rvLista;
    ListAdapter listAdapter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        rvLista = findViewById(R.id.rvLista);
        
        setRecycleView();

    }

    private void setRecycleView() {

        rvLista.setHasFixedSize(true);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter(getList(), this);
        rvLista.setAdapter(listAdapter);

    }

    private ArrayList<Producto> getList() {
        ArrayList<Producto> productos = new ArrayList<>();

        Intent intent = getIntent();

        id = intent.getIntExtra("id", 0);

        ConstructorProductos constructorProductos = new ConstructorProductos(this);
        productos = constructorProductos.obtenerDataProductos(id);

        return productos;
    }
}