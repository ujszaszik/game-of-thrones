package hu.ujszaszik.characters.shared.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "family")
    val family: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String
)