package com.j7arsen.postproject.ui.block.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.j7arsen.domain.model.person.PostPersonDataModel;
import com.j7arsen.postproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostPersonsAdapter extends RecyclerView.Adapter<PostPersonsAdapter.ItemViewHolder> {

    private List<PostPersonDataModel> postPersonDataModelList;

    public PostPersonsAdapter() {
        this.postPersonDataModelList = new ArrayList<>();
    }

    public void setData(List<PostPersonDataModel> postPersonDataModelList) {
        this.postPersonDataModelList = postPersonDataModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_post_person, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        if (postPersonDataModelList != null && postPersonDataModelList.size() != 0) {
            PostPersonDataModel postPersonDataModel = postPersonDataModelList.get(position);
            if (postPersonDataModel != null) {
                if (postPersonDataModel.getAvatarImage().getUrl() != null && !postPersonDataModel.getAvatarImage().getUrl().isEmpty()) {
                    holder.sdvPostPersonAvatar.setImageURI(postPersonDataModel.getAvatarImage().getUrl());
                } else {
                    holder.sdvPostPersonAvatar.setActualImageResource(android.R.drawable.ic_dialog_email);
                }
                holder.tvPostBlockTitle.setText(postPersonDataModel.getNickname());
            }
        }
    }

    @Override
    public int getItemCount() {
        return postPersonDataModelList != null ? postPersonDataModelList.size() : 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sdv_post_person_avatar)
        SimpleDraweeView sdvPostPersonAvatar;
        @BindView(R.id.tv_post_block_title)
        TextView tvPostBlockTitle;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
