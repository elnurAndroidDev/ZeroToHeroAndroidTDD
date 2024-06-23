package ru.easycode.zerotoheroandroidtdd

interface LoadResult {

    fun show(updateLiveData: LiveDataWrapper.Update)

    data class Success(private val data: SimpleResponse) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(text = data.text))
        }
    }

    data class Error(private val noConnection: Boolean) : LoadResult {

        private val errorText =
            if (noConnection) "No internet connection" else "Something went wrong"

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(errorText))
        }
    }

}