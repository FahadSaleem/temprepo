package com.example.fahadsaleem.temp;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class SelectAvatarActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);
/*
        ImageView image = findViewById(R.id.first_activity_dot);
        image.setImageResource(R.drawable.ic_navigation_dots_colored);
        Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.navigation_dot);
        hyperspaceJump.setFillEnabled(true);
        hyperspaceJump.setFillAfter(true);
        image.startAnimation(hyperspaceJump);
        */
        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(SelectAvatarActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
                v.setBackgroundTintList(getApplication().getResources().getColorStateList(R.color.button_text));
            }
        });

        //TODO complete main activity accordingly
    }
}
