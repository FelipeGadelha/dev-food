import React, { useEffect, useState } from 'react';
import * as GoIcons from 'react-icons/go';
import ProductCard from '../../components/ProductCard';
import { api } from '../../services/api';
import { Products } from '../../types/Product';

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

const FoodMenu: React.FC = () => {

  const [products, setProducts] = useState<Products>([])

  useEffect(() => {
    api.get(`/v1/products`)
      .then( response => {
        console.log(response.data)
        setProducts(response.data)
      }
    )
  }, [])

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
          <New to="/product-register"><GoIcons.GoPlus/>Novo</New>
        </Actions>
      </Header>
      <Content>
        {
          products.map(p =>
            <ProductCard
              key={p.id}
              url={p.imageLink}
              description={p.description}
              price={p.price.toString()}
              title={p.name}
            />
          )
        }
        {/* <ProductCard url="https://i.ibb.co/pjPxSqd/camaraothai.webp"/>
        <ProductCard url="https://i.ibb.co/qYYKHN3/coxinha-1030446680-612x612.jpg"/>
        <ProductCard url="https://i.ibb.co/T0jP8ry/porco-agridoce.jpg"/>
        <ProductCard url="https://i.ibb.co/vmJJvbp/salada-grelhada-quente-e-picante-da-carne-de-porco-receita-tailandesa-da-salada-da-carne-tradicional.webp"/> */}
      </Content>
    </Container>
  );
}

export default FoodMenu;
