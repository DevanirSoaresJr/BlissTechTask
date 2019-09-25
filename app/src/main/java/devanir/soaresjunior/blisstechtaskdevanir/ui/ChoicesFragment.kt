package devanir.soaresjunior.blisstechtaskdevanir.ui


import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import devanir.soaresjunior.blisstechtaskdevanir.R
import devanir.soaresjunior.blisstechtaskdevanir.data.Choice
import devanir.soaresjunior.blisstechtaskdevanir.rvAdapter.ChoicesAdapter
import kotlinx.android.synthetic.main.fragment_choices.*
import kotlinx.android.synthetic.main.item_rv_choices.*
import java.util.ArrayList
import javax.inject.Inject


class ChoicesFragment : Fragment() {
    @Inject
    lateinit var viewModel: HomeViewModel

    private var adapter: ChoicesAdapter? = null
    private var choices = listOf<Choice>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choices, container, false)
    }

    private fun onChoicesSet(choices: Choice?) {
        choices?.let {
            tvChoices.text = it.choice
            tvVote.text = it.votes.toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeChoices()
        val choice = arguments?.getParcelable<Choice>("choices")
        onChoicesSet(choice)
    }

    private fun observeChoices() {
        viewModel.showChoicesInfo().observe(viewLifecycleOwner, Observer{
            adapter = ChoicesAdapter(it)
            rvChoices.adapter = adapter
            choices = it
        })
    }

    companion object {
        fun newInstance(choices: List<Choice>): ChoicesFragment {
            val fragment = ChoicesFragment()
            val arguments = Bundle().apply {
                putParcelableArrayList("choices", choices as ArrayList<out Parcelable>)
            }
            fragment.arguments = arguments
            return fragment
        }
    }
}
