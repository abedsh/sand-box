package com.codefish.sandbox;


import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TourPageFragment extends Fragment {


    Button btn;

    public static TourPageFragment newInstance(Integer imageId) {
        TourPageFragment fragment = new TourPageFragment();
        Bundle args = new Bundle();
        args.putInt("imageId",imageId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_page, container, false);

        btn = rootView.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView imageView = rootView.findViewById(R.id.tour_img);

        Bundle args = getArguments();

        Integer imageId = args.getInt("imageId");

        imageView.setImageResource(imageId);

        return rootView;
    }



}
