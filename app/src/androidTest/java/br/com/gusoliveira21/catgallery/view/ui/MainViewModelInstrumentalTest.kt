package br.com.gusoliveira21.catgallery.view.ui

import br.com.data.Repository
import junit.framework.TestCase

class MainViewModelInstrumentalTest : TestCase(){

    val func = mockk<() -> br.com.data.Repository>(relaxed = true) // in this case invoke function has generic return type

}
