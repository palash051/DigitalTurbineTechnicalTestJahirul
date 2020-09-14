package com.jbhuiyan.projects.digitalturbinetechnicaltest.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jbhuiyan.projects.digitalturbinetechnicaltest.R
import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.Campaigns
import com.jbhuiyan.projects.digitalturbinetechnicaltest.util.ListItemClickListener
import kotlinx.android.synthetic.main.campaign_list_item.view.*

class CampaignListAdapter(
    var itemClickListener: ListItemClickListener,
    var campaignList: ArrayList<Campaigns>
) :
    RecyclerView.Adapter<CampaignListAdapter.PhotoViewHolder>() {

    fun updateCountries(newPhotoModels: List<Campaigns>) {
        campaignList.clear()
        campaignList.addAll(newPhotoModels)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.campaign_list_item, parent, false
        )
        return PhotoViewHolder(view, itemClickListener)
    }

    override fun getItemCount() = campaignList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(campaignList[position])
    }


    class PhotoViewHolder(
        private val view: View,
        private val itemClickListener: ListItemClickListener
    ) : RecyclerView.ViewHolder(view) {
        fun bind(campaigns: Campaigns) {
            view.setOnClickListener { itemClickListener.onItemClick(campaigns) }
            view.title.text= campaigns.productName
            view.address.text= campaigns.productDescription
            view.rating.rating= campaigns.rating.toFloat()
            view.numberOfDownloads.text="Total Downloads: "+ campaigns.numberOfDownloads
            Glide.with(view.productThumbnail).load(campaigns.productThumbnail).into(view.productThumbnail)
        }
    }
}

