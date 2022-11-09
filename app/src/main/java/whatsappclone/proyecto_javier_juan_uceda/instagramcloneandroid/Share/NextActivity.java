package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Share;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.R;

public class NextActivity extends AppCompatActivity {

    private static final String TAG = NextActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Log.d(TAG, "onCreate: got the chosen image: " + getIntent().getStringExtra(getString(R.string.selected_image)));
    }
}