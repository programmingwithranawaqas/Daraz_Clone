package com.example.daraz_clone;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCategories;
    LinearLayoutManager manager;
    GridLayoutManager gridLayoutManager;
    CategoryAdapter adapter;

    FloatingActionButton fabAddCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        fabAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder addCategory = new AlertDialog.Builder(MainActivity.this);
                addCategory.setTitle("Add New Category...");
                View view = LayoutInflater.from(MainActivity.this)
                                .inflate(R.layout.form_to_add_new_category,  null, false);
                addCategory.setView(view);

                EditText etName, etSubcategory, etImageUrl;
                etName = view.findViewById(R.id.etName);
                etImageUrl = view.findViewById(R.id.etImageUrl);
                etSubcategory = view.findViewById(R.id.etSubcategory);

                addCategory.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Category category = new Category(Integer.parseInt(etSubcategory.getText().toString()),
                                etName.getText().toString().trim(), etImageUrl.getText().toString());
                        MyApplication.categories.add(category);
                        adapter.notifyDataSetChanged();
                    }
                });


                addCategory.show();



            }
        });

    }
    private void init()
    {
        rvCategories = findViewById(R.id.rvCategories);
        fabAddCategory = findViewById(R.id.fabAddCategory);

        rvCategories.setHasFixedSize(true);
        manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        gridLayoutManager = new GridLayoutManager(this, 2);
        rvCategories.setLayoutManager(manager);
        adapter = new CategoryAdapter(this, MyApplication.categories);
        rvCategories.setAdapter(adapter);
    }
}