package cn.jianke.baseadapterdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.List;
import cn.jianke.baseadapterdemo.R;
import cn.jianke.baseadapterdemo.model.MsgModel;
import cn.jianke.baseadapterdemo.utils.ImageLoader;
import cn.jianke.baseadapterdemo.utils.StringUtil;

/**
 * @className: MsgAdapter
 * @classDescription: 消息适配器
 * @author: leibing
 * @createTime: 2017/1/6
 */

public class MsgAdapter extends BaseAdapter{
    // 布局
    private LayoutInflater mLayoutInflater;
    // 数据源
    private List<MsgModel> mData;
    // context weak ref
    private WeakReference<Context> mContextWeakRef;

    /**
     * Constructor
     * @author leibing
     * @createTime 2017/1/6
     * @lastModify 2017/1/6
     * @param context 上下文
     * @param mData 数据源
     * @return
     */
    public MsgAdapter(Context context, List<MsgModel> mData){
        mLayoutInflater = LayoutInflater.from(context);
        this.mData = mData;
        // init context weak ref
        mContextWeakRef = new WeakReference<Context>(context);
    }

    @Override
    public int getCount() {
        return mData != null?mData.size():0;
    }

    @Override
    public Object getItem(int i) {
        return mData != null?mData.get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = mLayoutInflater.inflate(R.layout.layout_lv, null);
            holder = new ViewHolder(view, mContextWeakRef);
            view.setTag(holder);
        }else {
            holder =(ViewHolder) view.getTag();
        }

        // updateUI
        if (mData != null
                && mData.size() != 0
                && i < mData.size()){
            holder.updateUI(mData.get(i));
        }

        return view;
    }

    /**
     * 更新数据源
     * @author leibing
     * @createTime 2017/1/6
     * @lastModify 2017/1/6
     * @param mData 数据源
     * @return
     */
    public void setData(List<MsgModel> mData){
        this.mData = mData;
        MsgAdapter.this.notifyDataSetChanged();
    }
    
    /**
     * @interfaceName: ViewHolder
     * @interfaceDescription: 视图容器
     * @author: leibing
     * @createTime: 2017/1/6
     */
    static class ViewHolder{
        // context weak ref
        private WeakReference<Context> mContextWeakRef;
        // 布局一
        private RelativeLayout oneTypeRly;
        private ImageView oneTypeIv;
        private TextView oneTypeContentTv;
        private TextView oneTypeSystematicnameTv;
        // 布局二
        private LinearLayout twoTypeLy;
        private TextView twoTypeContentTv;
        private TextView twoTypeSystematicnameTv;
        private TextView twoTypeViewcoutTv;
        // 布局三
        private LinearLayout threeTypeLy;
        private TextView threeTypeContentTv;
        private ImageView moreOneIv;
        private ImageView moreTwoIv;
        private ImageView moreThreeIv;
        private TextView threeTypeSystematicnameTv;
        private TextView threeTypeViewcoutTv;
        // 布局四
        private RelativeLayout fourTypeRly;
        private ImageView rightPicIv;
        private TextView fourTypeContentTv;
        private TextView fourTypeSystematicnameTv;
        private TextView fourTypeViewcoutTv;

        /**
         * Constructor
         * @author leibing
         * @createTime 2017/1/6
         * @lastModify 2017/1/6
         * @param view
         * @return
         */
        public ViewHolder(View view,WeakReference<Context> mContextWeakRef){
            // init context weak ref
            this.mContextWeakRef = mContextWeakRef;
            // 布局一
            oneTypeRly = (RelativeLayout) view.findViewById(R.id.rly_one_type);
            oneTypeIv = (ImageView) view.findViewById(R.id.iv_one_type);
            oneTypeContentTv = (TextView) view.findViewById(R.id.tv_one_type_content);
            oneTypeSystematicnameTv = (TextView) view.findViewById(R.id.tv_one_type_systematicname);
            // 布局二
            twoTypeLy = (LinearLayout) view.findViewById(R.id.ly_two_type);
            twoTypeContentTv = (TextView) view.findViewById(R.id.tv_two_type_content);
            twoTypeSystematicnameTv = (TextView) view.findViewById(R.id.tv_two_type_systematicname);
            twoTypeViewcoutTv = (TextView) view.findViewById(R.id.tv_two_type_viewcout);
            // 布局三
            threeTypeLy = (LinearLayout) view.findViewById(R.id.ly_three_type);
            threeTypeContentTv = (TextView) view.findViewById(R.id.tv_three_type_content);
            moreOneIv = (ImageView) view.findViewById(R.id.iv_more_one);
            moreTwoIv = (ImageView) view.findViewById(R.id.iv_more_two);
            moreThreeIv = (ImageView) view.findViewById(R.id.iv_more_three);
            threeTypeSystematicnameTv = (TextView) view.findViewById(R.id.tv_three_type_systematicname);
            threeTypeViewcoutTv = (TextView) view.findViewById(R.id.tv_three_type_viewcout);
            // 布局四
            fourTypeRly = (RelativeLayout) view.findViewById(R.id.rly_four_type);
            rightPicIv = (ImageView) view.findViewById(R.id.iv_right_img);
            fourTypeContentTv = (TextView) view.findViewById(R.id.tv_four_type_content);
            fourTypeSystematicnameTv = (TextView) view.findViewById(R.id.tv_four_type_systematicname);
            fourTypeViewcoutTv = (TextView) view.findViewById(R.id.tv_four_type_viewcout);
        }

        /**
         * 显示需要显示的布局
         * @author leibing
         * @createTime 2017/1/6
         * @lastModify 2017/1/6
         * @param layoutType 布局标识
         * @return
         */
        private void whatLayoutCouldShow(int layoutType){
            switch (layoutType){
                case MsgModel.ONE_TYPE:
                    oneTypeRly.setVisibility(View.VISIBLE);
                    twoTypeLy.setVisibility(View.GONE);
                    threeTypeLy.setVisibility(View.GONE);
                    fourTypeRly.setVisibility(View.GONE);
                    break;
                case MsgModel.TWO_TYPE:
                    oneTypeRly.setVisibility(View.GONE);
                    twoTypeLy.setVisibility(View.VISIBLE);
                    threeTypeLy.setVisibility(View.GONE);
                    fourTypeRly.setVisibility(View.GONE);
                    break;
                case MsgModel.THREE_TYPE:
                    oneTypeRly.setVisibility(View.GONE);
                    twoTypeLy.setVisibility(View.GONE);
                    threeTypeLy.setVisibility(View.VISIBLE);
                    fourTypeRly.setVisibility(View.GONE);
                    break;
                case MsgModel.FOUR_TYPE:
                    oneTypeRly.setVisibility(View.GONE);
                    twoTypeLy.setVisibility(View.GONE);
                    threeTypeLy.setVisibility(View.GONE);
                    fourTypeRly.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }

        /**
         * 更新UI
         * @author leibing
         * @createTime 2017/1/6
         * @lastModify 2017/1/6
         * @param msgModel
         * @return
         */
        public void updateUI(MsgModel msgModel){
            try {
                // 显示需要显示的布局
                whatLayoutCouldShow(msgModel.getLayoutType());
                switch (msgModel.getLayoutType()){
                    case MsgModel.ONE_TYPE:
                        // 布局一
                        // 更新大图
                        if (StringUtil.isNotEmpty(msgModel.getLargeImgUrl())
                                && mContextWeakRef != null
                                && mContextWeakRef.get() != null){
                            try {
                                ImageLoader.getInstance().load(mContextWeakRef.get(),
                                        oneTypeIv,
                                        msgModel.getLargeImgUrl());
                            }catch (Exception ex){
                            }
                        }
                        // 更新布局一内容
                        if (StringUtil.isNotEmpty(msgModel.getOneContent())){
                            oneTypeContentTv.setText(msgModel.getOneContent());
                        }
                        // 更新布局一分类名称
                        if (StringUtil.isNotEmpty(msgModel.getOneSystematicName())){
                            oneTypeSystematicnameTv.setText(msgModel.getOneSystematicName());
                        }
                        break;
                    case MsgModel.TWO_TYPE:
                        // 布局二
                        // 更新布局二内容
                        if (StringUtil.isNotEmpty(msgModel.getTwoContent())){
                           twoTypeContentTv.setText(msgModel.getTwoContent());
                        }
                        // 更新布局二分类名称
                        if (StringUtil.isNotEmpty(msgModel.getTwoSystematicName())){
                            twoTypeSystematicnameTv.setText(msgModel.getTwoSystematicName());
                        }
                        // 更新布局二浏览次数
                        if (msgModel.getTwoViewCount() != 0){
                            twoTypeViewcoutTv.setText(msgModel.getTwoViewCount() + "次");
                        }
                        break;
                    case MsgModel.THREE_TYPE:
                        // 布局三
                        // 更新布局三内容
                        if (StringUtil.isNotEmpty(msgModel.getThreeContent())){
                            threeTypeContentTv.setText(msgModel.getThreeContent());
                        }
                        // 更新布局三分类名称
                        if (StringUtil.isNotEmpty(msgModel.getThreeSystematicName())){
                            threeTypeSystematicnameTv.setText(msgModel.getThreeSystematicName());
                        }
                        // 更新布局三浏览次数
                        if (msgModel.getThreeViewCount() != 0){
                            threeTypeViewcoutTv.setText(msgModel.getThreeViewCount() + "次");
                        }
                        // 更新布局三多图
                        if (msgModel.getMoreImgUrlList() != null
                                && msgModel.getMoreImgUrlList().size() != 0){
                            switch (msgModel.getMoreImgUrlList().size()){
                                case 1:
                                    moreOneIv.setVisibility(View.VISIBLE);
                                    // 图一
                                    if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(0))
                                            && mContextWeakRef != null
                                            && mContextWeakRef.get() != null){
                                        try {
                                            ImageLoader.getInstance().load(mContextWeakRef.get(),
                                                    moreOneIv,
                                                    msgModel.getMoreImgUrlList().get(0));
                                        }catch (Exception ex){
                                        }
                                    }
                                    break;
                                case 2:
                                    moreOneIv.setVisibility(View.VISIBLE);
                                    moreTwoIv.setVisibility(View.VISIBLE);
                                    // 图一
                                    if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(0))
                                            && mContextWeakRef != null
                                            && mContextWeakRef.get() != null){
                                        try {
                                            ImageLoader.getInstance().load(mContextWeakRef.get(),
                                                    moreOneIv,
                                                    msgModel.getMoreImgUrlList().get(0));
                                        }catch (Exception ex){
                                        }
                                    }
                                    // 图二
                                    if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(1))
                                            && mContextWeakRef != null
                                            && mContextWeakRef.get() != null){
                                        try {
                                            ImageLoader.getInstance().load(mContextWeakRef.get(),
                                                    moreTwoIv,
                                                    msgModel.getMoreImgUrlList().get(1));
                                        }catch (Exception ex){
                                        }
                                    }
                                    break;
                                case 3:
                                    moreOneIv.setVisibility(View.VISIBLE);
                                    moreTwoIv.setVisibility(View.VISIBLE);
                                    moreThreeIv.setVisibility(View.VISIBLE);
                                    // 图一
                                    if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(0))
                                            && mContextWeakRef != null
                                            && mContextWeakRef.get() != null){
                                        try {
                                            ImageLoader.getInstance().load(mContextWeakRef.get(),
                                                    moreOneIv,
                                                    msgModel.getMoreImgUrlList().get(0));
                                        }catch (Exception ex){
                                        }
                                    }
                                    // 图二
                                    if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(1))
                                            && mContextWeakRef != null
                                            && mContextWeakRef.get() != null){
                                        try {
                                            ImageLoader.getInstance().load(mContextWeakRef.get(),
                                                    moreTwoIv,
                                                    msgModel.getMoreImgUrlList().get(1));
                                        }catch (Exception ex){
                                        }
                                    }
                                    // 图三
                                    if (StringUtil.isNotEmpty(msgModel.getMoreImgUrlList().get(2))
                                            && mContextWeakRef != null
                                            && mContextWeakRef.get() != null){
                                        try {
                                            ImageLoader.getInstance().load(mContextWeakRef.get(),
                                                    moreThreeIv,
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
                           fourTypeContentTv.setText(msgModel.getFourContent());
                        }
                        // 更新布局四分类名称
                        if (StringUtil.isNotEmpty(msgModel.getFourSystematicName())){
                            fourTypeSystematicnameTv.setText(msgModel.getFourSystematicName());
                        }
                        // 更新布局四浏览次数
                        if (msgModel.getFourViewCount() != 0){
                            fourTypeViewcoutTv.setText(msgModel.getFourViewCount() + "次");
                        }
                        // 更新右图
                        if (StringUtil.isNotEmpty(msgModel.getFourRightImgURl())
                                && mContextWeakRef != null
                                && mContextWeakRef.get() != null){
                            try {
                                ImageLoader.getInstance().load(mContextWeakRef.get(),
                                        rightPicIv,
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
    }
}
