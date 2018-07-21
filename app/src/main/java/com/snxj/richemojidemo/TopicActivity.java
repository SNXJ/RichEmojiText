package com.snxj.richemojidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.shingxj.richemojitext.model.TopicModel;
import com.snxj.richemojidemo.adapter.TopicAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author: ShingXJ
 * @Date: 2018/7/21
 * @Desc: **
 */
public class TopicActivity extends AppCompatActivity {
    @BindView(R.id.recycle)
    RecyclerView recycle;
    List<TopicModel> userList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        ButterKnife.bind(this);
        initData();
        initRv();
    }

    private void initRv() {
        recycle.setLayoutManager(new LinearLayoutManager(this));
        TopicAdapter adapter = new TopicAdapter(userList);
        recycle.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.DATA_TYPE, (Serializable) adapter.getData().get(position));
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            TopicModel user = new TopicModel();
            user.setTopicName("话题第" + i + "条");
            userList.add(user);
        }


    }
}
