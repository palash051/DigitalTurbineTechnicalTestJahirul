package com.jbhuiyan.projects.digitalturbinetechnicaltest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jbhu.CampaignListFragment
import com.jbhuiyan.projects.digitalturbinetechnicaltest.R
import com.jbhuiyan.projects.digitalturbinetechnicaltest.util.replaceFragment

class CampaignsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToBusinessListScreen()
    }

    private fun navigateToBusinessListScreen() {
        replaceFragment(CampaignListFragment(), false)
    }
}