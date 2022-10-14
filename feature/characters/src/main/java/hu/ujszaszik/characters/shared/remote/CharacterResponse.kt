package hu.ujszaszik.characters.shared.remote

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class CharacterResponse(
    @SerialName("id")
    val id: Int,

    @SerialName("firstName")
    val firstName: String,

    @SerialName("lastName")
    val lastName: String,

    @SerialName("fullName")
    val fullName: String,

    @SerialName("title")
    val title: String,

    @SerialName("family")
    val family: String,

    @SerialName("image")
    val image: String,

    @SerialName("imageUrl")
    val imageUrl: String
)