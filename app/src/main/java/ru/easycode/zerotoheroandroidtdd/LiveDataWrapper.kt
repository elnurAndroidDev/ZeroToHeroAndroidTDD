package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Observe : LiveDataWrapper {
        fun liveData(): LiveData<UiState>
    }

    interface Update : LiveDataWrapper {
        fun update(value: UiState)
    }

    interface Save : LiveDataWrapper {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Mutable : Update, Save, Observe

    class Base(
        private val liveData: MutableLiveData<UiState> = SingleLiveEvent()
    ) : Mutable {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

        override fun liveData(): LiveData<UiState> = liveData

    }
}