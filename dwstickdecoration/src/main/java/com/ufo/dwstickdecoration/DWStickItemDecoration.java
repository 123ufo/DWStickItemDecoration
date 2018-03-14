package com.ufo.dwstickdecoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 日期:2018/3/12
 * <p>
 * 作者:xudiwei
 * <p>
 * 描述: RecyclerView 的StickDecoration
 * 使用方式:
 * <p>
 * StickItemDecoration decoration = new StickItemDecoration(this) {
 *
 * @Override protected boolean isShowItemLabel(int position) {
 * //返回true表示当前Item是要显示标签,否则返回false
 * return mList.get(position).isShowLable();
 * }
 * @Override protected String getItemLabelStr(int position) {
 * //返回标签的文本内容
 * return mList.get(position).getSpell();
 * }
 * };
 * <p>
 * RecyclerView rv = find.......;
 * rv.addItemDecoration(decoration);
 */
public abstract class DWStickItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "StickItemDecoration";
    //默认标签颜色
    private final int DEFAULT_LABEL_COLOR = Color.WHITE;
    //默认标签字体颜色
    private final int DEFAULT_LABEL_TEXT_COLOR = Color.DKGRAY;
    //默认标签字体大小dp
    private final int DEFAULT_LABEL_TEXT_SIZE = 12;
    //默认标签高度dp
    private final int DEFAULT_LABEL_HEIGHT = 30;
    private Context mContext;
    private Rect mRect = new Rect();
    private Paint mPaint = new Paint();

    private int mLabelHeight;
    private int mLabelColor;
    private int mTextSize;
    private int mTextColor;

    /**
     * 构造方法,用此构造方法创建的话.相关的参数都会会初始化一个默认值,当然你还可以调用以下方
     * 法再进行设置相关参数,设置标签颜色{@linkplain #setLabelColor(int)};
     * 设置标签高度{@linkplain #setLabelHeight(int)};
     * 设置标签字体大小单位是像素{@linkplain #setTextSize(int)};
     * 设置标签字体颜色{@linkplain #setTextColor(int)};
     *
     * @param context 上下文
     */
    public DWStickItemDecoration(Context context) {
        mContext = context;
        setTextSize(dpToPx(DEFAULT_LABEL_TEXT_SIZE));
        setLabelColor(DEFAULT_LABEL_COLOR);
        setTextColor(DEFAULT_LABEL_TEXT_COLOR);
        setLabelHeight(dpToPx(DEFAULT_LABEL_HEIGHT));
    }

    /**
     * 用此构造方法创建的对象的话,需要传入相关的参数.
     *
     * @param context     上下文
     * @param labelHeight 标签的高度 dp
     * @param labelColor  标签的颜色 int值
     * @param textSize    标签的字体大小 px
     * @param textColor   标签的字体颜色 int值
     */
    public DWStickItemDecoration(Context context, int labelHeight, int labelColor, int textSize, int textColor) {
        mContext = context;
        setLabelHeight(labelHeight);
        setLabelColor(labelColor);
        setTextSize(textSize);
        setTextColor(textColor);
    }

    /**
     * 设置标签的颜色
     *
     * @param labelColor 颜色的int值
     */
    public void setLabelColor(@ColorInt int labelColor) {
        this.mLabelColor = labelColor;
        mPaint.setColor(labelColor);
    }

    /**
     * 设置标签字体大小
     *
     * @param textSize 像素 px
     */
    public void setTextSize(int textSize) {
        this.mTextSize = textSize;
        mPaint.setTextSize(mTextSize);
        mPaint.setAntiAlias(true);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
    }

    /**
     * 设置标签字体颜色
     *
     * @param textColor 颜色的int值
     */
    public void setTextColor(@ColorInt int textColor) {
        this.mTextColor = textColor;
    }

    /**
     * 设置标签高度
     *
     * @param labelHeight dp
     */
    public void setLabelHeight(int labelHeight) {
        this.mLabelHeight = labelHeight;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int childCount = parent.getChildCount();
        mRect.left = parent.getPaddingLeft();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);

            //画顶部的标签,只有在列表的第一条item的索引为非0,或是第一条item为0但是它的getTop
            //小于0时才需要绘制
            if (i == 0 && (position > 0) || (position == 0 && child.getTop() < 0)) {
                mRect.right = parent.getWidth();
                mRect.top = parent.getTop();
                mRect.bottom = parent.getTop() + mLabelHeight;
                mPaint.setColor(mLabelColor);
                c.drawRect(mRect, mPaint);
                mPaint.setColor(Color.DKGRAY);
                int y = mRect.top + (mLabelHeight / 2);
                int textWidth = (int) mPaint.measureText(getItemLabelStr(position));
                y += textWidth / 2;
                c.drawText(getItemLabelStr(position), mRect.width() / 2, y, mPaint);
            }

        }

    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        mRect.left = parent.getPaddingLeft();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(child);

            //组制每组的标签
            if (isShowItemLabel(position)) {
                mRect.top = child.getTop() - mLabelHeight;
                mRect.bottom = child.getTop();
                mRect.right = child.getRight();
                mPaint.setColor(mLabelColor);
                c.drawRect(mRect, mPaint);
                mPaint.setColor(Color.DKGRAY);
                int y = mRect.top + (mLabelHeight / 2);
                int textWidth = (int) mPaint.measureText(getItemLabelStr(position));
                y += textWidth / 2;
                c.drawText(getItemLabelStr(position), mRect.width() / 2, y, mPaint);
            }

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (isShowItemLabel(position)) {
            outRect.top = mLabelHeight;
        } else {
            outRect.top = 0;
        }
    }

    //dp to px
    private int dpToPx(int dp) {
        return (int) (mContext.getResources().getDisplayMetrics().density * dp);
    }


    /**
     * 是否显示Item的标签
     * 字类必须要复写此方法来说明当前item是否要显示标签
     *
     * @param position 当前item的索引
     */
    protected abstract boolean isShowItemLabel(int position);

    /**
     * 获取标签的字符串
     * 字类必须要复写此方法来返回标签的文本内容
     *
     * @param position 当前item的索引
     */
    protected abstract String getItemLabelStr(int position);


}
