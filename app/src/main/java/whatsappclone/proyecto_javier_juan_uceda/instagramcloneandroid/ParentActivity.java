package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid;

import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;

public class ParentActivity extends AppCompatActivity {
    protected Context mContext = this;

    public void m1(String tag, int activityNum){
        Log.d(tag, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationView bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(activityNum);
        menuItem.setChecked(true);
    }


}
