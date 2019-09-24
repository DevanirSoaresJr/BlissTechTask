package devanir.soaresjunior.blisstechtaskdevanir.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class StatusResponse(

    var status: String? = null
)

@Parcelize
data class QuestionsResponse(
    val id: Int,
    val question: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("thumb_url")
    val thumbUrl: String,
    @SerializedName("published_at")
    val publishedAt: String,
    val choices: List<Choice>
) : Parcelable

@Parcelize
data class Choice(
    val choice: String,
    val votes: Int
) : Parcelable