package com.example.muscle_studio_100;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CoachAdapter extends ArrayAdapter<Coach> {
    private Context mContext;
    private int mRss;

    //
    public CoachAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Coach> objects) {
        super(context, resource, objects);

        this.mContext=context;
        this.mRss=resource;
    }

    @NonNull
    @Override
    public View getView(int position , @Nullable View convertView , @NonNull ViewGroup parent)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);  //from(mContext);

        convertView = layoutInflater.inflate(mRss , parent ,false);

        ImageView imageView = convertView.findViewById(R.id.img);
        TextView NomCoach=convertView.findViewById(R.id.NomCoach);
        TextView Desc_Coach = convertView.findViewById(R.id.description_coach);

        imageView.setImageResource(getItem(position).getImg());
        NomCoach.setText(getItem(position).getName());
        Desc_Coach.setText(getItem(position).getDesc());

        return convertView;
    }

}
