package com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.adaptor

import android.app.Activity
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.formats.MediaView
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.R
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.model.Image
import com.pdf.pdfreader.pdfviewer.pdfeditor.imagetopdf.pdfconverter.jpgtopdf.androidapp.utils.AdManagment


class ImageAdaptor(var context: Activity, var imageArrayList: ArrayList<Image>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val CONTENT_TYPE = 0
    private val AD_TYPE = 1
    var type = 0
    private var adManagment: AdManagment? = null

    inner class ImageItem(view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var itemView: View? = null
        type = viewType
        if (viewType == AD_TYPE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_layout, null)
            return AdHolder(itemView!!)
        } else if (viewType == CONTENT_TYPE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, null)
            itemView = itemView
        }
        return ImageItem(
            itemView!!
        )

    }
/*    private fun loadBannerAd() {
        // Creating  a Ad Request
        val adRequest: AdRequest = AdRequest.Builder().build()

        // load Ad with the Request
        banner.loadAd(adRequest)

        // Showing a simple Toast message to user when an ad is Loading
        Toast.makeText(context, "Banner Ad is loading ", Toast.LENGTH_LONG).show()
    }*/
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        adManagment = AdManagment(context)
        if (holder.getItemViewType() == CONTENT_TYPE) {
            val itemHolder: ImageItem =
                holder as ImageItem
            Glide.with(context)
                .load(imageArrayList.get(position).image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.image);
        } else if (holder.getItemViewType() == AD_TYPE) {
            val itemHolder = holder as AdHolder
            holder.textloading?.visibility= View.VISIBLE
            val adRequest: AdRequest = AdRequest.Builder().build()
            // load Ad with the Request
            itemHolder.adView?.loadAd(adRequest)
            itemHolder.adView?.setAdListener(object : AdListener() {
                override fun onAdLoaded() {
                    // setting adLoaded to true
                 //   adLoaded = true
                    // Showing a simple Toast message to user when an ad is loaded
                    //Toast.makeText(context, "Ad is Loaded", Toast.LENGTH_LONG).show()

                    itemHolder.textloading?.visibility=View.GONE
                    itemHolder.adView?.visibility=View.VISIBLE
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    // setting adLoaded to false
                 //   adLoaded = false

                    // Showing a simple Toast message to user when and ad is failed to load
                    Toast.makeText(context, "Ad Failed to Load ", Toast.LENGTH_LONG)
                        .show()
                }

                override fun onAdOpened() {

                    // Showing a simple Toast message to user when an ad opens and overlay and covers the device screen
                    //Toast.makeText(context, "Ad Opened", Toast.LENGTH_LONG).show()
                }

                override fun onAdClicked() {

                    // Showing a simple Toast message to user when a user clicked the ad
                  //  Toast.makeText(context, "Ad Clicked", Toast.LENGTH_LONG).show()
                }

                fun onAdLeftApplication() {

                  /*  // Showing a simple Toast message to user when the user left the application
                    Toast.makeText(context, "Ad Left the Application", Toast.LENGTH_LONG)
                        .show()*/
                }

                override fun onAdClosed() {

                    // Showing a simple Toast message to user when the user interacted with ad and got the other app and then return to the app again
                   // Toast.makeText(context, "Ad is Closed", Toast.LENGTH_LONG).show()
                }
            })

        }

    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % 3 == 0 && position + 1 != 1) //&& DataProvider.getInstance().get_native_admob()!=null)
            AD_TYPE
        else CONTENT_TYPE
    }

    override fun getItemCount(): Int {
        return imageArrayList.size
    }

    fun is_add(pos: Int): Boolean {
        return if ((pos + 1) % 3 == 0 && pos + 1 != 1) {
            true
        } else false
    }

    class AdHolder(view: View) : RecyclerView.ViewHolder(view) {
        var adView:AdView?=null
        var textloading:ProgressBar?=null
        init {
            adView = view.findViewById(R.id.bannerAdView)
            textloading = view.findViewById(R.id.textloading)
        }
    }

    private fun populateUnifiedNativeAdView(
        nativeAd: NativeAd,
        adView: NativeAdView
    ) {
        val mediaView = adView.findViewById(R.id.ad_media) as MediaView
        val mainImageView = adView.findViewById(R.id.ad_image) as ImageView
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline))
        adView.setBodyView(adView.findViewById(R.id.ad_body))
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action))
        adView.setIconView(adView.findViewById(R.id.ad_app_icon))
        adView.setPriceView(adView.findViewById(R.id.ad_price))
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars))
        adView.setStoreView(adView.findViewById(R.id.ad_store))
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser))
        (adView.getHeadlineView() as TextView).text = nativeAd.headline
        (adView.getBodyView() as TextView).text = nativeAd.body
        (adView.getCallToActionView() as Button).text = nativeAd.callToAction
        (adView.getCallToActionView() as Button).backgroundTintList =
            context.resources.getColorStateList(R.color.purple_700)
        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.icon == null) {
            adView.getIconView().setVisibility(View.GONE)
        } else {
            (adView.getIconView() as ImageView).setImageDrawable(
                nativeAd.icon.drawable
            )
            adView.getIconView().setVisibility(View.VISIBLE)
        }
        if (nativeAd.price == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE)
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE)
            (adView.getPriceView() as TextView).text = nativeAd.price
        }
        if (nativeAd.store == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE)
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE)
            (adView.getStoreView() as TextView).text = nativeAd.store
        }
        if (nativeAd.starRating == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE)
        } else {
            (adView.getStarRatingView() as RatingBar).rating = nativeAd.starRating.toFloat()
            adView.getStarRatingView().setVisibility(View.VISIBLE)
        }
        if (nativeAd.advertiser == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE)
        } else {
            (adView.getAdvertiserView() as TextView).text = nativeAd.advertiser
            adView.getAdvertiserView().setVisibility(View.VISIBLE)
        }
        adView.setNativeAd(nativeAd)
    }
}