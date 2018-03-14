package com.ufo.stickitemdecoration;

/**
 * 日期:2018/3/12
 * <p>
 * 作者:xudiwei
 * <p>
 * 描述:
 */
public class DataBean {

    private String data;
    private boolean isShowLable;
    private String spell;

    public DataBean(String data, boolean isShowLable, String spell) {
        this.data = data;
        this.isShowLable = isShowLable;
        this.spell = spell;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isShowLable() {
        return isShowLable;
    }

    public void setShowLable(boolean showLable) {
        isShowLable = showLable;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }
}
