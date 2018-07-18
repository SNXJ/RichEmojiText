package com.shingxj.richemojitext.listener;

import android.view.View;

import com.shingxj.richemojitext.model.TopicModel;

/**
 * @Author: ShingXJ
 * @Date: 2018/7/17
 * 处理话题的回调
 */

public interface SpanTopicCallBack {
    void onClick(View view, TopicModel topicModel);
}
