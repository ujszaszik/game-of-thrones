package hu.ujszaszik.characters.list.domain

import android.arch.core.executor.testing.InstantTaskExecutorRule
import hu.ujszaszik.characters.shared.repository.fakeCharacters
import hu.ujszaszik.extension.fromBase64
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CharacterGridMapperTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `test grid mapper, when values are passed, then return value has appropriate size`() {
        val expectedOutcome = fakeCharacters.size
        val mappedValues = CharacterGridMapper.map(fakeCharacters)
        assertEquals(expectedOutcome, mappedValues.size)
    }

    @Test
    fun `test grid mapper, when empty value is passed, then return value is also empty`() {
        val expectedOutcome = 0
        val mappedValues = CharacterGridMapper.map(emptyList())
        assertEquals(expectedOutcome, mappedValues.size)
    }

    @Test
    fun `test grid mapper, when value is returned, then id is mapped appropriately`() {
        val expectedOutcome = fakeCharacters[0].id
        val mappedValue = CharacterGridMapper.map(fakeCharacters)[0]
        assertEquals(expectedOutcome, mappedValue.id)
    }

    @Test
    fun `test grid mapper, when value is returned, then image url is mapped appropriately`() {
        val expectedOutcome = fakeCharacters[0].imageUrl.fromBase64()
        val mappedValue = CharacterGridMapper.map(fakeCharacters)[0]
        assertEquals(expectedOutcome, mappedValue.imageUrl)
    }

}