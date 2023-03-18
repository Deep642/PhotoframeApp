package com.example.photoframeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var currImage=0
    var names= arrayOf("Messi","Shiva","Dipayan")
    lateinit var image:ImageView
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide() //for handeling the nullpointer problem

        val prev=findViewById<ImageButton>(R.id.imageButtonprev)
        val post=findViewById<ImageButton>(R.id.imageButtonpost)
        val text=findViewById<TextView>(R.id.nameView)

          prev.setOnClickListener {
              val curImageId="pic_$currImage"
              val curImageIdInt=this.resources.getIdentifier(curImageId,"id",packageName)
              image=findViewById(curImageIdInt)
              image.alpha=0f
              currImage=(3+(currImage-1))%3

              val toShowImageId="pic_$currImage"
              val toShowImageIdInt=this.resources.getIdentifier(toShowImageId,"id",packageName)
              image=findViewById(toShowImageIdInt)
              image.alpha=1f

              text.text=names[currImage]
          }
          post.setOnClickListener {
              val curImageId="pic_$currImage"
              val curImageIdInt=this.resources.getIdentifier(curImageId,"id",packageName)
              image=findViewById(curImageIdInt)
              image.alpha=0f
              currImage=(3+(currImage+1))%3

              val toShowImageId="pic_$currImage"
              val toShowImageIdInt=this.resources.getIdentifier(toShowImageId,"id",packageName)
              image=findViewById(toShowImageIdInt)
              image.alpha=1f

              text.text=names[currImage]
          }
    }
}