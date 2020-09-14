package com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CampaignsBase(
    @SerializedName("campaigns") var campaigns: List<Campaigns>,
    @SerializedName("totalCampaignsRequested") var totalCampaignsRequested: Int,
    @SerializedName("serverId") var serverId: String,
    @SerializedName("responseTime") var responseTime: String,
    @SerializedName("errorMessage") var errorMessage: String,
    @SerializedName("version") var version: String
) : Parcelable

@Parcelize
data class Campaigns(
    @SerializedName("advertiserDomainUrl") var advertiserDomainUrl: String,
    @SerializedName("apks") var apks: String,
    @SerializedName("appId") var appId: String,
    @SerializedName("appPrivacyPolicyUrl") var appPrivacyPolicyUrl: String,
    @SerializedName("averageRatingImageURL") var averageRatingImageURL: String,
    @SerializedName("bidRate") var bidRate: Double,
    @SerializedName("billingTypeId") var billingTypeId: Int,
    @SerializedName("callToAction") var callToAction: String,
    @SerializedName("campaignDisplayOrder") var campaignDisplayOrder: Int,
    @SerializedName("campaignId") var campaignId: Int,
    @SerializedName("campaignTypeId") var campaignTypeId: Int,
    @SerializedName("carrier") var carrier: String,
    @SerializedName("categoryName") var categoryName: String,
    @SerializedName("clickProxyURL") var clickProxyURL: String,
    @SerializedName("creativeId") var creativeId: Int,
    @SerializedName("developerName") var developerName: String,
    @SerializedName("dtPrivacyPolicyUrl") var dtPrivacyPolicyUrl: String,
    @SerializedName("externalMetadata") var externalMetadata: String,
    @SerializedName("googlePlayAppStoreUrl") var googlePlayAppStoreUrl: String,
    @SerializedName("homeScreen") var homeScreen: Boolean,
    @SerializedName("impressionTrackingURL") var impressionTrackingURL: String,
    @SerializedName("isRandomPick") var isRandomPick: Boolean,
    @SerializedName("longDescription") var longDescription: String,
    @SerializedName("maxOSVersion") var maxOSVersion: String,
    @SerializedName("minOSVersion") var minOSVersion: String,
    @SerializedName("mmpPartner") var mmpPartner: String,
    @SerializedName("numberOfRatings") var numberOfRatings: String,
    @SerializedName("productDescription") var productDescription: String,
    @SerializedName("productId") var productId: Int,
    @SerializedName("productImage") var productImage: String,
    @SerializedName("productName") var productName: String,
    @SerializedName("productThumbnail") var productThumbnail: String,
    @SerializedName("rating") var rating: Double,
    @SerializedName("numberOfDownloads") var numberOfDownloads: String,
    @SerializedName("tstiEligible") var tstiEligible: Boolean,
    @SerializedName("stiEnabled") var stiEnabled: Boolean,
    @SerializedName("screenshots") var screenshots: String,
    @SerializedName("postInstallActions") var postInstallActions: List<String>
) : Parcelable



