package com.example.vito.openwebinarscurse.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vito.openwebinarscurse.adapters.MyBreakdownRecyclerViewAdapter;
import com.example.vito.openwebinarscurse.R;
import com.example.vito.openwebinarscurse.entities.Breakdown;
import com.example.vito.openwebinarscurse.interfaces.OnBreakdownInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class BreakdownFragment extends Fragment {

    private OnBreakdownInteractionListener breakdownListener;
    private List<Breakdown> breakdownList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BreakdownFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        breakdownList = new ArrayList<>();
        breakdownList.add(new Breakdown("Espejo roto", "Se ha roto el espejo izquierdo", "Seat Ibiza","", 1));
        breakdownList.add(new Breakdown("Rueda pinchada", "Se ha pinchado la rueda derecha", "Audi A3","", 2));
        breakdownList.add(new Breakdown("Espejo roto", "Se ha roto el espejo izquierdo", "Seat Ibiza","", 1));
        breakdownList.add(new Breakdown("Rueda pinchada", "Se ha pinchado la rueda derecha", "Audi A3","", 2));
        breakdownList.add(new Breakdown("Espejo roto", "Se ha roto el espejo izquierdo", "Seat Ibiza","", 1));
        breakdownList.add(new Breakdown("Rueda pinchada", "Se ha pinchado la rueda derecha", "Audi A3","", 2));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_breakdown_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MyBreakdownRecyclerViewAdapter(breakdownList, breakdownListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBreakdownInteractionListener) {
            breakdownListener = (OnBreakdownInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        breakdownListener = null;
    }
}
