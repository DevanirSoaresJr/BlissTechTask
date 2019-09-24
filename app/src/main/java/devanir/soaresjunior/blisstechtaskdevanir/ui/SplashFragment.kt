package devanir.soaresjunior.blisstechtaskdevanir.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import devanir.soaresjunior.blisstechtaskdevanir.R
import kotlinx.android.synthetic.main.fragment_splash.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment() {
    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pbLoading.visibility = View.VISIBLE
        observeNetworkStatus()
    }

    private fun observeNetworkStatus() {
        viewModel.fetchNetWorkStatus().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                "OK" -> {
                    pbLoading.visibility = View.GONE
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.flContainer, QuestionsFragment(), QuestionsFragment().tag)
                        ?.commit()

                    fragmentManager?.popBackStack()
                }
                else -> {
                    pbLoading.visibility = View.GONE
                    ibRetry.visibility = View.VISIBLE

                    ibRetry.setOnClickListener {
                        pbLoading.visibility = View.VISIBLE
                        ibRetry.visibility = View.GONE
                        observeNetworkStatus()
                    }
                }
            }
        })
    }

}
