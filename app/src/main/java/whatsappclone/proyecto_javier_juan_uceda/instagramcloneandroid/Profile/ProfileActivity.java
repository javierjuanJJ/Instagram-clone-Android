package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Profile;

import static whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper.setupBottomNavigationView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.ParentActivity;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.R;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends ParentActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private static final int ACTIVITY_NUM = 1;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setUI();

    }

    private void setUI() {
        Log.d(TAG, "onCreate: starting.");
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);

        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);

        setupBottomNavigationView(bottomNavigationView);
        m1(TAG, ACTIVITY_NUM);
        setupBottomNavigationView(bottomNavigationView);
        setupToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d(TAG, "onMenuItemClick: clicked menu item: " + item);

                switch (item.getItemId()){
                    case R.id.profileMenu:
                        Log.d(TAG, "onMenuItemClick: Navigating to Profile Preferences.");
                }

                return false;
            }
        });
    }
}