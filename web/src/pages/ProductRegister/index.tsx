import { useEffect, useState } from 'react';
import { useForm } from 'react-hook-form';
import * as yup from 'yup'
import { yupResolver } from '@hookform/resolvers/yup'

import * as BiIcons from 'react-icons/bi';

import Input from '../../components/Input';
import Select from '../../components/Select';

import { Categories } from '../../types/Category';
import { ProductFormData } from '../../types/Product'
import { api } from '../../services/api';

import { toast } from 'react-toastify'
import * as S from './styles';
import { useNavigate } from 'react-router-dom';

const SUPPORTED_FORMATS = ['image/png', 'image/jpeg']

const productFormSchema = yup.object().shape({
  name: yup.string().required('nome obrigatório'),
  description: yup.string().required('descrição obrigatório'),
  price: yup.string().required('preço obrigatório'),
  category: yup.string().required('categoria obrigatória'),
  image: yup.mixed().required('selecione uma imagem')
    .test(
      "FILE_SIZE",
      "selecione uma imagem",
      (value) => {return !value || value.length > 0}
    ).test(
      "FILE_FORMAT",
      "O arquivo de imagem tem formato incompatível",
      (value) =>
        !value ||
          (value && value.length > 0 &&
            SUPPORTED_FORMATS.includes(value[0].type))
    )
})

function ProductRegister() {

  const [categories, setCategories] = useState<Categories>([])
  const navigate = useNavigate();

  useEffect(() => {
    api.get(`/v1/categories`)
    .then( response => {
      setCategories(response.data)
      console.log(response.data)
    }
  )}, [])

  const {
    handleSubmit,
    setValue,
    getValues,
    reset,
    register,
    formState: { errors,  }
  } = useForm({
    defaultValues: {"category": ""} as ProductFormData,
    resolver: yupResolver(productFormSchema)
  })

  async function onSubmit(data: ProductFormData){
    const image = document.getElementById("image") as HTMLInputElement
    const formData = new FormData();
    formData.append('name', data.name)
    formData.append('price', data.price)
    formData.append('categoryId', data.category)
    formData.append('description', data.description)
    formData.append('image', image?.files?.item(0) as File)

    await api.post('/v1/products', formData, {
      headers: { "Content-Type": "multipart/form-data" }
    })
    .then((response) => {toast.error("Produto salvo com sucesso! " + response.data.id)})
    .then(() => reset())
    .catch(() => {toast.warn("Erro ao salvar o produto!")})
  }

  return (
    <S.Container>
      <S.Header>
        <S.HeaderLeft>
          <h1>Adicionar Produto</h1>
        </S.HeaderLeft>
        <S.Actions>
          <S.Back onClick={() => navigate(-1)}>
            <BiIcons.BiLeftArrowAlt />Voltar
          </S.Back>
        </S.Actions>
      </S.Header>
      <S.Content onSubmit={handleSubmit(onSubmit)}>
        <Input type="text" label='Nome' {...register('name')} fieldError={errors.name}/>
        <S.ContentRow>
          <Input
            type="Text"
            label='Preço'
            width='40%'
            fieldError={errors.price}
            {...register('price')}
          />
          <Select
            label="Categoria"
            {...register('category')}
            fieldError={errors.category}
            value={getValues('category')}
            onChange={(e) => setValue('category', e.target.value, {shouldValidate: true})}
            options={categories.map(c => ({value: c.id.toString(), label: c.name}))}
          />
        </S.ContentRow>
        <Input
          type="file"
          label='Imagem'
          accept='image/png, image/jpeg'
          {...register('image')}
          fieldError={errors.image}
        />
        <label htmlFor='description'>Descrição</label>
        {errors.description && <S.Error>{errors.description.message}</S.Error>}
        <S.TextArea id='description' {...register('description')}/>
        <S.Groups>
          <S.Button onClick={() => {reset()}}>Cancelar</S.Button>
          {/* <Input name='reset' type="reset" /> */}
          <S.Button
            background='#E02041'
            color='#FFF'
            type='submit'
          >Salvar</S.Button>
        </S.Groups>
      </S.Content>
    </S.Container>
  );
}

export default ProductRegister;
