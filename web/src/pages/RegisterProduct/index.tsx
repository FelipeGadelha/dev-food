import React from 'react';

import * as BiIcons from 'react-icons/bi';
import InputStyle from '../../components/InputStyle';

import { 
  Container,
  Header,
  HeaderLeft,
  Actions,
  Back,
  Content,
  TextArea,
  ContentRow
} from './styles';

const RegisterProduct: React.FC = () => {
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
            <InputStyle type="Text" name="urlImage" title='Url da Imagem:'/>
          </ContentRow>
          <label htmlFor='description'>Descrição:</label>
          <TextArea name="description"/>
          {/* <SubmitButton>Salvar</SubmitButton> */}
        </Content>
    </Container>
  );
}

export default RegisterProduct;