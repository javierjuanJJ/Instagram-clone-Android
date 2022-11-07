package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Home;

import android.os.Bundle;
import android.util.Log;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.ParentActivity;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.R;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;

public class HomeActivity extends ParentActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private static final int ACTIVITY_NUM = 0;

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
        setupViewPager();
    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment()); //index 0
        adapter.addFragment(new HomeFragment()); //index 1
        adapter.addFragment(new MessagesFragment()); //index 2
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_action_name);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_arrow);
    }
}