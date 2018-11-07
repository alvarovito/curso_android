package com.example.vito.openwebinarscurse.adapters;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vito.openwebinarscurse.R;
import com.example.vito.openwebinarscurse.entities.Breakdown;
import com.example.vito.openwebinarscurse.interfaces.OnBreakdownInteractionListener;

import java.util.List;

public class MyBreakdownRecyclerViewAdapter extends RecyclerView.Adapter<MyBreakdownRecyclerViewAdapter.ViewHolder> {

    private final List<Breakdown> mValues;
    private final OnBreakdownInteractionListener mListener;

    public MyBreakdownRecyclerViewAdapter(List<Breakdown> items, OnBreakdownInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_breakdown, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.breakdownName.setText(holder.mItem.getName());
        holder.breakdownCarBrand.setText(holder.mItem.getCarBrand());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onBreakdownClicked(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView breakdownName;
        public final TextView breakdownCarBrand;
        public final ImageView breakdownImage;
        public Breakdown mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            breakdownName = (TextView) view.findViewById(R.id.breakdownName);
            breakdownCarBrand = (TextView) view.findViewById(R.id.breakdownCarBrand);
            breakdownImage = (ImageView) view.findViewById(R.id.breakdownImage);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + breakdownName.getText() + "'";
        }
    }
}
