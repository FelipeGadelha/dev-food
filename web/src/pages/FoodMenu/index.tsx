import React from 'react';
import * as GoIcons from 'react-icons/go';

import { Container, 
  Header, 
  HeaderLeft, 
  Actions, 
  Search, 
  Icon, 
  SearchInput, 
  New, 
  Content
} from './styles';

import ProductCard from '../../components/ProductCard';

const FoodMenu: React.FC = () => {
  return (
    <Container>
      <Header>
        <HeaderLeft>
          <h1>Cardápio</h1>
        </HeaderLeft>
        <Actions>
          <Search>
            <SearchInput placeholder='buscar...' />
            <Icon />
          </Search>
          <New to="/register-product"><GoIcons.GoPlus/>Novo</New>
        </Actions>
      </Header>
      <Content>
        <ProductCard url="https://i.ibb.co/pjPxSqd/camaraothai.webp"/>
        <ProductCard url="https://i.ibb.co/qYYKHN3/coxinha-1030446680-612x612.jpg"/>
        <ProductCard url="https://i.ibb.co/T0jP8ry/porco-agridoce.jpg"/>
        <ProductCard url="https://i.ibb.co/vmJJvbp/salada-grelhada-quente-e-picante-da-carne-de-porco-receita-tailandesa-da-salada-da-carne-tradicional.webp"/>
      </Content>
    </Container>
  );
}

export default FoodMenu;