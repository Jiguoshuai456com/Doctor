package com.wd.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;
import com.wd.main.adapter.RlvAdapter;

import butterknife.BindView;

@Route(path = "/homepage/HomePageActivity")
public class CeActivity extends BaseActivity {

    @BindView(R2.id.main_rlv)
    RecyclerView mainRlv;
    private RlvAdapter rlvAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_ce;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);

        mainRlv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void initData() {

        rlvAdapter = new RlvAdapter(this);

        mainRlv.setAdapter(rlvAdapter);
    }
}
