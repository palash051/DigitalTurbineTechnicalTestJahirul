package com.jbhuiyan.projects.digitalturbinetechnicaltest.di

import com.jbhuiyan.projects.digitalturbinetechnicaltest.businesslogic.CampaignService
import com.jbhuiyan.projects.digitalturbinetechnicaltest.viewmodel.CampaignViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service: CampaignService)
    fun inject(yelpBusinessViewModel:CampaignViewModel)
}