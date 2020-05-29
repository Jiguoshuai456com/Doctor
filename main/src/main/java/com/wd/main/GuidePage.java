package com.wd.main;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.wd.common.Base.BaseActivity;
import com.wd.common.Base.BasePresenter;

import butterknife.BindView;

/**
 * Author:周盟棋
 * Description:
 */

public class GuidePage extends BaseActivity {

    int time = 3;

    @BindView(R2.id.guidepage_tv)
    TextView guidepageTv;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 1){
                if (time>0){
                    guidepageTv.setText(""+time);
                    time--;
                    handler.sendEmptyMessage(1);
                }else {
                    //删除消息
                    handler.removeMessages(1);
                    startActivity(new Intent(GuidePage.this,CeActivity.class));
                    finish();
                }
            }
            return true;
        }
    });

    @Override
    protected int getLayout() {
        return R.layout.guidepage_layout;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        guidepageTv.setText(""+time);
        handler.sendEmptyMessage(1);
    }

}
