package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class AccountSettingsActivity extends ParentActivity {
    private static final String TAG = AccountSettingsActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        setUI();
    }

    private void setUI() {
        Log.d(TAG, "onCreate: started.");
    }
}