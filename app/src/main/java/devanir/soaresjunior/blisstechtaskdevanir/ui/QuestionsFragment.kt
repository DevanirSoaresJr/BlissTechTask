package devanir.soaresjunior.blisstechtaskdevanir.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import devanir.soaresjunior.blisstechtaskdevanir.R
import devanir.soaresjunior.blisstechtaskdevanir.data.QuestionsResponse
import devanir.soaresjunior.blisstechtaskdevanir.rvAdapter.OnItemClickedListener
import devanir.soaresjunior.blisstechtaskdevanir.rvAdapter.QuestionsAdapter
import kotlinx.android.synthetic.main.fragment_questions.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class QuestionsFragment : Fragment(), OnItemClickedListener {
    @Inject
    lateinit var viewModel: HomeViewModel

    private var adapter: QuestionsAdapter? = null
    private var questions = listOf<QuestionsResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeQuestions()
    }

    private fun observeQuestions() {
        viewModel.showQuestionsInfo().observe(viewLifecycleOwner, Observer {
            adapter = QuestionsAdapter(it, this)
            rvQuestions.adapter = adapter
            questions = it
        })
    }

    override fun onItemClicked(position: Int) {
        ChoicesFragment.newInstance(questions[position].choices)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flContainer, ChoicesFragment(), ChoicesFragment().tag)
            ?.addToBackStack(ChoicesFragment().tag)
            ?.commit()
    }
}
