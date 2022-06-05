package br.com.portfolio.devfood.infra.dto.response

data class ImgBBRs(
  val data: ImgData
)
data class ImgData(
    val url: String,
    val delete_url: String
)
//{
//    "data": {
//        "id": "3z7QtGr",
//        "title": "cf50136f29bd",
//        "url_viewer": "https:\/\/ibb.co\/3z7QtGr",
//        "url": "https:\/\/i.ibb.co\/NSsbwQV\/cf50136f29bd.png",
//        "display_url": "https:\/\/i.ibb.co\/NSsbwQV\/cf50136f29bd.png",
//        "width": "225",
//        "height": "225",
//        "size": 2341,
//        "time": "1654366514",
//        "expiration": "600",
//    "image": {
//        "filename": "cf50136f29bd.png",
//        "name": "cf50136f29bd",
//        "mime": "image\/png",
//        "extension": "png",
//        "url": "https:\/\/i.ibb.co\/NSsbwQV\/cf50136f29bd.png"
//    },
//    "thumb": {
//        "filename": "cf50136f29bd.png",
//        "name": "cf50136f29bd",
//        "mime": "image\/png",
//        "extension": "png",
//        "url": "https:\/\/i.ibb.co\/3z7QtGr\/cf50136f29bd.png"
//    },
//    "delete_url": "https:\/\/ibb.co\/3z7QtGr\/ec65c365f77421e5345c20cd754576b5"
//    },
//    "success": true,
//    "status": 200
//}