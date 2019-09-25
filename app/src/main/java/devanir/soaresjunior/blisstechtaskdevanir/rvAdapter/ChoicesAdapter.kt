package devanir.soaresjunior.blisstechtaskdevanir.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import devanir.soaresjunior.blisstechtaskdevanir.R
import devanir.soaresjunior.blisstechtaskdevanir.data.Choice

class ChoicesAdapter(private val choicesList: List<Choice>) :
RecyclerView.Adapter<ChoicesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoicesViewHolder {
        return ChoicesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_choices, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChoicesViewHolder, position: Int) {
        holder.bind(choicesList[position])}



    override fun getItemCount(): Int {
        return choicesList.size
    }


}
class ChoicesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvChoices: TextView = itemView.findViewById(R.id.tvChoices)
    private val tvVote: TextView = itemView.findViewById(R.id.tvVote)

    fun bind(choice: Choice) {
        tvChoices.text = choice.choice
        tvVote.text = choice.votes.toString()
    }
}
