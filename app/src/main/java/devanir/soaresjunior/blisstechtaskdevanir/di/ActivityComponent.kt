package devanir.soaresjunior.blisstechtaskdevanir.di

import dagger.Component
import devanir.soaresjunior.blisstechtaskdevanir.ui.ChoicesFragment
import devanir.soaresjunior.blisstechtaskdevanir.ui.QuestionsFragment
import devanir.soaresjunior.blisstechtaskdevanir.ui.SplashFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(splashFragment: SplashFragment)
    fun inject(questionsFragment: QuestionsFragment)
    fun inject(choicesFragment: ChoicesFragment)
}