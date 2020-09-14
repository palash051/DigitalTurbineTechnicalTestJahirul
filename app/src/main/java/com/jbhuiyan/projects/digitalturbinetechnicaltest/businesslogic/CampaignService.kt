package com.jbhuiyan.projects.digitalturbinetechnicaltest.businesslogic

import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.CampaignsBase
import com.jbhuiyan.projects.digitalturbinetechnicaltest.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CampaignService {
    @Inject
    lateinit var api: CampaignApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCampaigns(): Single<CampaignsBase> {
        return api.getCampaigns()
    }
}