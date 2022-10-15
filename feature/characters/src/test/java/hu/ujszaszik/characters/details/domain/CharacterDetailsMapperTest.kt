package hu.ujszaszik.characters.details.domain

import android.arch.core.executor.testing.InstantTaskExecutorRule
import hu.ujszaszik.characters.shared.repository.fakeCharacters
import hu.ujszaszik.extension.fromBase64
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CharacterDetailsMapperTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `test details mapper, when value is returned, then name is mapped appropriately`() {
        val expectedOutcome = "${fakeCharacters[0].firstName} ${fakeCharacters[0].lastName}"
        val mappedValue = CharacterDetailsMapper.map(fakeCharacters[0])
        assertEquals(expectedOutcome, mappedValue.name)
    }

    @Test
    fun `test details mapper, when value is returned, then title is mapped appropriately`() {
        val expectedOutcome = fakeCharacters[0].title
        val mappedValue = CharacterDetailsMapper.map(fakeCharacters[0])
        assertEquals(expectedOutcome, mappedValue.title)
    }

    @Test
    fun `test details mapper, when value is returned, then family is mapped appropriately`() {
        val expectedOutcome = fakeCharacters[0].family
        val mappedValue = CharacterDetailsMapper.map(fakeCharacters[0])
        assertEquals(expectedOutcome, mappedValue.family)
    }

    @Test
    fun `test details mapper, when value is returned, then image url is mapped appropriately`() {
        val expectedOutcome = fakeCharacters[0].imageUrl.fromBase64()
        val mappedValue = CharacterDetailsMapper.map(fakeCharacters[0])
        assertEquals(expectedOutcome, mappedValue.imageUrl)
    }

}