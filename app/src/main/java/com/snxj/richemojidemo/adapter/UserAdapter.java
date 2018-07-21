package com.snxj.richemojidemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shingxj.richemojitext.model.UserModel;
import com.snxj.richemojidemo.R;

import java.util.List;

/**
 * @Author: ShingXJ
 * @Date: 2018/7/21
 * @Desc: **
 */
public class UserAdapter extends BaseQuickAdapter<UserModel, BaseViewHolder> {
    public UserAdapter(@Nullable List<UserModel> data) {
        super(R.layout.item_recycle, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserModel item) {
        helper.setText(R.id.tv_item, item.getUser_name());

    }
}
