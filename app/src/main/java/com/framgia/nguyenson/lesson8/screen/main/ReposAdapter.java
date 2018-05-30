package com.framgia.nguyenson.lesson8.screen.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.framgia.nguyenson.lesson8.R;
import com.framgia.nguyenson.lesson8.data.model.Repos;

import java.util.List;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {
    private List<Repos> mArrayList;
    private Context mContext;

    public ReposAdapter(List<Repos> arrayList, Context context) {
        mArrayList = arrayList;
        mContext = context;
    }

    @NonNull
    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ReposAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposAdapter.ViewHolder holder, int position) {
        Glide.with(mContext).load(mArrayList.get(position).getOwner().getAvatarURL())
                .into(holder.mImage);
        holder.mId.setText(String.valueOf(mArrayList.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;
        private TextView mId;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.imageView);
            mId = itemView.findViewById(R.id.text_id);
        }
    }

    public List<Repos> getArrayList() {
        return mArrayList;
    }

    public void setArrayList(List<Repos> arrayList) {
        mArrayList = arrayList;
    }
}