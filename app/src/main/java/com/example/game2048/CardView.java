package com.example.game2048;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CardView extends FrameLayout {

    // 卡片数量
    private int num = 0;
    // 卡片文字
    private TextView tv_num;

    public CardView(Context context) {
        super(context);
        // 初始化TextView
        tv_num = new TextView(getContext());
        // 卡片文字大小
        tv_num.setTextSize(20);
        // 布局控制器，填充满整个父容器
        LayoutParams lp = new LayoutParams(-1, -1);
        addView(tv_num, lp);

        setNum(0);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;

        // 要呈现出来的文字（这里要注意是String类型的）
        tv_num.setText(num + "");
    }

    // 两卡片相同的比较方法
    public boolean equals(CardView card) {

        return getNum() == card.getNum();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // TODO Auto-generated method stub
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
