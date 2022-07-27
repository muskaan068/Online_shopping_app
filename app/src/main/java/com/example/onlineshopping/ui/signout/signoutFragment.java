package com.example.onlineshopping.ui.signout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.onlineshopping.LoginActivity;
import com.example.onlineshopping.R;
import com.example.onlineshopping.SignUpActivity;
import com.example.onlineshopping.databinding.FragmentGalleryBinding;
import com.example.onlineshopping.databinding.FragmentHomeBinding;
import com.example.onlineshopping.databinding.FragmentSignoutBinding;
import com.example.onlineshopping.databinding.FragmentSlideshowBinding;
import com.example.onlineshopping.ui.gallery.GalleryViewModel;
import com.example.onlineshopping.ui.home.HomeViewModel;

public class signoutFragment extends Fragment {
    TextView text;
    Button btn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signout, container, false);
    }
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view,savedInstanceState);
        text = (TextView)view.findViewById(R.id.textview14);
        btn=(Button)view.findViewById(R.id.loginbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(signoutFragment.this)
                        .navigate(androidx.appcompat.R.id.action_bar_activity_content);
            }
        });

    }


}
