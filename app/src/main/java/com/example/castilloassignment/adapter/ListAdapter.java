package com.example.castilloassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.castilloassignment.R;
import com.example.castilloassignment.pojo.Producto;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    ArrayList<Producto> productos;
    Context context;

    public ListAdapter(ArrayList<Producto> productos, Context context) {
        this.productos = productos;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_products, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Producto producto = productos.get(position);

        holder.tvProducto.setText(producto.getNombre());
        holder.edtCosto.setText(String.valueOf(producto.getCosto()));
        holder.edtRuta.setText(String.valueOf(producto.getRuta_mayor()));
        holder.edtStock.setText(String.valueOf(producto.getStock()));


    }

    @Override
    public int getItemCount() {
        return productos.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView tvProducto;
        private EditText edtCosto;
        private EditText edtRuta;
        private EditText edtStock;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProducto = itemView.findViewById(R.id.tvProducto);
            edtCosto = itemView.findViewById(R.id.edtCosto);
            edtRuta = itemView.findViewById(R.id.edtRuta);
            edtStock = itemView.findViewById(R.id.edtStock);
        }
    }
}
