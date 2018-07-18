package com.shingxj.richemojitext.listener;

import android.view.View;

/**
 * @Author: ShingXJ
 * @Date: 2018/7/17
 * url被点击的回掉
 */

public interface SpanUrlCallBack {
    void phone(View view, String phone);

    void url(View view, String url);
}
