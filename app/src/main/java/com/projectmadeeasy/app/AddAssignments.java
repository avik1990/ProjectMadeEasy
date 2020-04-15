package com.projectmadeeasy.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.flexbox.FlexboxLayout;
import com.projectmadeeasy.app.utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class AddAssignments extends AppCompatActivity implements View.OnClickListener {

    Context context;
    LinearLayout llBox1, llBox2;
    private int mColor = 0;
    Button Button1;
    List<String> listColor = new ArrayList<>();
    int clicked = -1;

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
        listColor.add("#633974"); //3

        listColor.add("#633974"); //3

        listColor.add("#633974"); //3
        listColor.add("#633974"); //3
        listColor.add("#633974"); //3
        listColor.add("#633974"); //3
        listColor.add("#633974"); //3
        listColor.add("#633974"); //3
        listColor.add("#633974"); //3
    }

    private void initView() {
        Button1 = findViewById(R.id.Button1);
        Button1.setOnClickListener(v -> {
            Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.color_popuplayout);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            inflatecoulorVIews(dialog);
            dialog.show();
        });
    }

    private void inflatecoulorVIews(Dialog dialog) {
        FlexboxLayout llContainer = dialog.findViewById(R.id.v_container);
        Button btnSelectionDone = dialog.findViewById(R.id.btnSelectionDone);
        btnSelectionDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                clicked = -1;
            }
        });
        ///layout param used to set margin or layout releated function like padding, margin e.t.c
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.setMargins(5, 5, 5, 5);
        //for inflating the function for regenerating.
        LayoutInflater linf = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        llContainer.removeAllViews();
        for (int i = 0; i < listColor.size(); i++) {
            View v1 = linf.inflate(R.layout.row_color, null);
            v1.setLayoutParams(buttonLayoutParams);
            LinearLayout outerView = v1.findViewById(R.id.outerView);
            ImageView ivTick = v1.findViewById(R.id.ivTick);
            outerView.setBackgroundColor(Color.parseColor(listColor.get(i)));
            outerView.setId(i);

            if (clicked == i) {
                ivTick.setVisibility(View.VISIBLE);
            } else {
                ivTick.setVisibility(View.GONE);
            }
            ///=======
            outerView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    clicked = outerView.getId();
                    Utility.showToast(context, listColor.get(clicked) + outerView.getId());

                    inflatecoulorVIews(dialog);
                }
            });
            llContainer.addView(v1);
        }
    }

    private void keepItemSelected() {

    }

    @Override
    public void onClick(View v) {

    }
}
