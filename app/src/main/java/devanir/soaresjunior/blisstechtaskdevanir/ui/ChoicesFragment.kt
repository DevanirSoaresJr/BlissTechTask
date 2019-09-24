package devanir.soaresjunior.blisstechtaskdevanir.ui


import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import devanir.soaresjunior.blisstechtaskdevanir.R
import devanir.soaresjunior.blisstechtaskdevanir.data.Choice
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class ChoicesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

    companion object {
        fun newInstance(choices: List<Choice>): ChoicesFragment {
            val fragment = ChoicesFragment()
            val arguments = Bundle().apply {
                putParcelableArrayList("choices", choices as ArrayList<Choice>)
            }
            fragment.arguments = arguments
            return fragment
        }
    }
}
