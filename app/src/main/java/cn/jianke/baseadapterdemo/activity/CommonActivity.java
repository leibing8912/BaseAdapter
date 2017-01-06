package cn.jianke.baseadapterdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import cn.jianke.baseadapterdemo.R;
import cn.jianke.baseadapterdemo.adapter.MsgAdapter;
import cn.jianke.baseadapterdemo.model.MsgModel;

/**
 * @className: CommonActivity
 * @classDescription: 通用listview统一列表页面
 * @author: leibing
 * @createTime: 2017/1/6
 */
public class CommonActivity extends AppCompatActivity {
    // ListView
    private ListView mListView;
    // 适配器
    private MsgAdapter mMsgAdapter;
    // 数据源
    private List<MsgModel> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findView
        mListView = (ListView) findViewById(R.id.ly_base);
        // set adapter
        mMsgAdapter = new MsgAdapter(this, mData);
        mListView.setAdapter(mMsgAdapter);
        // init data
        initData();
        // update adapter
        mMsgAdapter.setData(mData);
    }

    /**
     * init data
     * @author leibing
     * @createTime 2017/1/6
     * @lastModify 2017/1/6
     * @param
     * @return
     */
    private void initData() {
        // init data
        mData = new ArrayList<>();
        // 模拟数据
        // 添加布局一数据
        MsgModel msgModel = new MsgModel();
        msgModel.setLayoutType(MsgModel.ONE_TYPE);
        msgModel.setLargeImgUrl("http://a.hiphotos.baidu.com/image/pic/item/359b033b5bb5c9ea9d26fbe4d739b6003bf3b3e4.jpg");
        msgModel.setOneContent("布局一:美女美女美女美女");
        msgModel.setOneSystematicName("布局一");
        mData.add(msgModel);

        // 添加布局二数据
        msgModel = new MsgModel();
        msgModel.setLayoutType(MsgModel.TWO_TYPE);
        msgModel.setTwoContent("测试实打实的撒旦撒大声大声道是");
        msgModel.setTwoSystematicName("布局二");
        msgModel.setTwoViewCount(2332);
        mData.add(msgModel);

        // 添加布局三数据
        msgModel = new MsgModel();
        msgModel.setLayoutType(MsgModel.THREE_TYPE);
        msgModel.setThreeContent("是第三方士大夫第三方对方水电费");
        msgModel.setThreeSystematicName("布局三");
        ArrayList<String> picUrlList = new ArrayList<>();
        picUrlList.add("http://e.hiphotos.baidu.com/image/pic/item/a8773912b31bb0511c96a229347adab44aede005.jpg");
        picUrlList.add("http://e.hiphotos.baidu.com/image/pic/item/d000baa1cd11728bbb297122cafcc3cec3fd2cae.jpg");
        picUrlList.add("http://g.hiphotos.baidu.com/image/pic/item/ca1349540923dd54d80b8017d309b3de9c824850.jpg");
        msgModel.setMoreImgUrlList(picUrlList);
        mData.add(msgModel);

        // 添加布局四数据
        msgModel = new MsgModel();
        msgModel.setLayoutType(MsgModel.FOUR_TYPE);
        msgModel.setFourContent("所得税的实打实的三大");
        msgModel.setFourSystematicName("布局四");
        msgModel.setFourViewCount(4545);
        msgModel.setFourRightImgURl("http://e.hiphotos.baidu.com/image/pic/item/622762d0f703918ff453d0ce533d269759eec430.jpg");
        mData.add(msgModel);
    }
}
