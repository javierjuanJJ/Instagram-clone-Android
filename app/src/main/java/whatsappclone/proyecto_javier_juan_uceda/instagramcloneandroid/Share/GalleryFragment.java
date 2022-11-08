package whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.Share;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import whatsappclone.proyecto_javier_juan_uceda.instagramcloneandroid.R;

public class GalleryFragment extends Fragment {

    private static final String TAG = GalleryFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        Log.d(TAG, "onCreateView: started.");

        return view;
    }
}