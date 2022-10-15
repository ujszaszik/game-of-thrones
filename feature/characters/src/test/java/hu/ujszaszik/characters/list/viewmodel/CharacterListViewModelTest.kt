package hu.ujszaszik.characters.list.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import hu.ujszaszik.characters.list.domain.CharacterGridMapper
import hu.ujszaszik.characters.list.domain.GetCharactersListUseCase
import hu.ujszaszik.characters.shared.repository.FakeCharactersRepository
import hu.ujszaszik.characters.shared.repository.fakeCharacters
import junit.framework.Assert.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
class CharacterListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private fun getViewModel(throwError: Boolean = false): CharactersListViewModel {
        val useCase = GetCharactersListUseCase(FakeCharactersRepository(throwError))
        return CharactersListViewModel(useCase)
    }

    @Test
    fun `test viewmodel state, when load finished without error, then it is not loading anymore`() {
        runTest {
            val viewModel = getViewModel()
            val state = viewModel.reducer.state.first()
            assertFalse(state.isLoading)
        }
    }

    @Test
    fun `test viewmodel state, when load finished without error, then success is returned`() {
        runTest {
            val viewModel = getViewModel()
            val state = viewModel.reducer.state.first()
            assertNotNull(state.characters)
        }
    }

    @Test
    fun `test viewmodel state, when load finished without error, then returned value has appropriate size`() {
        runTest {
            val viewModel = getViewModel()
            val expectedOutcome = fakeCharacters.size
            val state = viewModel.reducer.state.first()
            assertEquals(expectedOutcome, state.characters?.size)
        }
    }

    @Test
    fun `test viewmodel state, when load finished without error, then returned value has appropriate values`() {
        runTest {
            val viewModel = getViewModel()
            val expectedOutcome = CharacterGridMapper.map(fakeCharacters)
            val state = viewModel.reducer.state.first()
            assertEquals(expectedOutcome, state.characters)
        }
    }

    @Test
    fun `test viewmodel state, when load finished with error, then it is not loading anymore`() {
        runTest {
            val viewModel = getViewModel(true)
            val state = viewModel.reducer.state.first()
            assertFalse(state.isLoading)
        }
    }

    @Test
    fun `test viewmodel state, when load finished with error, then no characters returned`() {
        runTest {
            val viewModel = getViewModel(true)
            val state = viewModel.reducer.state.first()
            assertNull(state.characters)
        }
    }

}