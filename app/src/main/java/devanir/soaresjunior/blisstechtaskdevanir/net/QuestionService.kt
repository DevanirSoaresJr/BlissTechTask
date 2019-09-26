package devanir.soaresjunior.blisstechtaskdevanir.net

import devanir.soaresjunior.blisstechtaskdevanir.CHOICES_ENDPOINT
import devanir.soaresjunior.blisstechtaskdevanir.NET_STATUS_ENDPOINT
import devanir.soaresjunior.blisstechtaskdevanir.QUESTIONS_ENDPOINT
import devanir.soaresjunior.blisstechtaskdevanir.data.Choice
import devanir.soaresjunior.blisstechtaskdevanir.data.QuestionsResponse
import devanir.soaresjunior.blisstechtaskdevanir.data.StatusResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface QuestionService {

    @GET(QUESTIONS_ENDPOINT)
    fun getQuestions(): Single<List<QuestionsResponse>>

    @GET(CHOICES_ENDPOINT)
    fun getChoices(): Single<List<Choice>>

    @GET(NET_STATUS_ENDPOINT)
    fun getNetStatus(): Single<StatusResponse>

    @PUT("")
    fun updateVotes(): Observable<QuestionsResponse>

}
