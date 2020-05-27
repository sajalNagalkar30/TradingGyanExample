package com.example.tradinggyanexample.ui;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tradinggyanexample.R;
import com.example.tradinggyanexample.ui.trading.TradingViewModel;

public class TradingFragment extends Fragment {

    private TradingViewModel mViewModel;

    public static TradingFragment newInstance() {
        return new TradingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.trading_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TradingViewModel.class);
        // TODO: Use the ViewModel
    }

}
