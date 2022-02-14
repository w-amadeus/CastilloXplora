package com.example.castilloassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.castilloassignment.db.ConstructorUsuarios;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.HashMap;


public class ProfileFragment extends Fragment {
    private TextView tvProfile;
    private TextView tvProfileCorreo;
    private CircularImageView ivProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_profile, container, false);
        getActivity().setTitle(R.string.profile_frag);

        tvProfile = root.findViewById(R.id.tvProfile);
        tvProfileCorreo= root.findViewById(R.id.tvProfileCorreo);

        ivProfile = root.findViewById(R.id.ivProfile);

        SessionManager sessionManager = new SessionManager(getContext());
        HashMap<String, String> hashMap = sessionManager.getUserDetails();

        tvProfile.setText(hashMap.get("name"));
        tvProfileCorreo.setText(hashMap.get("email"));

        ivProfile.setImageResource(Integer.parseInt(hashMap.get("foto")));

        return root;


    }


}