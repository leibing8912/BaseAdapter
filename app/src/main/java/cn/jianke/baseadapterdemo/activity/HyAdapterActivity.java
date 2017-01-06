package cn.jianke.baseadapterdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import java.util.ArrayList;
import java.util.List;
import cn.jianke.baseadapterdemo.R;
import cn.jianke.baseadapterdemo.model.MsgModel;
import cn.jianke.baseadapterdemo.utils.ImageLoader;
import cn.jianke.baseadapterdemo.utils.StringUtil;

/**
 * @className: HyAdapterActivity
 * @classDescription: 鸿洋万能适配器列表页面
 * @author: leibing
 * @createTime: 2017/1/6
 */
public class HyAdapterActivity extends Activity {
    // RecyclerView
    private RecyclerView mHyBaseRv;
    // 万能适配器
    private CommonAdapter<MsgModel> mCommonAdapter;
    // 数据源
    private List<MsgModel> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hy_adapter);
        // findView
        mHyBaseRv = (RecyclerView) findViewById(R.id.rv_hy_base);
        // init data
        initData();
        // add layout mananger
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mHyBaseRv.setLayoutManager(mLinearLayoutManager);
        try {
            // init adapter
            mCommonAdapter = new CommonAdapter<MsgModel>(this, R.layout.layout_lv, mData) {
                @Override
                protected void convert(ViewHolder holder, MsgModel msgModel, int position) {
                    updateUI(holder, msgModel);
                }
            };
            // set adapter
            mHyBaseRv.setAdapter(mCommonAdapter);
        }catch (Exception ex){
        }
    }

    /**
     * 更新UI
     * @author leibing
     * @createTime 2017/1/6
     * @lastModify 2017/1/6
     * @param holder
     * @param msgModel
     * @return
     */
    private void updateUI(ViewHolder holder, MsgModel msgModel) {
        try {
            // 显示需要显示的布局
            whatLayoutCouldShow(msgModel.getLayoutType(), holder);
            switch (msgModel.getLayoutType()){
                case MsgModel.ONE_TYPE:
                    // 布局一
                    // 更新大图
                    if (StringUtil.isNotEmpty(msgModel.getLargeImgUrl())){
                        try {
                            ImageLoader.getInstance().load(this,
                                    (ImageView) holder.getView(R.id.iv_one_type),
                                    msgModel.getLargeImgUrl());
                        }catch (Exception ex){
                        }
                    }
                    // 更新布局一内容
                    if (StringUtil.isNotEmpty(msgModel.getOneContent())){
                        holder.setText(R.id.tv_one_type_content, msgModel.getOneContent());
                    }
                    // 更新布局一分类名称
                    if (StringUtil.isNotEmpty(msgModel.getOneSystematicName())){
                        holder.setText(R.id.tv_one_type_systematicname,
                                msgModel.getOneSystematicName());
                    }
                    break;
                case MsgModel.TWO_TYPE:
                    // 布局二
                    // 更新布局二内容
                    if (StringUtil.isNotEmpty(msgModel.getTwoContent())){
                        holder.setText(R.id.tv_two_type_content, msgModel.getTwoContent());
                    }
                    // 更新布局二分类名称
                    if (StringUtil.isNotEmpty(msgModel.getTwoSystematicName())){
                        holder.setText(R.id.tv_two_type_systematicname,
                                msgModel.getTwoSystematicName());
                    }
                    // 更新布局二浏览次数
                    if (msgModel.getTwoViewCount() != 0){
                        holder.setText(R.id.tv_two_type_viewcout,
                                msgModel.getTwoViewCount() + "次");
                    }
                    break;
                case MsgModel.THREE_TYPE:
                    // 布局三
                    // 更新布局三内容
                    if (StringUtil.isNotEmpty(msgModel.getThreeContent())){
                        holder.setText(R.id.tv_three_type_content, msgModel.getThreeContent());
                    }
                    // 更新布局三分类名称
                    if (StringUtil.isNotEmpty(msgModel.getThreeSystematicName())){
                        holder.setText(R.id.tv_three_type_systematicname,
                                msgModel.getThreeSystematicName());
                    }
                    // 更新布局三浏览次数
                    if (msgModel.getThreeViewCount() != 0){
                        holder.setText(R.id.tv_three_type_viewcout,
                                msgModel.getThreeViewCount() + "次");
                    }
                    // 更新布局三多图
                    if (msgModel.getMoreImgUrlList() != null
                            && msgModel.getMoreImgUrlList().size() != 0){
                        switch (msgModel.getMoreImgUrlList().size()){
                            case 1:
                                holder.getView(R.id.iv_more_one).setVisibility(View.VISIBLE);
                                // 图一
                                if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(0))){
                                    try {
                                        ImageLoader.getInstance().load(this,
                                                (ImageView) holder.getView(R.id.iv_more_one),
                                                msgModel.getMoreImgUrlList().get(0));
                                    }catch (Exception ex){
                                    }
                                }
                                break;
                            case 2:
                                holder.getView(R.id.iv_more_one).setVisibility(View.VISIBLE);
                                holder.getView(R.id.iv_more_two).setVisibility(View.VISIBLE);
                                // 图一
                                if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(0))){
                                    try {
                                        ImageLoader.getInstance().load(this,
                                                (ImageView) holder.getView(R.id.iv_more_one),
                                                msgModel.getMoreImgUrlList().get(0));
                                    }catch (Exception ex){
                                    }
                                }
                                // 图二
                                if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(1))){
                                    try {
                                        ImageLoader.getInstance().load(this,
                                                (ImageView) holder.getView(R.id.iv_more_two),
                                                msgModel.getMoreImgUrlList().get(1));
                                    }catch (Exception ex){
                                    }
                                }
                                break;
                            case 3:
                                holder.getView(R.id.iv_more_one).setVisibility(View.VISIBLE);
                                holder.getView(R.id.iv_more_two).setVisibility(View.VISIBLE);
                                holder.getView(R.id.iv_more_three).setVisibility(View.VISIBLE);
                                // 图一
                                if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(0))){
                                    try {
                                        ImageLoader.getInstance().load(this,
                                                (ImageView) holder.getView(R.id.iv_more_one),
                                                msgModel.getMoreImgUrlList().get(0));
                                    }catch (Exception ex){
                                    }
                                }
                                // 图二
                                if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(1))){
                                    try {
                                        ImageLoader.getInstance().load(this,
                                                (ImageView) holder.getView(R.id.iv_more_two),
                                                msgModel.getMoreImgUrlList().get(1));
                                    }catch (Exception ex){
                                    }
                                }
                                // 图三
                                if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(2))){
                                    try {
                                        ImageLoader.getInstance().load(this,
                                                (ImageView) holder.getView(R.id.iv_more_three),
                                                msgModel.getMoreImgUrlList().get(2));
                                    }catch (Exception ex){
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case MsgModel.FOUR_TYPE:
                    // 布局四
                    // 更新布局四内容
                    if (StringUtil.isNotEmpty(msgModel.getFourContent())){
                        holder.setText(R.id.tv_four_type_content, msgModel.getFourContent());
                    }
                    // 更新布局四分类名称
                    if (StringUtil.isNotEmpty(msgModel.getFourSystematicName())){
                        holder.setText(R.id.tv_four_type_systematicname,
                                msgModel.getFourSystematicName());
                    }
                    // 更新布局四浏览次数
                    if (msgModel.getFourViewCount() != 0){
                        holder.setText(R.id.tv_four_type_viewcout,
                                msgModel.getFourViewCount() + "次");
                    }
                    // 更新右图
                    if (StringUtil.isNotEmpty(msgModel.getFourRightImgURl())){
                        try {
                            ImageLoader.getInstance().load(this,
                                    (ImageView) holder.getView(R.id.iv_right_img),
                                    msgModel.getFourRightImgURl());
                        }catch (Exception ex){
                        }
                    }
                    break;
                default:
                    break;
            }
        }catch (Exception ex){
        }
    }

    /**
     * 显示需要显示的布局
     * @author leibing
     * @createTime 2017/1/6
     * @lastModify 2017/1/6
     * @param layoutType 布局标识
     * @return
     */
    private void whatLayoutCouldShow(int layoutType, ViewHolder holder){
        switch (layoutType){
            case MsgModel.ONE_TYPE:
                holder.getView(R.id.rly_one_type).setVisibility(View.VISIBLE);
                holder.getView(R.id.ly_two_type).setVisibility(View.GONE);
                holder.getView(R.id.ly_three_type).setVisibility(View.GONE);
                holder.getView(R.id.rly_four_type).setVisibility(View.GONE);
                break;
            case MsgModel.TWO_TYPE:
                holder.getView(R.id.rly_one_type).setVisibility(View.GONE);
                holder.getView(R.id.ly_two_type).setVisibility(View.VISIBLE);
                holder.getView(R.id.ly_three_type).setVisibility(View.GONE);
                holder.getView(R.id.rly_four_type).setVisibility(View.GONE);
                break;
            case MsgModel.THREE_TYPE:
                holder.getView(R.id.rly_one_type).setVisibility(View.GONE);
                holder.getView(R.id.ly_two_type).setVisibility(View.GONE);
                holder.getView(R.id.ly_three_type).setVisibility(View.VISIBLE);
                holder.getView(R.id.rly_four_type).setVisibility(View.GONE);
                break;
            case MsgModel.FOUR_TYPE:
                holder.getView(R.id.rly_one_type).setVisibility(View.GONE);
                holder.getView(R.id.ly_two_type).setVisibility(View.GONE);
                holder.getView(R.id.ly_three_type).setVisibility(View.GONE);
                holder.getView(R.id.rly_four_type).setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
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
