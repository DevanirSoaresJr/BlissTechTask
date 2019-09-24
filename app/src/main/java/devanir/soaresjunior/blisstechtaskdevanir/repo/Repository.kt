package devanir.soaresjunior.blisstechtaskdevanir.repo

import androidx.lifecycle.LiveData
import devanir.soaresjunior.blisstechtaskdevanir.data.QuestionsResponse
import devanir.soaresjunior.blisstechtaskdevanir.data.StatusResponse

interface Repository {

    fun getQuestions(): LiveData<List<QuestionsResponse>>

    fun getNetStatus(): LiveData<StatusResponse>

    fun dispose()
}