package hu.ujszaszik.splash.presentation.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
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
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SplashViewModelTest {

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

    private fun getViewModel() = SplashViewModel()

    @Test
    fun `test viewmodel state, when initialized, then state is loading`() {
        runTest {
            val viewModel = getViewModel()
            val state = viewModel.reducer.state.first()
            assertTrue(state.isLoading)
        }
    }

    @Test
    fun `test viewmodel state, when splash delay finishes, then state is not loading`() {
        runTest {
            val viewModel = getViewModel()
            delay(SplashViewModel.SPLASH_DELAY)
            val state = viewModel.reducer.state.first()
            assertFalse(state.isLoading)
        }
    }
}