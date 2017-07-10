package com.example.musab.viewmodelexample;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailsFragment extends LifecycleFragment {
    public static String TAG = "DetailsFragment";

    private TextView textViewDetails;

    public DetailsFragment() {
    }


    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        textViewDetails = view.findViewById(R.id.textViewDetails);

        SharedDataViewModel model = ViewModelProviders.of(getActivity()).get(SharedDataViewModel.class);

        model.getSelected().observe(this, new Observer<DummyContent.DummyItem>() {
            @Override
            public void onChanged(@Nullable DummyContent.DummyItem dummyItem) {//if there is new selected item it will trigger here
                if (dummyItem != null)
                    textViewDetails.setText(dummyItem.toString());
            }
        });

        return view;
    }

}
