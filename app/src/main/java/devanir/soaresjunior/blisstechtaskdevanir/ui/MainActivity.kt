package devanir.soaresjunior.blisstechtaskdevanir.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import devanir.soaresjunior.blisstechtaskdevanir.R
import devanir.soaresjunior.blisstechtaskdevanir.di.ActivityComponent
import devanir.soaresjunior.blisstechtaskdevanir.di.ActivityModule
import devanir.soaresjunior.blisstechtaskdevanir.di.DaggerActivityComponent
import devanir.soaresjunior.blisstechtaskdevanir.rvAdapter.QuestionsAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, SplashFragment(), SplashFragment().tag)
            .commit()
    }
}
