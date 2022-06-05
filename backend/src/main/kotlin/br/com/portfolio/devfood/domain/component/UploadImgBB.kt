package br.com.portfolio.devfood.domain.component

import br.com.portfolio.devfood.infra.integration.ImgBBClient
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class UploadImgBB(
    private val imgBBClient: ImgBBClient
): Uploader {

    override fun send(image: MultipartFile): String {
//        return imgBBClient.uploader(mapOf("image" to image.bytes))
        return ""
    }
}