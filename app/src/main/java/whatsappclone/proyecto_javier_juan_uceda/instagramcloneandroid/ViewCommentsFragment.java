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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.Comment;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.Like;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.Photo;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.User;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Models.UserAccountSettings;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.BottomNavigationViewHelper;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.CommentListAdapter;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.FirebaseMethods;
import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Utils.Heart;

public class ViewCommentsFragment extends Fragment {

    private static final String TAG = ViewCommentsFragment.class.getSimpleName();

    public ViewCommentsFragment(){
        super();
        setArguments(new Bundle());
    }

    //widgets
    private ImageView mBackArrow, mCheckMark;
    private EditText mComment;
    private ListView mListView;

    //vars
    private Photo mPhoto;
    private ArrayList<Comment> mComments;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_comments, container, false);

        mBackArrow = (ImageView) view.findViewById(R.id.backArrow);
        mCheckMark = (ImageView) view.findViewById(R.id.ivPostComment);
        mComment = (EditText) view.findViewById(R.id.comment);
        mListView = (ListView) view.findViewById(R.id.listView);
        mComments = new ArrayList<>();


        try{
            mPhoto = getPhotoFromBundle();

        }catch (NullPointerException e){
            Log.e(TAG, "onCreateView: NullPointerException: " + e.getMessage() );
        }


        Comment firstComment = new Comment();
        firstComment.setComment(mPhoto.getCaption());
        firstComment.setUser_id(mPhoto.getUser_id());
        firstComment.setDate_created(mPhoto.getDate_created());

        mComments.add(firstComment);
        CommentListAdapter adapter = new CommentListAdapter(getActivity(),
                R.layout.layout_comments, mComments);
        mListView.setAdapter(adapter);
        return view;
    }

    /**
     * retrieve the photo from the incoming bundle from profileActivity interface
     * @return
     */
    private Photo getPhotoFromBundle(){
        Log.d(TAG, "getPhotoFromBundle: arguments: " + getArguments());

        Bundle bundle = this.getArguments();
        if(bundle != null) {
            return bundle.getParcelable(getString(R.string.photo));
        }else{
            return null;
        }
    }

}
