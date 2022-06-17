package br.com.gusoliveira21.catgallery.view.ui

import br.com.gusoliveira21.catgallery.data.Repository
import junit.framework.TestCase

class MainViewModelInstrumentalTest : TestCase(){

    val func = mockk<() -> Repository>(relaxed = true) // in this case invoke function has generic return type

}
