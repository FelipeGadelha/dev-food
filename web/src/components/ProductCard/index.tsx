import React from 'react';
import * as BiIcons from 'react-icons/bi';

import {
  Container,
  Image,
  Data,
  Header,
  Title,
  Actions,
  EditLink,
  DeleteLink,
  Description
} from './styles';

type ProductCardTypes = {
  url?: string,
  title?: string,
  price?: string,
  description?: string
}

const ProductCard: React.FC<ProductCardTypes> = ({url, title, price, description}) => {
  return (
    <Container>
      <Image src={url} />
      <Data>
        <Header>
          <Title>{title} - R$ {price}</Title>
          <Actions>
            <EditLink to="#"><BiIcons.BiEdit/>Editar</EditLink>
            <DeleteLink to="#"><BiIcons.BiTrash/>Excluir</DeleteLink>
          </Actions>
        </Header>
        <strong>Descrição</strong>
        <Description>{description}
          {/* Lorem ipsum dolor sit, amet consectetur adipisicing elit. Distinctio temporibus,
          fugiat ipsum voluptate eaque aspernatur sequi tempora, facilis tempore cum ex fugit numquam vitae!
          Animi, numquam eveniet? Modi, voluptate quia? */}
        </Description>
      </Data>
    </Container>
  );
}

export default ProductCard;
