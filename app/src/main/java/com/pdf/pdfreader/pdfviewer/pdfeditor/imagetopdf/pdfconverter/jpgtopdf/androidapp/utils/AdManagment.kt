package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R

class AdManagment(var context: Context) {
    var nativeAd: NativeAd? = null
    fun getNatAdd(

    ) {
        val builder = AdLoader.Builder(context, "ca-app-pub-3940256099942544/2247696110")
        val videoOptions = VideoOptions.Builder()
            .setStartMuted(true)
            .build()
        var choice = NativeAdOptions.ADCHOICES_TOP_RIGHT
        val adOptions = NativeAdOptions.Builder()
            .setVideoOptions(videoOptions)
            .setAdChoicesPlacement(choice)
            .build()

        val adLoader = builder.forNativeAd { unifiedNativeAd ->
            nativeAd = unifiedNativeAd
            /*adFrame?.let {
                populateUnifiedNativeAdView(unifiedNativeAd, adView, it)
            }*/
        }.withAdListener(
            object : AdListener() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                }

                override fun onAdClicked() {

                }

                override fun onAdClosed() {
                    // adsCallbacks.onAdClosed(AdType.HONENATIVE, AdNetWorkType.ADMOB, isFail = false)
                }

                override fun onAdOpened() {
                    //adsCallbacks.onAdClicked(0)
                }
            }).withNativeAdOptions(adOptions)
            .build()
        adLoader.loadAd(AdRequest.Builder().build())


    }

    fun getnative(): NativeAd? {
        return nativeAd
    }




}