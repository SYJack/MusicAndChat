package com.jack.musicandchat.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.jack.musicandchat.interf.BaseViewInterface;

import butterknife.ButterKnife;

/**
 * author:S.jack
 * data:2015-10-10 20:52
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, BaseViewInterface {

    private LayoutInflater mInflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeSetContentLayout();
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mInflater = getLayoutInflater();
        //通过注解绑定控件
        ButterKnife.inject(this);
        init(savedInstanceState);
        initView();
        initData();
    }

    protected void init(Bundle savedInstanceState) {
    }

    protected void onBeforeSetContentLayout() {
    }

    protected int getLayoutId() {
        return 0;
    }

    protected View inflateView(int resId) {
        return mInflater.inflate(resId, null);
    }
}
