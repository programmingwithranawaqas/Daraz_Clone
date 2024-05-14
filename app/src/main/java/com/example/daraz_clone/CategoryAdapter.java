package com.example.daraz_clone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> categories;
    public CategoryAdapter(Context context, ArrayList<Category> categories)
    {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_category_item_design, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.tvCategoryName.setText(category.getName());
        holder.tvCountSubCategory.setText(category.getSubCategories()+"");
        if (category.getImgUrl().equals("clothes"))
        {
            holder.ivCategoryPic.setImageResource(R.drawable.clothes);
        }
        else if (category.getImgUrl().equals("shirts"))
        {
            holder.ivCategoryPic.setImageResource(R.drawable.shirts);
        }
        else if (category.getImgUrl().equals("shoes"))
        {
            holder.ivCategoryPic.setImageResource(R.drawable.shoes);
        }
        else if (category.getImgUrl().equals("pents"))
        {
            holder.ivCategoryPic.setImageResource(R.drawable.pents);
        }



    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivCategoryPic;
        TextView tvCategoryName, tvCountSubCategory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCategoryPic = itemView.findViewById(R.id.ivCategoryPic);
            tvCategoryName = itemView.findViewById(R.id.tvCategoryName);
            tvCountSubCategory = itemView.findViewById(R.id.tvCountSubCategory);

        }
    }
}
