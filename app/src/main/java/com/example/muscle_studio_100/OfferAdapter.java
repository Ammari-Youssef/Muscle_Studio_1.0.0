package com.example.muscle_studio_100;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class OfferAdapter extends ArrayAdapter<Offer> {

    private Context mContext ;
    private int mRss;
    public OfferAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Offer> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mRss=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView= inflater.inflate(mRss , parent , false);

        TextView subType = convertView.findViewById(R.id.subtype);
        TextView subBill = convertView.findViewById(R.id.subbill);


        subType.setText(getItem(position).getSubscription_type());
        subBill.setText(getItem(position).getBill());

        return convertView;
    }
}
