package com.example.castilloassignment.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.castilloassignment.MapsActivity;
import com.example.castilloassignment.PDVActivity;
import com.example.castilloassignment.R;
import com.example.castilloassignment.pojo.PDV;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class PDVAdapter extends RecyclerView.Adapter<PDVAdapter.PDVViewHolder> {

    ArrayList<PDV> pdvs;
    Activity activity;
    private String name;
    private double latitude;
    private double longitude;
    private String location;
    private int logo;
    private int id;

    public PDVAdapter(ArrayList<PDV> pdvs, Activity activity) {
        this.pdvs = pdvs;
        this.activity = activity;
    }


    @Override
    public PDVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card_view,parent,false);
        return new PDVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PDVViewHolder holder, int position) {

        PDV pdv = pdvs.get(position);

        holder.ivLogo.setImageResource(pdv.getLogo());
        holder.tvNombre.setText(pdv.getNombre());
        holder.tvCodigo.setText(pdv.getCodigo());
        holder.tvDireccion.setText(pdv.getDireccion());

        holder.btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = pdv.getNombre();
                longitude = pdv.getLongitud();
                latitude = pdv.getLatitud();

                Intent intent = new Intent(view.getContext(), MapsActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("longitude", longitude);
                intent.putExtra("latitude", latitude);
                view.getContext().startActivity(intent);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = pdv.getNombre();



                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(view.getContext());
                builder.setTitle(name);
                builder.setMessage(R.string.alert_message);
                builder.setPositiveButton(R.string.alert_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        name = pdv.getNombre();
                        location = pdv.getDireccion();
                        logo = pdv.getLogo();
                        id = pdv.getId();

                        Intent intent = new Intent(view.getContext(), PDVActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("location", location);
                        intent.putExtra("logo", logo);
                        intent.putExtra("id", id);
                        view.getContext().startActivity(intent);

                    }
                });
                builder.setNegativeButton(R.string.alert_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return pdvs.size();
    }

    public static class PDVViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivLogo;
        private TextView tvNombre;
        private  TextView   tvCodigo;
        private TextView tvDireccion;
        private ImageButton btnLocation;
        private CardView cardView;

        public PDVViewHolder( View itemView) {
            super(itemView);
            ivLogo     = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvNombre    = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCodigo  = (TextView) itemView.findViewById(R.id.tvCodigo);
            tvDireccion      = (TextView) itemView.findViewById(R.id.tvDireccion);
            btnLocation = (ImageButton) itemView.findViewById(R.id.btnLocation);
            cardView = (CardView) itemView.findViewById(R.id.my_cardview);
        }


    }


}
