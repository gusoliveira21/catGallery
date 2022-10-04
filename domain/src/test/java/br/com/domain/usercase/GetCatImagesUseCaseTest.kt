package br.com.domain.usercase

import assertk.assertThat
import assertk.assertions.isEqualTo
import br.com.domain.MainCoroutineRule
import br.com.domain.catDataExpected
import br.com.domain.catDataReality
import br.com.domain.repository.CatRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

/**
 * Referencia: https://medium.com/swlh/unit-testing-with-kotlin-coroutines-the-android-way-19289838d257
 * https://medium.com/google-developer-experts/unit-testing-kotlin-flow-76ea5f4282c5
 */
class GetCatImagesUseCaseTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = MainCoroutineRule()

    private val repository = mockk<CatRepository>(relaxed = true)


    @ExperimentalCoroutinesApi
    @Test
    fun `checks if the function return is a link`() = runBlocking {
        // arrange
        coEvery { repository.getCats("cat") } returns catDataReality
        val getCatImagesUseCaseTest = GetCatImagesUseCase(repository)

        // act
        val result = getCatImagesUseCaseTest.execute("cat")

        // assert
        assertThat(result.success.data.first().image).isEqualTo(catDataExpected)
    }
}