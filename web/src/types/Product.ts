import { Category } from "./Category"

export type Product = {
  id: number
  name: string
  description: string
  price: number
  imageLink: string
  active: boolean
  category: Category
}

export type Products = Product[]

export type ProductFormData = {
  name: string,
  price: string,
  description: string
  category: string,
  image: File
}
