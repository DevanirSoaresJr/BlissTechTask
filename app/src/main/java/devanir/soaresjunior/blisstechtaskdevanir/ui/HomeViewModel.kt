package devanir.soaresjunior.blisstechtaskdevanir.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import devanir.soaresjunior.blisstechtaskdevanir.data.QuestionsResponse
import devanir.soaresjunior.blisstechtaskdevanir.data.StatusResponse
import devanir.soaresjunior.blisstechtaskdevanir.repo.Repository

class HomeViewModel(private val repository: Repository) : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        repository.dispose()
    }

    fun showQuestionsInfo(): LiveData<List<QuestionsResponse>> = repository.getQuestions()

    fun fetchNetWorkStatus(): LiveData<StatusResponse> = repository.getNetStatus()
}