package com.example.watersystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.watersystem.R;
import com.example.watersystem.db.table.UserWater;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterAllData extends RecyclerView.Adapter<AdapterAllData.Holder> {
    List<UserWater> UserWateres;
    public static String TAG = "adapter store page";


    public AdapterAllData(List<UserWater> products) {
        this.UserWateres = products;
    }

    @NonNull
    @Override
    public AdapterAllData.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_view_item, parent, false);

        return new AdapterAllData.Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterAllData.Holder holder, final int position) {

        UserWater userWater = UserWateres.get(position);

        holder.tv_count.setText(userWater.getCount() + "");
        holder.tv_date.setText(userWater.getDate());
        holder.tv_day.setText(userWater.getDay());

    }

    @Override
    public int getItemCount() {
        return UserWateres.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tv_day, tv_date, tv_count;


        public Holder(@NonNull View itemView) {
            super(itemView);
            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_count = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
}
