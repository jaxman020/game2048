package com.example.game2048

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class CardAdapter(private var context: Context, private var cards: MutableList<CardView>): BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var textView: TextView
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
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.cardview, null)
        }
        textView = convertView!!.findViewById(R.id.num)

        textView.text = cards[position].num.toString()
        return convertView
    }


}
