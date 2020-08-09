package com.anurag.imagessubredditviewer.imageLoader

import android.graphics.Bitmap
import java.io.Closeable
import java.lang.ref.SoftReference
import java.util.*

class MemoryCache : Closeable {
    private val cache = Collections.synchronizedMap(HashMap<String, SoftReference<Bitmap>>())

    fun getImageBitmap(imageId: String): Bitmap? = cache[imageId]?.get()

    fun putImageBitmap(id: String, bitmap: Bitmap) {
        cache[id] = SoftReference(bitmap)
    }

    override fun close() {
        cache.clear()
    }
}