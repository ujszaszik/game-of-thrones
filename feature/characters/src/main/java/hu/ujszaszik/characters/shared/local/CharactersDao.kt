package hu.ujszaszik.characters.shared.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Query("SELECT * FROM characters")
    fun getAll(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM characters WHERE id = :id")
    fun getById(id: Int): Flow<CharacterEntity>

    @Insert
    fun insertAll(characters: List<CharacterEntity>)

    @Query("SELECT COUNT(*) FROM characters")
    fun getSize(): Int

    fun isEmpty() = getSize() == 0
}