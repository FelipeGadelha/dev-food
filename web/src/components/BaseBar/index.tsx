import React from 'react';
import * as BiIcons from 'react-icons/bi';
import * as RiIcons from 'react-icons/ri';
import * as MdIcons from 'react-icons/md';

import { Container, TopSection, MenuItens } from './styles';
import MenuItem from './MenuItem';
import Logo from '../../assets/Logo';

const BaseBar: React.FC = () => {

  return (
    <Container>
      <TopSection>
        <Logo fill='#E02041' /><p><strong>Olá,</strong> User</p>
      </TopSection>
      <MenuItens>
        <MenuItem path="/dashboard" Icon={ RiIcons.RiDashboardLine } title="Dashboard"/>
        <MenuItem path="/food-menu" Icon={ BiIcons.BiFoodMenu } title="Cardápio"/>
        <MenuItem path="/order" Icon={ MdIcons.MdOutlineShoppingCart } title="Pedidos" />
        <MenuItem path="/invoice" Icon={ MdIcons.MdOutlineAttachMoney } title="Faturamento" />
        <MenuItem path="#" Icon={ MdIcons.MdLogout } title="Sair" />
      </MenuItens>
    </Container>
  );
}

export default BaseBar;
