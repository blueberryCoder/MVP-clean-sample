package com.blueberry.start.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blueberry.star.domain.model.Star;
import com.blueberry.start.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by blueberry on 8/5/2017.
 */

public class StarListAdapter extends RecyclerView.Adapter<StarListAdapter.ViewHolder> {

    private static final String TAG = "StarListAdapter";


    private LayoutInflater mLayoutInflater;
    private List<Star> mData;
    private Context mContext;

    public StarListAdapter(Context context, List<Star> data) {
        this.mData = data;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater
                .inflate(R.layout.item_star, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(mData.get(position).getName());
        holder.tvGender.setText(mData.get(position).getGender() == 0 ? "女" : "男");
        holder.tvDateOfBirth.setText(mData.get(position).getDateOfBirth());
        holder.tvBasicInfo.setText(mData.get(position).getBasicInfo());
        Glide.with(mContext)
                .load(mData.get(position).getPhoto())
                .into(holder.ivPhoto);

    }

    @Override
    public int getItemCount() {
        return null == mData ? 0 : mData.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView ivPhoto;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_gender)
        TextView tvGender;
        @BindView(R.id.tv_date_of_birth)
        TextView tvDateOfBirth;
        @BindView(R.id.tv_basic_info)
        TextView tvBasicInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
