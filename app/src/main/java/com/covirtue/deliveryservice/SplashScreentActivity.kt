package com.covirtue.deliveryservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashScreentActivity : AppCompatActivity() {

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screent)

        compositeDisposable = CompositeDisposable()
        delaySplashScreen()
    }

    private fun delaySplashScreen() {
        val disposable = Completable.timer(5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Toast.makeText(this, "Done", Toast.LENGTH_LONG).show()
            }
        disposable.addTo(compositeDisposable)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }
}