package br.com.gusoliveira21.catgallery.domain.usercase

import br.com.gusoliveira21.catgallery.data.repository.CatRepository
import br.com.gusoliveira21.catgallery.domain.entities.CatEntity
import br.com.gusoliveira21.catgallery.domain.usercase.base.BaseUseCase

class GetCatImagesUseCase(private val catRepository: CatRepository): BaseUseCase<Unit, List<CatEntity>>() {

    override suspend fun doWork(params: Unit): List<CatEntity> {
        val result = catRepository.getData()
        val catList: MutableList<CatEntity> = mutableListOf()

        result.data.forEach { dataList ->
            dataList.images?.forEach { imageList ->
                if (imageList.type != "video/mp4" || imageList.type != "image/gif") {
                    catList.add(CatEntity(imageList.link))
                }
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