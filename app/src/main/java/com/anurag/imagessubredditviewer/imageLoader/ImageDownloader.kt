package com.anurag.imagessubredditviewer.imageLoader

import android.app.Activity
import android.graphics.BitmapFactory
import android.widget.ImageView
import java.net.URL


class ImageDownloader(private val imageUrl: String, private val imageView: ImageView) : Runnable {
    override fun run() {
        val url = URL(imageUrl)
        val bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        MemoryCache().putImageBitmap(imageUrl, bitmap)
        (imageView.context as Activity).runOnUiThread {
            imageView.setImageBitmap(bitmap)
        }
    }
}