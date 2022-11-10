package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.Like;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.Photo;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.User;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.UserAccountSettings;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.FirebaseMethods;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.Heart;

public class ViewCommentsFragment extends Fragment {

    private static final String TAG = ViewCommentsFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_comments, container, false);


        return view;
    }

}
