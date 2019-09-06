package com.example.myapplication.Dda;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;

import java.util.ArrayList;

public class DdapendingAdapter extends RecyclerView.Adapter<DdapendingAdapter.ViewHolderPendingDda>{
    private static final String TAG = "DdapendingAdapter";
    ArrayList<String> mtextview1;
    ArrayList<String> mtextview2;
    ArrayList<String> mtextview3;
    Context mcontext;

    public DdapendingAdapter(Context mcontext, ArrayList<String> mtextview1, ArrayList<String> mtextview2,ArrayList<String> mtextview3) {
        this.mcontext = mcontext;
        this.mtextview1 = mtextview1;
        this.mtextview2 = mtextview2;
        this.mtextview3 = mtextview3;
    }

    @NonNull
    @Override
    public ViewHolderPendingDda onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.notassignedlist,parent,false);
        ViewHolderPendingDda viewHolderPendingDda = new ViewHolderPendingDda(view);
        return viewHolderPendingDda;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPendingDda holder, int position) {
        holder.tv1.setText(mtextview1.get(position));
        holder.tv2.setText(mtextview2.get(position));
        holder.tv3.setText(mtextview3.get(position));

        holder.parentnotassigned.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: item clicked");
                Intent intent = new Intent(mcontext, DdaselectAdo.class);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mtextview1.size();
    }

    public class ViewHolderPendingDda extends RecyclerView.ViewHolder{

        TextView tv1;
        TextView tv2;
        TextView tv3;
        RelativeLayout parentnotassigned;

        public ViewHolderPendingDda(@NonNull View itemView) {
            super(itemView);
            mcontext = itemView.getContext();
            parentnotassigned = itemView.findViewById(R.id.parentnotassigned);
            tv1 = itemView.findViewById(R.id.date);
            tv2 = itemView.findViewById(R.id.Time);
            tv3 = itemView.findViewById(R.id.address);

        }

    }

}