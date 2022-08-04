package com.aigs.junctionbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;

import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    private List<DataSnapshot> dataSnapshots;

    public StatusAdapter(List<DataSnapshot> dataSnapshots) {
        this.dataSnapshots = dataSnapshots;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(dataSnapshots.get(position).getKey());
        holder.status.setText(dataSnapshots.get(position).getValue(String.class));
    }

    @Override
    public int getItemCount() {
        if (dataSnapshots == null)
            return 0;
        else return dataSnapshots.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name,status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.device);
            status =itemView.findViewById(R.id.status);


        }
    }
}
