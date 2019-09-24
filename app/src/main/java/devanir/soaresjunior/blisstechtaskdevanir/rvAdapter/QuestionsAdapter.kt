package devanir.soaresjunior.blisstechtaskdevanir.rvAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import devanir.soaresjunior.blisstechtaskdevanir.R
import devanir.soaresjunior.blisstechtaskdevanir.data.QuestionsResponse
import java.text.SimpleDateFormat
import java.util.*

class QuestionsAdapter(
    private val questionList: List<QuestionsResponse>,
    private val listener: OnItemClickedListener
) :
    RecyclerView.Adapter<QuestionsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        return QuestionsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_rv_questions, parent, false)
        )
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        holder.bind(questionList[position])
        holder.itemView.setOnClickListener { listener.onItemClicked(position) }
    }

    override fun getItemCount(): Int {
        return questionList.size
    }
}

class QuestionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvId: TextView = itemView.findViewById(R.id.tvId)
    private val tvQuestion: TextView = itemView.findViewById(R.id.tvQuestion)
    private val tvPublishedAt: TextView = itemView.findViewById(R.id.tvPublishedAt)

    fun bind(question: QuestionsResponse) {
        tvId.text = question.id.toString()
        tvQuestion.text = question.question
        tvPublishedAt.text = dateFormatter(question.publishedAt)
    }

    private fun dateFormatter(databaseDate: String): String {
        val pattern: String = if (databaseDate.matches(Regex("2015-08-05T08:40:51.620Z"))) {
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        } else {
            "yyyy-MM-dd'T'hh:mm:ss'Z'"
        }

        val dateFormat = SimpleDateFormat(pattern)
        val date: Date = dateFormat.parse(databaseDate)
        val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        outputFormat.timeZone = TimeZone.getDefault()

        return outputFormat.format(date)
    }
}

interface OnItemClickedListener {
    fun onItemClicked(position: Int)
}




