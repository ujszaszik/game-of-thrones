package hu.ujszaszik.characters.details.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import hu.ujszaszik.characters.details.domain.CharacterDetailsMapper
import hu.ujszaszik.characters.details.domain.GetCharacterByIdUseCase
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
class CharacterDetailsViewModelTest {

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

    private fun getViewModel(throwError: Boolean = false): CharacterDetailsViewModel {
        val useCase = GetCharacterByIdUseCase(FakeCharactersRepository(throwError))
        return CharacterDetailsViewModel(useCase)
    }

    @Test
    fun `test viewmodel state, when initialized, then state is loading`() {
        runTest {
            val viewModel = getViewModel()
            val state = viewModel.reducer.state.first()
            assertTrue(state.isLoading)
        }
    }

    @Test
    fun `test viewmodel state, when load finished without error, then it is not loading anymore`() {
        runTest {
            val testId = 1
            val viewModel = getViewModel()
            viewModel.loadCharacterDetails(testId)
            val state = viewModel.reducer.state.first()
            assertFalse(state.isLoading)
        }
    }

    @Test
    fun `test viewmodel state, when load finished without error, then success is returned`() {
        runTest {
            val testId = 1
            val viewModel = getViewModel()
            viewModel.loadCharacterDetails(testId)
            val state = viewModel.reducer.state.first()
            assertNotNull(state.character)
        }
    }

    @Test
    fun `test viewmodel state, when load finished without error, then appropriate value is returned`() {
        runTest {
            val testId = 1
            val expectedOutcome = CharacterDetailsMapper.map(fakeCharacters[testId - 1])
            val viewModel = getViewModel()
            viewModel.loadCharacterDetails(testId)
            val state = viewModel.reducer.state.first()
            assertEquals(expectedOutcome, state.character)
        }
    }

    @Test
    fun `test viewmodel state, when load finished with error, then it is not loading anymore`() {
        runTest {
            val testId = 1
            val viewModel = getViewModel(true)
            viewModel.loadCharacterDetails(testId)
            val state = viewModel.reducer.state.first()
            assertFalse(state.isLoading)
        }
    }

    @Test
    fun `test viewmodel state, when load finished with error, then no character returned`() {
        runTest {
            val testId = 1
            val viewModel = getViewModel(true)
            viewModel.loadCharacterDetails(testId)
            val state = viewModel.reducer.state.first()
            assertNull(state.character)
        }
    }

}