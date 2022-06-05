package br.com.portfolio.devfood.infra.integration

import br.com.portfolio.devfood.infra.dto.response.ImgBBRs
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart

@FeignClient(
    name = "imgbb",
    url = "https://api.imgbb.com"
)
interface ImgBBClient {

    @PostMapping(
        path = ["/1/upload?expiration=600&key=f54d57248bf481f177e5f0500f14a351"],
        consumes = ["multipart/form-data"]
    )
    fun uploader(@RequestPart("image") image: String): ImgBBRs
//    fun uploader(@RequestBody image: String): String
}