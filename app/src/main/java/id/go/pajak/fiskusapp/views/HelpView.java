package id.go.pajak.fiskusapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.go.pajak.fiskusapp.LoginsActivity;
import id.go.pajak.fiskusapp.MainActivity;
import id.go.pajak.fiskusapp.PreconfigActivity;
import id.go.pajak.fiskusapp.R;

public class HelpView extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        Intent gotoMain =  new Intent(getContext(), LoginsActivity.class);
        startActivity(gotoMain);
        return view;
    }
}
