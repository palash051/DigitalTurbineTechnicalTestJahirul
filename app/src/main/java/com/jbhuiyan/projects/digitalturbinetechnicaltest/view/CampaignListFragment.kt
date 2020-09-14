package com.jbhu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jbhuiyan.projects.digitalturbinetechnicaltest.R
import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.Campaigns
import com.jbhuiyan.projects.digitalturbinetechnicaltest.util.ListItemClickListener
import com.jbhuiyan.projects.digitalturbinetechnicaltest.util.replaceFragment
import com.jbhuiyan.projects.digitalturbinetechnicaltest.view.CampaignDetailsFragment
import com.jbhuiyan.projects.digitalturbinetechnicaltest.view.CampaignListAdapter
import com.jbhuiyan.projects.digitalturbinetechnicaltest.view.CampaignsActivity
import com.jbhuiyan.projects.digitalturbinetechnicaltest.viewmodel.CampaignViewModel
import kotlinx.android.synthetic.main.fragment_campaign_list.*


class CampaignListFragment : Fragment(R.layout.fragment_campaign_list),
    ListItemClickListener {
    lateinit var viewModel: CampaignViewModel
    private var countriesAdapter: CampaignListAdapter = CampaignListAdapter(this, arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        instantiateTheViewModel()
        viewModel.refresh()
        observeViewModel()
    }

    private fun instantiateTheViewModel() {
        viewModel = ViewModelProviders.of(requireActivity()).get(CampaignViewModel::class.java)
        featureList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
            this.addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }

    fun observeViewModel() {
        viewModel.campaignModel.observe(this, Observer { campaignList ->
            campaignList?.campaigns.let { list ->
                featureList.visibility = View.VISIBLE
                list?.let { countriesAdapter.updateCountries(it) }
            }
        })

        viewModel.campaignLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if (it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    list_error.visibility = View.GONE
                    featureList.visibility = View.GONE
                }
            }
        })
    }

    override fun onItemClick(campaigns: Campaigns) {
        viewModel.selectedCampaign.value=campaigns
        (activity as CampaignsActivity).replaceFragment(CampaignDetailsFragment())
    }
}