package com.jack.musicandchat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.jack.musicandchat.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * author:S.jack
 * data:2015-10-20 22:18
 */
public class QuickOptionDialogFragment extends DialogFragment implements View.OnClickListener {


    @InjectView(R.id.tv_quick_content_location)
    View tvQuickContentLocation;

    @InjectView(R.id.tv_quick_content_android)
    View tvQuickContentAndroid;

    @InjectView(R.id.tv_quick_content_zhihujingxuan)
    View tvQuickContentZhihujingxuan;

    @InjectView(R.id.tv_quick_content_douban)
    View tvQuickContentDouban;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.dialog_quick_option, container);
        ButterKnife.inject(this, view);

        //设置宽度为屏宽,靠近屏幕底部

        initView();
        return view;

    }

    private void initView() {
        tvQuickContentLocation.setOnClickListener(this);
        tvQuickContentAndroid.setOnClickListener(this);
        tvQuickContentZhihujingxuan.setOnClickListener(this);
        tvQuickContentDouban.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_quick_content_location:
                break;
            case R.id.tv_quick_content_android:
                break;
            case R.id.tv_quick_content_zhihujingxuan:
                break;
            case R.id.tv_quick_content_douban:
                break;
            default:
                break;
        }

    }


}
