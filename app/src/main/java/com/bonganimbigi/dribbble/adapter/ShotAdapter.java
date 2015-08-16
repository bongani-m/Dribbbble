package com.bonganimbigi.dribbble.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bonganimbigi.dribbble.R;
import com.bonganimbigi.dribbble.adapter.holder.ShotHolder;
import com.bonganimbigi.dribbble.entity.Page;
import com.bonganimbigi.dribbble.entity.Shot;
import com.bonganimbigi.dribbble.listener.OnShotClickListener;
import com.bonganimbigi.dribbble.util.DribbblePicasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ShotAdapter extends android.support.v7.widget.RecyclerView.Adapter<ShotHolder> {

    @Inject
    Resources resources;

    @Inject
    Context context;

    @Inject
    LayoutInflater layoutInflater;

    private final List<Shot> shots = new ArrayList<>();
    private OnShotClickListener onShotClickListener;

    @Inject
    public ShotAdapter() {}

    @Override
    public ShotHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShotHolder(layoutInflater.inflate(R.layout.card_dribble, parent, false));
    }

    @Override
    public void onBindViewHolder(ShotHolder holder, int position) {
        Shot shot = shots.get(position);
        holder.onShotClickListener = onShotClickListener;
        holder.shot = shot;
        DribbblePicasso.with(context, shot.getImageUrl()).into(holder.dribbbleImage);
        holder.dribbbleTittle.setText(shot.getTitle());
        holder.viewCount.setText(shot.getViewsCount().toString());
    }

    @Override
    public int getItemCount() {
        return shots.size();
    }

    public void addPageShots(Page newPage) {
        this.shots.addAll(newPage.getShots());
        notifyDataSetChanged();
    }

    public void cleanShots() {
        this.shots.clear();
    }

    public void setOnShotClickListener(OnShotClickListener onShotClickListener) {
        this.onShotClickListener = onShotClickListener;
    }
}
