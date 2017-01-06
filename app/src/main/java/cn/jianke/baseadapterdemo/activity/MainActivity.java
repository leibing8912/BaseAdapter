package cn.jianke.baseadapterdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.jianke.baseadapterdemo.R;

/**
 * @className: MainActivity
 * @classDescription: 首页
 * @author: leibing
 * @createTime: 2017/1/6
 */
public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // onClick
        findViewById(R.id.btn_cm_lv).setOnClickListener(this);
        findViewById(R.id.btn_hy_rv).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cm_lv:
                // 通用
                turnToNewPage(CommonActivity.class);
                break;
            case R.id.btn_hy_rv:
                // 鸿洋万能适配
                turnToNewPage(HyAdapterActivity.class);
                break;
            default:
                break;
        }
    }

    /**
     * 跳转页面
     * @author leibing
     * @createTime 2017/1/6
     * @lastModify 2017/1/6
     * @param cls 新页面类
     * @return
     */
    private void turnToNewPage(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
