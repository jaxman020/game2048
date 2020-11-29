package com.example.game2048

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout

class game2048 : GridLayout {
    /**
     * 移动之前时的model
     */
    private lateinit var beforeModel: Array<IntArray>

    constructor(ctx: Context?) : this(ctx, null)
    constructor(ctx: Context?, attrs: AttributeSet?) : this(ctx, attrs, 0)
    constructor(ctx: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr) {

    }
}