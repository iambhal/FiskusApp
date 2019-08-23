package id.go.pajak.fiskusapp.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.go.pajak.fiskusapp.R;

public class UserView extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        TextView tvGallery=view.findViewById(R.id.tvGalerry);
        tvGallery.setText("pakai set text nih");

        return view;
    }
}
