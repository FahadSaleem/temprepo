package com.example.fahadsaleem.temp;

import android.app.Activity;

public abstract class State {
    Activity activity;
    State(Activity activity){
        this.activity=activity;
    }
    public abstract void doAction();
}
