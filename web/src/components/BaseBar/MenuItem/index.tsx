import React, { ReactElement } from 'react';

import { Container, MenuIcon } from './styles';

type IMenuItemProps = {
  title: string,
  icon: ReactElement<any, any>
  path: string
}

const MenuItem: React.FC<IMenuItemProps> = ({title, icon, path}) => {
  return (
    <Container to={path}>
      <MenuIcon>{icon}</MenuIcon>{title}
    </Container>
  );
}

export default MenuItem;