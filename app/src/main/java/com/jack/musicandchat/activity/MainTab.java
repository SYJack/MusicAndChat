package com.jack.musicandchat.activity;

import com.jack.musicandchat.R;
import com.jack.musicandchat.fragment.ChatFragment;
import com.jack.musicandchat.fragment.MusicFragment;

/**
 * enum：枚举
 * author:S.jack
 * data:2015-10-12 12:25
 */
public enum MainTab {
    MUSIC(0, R.string.main_tab_name_music, R.drawable.tab_icon_music, MusicFragment.class),

    QUICK(1, R.string.main_tab_name_quick, R.drawable.tab_icon_quick, null),

    CHAT(2, R.string.main_tab_name_chat, R.drawable.tab_icon_chat, ChatFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> cls;

    private MainTab(int idx, int resName, int resIcon, Class<?> cls) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.cls = cls;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }
}
