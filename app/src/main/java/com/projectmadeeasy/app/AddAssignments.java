package com.projectmadeeasy.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.colorpicker.ColorPickerDialog;
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog;
import com.github.dhaval2404.colorpicker.model.ColorShape;
import com.projectmadeeasy.app.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class AddAssignments extends AppCompatActivity implements View.OnClickListener {

    Context context;
    LinearLayout llBox1, llBox2;
    private int mColor = 0;
    Button Button1;
    List<String> listColor = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);
        context = this;

        initView();
        insertColor();
    }

    private void insertColor() {
        listColor.clear();
        listColor.add("#000000"); //0
        listColor.add("#F1948A"); //1
        listColor.add("#239B56"); //2
        listColor.add("#633974"); //3
    }

    private void initView() {
        Button1 = findViewById(R.id.Button1);
        Button1.setOnClickListener(v -> {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.color_popuplayout);
            LinearLayout llContainer = dialog.findViewById(R.id.llContainer);
            LayoutInflater linf = (LayoutInflater) getApplicationContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            for (int i = 0; i < listColor.size(); i++) {
                View v1 = linf.inflate(R.layout.row_color, null);
                LinearLayout outerView = v1.findViewById(R.id.outerView);
                ImageView ivTick=v1.findViewById(R.id.ivTick);
                outerView.setBackgroundColor(Color.parseColor(listColor.get(i)));
                outerView.setId(i);
                outerView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Utility.showToast(context,""+outerView.getId());
                        int clicked=outerView.getId();
                        for (int i = 0; i < listColor.size(); i++) {
                            if(clicked==i){

                            }else {
                                ivTick.setVisibility(View.GONE);
                            }
                        }
                    }
                });
                llContainer.addView(v1);
            }

            dialog.show();
        });

    }

    @Override
    public void onClick(View v) {

    }
}
