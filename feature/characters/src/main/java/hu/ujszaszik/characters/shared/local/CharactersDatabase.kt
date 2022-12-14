package hu.ujszaszik.characters.shared.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun dao(): CharactersDao
}