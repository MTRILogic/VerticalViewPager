package com.mtrilogic.verticalviewpager.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mtrilogic.verticalviewpager.R;

public class PageFragment extends Fragment {
    private static final String TITLE = "title", NUMBER = "number", TAG = "MTRI-LOGIC";

    private TextView lblNumber;
    private String title;
    private int number;

    public static PageFragment getInstance(String title){
        Log.d(TAG, "getInstance: " + title);
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        args.putInt(NUMBER, 0);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            title = savedInstanceState.getString(TITLE);
            number = savedInstanceState.getInt(NUMBER);
        }else {
            Bundle args = getArguments();
            if (args != null) {
                title = args.getString(TITLE);
                number = args.getInt(NUMBER);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        FrameLayout mainContainer = view.findViewById(R.id.mainContainer);
        mainContainer.setBackgroundColor(getColorFromTitle(title));

        lblNumber = view.findViewById(R.id.lblNumber);
        lblNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblNumber.setText(getString(R.string.numberMask, ++number));
            }
        });

        lblNumber.setText(getString(R.string.numberMask, number));
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(TITLE, title);
        outState.putInt(NUMBER, number);
        super.onSaveInstanceState(outState);
    }

    private int getColorFromTitle(String title){
        switch (title){
            case "GREEN": return Color.GREEN;
            case "BLUE": return Color.BLUE;
            case "RED": return Color.RED;
            case "YELLOW": return Color.YELLOW;
            case "MAGENTA": return Color.MAGENTA;
            case "CYAN": return Color.CYAN;
        }
        return Color.WHITE;
    }
}
