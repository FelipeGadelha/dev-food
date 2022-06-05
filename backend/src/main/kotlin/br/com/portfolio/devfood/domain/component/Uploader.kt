package br.com.portfolio.devfood.domain.component

import org.springframework.web.multipart.MultipartFile

interface Uploader {
    fun send(image: MultipartFile): String
}
