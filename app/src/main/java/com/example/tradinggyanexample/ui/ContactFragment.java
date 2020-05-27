package com.example.tradinggyanexample.ui;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tradinggyanexample.R;
import com.example.tradinggyanexample.ui.contactoncall.ContactViewModel;

public class ContactFragment extends Fragment {


    private ContactViewModel mViewModel;
    ImageView call;

    public static ContactFragment newInstance() {
        return new ContactFragment();

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.contact_fragment, container, false);
        call=view.findViewById(R.id.callps);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number="+918999144690";
                Intent intent=new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+number));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    // TODO: Consider calling

                    return;
                }
                startActivity(intent);
            }
        });

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        // TODO: Use the ViewModel
    }


}