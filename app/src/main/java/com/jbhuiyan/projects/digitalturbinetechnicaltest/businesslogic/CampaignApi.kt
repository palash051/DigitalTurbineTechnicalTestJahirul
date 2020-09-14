package com.jbhuiyan.projects.digitalturbinetechnicaltest.businesslogic

import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.CampaignsBase
import io.reactivex.Single
import retrofit2.http.GET

interface CampaignApi {

    @GET("getAds?id=236&password=OVUJ1DJN&siteId=10777&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=100&lname=bhuiyan")
    fun getCampaigns(): Single<CampaignsBase>
}