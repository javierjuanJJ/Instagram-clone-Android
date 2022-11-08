package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Share;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Home.SectionsPagerAdapter;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.ParentActivity;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.R;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.Permissions;

public class ShareActivity extends ParentActivity {

    private static final String TAG = ShareActivity.class.getSimpleName();
    private BottomNavigationView bottomNavigationView;
    private static final int ACTIVITY_NUM = 2;
    private static final int VERIFY_PERMISSIONS_REQUEST = 1;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        setUI();

    }

    private void setUI() {
        Log.d(TAG, "onCreate: starting.");
//        bottomNavigationView = findViewById(R.id.bottomNavViewBar);
//        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationView);
//        m1(TAG, ACTIVITY_NUM);
        if(checkPermissionsArray(Permissions.PERMISSIONS)){
            setupViewPager();
        }else{
            verifyPermissions(Permissions.PERMISSIONS);
        }
    }

    private void setupViewPager() {
        SectionsPagerAdapter adapter =  new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GalleryFragment());
        adapter.addFragment(new PhotoFragment());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabsBottom);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setText(getString(R.string.gallery));
        tabLayout.getTabAt(1).setText(getString(R.string.photo));

    }

    /**
     * verifiy all the permissions passed to the array
     * @param permissions
     */

    public void verifyPermissions(String[] permissions){
        Log.d(TAG, "verifyPermissions: verifying permissions.");

        ActivityCompat.requestPermissions(
                ShareActivity.this,
                permissions,
                VERIFY_PERMISSIONS_REQUEST
        );
    }

    /**
     * Check an array of permissions
     * @param permissions
     * @return
     */
    public boolean checkPermissionsArray(String[] permissions){
        Log.d(TAG, "checkPermissionsArray: checking permissions array.");

        for(int i = 0; i< permissions.length; i++){
            String check = permissions[i];
            if(!checkPermissions(check)){
                return false;
            }
        }
        return true;
    }

    /**
     * Check a single permission is it has been verified
     * @param permission
     * @return
     */
    public boolean checkPermissions(String permission){
        Log.d(TAG, "checkPermissions: checking permission: " + permission);

        int permissionRequest = ActivityCompat.checkSelfPermission(ShareActivity.this, permission);

        if(permissionRequest != PackageManager.PERMISSION_GRANTED){
            Log.d(TAG, "checkPermissions: \n Permission was not granted for: " + permission);
            return false;
        }
        else{
            Log.d(TAG, "checkPermissions: \n Permission was granted for: " + permission);
            return true;
        }
    }
}