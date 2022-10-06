package br.com.domain.usercase

import br.com.domain.entities.CatEntity
import br.com.domain.repository.CatRepository
import br.com.domain.usercase.base.BaseUseCase

class GetCatImagesUseCase(private val catRepository: CatRepository): BaseUseCase<Unit, List<CatEntity>>() {

    override suspend fun doWork(wordToSearch: String): List<CatEntity> {
        val result = catRepository.getCats(wordToSearch)
        val catList: MutableList<CatEntity> = mutableListOf()
        result.forEach { image ->
            if (image.type != "video/mp4" || image.type != "image/gif") {
                catList.add(image)
            }
        }
        return catList
    }

//    private fun getListImg(listData: CatDataClass) {
//        val listUriCat: MutableList<String> = mutableListOf()
//        listData.data.forEach { dataList ->
//            dataList.images.forEach { imageList ->
//                if (imageList.type != "video/mp4" || imageList.type != "image/gif") {
//                    listUriCat.add(imageList.link)
//                }
//            }
//        }
//    }
}