import { useEffect, useState } from 'react';

import * as BiIcons from 'react-icons/bi';
import Input from '../../components/Input';
import Select from '../../components/Select';

import { Categories } from '../../types/Category';
import { api } from '../../services/api';

import * as S from './styles';
import { useNavigate } from 'react-router-dom';

function ProductRegister() {

  const [category, setCategory] = useState('')
  const [categories, setCategories] = useState<Categories>([])
  const navigate = useNavigate();
  useEffect(() => {
    api.get(`/v1/categories`)
      .then( response => {
        setCategories(response.data)
        console.log(response.data)
      }
    )
  }, [])

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
      <S.Content>
        <Input type="text" name="title" label='Título:'/>
        <S.ContentRow>
          <Input type="Text" name="preco" label='Preço:' width='40%'/>
          <Select
            label="Categoria:"
            name="category"
            value={category}
            onChange={e => setCategory(e.target.value)}
            options={categories.map(c => ({value: c.id.toString(), label: c.name}))}
          />
        </S.ContentRow>
        <Input type="file" name="urlImage" label='Imagem:'/>
        <label htmlFor='description'>Descrição:</label>
        <S.TextArea name="description"/>
        <S.Groups>
          <S.Button>Cancelar</S.Button>
          <S.Button background='#E02041' color='#FFF'>Salvar</S.Button>
        </S.Groups>
      </S.Content>
    </S.Container>
  );
}

export default ProductRegister;
