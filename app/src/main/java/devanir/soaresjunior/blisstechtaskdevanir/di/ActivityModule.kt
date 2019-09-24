package devanir.soaresjunior.blisstechtaskdevanir.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.blisstechtaskdevanir.repo.Repository
import devanir.soaresjunior.blisstechtaskdevanir.repo.RepositoryImpl
import devanir.soaresjunior.blisstechtaskdevanir.net.QuestionService
import devanir.soaresjunior.blisstechtaskdevanir.ui.HomeViewModel
import devanir.soaresjunior.blisstechtaskdevanir.ui.ViewModelFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ActivityModule(private val activity: AppCompatActivity) {
    @Provides
    @Singleton
    fun provideHomeViewModel(factory: ViewModelFactory) = ViewModelProviders.of(activity, factory)
        .get(HomeViewModel::class.java)

    @Provides
    @Singleton
    fun provideRepository(questionService: QuestionService): Repository = RepositoryImpl(questionService)
}