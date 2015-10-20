package com.jack.musicandchat.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.jack.musicandchat.ActivityManager;
import com.jack.musicandchat.R;
import com.jack.musicandchat.fragment.QuickOptionDialogFragment;
import com.jack.musicandchat.widget.MyFragmentTabHost;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * author:S.jack
 * data:2015-10-10 22:16
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        View.OnTouchListener, TabHost.OnTabChangeListener {

    public static final String TAG = "MainActivity.class";
    @InjectView(android.R.id.tabhost)
    MyFragmentTabHost mTabHost;
    @InjectView(R.id.iv_quick_option)
    ImageView ivQuickOption;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate");
        ButterKnife.inject(this);
        initView();
        ActivityManager.getActivityManager().addActivity(this);

    }

    private void initView() {

        //设置FragmentTabHost
        mTabHost.setup(MainActivity.this, getSupportFragmentManager(), R.id.realtabcontent);
        //判断sdk版本，当sdk大于10，其实是没有必要的
        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }
        //初始化FragmentTabHost
        initTabs();

        // 中间按键图片触发
        ivQuickOption.setOnClickListener(this);

        mTabHost.setCurrentTab(0);
        mTabHost.setOnTabChangedListener(this);
    }

    private void initTabs() {
        MainTab[] tabs = MainTab.values();
        final int size = tabs.length;
        Log.d(TAG, "Tab的个数为" + size);
        for (int i = 0; i < size; i++) {
            MainTab mainTab = tabs[i];
            TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()));
            View indicator = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            Drawable drawable = this.getResources().getDrawable(mainTab.getResIcon());
            title.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
            if (i == 1) {
                indicator.setVisibility(View.INVISIBLE);
                mTabHost.setNoTabChangedTag(getString(mainTab.getResName()));
            }
            title.setText(getString(mainTab.getResName()));
            tab.setIndicator(indicator);
            tab.setContent(new TabContentFactory() {
                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });
            mTabHost.addTab(tab, mainTab.getCls(), null);

            mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_quick_option) {
            QuickOptionDialogFragment quickQuickOptionDialogFragment = new QuickOptionDialogFragment();
            quickQuickOptionDialogFragment.show(getSupportFragmentManager(), "QuickOptionDialogFragment");
        }

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onTabChanged(String tabId) {

    }
}
