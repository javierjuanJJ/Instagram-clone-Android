package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Likes;

import static whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper.setupBottomNavigationView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.ParentActivity;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.R;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;

public class LikesActivity extends ParentActivity {

    private static final String TAG = LikesActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private static final int ACTIVITY_NUM = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();

    }

    private void setUI() {
        Log.d(TAG, "onCreate: starting.");
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        setupBottomNavigationView(bottomNavigationView);
        m1(TAG, ACTIVITY_NUM);
        setupBottomNavigationView();
    }
}