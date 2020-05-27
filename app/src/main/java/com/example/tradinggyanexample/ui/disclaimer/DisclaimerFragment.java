package com.example.tradinggyanexample.ui.disclaimer;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tradinggyanexample.R;

public class DisclaimerFragment extends Fragment {


    private DisclaimerViewModel mViewModel;

    public static DisclaimerFragment newInstance() {
        return new DisclaimerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.disclaimer_fragment, container, false);
        Toolbar toolbar = v.findViewById(R.id.toolbar);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DisclaimerViewModel.class);
        // TODO: Use the ViewModel
    }

}
