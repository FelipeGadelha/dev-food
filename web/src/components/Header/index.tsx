import React from 'react';

import { Container } from './styles';
import Logo from "../../assets/Logo"

const Header: React.FC = () => {
  return (
    <Container>
      <Logo fill="#FFF"/><strong>Dev Food</strong>
    </Container>
  );
}

export default Header;