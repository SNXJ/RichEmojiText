package com.snxj.richemojidemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shingxj.richemojitext.EmojiLayout;
import com.shingxj.richemojitext.KeyBoardLockLayout;
import com.shingxj.richemojitext.RichEditText;
import com.shingxj.richemojitext.SmileUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_content)
    RichEditText richEditText;
    @BindView(R.id.im_pic)
    ImageView imPic;
    @BindView(R.id.ll_pic)
    LinearLayout llPic;
    @BindView(R.id.ll_type)
    LinearLayout llType;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.ll_emoji)
    LinearLayout llEmoji;
    @BindView(R.id.ll_type_select)
    LinearLayout llTypeSelect;
    @BindView(R.id.keyboard_layout)
    KeyBoardLockLayout keyboardLayout;
    @BindView(R.id.emoji_layout)
    EmojiLayout emojiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmileUtils.initPatternAll(this);//setContentView() 之前初始化
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        emojiLayout.setEditTextSmile(richEditText);
        keyboardLayout.setBottomView(emojiLayout);
        keyboardLayout.setKeyBoardStateListener(new KeyBoardLockLayout.KeyBoardStateListener() {
            @Override
            public void onState(boolean show) {
                if (show)
                    emojiLayout.showKeyboard();
                else
                    emojiLayout.hideKeyboard();
            }
        });
    }

    @OnClick({R.id.im_pic, R.id.ll_pic, R.id.ll_type, R.id.ll_user, R.id.ll_emoji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_pic:
                break;
            case R.id.ll_pic:
                break;
            case R.id.ll_type:
                break;
            case R.id.ll_user:
                break;
            case R.id.ll_emoji:
                showEmoji();
                break;
        }
    }
    private void showEmoji() {
        if (emojiLayout.getVisibility() != View.VISIBLE) {
            keyboardLayout.showBottomViewLockHeight();
        } else {
            keyboardLayout.hideBottomViewLockHeight();
        }
    }
}
