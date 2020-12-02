package com.example.game2048

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.game2048.adapters.CardAdapter
import com.example.game2048.models.Card
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {
    private lateinit var gridView : GridView
    private var rowCounts by Delegates.notNull<Int>()
    private var columnCounts by Delegates.notNull<Int>()
    private lateinit var game : ArrayList<Card>
    private lateinit var cardAdapter : CardAdapter


    private var x1 = 0.0f
    /*
     *   點擊事件起始點Y
     */
    private var y1 = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        rowCounts = 4
        columnCounts = 4
        gridView = findViewById<GridView>(R.id.gridView)
        gridView.numColumns = columnCounts

//        val cardWidth = gridView.width/columnCounts
        game = addCard()

        cardAdapter = CardAdapter(this, game)
        gridView.adapter = cardAdapter

        gridView.setOnTouchListener { v: View, event: MotionEvent ->
            tochEvent(event)
        }
    }

    fun tochEvent(event: MotionEvent): Boolean {
        var iRet = true
        when (event.action) {
            // when user first touches the screen we get x and y coordinate
            MotionEvent.ACTION_DOWN -> {
                x1 = event.x
                y1 = event.y
            }
            MotionEvent.ACTION_UP -> {
                val x2 = event.x
                val y2 = event.y
                val minDistance = 200

                if (x1 < x2 && x2 - x1 > minDistance)
                    actionMove("R")
                else if (x1 > x2 && x1 - x2 > minDistance)
                    actionMove("L")
                else if (y1 < y2 && y2 - y1 > minDistance)
                    actionMove("D")
                else if (y1 > y2 && y1 - y2 > minDistance)
                    actionMove("U")
                else
                    iRet = false
            }
        }
        return iRet
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        tochEvent(event)
        return super.onTouchEvent(event)
    }

    private fun actionMove(direction: String){
        when (direction) {
            "R" ->
                Toast.makeText(this, "R", Toast.LENGTH_SHORT).show()
            "L" ->
                Toast.makeText(this, "L", Toast.LENGTH_SHORT).show()
            "U" ->
                Toast.makeText(this, "U", Toast.LENGTH_SHORT).show()
            "D" ->
                Toast.makeText(this, "D", Toast.LENGTH_SHORT).show()
            else ->
                Toast.makeText(this, "none", Toast.LENGTH_SHORT).show()

        }
    }

    // 添加卡片,参数为卡片的宽高，因为他是正方形，所以宽高都是cardWidth
    private fun addCard() : ArrayList<Card>{
        // 创建方块
        var list = ArrayList<Card>()
        // 循环添加
        for (i in 0..rowCounts-1) {
            for (j in 0..columnCounts-1) {

                list.add(Card(0))
//                gridView.addView(c, cardWidth, cardHeight)
            }
        }
        return list
    }
    // 随机数
//    private fun addRandom() {
//        // 我们新建一个lsit存放空的方块，操作之前清空
//        point.clear()
//        // 对所有的位置进行遍历
//        for (i in 0..3) {
//            for (j in 0..3) {
//                // 空方块才可以添加数字，有值我们就不添加
//                if (cards.get(j).get(i).getNum() <= 0) {
//                    point.add(Point(j, i))
//                }
//            }
//        }
//        // for循环走完之后我们要取方块
//        val p: Point = point.remove((Math.random() * point.size()) as Int)
//        // 我们用Math.random()返回一个0-1的数，当大于0.1的时候是2否则就是4，也就是4出现的概率为十分之一
//        cards.get(p.x).get(p.y).setNum(if (Math.random() > 0.1) 2 else 4)
//    }
}
