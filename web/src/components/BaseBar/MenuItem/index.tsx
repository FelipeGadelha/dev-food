import React, { ReactElement } from 'react';

import { Container, MenuIcon } from './styles';

type IMenuItemProps = {
  title: string
  Icon: React.ElementType
  path: string
}

const MenuItem: React.FC<IMenuItemProps> = ({title, Icon, path}) => {
  return (
    <Container to={path}>
      <MenuIcon><Icon/></MenuIcon>{title}
    </Container>
  );
}

export default MenuItem;