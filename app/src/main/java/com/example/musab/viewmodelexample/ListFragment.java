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
    int selectedItem = -1;
    private final String SELECTED_ITEM_KEY = TAG + "SELECTED_ITEM_KEY";


    public ListFragment() {
    }

    @SuppressWarnings("unused")
    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null && savedInstanceState.containsKey(SELECTED_ITEM_KEY))//check if it's new or has been killed and rerun
            selectedItem = savedInstanceState.getInt(SELECTED_ITEM_KEY);

        model = ViewModelProviders.of(getActivity()).get(SharedDataViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        OnListItemClicked mListener = new OnListItemClicked() {

            @Override
            public void onListFragmentInteraction(DummyItem item, int position) {
                model.select(item);//now trigger the view model live data to handle the selected item on other fragment
                selectedItem = position;
            }
        };

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }

        if (selectedItem != -1)
            model.select(DummyContent.ITEMS.get(selectedItem));//now trigger the view model live data to handle the selected item on other fragment

        return view;
    }


    public interface OnListItemClicked {
        void onListFragmentInteraction(DummyItem item, int position);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM_KEY, selectedItem);//here we save the selected item index to handle if the app has been killed
    }
}
