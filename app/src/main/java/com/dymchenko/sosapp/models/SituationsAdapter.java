package com.dymchenko.sosapp.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dymchenko.sosapp.Instructions;
import com.dymchenko.sosapp.MainActivity;
import com.dymchenko.sosapp.R;

import java.util.List;

public class SituationsAdapter extends RecyclerView.Adapter<SituationsAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<EmergencySituations> situations;

    public SituationsAdapter(Context context, List<EmergencySituations> situations) {
            this.situations = situations;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public SituationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.emergency_situation_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SituationsAdapter.ViewHolder holder, int position) {
        EmergencySituations situation = situations.get(position);
        holder.icon.setImageDrawable(situation.Icon);
        holder.nameView.setText(situation.Name);
        holder.emergencyRow.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Instructions.class);
                intent.putExtra("name", holder.nameView.getText());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return situations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView icon;
        final TextView nameView;
        final RelativeLayout emergencyRow;
        ViewHolder(View view){
            super(view);
            icon = view.findViewById(R.id.emergency_image);
            nameView = view.findViewById(R.id.emergency_name);
            emergencyRow = view.findViewById(R.id.emergency_row);
        }
    }
}