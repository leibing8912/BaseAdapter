package cn.jianke.baseadapterdemo.model;

import java.util.ArrayList;

/**
 * @className: MsgModel
 * @classDescription: 消息实体
 * @author: leibing
 * @createTime: 2017/1/6
 */

public class MsgModel {
    // 布局类型标识（布局一）
    public final static int ONE_TYPE = 1;
    // 布局类型标识（布局二）
    public final static int TWO_TYPE = 2;
    // 布局类型标识（布局三）
    public final static int THREE_TYPE = 3;
    // 布局类型标识（布局四）
    public final static int FOUR_TYPE = 4;

    // 布局类型
    private int layoutType;

    // 布局一
    // 大图url地址
    private String largeImgUrl = "";
    // 内容
    private String oneContent = "";
    // 分类名称
    private String oneSystematicName = "";

    // 布局二
    // 内容
    private String twoContent = "";
    // 分类名称
    private String twoSystematicName = "";
    // 浏览次数
    private int twoViewCount;

    // 布局三
    // 内容
    private String threeContent = "";
    // 分类名称
    private String threeSystematicName = "";
    // 多图url集合
    private ArrayList<String> moreImgUrlList;
    // 浏览次数
    private int threeViewCount;

    // 布局四
    // 内容
    private String fourContent = "";
    // 分类名称
    private String fourSystematicName = "";
    // 右图url
    private String fourRightImgURl = "";
    // 浏览次数
    private int fourViewCount;

    // set and get
    public String getLargeImgUrl() {
        return largeImgUrl;
    }

    public void setLargeImgUrl(String largeImgUrl) {
        this.largeImgUrl = largeImgUrl;
    }

    public int getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

    public String getOneContent() {
        return oneContent;
    }

    public void setOneContent(String oneContent) {
        this.oneContent = oneContent;
    }

    public String getTwoContent() {
        return twoContent;
    }

    public void setTwoContent(String twoContent) {
        this.twoContent = twoContent;
    }

    public String getOneSystematicName() {
        return oneSystematicName;
    }

    public void setOneSystematicName(String oneSystematicName) {
        this.oneSystematicName = oneSystematicName;
    }

    public String getTwoSystematicName() {
        return twoSystematicName;
    }

    public void setTwoSystematicName(String twoSystematicName) {
        this.twoSystematicName = twoSystematicName;
    }

    public int getTwoViewCount() {
        return twoViewCount;
    }

    public void setTwoViewCount(int twoViewCount) {
        this.twoViewCount = twoViewCount;
    }

    public String getThreeContent() {
        return threeContent;
    }

    public void setThreeContent(String threeContent) {
        this.threeContent = threeContent;
    }

    public String getThreeSystematicName() {
        return threeSystematicName;
    }

    public void setThreeSystematicName(String threeSystematicName) {
        this.threeSystematicName = threeSystematicName;
    }

    public ArrayList<String> getMoreImgUrlList() {
        return moreImgUrlList;
    }

    public void setMoreImgUrlList(ArrayList<String> moreImgUrlList) {
        this.moreImgUrlList = moreImgUrlList;
    }

    public int getThreeViewCount() {
        return threeViewCount;
    }

    public void setThreeViewCount(int threeViewCount) {
        this.threeViewCount = threeViewCount;
    }

    public String getFourContent() {
        return fourContent;
    }

    public void setFourContent(String fourContent) {
        this.fourContent = fourContent;
    }

    public String getFourSystematicName() {
        return fourSystematicName;
    }

    public void setFourSystematicName(String fourSystematicName) {
        this.fourSystematicName = fourSystematicName;
    }

    public String getFourRightImgURl() {
        return fourRightImgURl;
    }

    public void setFourRightImgURl(String fourRightImgURl) {
        this.fourRightImgURl = fourRightImgURl;
    }

    public int getFourViewCount() {
        return fourViewCount;
    }

    public void setFourViewCount(int fourViewCount) {
        this.fourViewCount = fourViewCount;
    }
}
