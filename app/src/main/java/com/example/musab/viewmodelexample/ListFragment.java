package com.example.musab.viewmodelexample;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.musab.viewmodelexample.DummyContent.DummyItem;

public class ListFragment extends Fragment {

    public static String TAG = "ListFragment";
    SharedDataViewModel model;


    public ListFragment() {
    }

    @SuppressWarnings("unused")
    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        model = ViewModelProviders.of(getActivity()).get(SharedDataViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        OnListItemClicked mListener = new OnListItemClicked() {
            @Override
            public void onListFragmentInteraction(DummyItem item) {
                model.select(item);
            }
        };

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }


    public interface OnListItemClicked {
        void onListFragmentInteraction(DummyItem item);
    }
}
