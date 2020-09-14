package com.jbhuiyan.projects.digitalturbinetechnicaltest.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jbhuiyan.projects.digitalturbinetechnicaltest.R
import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.Campaigns
import java.lang.StringBuilder

interface ListItemClickListener {
    fun onItemClick(business: Campaigns)
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, needBackStack: Boolean) {
    val fragmentManager = supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(R.id.host, fragment)
    if (needBackStack) {
        transaction.addToBackStack(null)
    }
    transaction.commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    replaceFragment(fragment, true)
}

fun Campaigns.getProductDetails(): String {
    var productDetails = StringBuilder()
    productDetails.append("Product Details:\n")
    if (apks != null) {
        productDetails.append("Apks: " + apks + "\n")
    }

    if (appId != null) {
        productDetails.append("AppId: " + appId + "\n")
    }
    if (bidRate != null) {
        productDetails.append("Bid Rate: " + bidRate + "\n")
    }

    if (billingTypeId != null) {
        productDetails.append("Billing TypeId: " + billingTypeId + "\n")
    }

    if (callToAction != null) {
        productDetails.append("Call To Action: " + callToAction + "\n")
    }

    if (campaignDisplayOrder != null) {
        productDetails.append("Campaign Display Order: " + campaignDisplayOrder + "\n")
    }

    if (campaignId != null) {
        productDetails.append("Campaign Id: " + campaignId + "\n")
    }

    if (campaignTypeId != null) {
        productDetails.append("Campaign Type Id: " + campaignTypeId + "\n")
    }

    if (carrier != null) {
        productDetails.append("Carrier: " + carrier + "\n")
    }

    if (categoryName != null) {
        productDetails.append("Category Name: " + categoryName + "\n")
    }

    if (creativeId != null) {
        productDetails.append("CreativeId: " + creativeId + "\n")
    }

    if (developerName != null) {
        productDetails.append("Developer Name: " + developerName + "\n")
    }

    if (numberOfRatings != null) {
        productDetails.append("Number Of Ratings: " + numberOfRatings + "\n")
    }

    if (productDescription != null) {
        productDetails.append("Product Description: " + productDescription + "\n")
    }

    if (productId != null) {
        productDetails.append("Product Id: " + productId + "\n")
    }

    if (productName != null) {
        productDetails.append("Product Name: " + productName + "\n")
    }

    if (rating != null) {
        productDetails.append("Rating: " + rating + "\n")
    }

    if (numberOfDownloads != null) {
        productDetails.append("Number Of Downloads: " + numberOfDownloads + "\n")
    }

    if (tstiEligible != null) {
        productDetails.append("TSTI Eligible: " + tstiEligible + "\n")
    }

    if (stiEnabled != null) {
        productDetails.append("STI Enabled: " + stiEnabled + "\n")
    }

    return productDetails.toString()
}


