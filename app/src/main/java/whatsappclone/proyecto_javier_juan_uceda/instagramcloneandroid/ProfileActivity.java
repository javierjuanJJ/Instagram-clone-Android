package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends ParentActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private static final int ACTIVITY_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();

    }

    private void setUI() {
        Log.d(TAG, "onCreate: starting.");
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationView);
        m1(TAG, ACTIVITY_NUM);
    }
}