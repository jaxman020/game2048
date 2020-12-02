package com.example.game2048.adapters

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.game2048.R
import com.example.game2048.models.Card


class CardAdapter(private var context: Context, private var cards: ArrayList<Card>): BaseAdapter() {
    private lateinit var num: TextView

    override fun getCount(): Int {
        return cards.size
    }
    override fun getItem(position: Int): Any? {
        return null
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View? {
        var view = View.inflate(context, R.layout.cardview, null)
        num = view.findViewById(R.id.num)
        num.text = cards[position].num.toString()

        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        num.getLayoutParams().height = width / 4
//        num.getLayoutParams().width = width / 4

        return view
    }


}
