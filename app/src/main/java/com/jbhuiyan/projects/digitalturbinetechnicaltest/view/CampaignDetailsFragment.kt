package com.jbhuiyan.projects.digitalturbinetechnicaltest.view

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jbhuiyan.projects.digitalturbinetechnicaltest.R
import com.jbhuiyan.projects.digitalturbinetechnicaltest.util.getProductDetails
import com.jbhuiyan.projects.digitalturbinetechnicaltest.viewmodel.CampaignViewModel
import kotlinx.android.synthetic.main.fragment_campaign_details.*


class CampaignDetailsFragment() : Fragment(R.layout.fragment_campaign_details) {
    lateinit var viewModel: CampaignViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(CampaignViewModel::class.java)
        productDetails.text= viewModel.selectedCampaign.value?.getProductDetails()
        productDetails.movementMethod=LinkMovementMethod.getInstance()
    }
}