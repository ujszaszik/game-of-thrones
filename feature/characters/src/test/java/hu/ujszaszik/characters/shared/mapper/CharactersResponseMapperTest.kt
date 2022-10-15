package hu.ujszaszik.characters.shared.mapper

import android.arch.core.executor.testing.InstantTaskExecutorRule
import hu.ujszaszik.characters.shared.remote.fakeCharacterResponses
import hu.ujszaszik.extension.toBase64
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CharactersResponseMapperTest {

    @get:Rule
    var instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `test response mapper, when values are passed, then return value has appropriate size`() {
        val expectedOutcome = fakeCharacterResponses.size
        val mappedValues = CharactersResponseMapper.map(fakeCharacterResponses)
        assertEquals(expectedOutcome, mappedValues.size)
    }

    @Test
    fun `test response mapper, when empty value is passed, then return value is also empty`() {
        val expectedOutcome = 0
        val mappedValues = CharactersResponseMapper.map(emptyList())
        assertEquals(expectedOutcome, mappedValues.size)
    }

    @Test
    fun `test response mapper, when value is returned, then id is mapped appropriately`() {
        val expectedOutcome = fakeCharacterResponses[0].id
        val testList = listOf(fakeCharacterResponses[0])
        val mappedValues = CharactersResponseMapper.map(testList)
        assertEquals(expectedOutcome, mappedValues[0].id)
    }

    @Test
    fun `test response mapper, when value is returned, then first name is mapped appropriately`() {
        val expectedOutcome = fakeCharacterResponses[0].firstName
        val testList = listOf(fakeCharacterResponses[0])
        val mappedValues = CharactersResponseMapper.map(testList)
        assertEquals(expectedOutcome, mappedValues[0].firstName)
    }

    @Test
    fun `test response mapper, when value is returned, then last name is mapped appropriately`() {
        val expectedOutcome = fakeCharacterResponses[0].lastName
        val testList = listOf(fakeCharacterResponses[0])
        val mappedValues = CharactersResponseMapper.map(testList)
        assertEquals(expectedOutcome, mappedValues[0].lastName)
    }

    @Test
    fun `test response mapper, when value is returned, then title is mapped appropriately`() {
        val expectedOutcome = fakeCharacterResponses[0].title
        val testList = listOf(fakeCharacterResponses[0])
        val mappedValues = CharactersResponseMapper.map(testList)
        assertEquals(expectedOutcome, mappedValues[0].title)
    }

    @Test
    fun `test response mapper, when value is returned, then family is mapped appropriately`() {
        val expectedOutcome = fakeCharacterResponses[0].family
        val testList = listOf(fakeCharacterResponses[0])
        val mappedValues = CharactersResponseMapper.map(testList)
        assertEquals(expectedOutcome, mappedValues[0].family)
    }

    @Test
    fun `test response mapper, when value is returned, then image url is mapped appropriately`() {
        val expectedOutcome = fakeCharacterResponses[0].imageUrl.toBase64()
        val testList = listOf(fakeCharacterResponses[0])
        val mappedValues = CharactersResponseMapper.map(testList)
        assertEquals(expectedOutcome, mappedValues[0].imageUrl)
    }

}