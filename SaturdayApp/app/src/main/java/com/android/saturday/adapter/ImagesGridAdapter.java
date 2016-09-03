package com.android.saturday.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.saturday.R;
import com.android.saturday.databinding.RowDataBinding;
import com.android.saturday.restclient.pojo.Image;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavdip on 9/3/16.
 */
public class ImagesGridAdapter extends RecyclerView.Adapter<ImagesGridAdapter.ImageViewHolder> {

    private ArrayList<Image> mImagesDataSet = new ArrayList<>();

    public ImagesGridAdapter() {
    }

    public void addImageItem(List<Image> imagesList) {
        if (imagesList != null && imagesList.size() > 0)
            mImagesDataSet.addAll(imagesList);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowDataBinding rowDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.row_image, parent, false);
        return new ImageViewHolder(rowDataBinding);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder imageViewHolder, int position) {
        imageViewHolder.bindItemView(position);
    }

    @Override
    public int getItemCount() {
        return mImagesDataSet.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RowDataBinding mRowDataBinding;
        private Context itemContext;

        public ImageViewHolder(RowDataBinding rowDataBinding) {
            super(rowDataBinding.getRoot());
            mRowDataBinding = rowDataBinding;
            mRowDataBinding.getRoot().setOnClickListener(this);
            itemContext = itemView.getContext();
        }

        public void bindItemView(int location) {
            Image rowData = mImagesDataSet.get(location);
            if (rowData != null) {
                mRowDataBinding.textViewPhotoName.setText(rowData.getTitle());
                loadGettyImages(itemContext, rowData.getDisplaySizes().get(0).getUri(), mRowDataBinding.imageViewPhoto);
            }
        }

        public void loadGettyImages(Context context, String endPointUrl, ImageView imageViewPhoto) {
            Glide.with(context)
                    .load(endPointUrl)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageViewPhoto);
        }

        @Override
        public void onClick(View view) {

        }
    }


}
