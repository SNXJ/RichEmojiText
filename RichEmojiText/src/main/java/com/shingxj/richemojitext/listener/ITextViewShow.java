package com.shingxj.richemojitext.listener;

import android.content.Context;
import android.text.method.MovementMethod;

import com.shingxj.richemojitext.model.TopicModel;
import com.shingxj.richemojitext.model.UserModel;
import com.shingxj.richemojitext.span.ClickAtUserSpan;
import com.shingxj.richemojitext.span.ClickTopicSpan;
import com.shingxj.richemojitext.span.LinkSpan;


/**
 * @Author: ShingXJ
 * @Date: 2018/7/17
 * textview 显示接口
 */

public interface ITextViewShow {
    void setText(CharSequence charSequence);

    CharSequence getText();

    void setMovementMethod(MovementMethod movementMethod);

    void setAutoLinkMask(int flag);

    ClickAtUserSpan getCustomClickAtUserSpan(Context context, UserModel userModel, int color, SpanAtUserCallBack spanClickCallBack);

    ClickTopicSpan getCustomClickTopicSpan(Context context, TopicModel topicModel, int color, SpanTopicCallBack spanTopicCallBack);

    LinkSpan getCustomLinkSpan(Context context, String url, int color, SpanUrlCallBack spanUrlCallBack);

    int emojiSize();

    int verticalAlignment();
}
