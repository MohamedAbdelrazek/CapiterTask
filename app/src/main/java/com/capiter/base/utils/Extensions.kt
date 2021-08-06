package com.capiter.base.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import io.reactivex.rxjava3.disposables.Disposable

fun AppCompatActivity.setUpActionBar(toolbar: Toolbar) {
    this.setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
    toolbar.setNavigationOnClickListener { finish() }
}

inline fun <reified T : Activity> Context.openActivity(block: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    block(intent)
    startActivity(intent)
}

fun Disposable.addTo(autoDisposable: AutoDisposable) {
    autoDisposable.add(this)
}

// to handle click Listener for Views
fun View.click(block: () -> Unit) {
    setOnClickListener {
        block()
    }
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

// to load images url into Images
fun ImageView.load(url: String) {
    Glide.with(this).load(url).into(this)
}