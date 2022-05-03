import React from 'react';
import * as GoIcons from 'react-icons/go';

import { Container, Header, HeaderLeft, Actions, Search, Icon, SearchInput, New, Content } from './styles';

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
          <New to="#"><GoIcons.GoPlus/>Novo</New>
        </Actions>
      </Header>
      <Content>
        Listas
      </Content>
    </Container>
  );
}

export default FoodMenu;