package devanir.soaresjunior.blisstechtaskdevanir.ui

import android.app.AlertDialog
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import devanir.soaresjunior.blisstechtaskdevanir.R
import devanir.soaresjunior.blisstechtaskdevanir.di.ActivityComponent
import devanir.soaresjunior.blisstechtaskdevanir.di.ActivityModule
import devanir.soaresjunior.blisstechtaskdevanir.di.DaggerActivityComponent
import devanir.soaresjunior.blisstechtaskdevanir.rvAdapter.ChoicesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_choices.*
import kotlinx.android.synthetic.main.fragment_questions.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var activityComponent: ActivityComponent


    private var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val notConnected = intent.getBooleanExtra(ConnectivityManager
                .EXTRA_NO_CONNECTIVITY, false)
            if (notConnected) {
                disconnected()
            } else {
                connected()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

    }


        override fun onStart() {
            super.onStart()
            registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }

        override fun onStop() {
            super.onStop()
            unregisterReceiver(broadcastReceiver)
        }

        private fun disconnected() {
            img_no_internet.visibility = View.VISIBLE
            rvChoices?.visibility = View.INVISIBLE
            rvQuestions?.visibility = View.INVISIBLE
        }

        private fun connected() {
            img_no_internet.visibility = View.INVISIBLE
            supportFragmentManager.beginTransaction()
                .add(R.id.flContainer, SplashFragment(), SplashFragment().tag)
                .commit()

            rvChoices?.visibility = View.VISIBLE
            rvQuestions?.visibility = View.VISIBLE
        }


    }