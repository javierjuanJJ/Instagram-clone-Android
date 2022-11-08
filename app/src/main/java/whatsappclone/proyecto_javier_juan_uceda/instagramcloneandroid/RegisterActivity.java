package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class RegisterActivity extends ParentActivity {
   private static final String TAG = RegisterActivity.class.getSimpleName();

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_register);
      Log.d(TAG, "onCreate: started.");
   }
}
