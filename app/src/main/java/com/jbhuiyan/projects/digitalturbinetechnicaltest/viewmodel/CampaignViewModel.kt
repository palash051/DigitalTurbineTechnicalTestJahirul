package com.jbhuiyan.projects.digitalturbinetechnicaltest.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.CampaignsBase
import com.jbhuiyan.projects.digitalturbinetechnicaltest.businesslogic.CampaignService
import com.jbhuiyan.projects.digitalturbinetechnicaltest.datamodel.Campaigns
import com.jbhuiyan.projects.digitalturbinetechnicaltest.di.DaggerApiComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import javax.inject.Inject

class CampaignViewModel : ViewModel() {

    @Inject
    lateinit var campaignService: CampaignService
    private val disposable = CompositeDisposable()
    val campaignModel = MutableLiveData<CampaignsBase>()
    val selectedCampaign = MutableLiveData<Campaigns>()
    val campaignLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun refresh() {
        fetchYelpcampaigns()
    }

    private fun fetchYelpcampaigns() {
        loading.value = true
        doAsync {
            uiThread {
                disposable.add(
                    campaignService.getCampaigns().subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<CampaignsBase>() {
                            override fun onSuccess(value: CampaignsBase?) {
                                setDataOnSuccess(value)
                            }

                            override fun onError(e: Throwable?) {
                                campaignLoadError.value = true
                                loading.value = false
                            }
                        })
                )
            }
        }
    }

    private fun setDataOnSuccess(value: CampaignsBase?) {
        campaignModel.value = value
        campaignLoadError.value = false
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}
