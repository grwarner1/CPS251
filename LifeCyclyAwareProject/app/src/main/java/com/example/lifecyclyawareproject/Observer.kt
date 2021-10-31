package com.example.lifecyclyawareproject

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.example.lifecyclyawareproject.ui.main.MainViewModel.Companion.addData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Observer: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        addData("onResume was fired on " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n" + "****\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        addData("onPause was fired on " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n" + "****\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        addData("onCreate was fired on " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        addData("onStart was fired on " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        addData("onStop was fired on " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        addData("onDestroy was fired on " +
                LocalDateTime.now().format(DateTimeFormatter.ISO_TIME) + "\n" + "****\n")
    }

}