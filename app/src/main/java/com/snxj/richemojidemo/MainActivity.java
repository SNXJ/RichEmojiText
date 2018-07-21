package com.snxj.richemojidemo;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shingxj.richemojitext.DisplayUtil;
import com.shingxj.richemojitext.EmojiLayout;
import com.shingxj.richemojitext.KeyBoardLockLayout;
import com.shingxj.richemojitext.RichEditBuilder;
import com.shingxj.richemojitext.RichEditText;
import com.shingxj.richemojitext.RichTextView;
import com.shingxj.richemojitext.SmileUtils;
import com.shingxj.richemojitext.listener.OnEditTextUtilJumpListener;
import com.shingxj.richemojitext.listener.SpanTopicCallBack;
import com.shingxj.richemojitext.model.TopicModel;
import com.shingxj.richemojitext.model.UserModel;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.rich_text_view)
    RichTextView richTextView;

    public int REQUEST_CODE_CHOOSE_PIC = 1111;//选择相册
    public int REQUEST_CODE_CHOOSE_TYPE = 2222;//选择品种
    public int REQUEST_CODE_CHOOSE_TYPE_111 = 2211;//选择品种
    public int REQUEST_CODE_CHOOSE_USER = 3333;//@用户
    public int REQUEST_CODE_CHOOSE_USER_111 = 3311;//@用户
    public static String DATA_TYPE = "DATA_TYPE";//

    List<TopicModel> topicModels = new ArrayList<>();

    List<UserModel> nameList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SmileUtils.initPatternAll(this);//setContentView() 之前初始化
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initRichEmoji();
        initRichText();
        initRichEditText();

    }


    private void initRichEmoji() {
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


    private void initRichText() {
        //temp data
        String strRich = "测试数据，#话题 @用户 表情[嘻嘻][哈哈]#测试 @测试 ";
        UserModel userModel = new UserModel();
        userModel.setUser_name("用户");
        nameList.add(userModel);
        TopicModel topicModel = new TopicModel();
        topicModel.setTopicName("话题");
        topicModels.add(topicModel);


        SpanTopicCallBack spanTopicCallBack = new SpanTopicCallBack() {
            @Override
            public void onClick(View view, TopicModel topicModel) {
                //do somthing CallBack

                if (view instanceof TextView) {
                    ((TextView) view).setHighlightColor(Color.TRANSPARENT);
                }
            }
        };
        //直接使用RichTextView
        richTextView.setAtColor(Color.RED);
        richTextView.setTopicColor(Color.BLUE);
        richTextView.setLinkColor(Color.YELLOW);
        richTextView.setNeedNumberShow(false);
        richTextView.setNeedUrlShow(false);
        richTextView.setEmojiSize(DisplayUtil.dip2px(this, 20));
        richTextView.setSpanAtUserCallBackListener(null);
        richTextView.setSpanTopicCallBackListener(spanTopicCallBack);
        richTextView.setSpanUrlCallBackListener(null);

        richTextView.setRichText(strRich, nameList, topicModels);

    }

    private void showEmoji() {
        if (emojiLayout.getVisibility() != View.VISIBLE) {
            keyboardLayout.showBottomViewLockHeight();
        } else {
            keyboardLayout.hideBottomViewLockHeight();
        }
    }

    private void initRichEditText() {
        emojiLayout.setEditTextSmile(richEditText);
        RichEditBuilder richEditBuilder = new RichEditBuilder();
        richEditBuilder.setEditText(richEditText)
                .setTopicModels(topicModels)
                .setUserModels(nameList)
                .setColorAtUser("#F04C40")
                .setColorTopic("#0000FF")
                .setEditTextAtUtilJumpListener(new OnEditTextUtilJumpListener() {
                    @Override
                    public void notifyAt() {
                        goActivityResult(MainActivity.this, UserActivity.class, REQUEST_CODE_CHOOSE_USER_111);

                    }

                    @Override
                    public void notifyTopic() {
                        goActivityResult(MainActivity.this, TopicActivity.class, REQUEST_CODE_CHOOSE_TYPE_111);
                    }
                })
                .builder();


    }

    public static void goActivityResult(Activity activity, Class<?> toActivityClass, int code) {
        Intent intent = new Intent(activity, toActivityClass);
        activity.startActivityForResult(intent, code);

    }

    @OnClick({R.id.im_pic, R.id.ll_pic, R.id.ll_type, R.id.ll_user, R.id.ll_emoji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_pic://用的Matisse 没写
                break;
            case R.id.ll_pic:
                break;
            case R.id.ll_type:
                goActivityResult(this, TopicActivity.class, REQUEST_CODE_CHOOSE_TYPE);
                break;
            case R.id.ll_user:
                goActivityResult(this, UserActivity.class, REQUEST_CODE_CHOOSE_USER);
                break;
            case R.id.ll_emoji:
                showEmoji();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            if (requestCode == REQUEST_CODE_CHOOSE_PIC) {//图片

//                mSelected = Matisse.obtainResult(data);
//                Log.d("Matisse", "mSelected: " + mSelected);
//                imPic.setVisibility(View.VISIBLE);
//                imgPath = Matisse.obtainPathResult(data);
//                Glide.with(this).load(mSelected.get(0)).into(imPic);

            } else if (requestCode == REQUEST_CODE_CHOOSE_TYPE) {
                TopicModel typeData = (TopicModel) data.getSerializableExtra(DATA_TYPE);

                richEditText.resolveTopicResult(typeData);


            } else if (requestCode == REQUEST_CODE_CHOOSE_TYPE_111) {
                TopicModel typeData = (TopicModel) data.getSerializableExtra(DATA_TYPE);
                richEditText.resolveTopicResultByEnter(typeData);


            } else if (requestCode == REQUEST_CODE_CHOOSE_USER) {
                UserModel userData = (UserModel) data.getSerializableExtra(DATA_TYPE);
                richEditText.resolveAtResult(userData);

            } else if (requestCode == REQUEST_CODE_CHOOSE_USER_111) {
                UserModel userData = (UserModel) data.getSerializableExtra(DATA_TYPE);
                richEditText.resolveAtResultByEnterAt(userData);

            }

        }

    }

}
