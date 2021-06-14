package com.example.myapplication

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

class MainActivity : AppCompatActivity() {

    private var mImageButtonCurrentPaint: ImageButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingView.setSizeForBrush(20.toFloat())
        mImageButtonCurrentPaint=ll_paint_colors[1] as ImageButton


        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this,R.drawable.pallet_pressed)
        )

        ib_brush.setOnClickListener {
            showBrushSizeChooserDialog()
        }



    }
    private fun showBrushSizeChooserDialog(){
        val brushDialog=Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size:")
        val smallButton=brushDialog.ib_small_brush
        smallButton.setOnClickListener {
            drawingView.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        val mediumButton=brushDialog.ib_medium_brush
        mediumButton.setOnClickListener {
            drawingView.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        val largeBrush=brushDialog.ib_large_brush
        largeBrush.setOnClickListener {
            drawingView.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
        }


    fun paintClicked(view: View){
        if(view!==mImageButtonCurrentPaint){
            val imageButton=view as ImageButton
            val coloTag=imageButton.tag.toString()
            drawingView.setColor(coloTag)
            imageButton.setImageDrawable(
                ContextCompat.getDrawable(this,R.drawable.pallet_pressed)
            )
            mImageButtonCurrentPaint!!.setImageDrawable(
                ContextCompat.getDrawable(this,R.drawable.pallet_normal)
            )
            mImageButtonCurrentPaint=view

        }
    }

}