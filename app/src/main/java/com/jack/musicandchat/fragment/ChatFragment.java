package com.jack.musicandchat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jack.musicandchat.R;
import com.jack.musicandchat.base.BaseFragment;

/**
 * author:S.jack
 * data:2015-10-12 14:20
 */
public class ChatFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_chat, null);
        return view;
    }
}
