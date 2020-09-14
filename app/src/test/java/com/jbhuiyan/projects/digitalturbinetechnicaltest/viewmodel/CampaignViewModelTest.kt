package com.jbhuiyan.projects.digitalturbinetechnicaltest.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jbhuiyan.projects.digitalturbinetechnicaltest.RxImmediateSchedulerRule
import com.jbhuiyan.projects.digitalturbinetechnicaltest.businesslogic.CampaignService
import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.Campaigns
import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.CampaignsBase
import io.reactivex.Single
import org.hamcrest.core.AnyOf
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit

@RunWith(MockitoJUnitRunner::class)
class CampaignViewModelTest {
    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    // Test rule for making the RxJava to run synchronously in unit test
    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Mock
    lateinit var apiService: CampaignService

    @Mock
    lateinit var retrofit: Retrofit

    lateinit var retroRXViewModel: CampaignViewModel

    private lateinit var single: Single<CampaignsBase>

    private var loading: Boolean = false

    @Before
    fun setUp() {
        // initialize the ViewModed with a mocked github api
        MockitoAnnotations.initMocks(this)
        retroRXViewModel = CampaignViewModel()
    }

    @Test
    fun fetchRetroInfoTest_success() {
        var campaignsList = ArrayList<Campaigns>()
        var cam = Campaigns(
            "",
            "",
            "",
            "",
            "",
            1.1,
            1,
            "",
            1,
            1,
            1,
            "",
            "",
            "",
            1,
            "",
            "",
            "",
            "",
            true,
            "",
            true,
            "",
            "",
            "",
            "",
            "",
            "", 1, "", "", "", 1.0, "", true, true, "", listOf()
        )

        campaignsList.add(cam)

        var retroRxModel = CampaignsBase(campaignsList, 1, "", "", "", "")
        single = Single.just(retroRxModel)
        if (retrofit != null) {
            if (apiService != null) {
                Mockito.`when`(apiService.getCampaigns()).thenReturn(single)
            }
        }

        retroRXViewModel.refresh()
        Assert.assertEquals(1, retroRXViewModel.campaignModel.value?.campaigns?.size)
        Assert.assertEquals(loading, retroRXViewModel.loading.value)
    }

}