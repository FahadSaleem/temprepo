package com.example.fahadsaleem.temp;

import android.app.Activity;
import android.content.Intent;

public class SelectAvatarActivityState extends State {
    @Override
    public void doAction() {
        Intent i = new Intent(activity,SelectAvatarActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
    }

    SelectAvatarActivityState(Activity activity) {
        super(activity);
    }
}

