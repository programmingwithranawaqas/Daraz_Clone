package com.example.daraz_clone;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> categories;
    Context context;
    public CategoryAdapter(Context context, ArrayList<Category> categories)
    {
        this.categories = categories;
        this.context = context;
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
        Category category = categories.get(holder.getAdapterPosition());

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



        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder editDelete = new AlertDialog.Builder(context);
                editDelete.setTitle("Update or Delete Category");
                View view = LayoutInflater.from(context)
                                .inflate(R.layout.form_to_add_new_category,  null, false);
                EditText etName = view.findViewById(R.id.etName);
                EditText etSubCategory = view.findViewById(R.id.etSubcategory);
                EditText etImageUrl = view.findViewById(R.id.etImageUrl);

                editDelete.setView(view);
                etName.setText(category.getName());
                etSubCategory.setText(category.getSubCategories()+"");
                etImageUrl.setText(category.getImgUrl());

                editDelete.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = etName.getText().toString().trim();
                        String subCategory = etSubCategory.getText().toString();
                        String imgUrl = etImageUrl.getText().toString().trim();

                        if(name.isEmpty() || subCategory.isEmpty() || imgUrl.isEmpty())
                        {
                            Toast.makeText(context, "Something is missing in the form", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            String oldName = category.getName();
                            category.setName(name);
                            category.setSubCategories(Integer.parseInt(subCategory));
                            category.setImgUrl(imgUrl);
                            Toast.makeText(context, oldName+" has been updated", Toast.LENGTH_SHORT).show();
                            notifyDataSetChanged();
                        }

                    }
                });

                editDelete.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyApplication.categories.remove(holder.getAdapterPosition());
                        Toast.makeText(context, category.getName()+" Deleted...", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                });

                editDelete.show();


                return false;
            }
        });

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
