package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends ParentActivity {
   private static final String TAG = RegisterActivity.class.getSimpleName();

   private Context mContext;
   private String email, username, password;
   private EditText mEmail, mPassword, mUsername;
   private TextView loadingPleaseWait;
   private Button btnRegister;
   private ProgressBar mProgressBar;

   //firebase
   private FirebaseAuth mAuth;
   private FirebaseAuth.AuthStateListener mAuthListener;

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_register);
      setUI();

   }

   private void setUI() {
      Log.d(TAG, "onCreate: started.");
      initWidgets();
      setupFirebaseAuth();
   }


   /**
    * Initialize the activity widgets
    */
   private void initWidgets(){
      Log.d(TAG, "initWidgets: Initializing Widgets.");
      mEmail = findViewById(R.id.input_email);
      mProgressBar = findViewById(R.id.progressBar);
      loadingPleaseWait = findViewById(R.id.loadingPleaseWait);
      mPassword = findViewById(R.id.input_password);
      mContext = RegisterActivity.this;
      mProgressBar.setVisibility(View.GONE);
      loadingPleaseWait.setVisibility(View.GONE);

   }

   private boolean isStringNull(String string){
      Log.d(TAG, "isStringNull: checking string if null.");
      return string.equals("");
   }

     /*
    ------------------------------------ Firebase ---------------------------------------------
     */

   /**
    * Setup the firebase auth object
    */
   private void setupFirebaseAuth(){
      Log.d(TAG, "setupFirebaseAuth: setting up firebase auth.");

      mAuth = FirebaseAuth.getInstance();

      mAuthListener = new FirebaseAuth.AuthStateListener() {
         @Override
         public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();

            if (user != null) {
               // User is signed in
               Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
            } else {
               // User is signed out
               Log.d(TAG, "onAuthStateChanged:signed_out");
            }
            // ...
         }
      };
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
