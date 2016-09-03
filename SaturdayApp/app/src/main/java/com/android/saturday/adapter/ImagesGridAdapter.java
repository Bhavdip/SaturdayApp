package com.android.saturday.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.android.saturday.restclient.pojo.ImagesDao;

import java.util.ArrayList;

/**
 * Created by bhavdip on 9/3/16.
 */
public class ImagesGridAdapter extends RecyclerView.Adapter<ImagesGridAdapter.ImageViewHolder> {

    private ArrayList<ImagesDao> mImagesDataSet = new ArrayList<>();

    public ImagesGridAdapter() {

    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mImagesDataSet.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageViewHolder(View itemView) {
            super(itemView);
        }
    }
}
