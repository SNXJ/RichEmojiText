package com.shingxj.richemojitext.listener;

import android.view.View;

import com.shingxj.richemojitext.model.UserModel;


/**
 * @Author: ShingXJ
 * @Date: 2018/7/17
 * 处理@被某人的回调
 */

public interface SpanAtUserCallBack {
    void onClick(View view, UserModel userModel1);
}
