package devanir.soaresjunior.blisstechtaskdevanir.net

import devanir.soaresjunior.blisstechtaskdevanir.NET_STATUS_ENDPOINT
import devanir.soaresjunior.blisstechtaskdevanir.QUESTIONS_ENDPOINT
import devanir.soaresjunior.blisstechtaskdevanir.data.QuestionsResponse
import devanir.soaresjunior.blisstechtaskdevanir.data.StatusResponse
import io.reactivex.Single
import retrofit2.http.GET

interface QuestionService {

    @GET(QUESTIONS_ENDPOINT)
    fun getQuestions(): Single<List<QuestionsResponse>>

    @GET(NET_STATUS_ENDPOINT)
    fun getNetStatus(): Single<StatusResponse>
}