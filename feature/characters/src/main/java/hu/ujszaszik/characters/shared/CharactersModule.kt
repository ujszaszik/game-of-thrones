package hu.ujszaszik.characters.shared

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.ujszaszik.characters.shared.local.CharactersDatabase
import hu.ujszaszik.characters.shared.repository.CharactersRepository
import hu.ujszaszik.characters.shared.repository.ICharactersRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharactersModule {

    private const val DATABASE_NAME = "Characters_DB"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CharactersDatabase {
        return Room.databaseBuilder(
            context,
            CharactersDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

}

@Module
@InstallIn(SingletonComponent::class)
interface CharactersRepositoryModule {

    @Binds
    @Singleton
    fun bindCharactersRepository(charactersRepository: CharactersRepository): ICharactersRepository
}