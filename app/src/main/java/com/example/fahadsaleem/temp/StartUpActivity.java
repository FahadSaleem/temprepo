package com.example.fahadsaleem.temp;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;

public class StartUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
      //  FirebaseApp.initializeApp(this);
        mAuth=FirebaseAuth.getInstance();

        //finding auth of user
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    user.getIdToken(true)
                            .addOnCompleteListener(new OnCompleteListener<GetTokenResult>() {
                                public void onComplete(@NonNull Task<GetTokenResult> task) {
                                    if (task.isSuccessful()) {
                                        String idToken = task.getResult().getToken();
                                        Toast.makeText(getApplicationContext(),"Token Exists",Toast.LENGTH_LONG).show();
                                        // Send token to your backend via HTTPS
                                        // ...
                                    } else {

                                        Toast.makeText(getApplicationContext(),"Token does not exist",Toast.LENGTH_LONG).show();
                                        State state=new IdleActivityState(StartUpActivity.this);
                                        state.doAction();
                                        // Handle error -> task.getException();
                                    }
                                }
                            });
                    // User is signed in
                    State state= new SelectAvatarActivityState(StartUpActivity.this);
                    state.doAction();
                    Log.d("Startup", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    State state=new IdleActivityState(StartUpActivity.this);
                    state.doAction();
                    Log.d("StartUp", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        //////// auth state listener////
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}

