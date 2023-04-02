package com.example.viewpagerwithindicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    private  lateinit var iv1:ImageView
    private  lateinit var iv2:ImageView
    private  lateinit var iv3:ImageView

    private  lateinit var viewPager2: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2=findViewById(R.id.view_pager2)
        iv1=findViewById(R.id.iv1)
        iv2=findViewById(R.id.iv2)
        iv3=findViewById(R.id.iv3)

        val images = listOf(R.drawable.dog,R.drawable.chair_1840011_640, R.drawable.sherk)
        val adapter=ViewPagerAdapter(images)
        viewPager2.adapter=adapter

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                changeColor()
            }

        })
    }
    fun changeColor(){
        when(viewPager2.currentItem){
            0 -> {
                iv1.setImageResource(R.drawable.ic_selected_dot)
                iv2.setImageResource(R.drawable.ic_unselected_dot)
                iv3.setImageResource(R.drawable.ic_unselected_dot)
            }
            1 -> {
                iv1.setImageResource(R.drawable.ic_unselected_dot)
                iv2.setImageResource(R.drawable.ic_selected_dot)
                iv3.setImageResource(R.drawable.ic_unselected_dot)
            }
            2 -> {
                iv1.setImageResource(R.drawable.ic_unselected_dot)
                iv2.setImageResource(R.drawable.ic_unselected_dot)
                iv3.setImageResource(R.drawable.ic_selected_dot)
            }

        }
    }
}