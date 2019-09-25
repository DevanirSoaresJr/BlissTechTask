package devanir.soaresjunior.blisstechtaskdevanir.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devanir.soaresjunior.blisstechtaskdevanir.data.Choice
import devanir.soaresjunior.blisstechtaskdevanir.data.QuestionsResponse
import devanir.soaresjunior.blisstechtaskdevanir.data.StatusResponse
import devanir.soaresjunior.blisstechtaskdevanir.net.QuestionService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepositoryImpl(private val questionService: QuestionService) : Repository {


    private val compositeDisposable = CompositeDisposable()
    private val questionsLiveData = MutableLiveData<List<QuestionsResponse>>()
    private val netStatusLiveData = MutableLiveData<StatusResponse>()
    private val choiceLiveData = MutableLiveData<List<Choice>>()


    override fun getQuestions(): LiveData<List<QuestionsResponse>> {
        compositeDisposable.add(questionService.getQuestions()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    questionsLiveData.value = it
                },
                {
                    error("Showing Questions Went Wrong")

                }
            ))

        return questionsLiveData
    }

    override fun getNetStatus(): LiveData<StatusResponse> {
        compositeDisposable.add(questionService.getNetStatus()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    netStatusLiveData.value = it
                },
                {
                    //If the server health is OK then the application should proceed to the “List Screen”.
                    //If the server health is NOT OK then the application should display a “Retry Action” widget.
                    error("Network Error")
                }
            )
        )
        return netStatusLiveData
    }

    override fun getChoices(): LiveData<List<Choice>> {
        compositeDisposable.add(questionService.getChoices()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe(
                {
                    choiceLiveData.value = it
                },
                {
                    error("Showing Choices Went Wrong")
                }
            )
        )
        return choiceLiveData
    }


    override fun dispose() {
        compositeDisposable.clear()
    }


}