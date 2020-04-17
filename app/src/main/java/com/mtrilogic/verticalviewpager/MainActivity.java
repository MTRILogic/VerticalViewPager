package com.mtrilogic.verticalviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.mtrilogic.adapters.PageFragmentAdapter;
import com.mtrilogic.adapters.PageChangeAdapter;

public class MainActivity extends AppCompatActivity {
    private PageFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new PageFragmentAdapter(getSupportFragmentManager());
        ViewPager pager = findViewById(R.id.pager);
        pager.addOnPageChangeListener(new PageChangeAdapter() {
            @Override
            public void onPageSelected(int position) {
                setTitle(adapter.getPageTitle(position));
            }
        });
        pager.setAdapter(adapter);
    }
}
