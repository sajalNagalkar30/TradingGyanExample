package com.example.tradinggyanexample.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tradinggyanexample.MainActivity;
import com.example.tradinggyanexample.R;
import com.example.tradinggyanexample.ui.raiseaticket.RaiseaticketViewModel;

import java.text.DateFormat;
import java.util.Date;

public class RaiseaticketFragment extends Fragment {

    private RaiseaticketViewModel mViewModel;
    Button raiseaticket,cancel;

    public static RaiseaticketFragment newInstance() {
        return new RaiseaticketFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.raiseaticket_fragment, container, false);

        raiseaticket=v.findViewById(R.id.raiseaticket);
        cancel=v.findViewById(R.id.btn_cancel);



        raiseaticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }

        });

        return v;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RaiseaticketViewModel.class);
        // TODO: Use the ViewModel
    }


    private void customDialog(){

        AlertDialog.Builder mydialog=new AlertDialog.Builder(getContext());

        LayoutInflater inflater=LayoutInflater.from(getContext());
        View view=inflater.inflate(R.layout.ticket,null);

        final AlertDialog dialog=mydialog.create();
        dialog.setView(view);


        cancel= view.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(true);
        dialog.show();

    }


}
