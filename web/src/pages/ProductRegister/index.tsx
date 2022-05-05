import React, { useState } from 'react';

import * as BiIcons from 'react-icons/bi';
import InputStyle from '../../components/InputStyle';
import SelectStyle from '../../components/SelectStyle';

import { 
  Container,
  Header,
  HeaderLeft,
  Actions,
  Back,
  Content,
  TextArea,
  ContentRow,
  Groups,
  Button
} from './styles';

const ProductRegister: React.FC = () => {
  
  const [category, setCategory] = useState('')

  return (
    <Container>
      <Header>
        <HeaderLeft>
          <h1>Adicionar Produto</h1>
        </HeaderLeft>
        <Actions>
          <Back to="/food-menu"><BiIcons.BiLeftArrowAlt/>Voltar</Back>
        </Actions>
      </Header>
      <Content>
        <InputStyle type="Text" name="title" title='Título:'/>
        <ContentRow>
          <InputStyle type="Text" name="preco" title='Preço:' width='40%'/>
          <SelectStyle 
            label="Categoria:"
            name="category"
            value={category}
            onChange={e => setCategory(e.target.value)}
            options={[
              {value: "0", label: "Prato Principal"},
              {value: "1", label: "Sobremesa"},
              {value: "2", label: "Bebida"}
            ]}
          />
        </ContentRow>
        <InputStyle type="Text" name="urlImage" title='Url da Imagem:'/>
        <label htmlFor='description'>Descrição:</label>
        <TextArea name="description"/>
        <Groups>
          <Button>Cancelar</Button>
          <Button background='#E02041' color='#FFF'>Salvar</Button>
        </Groups>
      </Content>
    </Container>
  );
}

export default ProductRegister;