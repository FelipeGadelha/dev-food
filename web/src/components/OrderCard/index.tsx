import React from 'react';

import * as S from './styles';

type OrderCardTypes = {
  orderId: string,
  totalPrice: string,
  color: string
}

const OrderCard: React.FC<OrderCardTypes> = ({orderId, totalPrice, color}) => {
  return (
    <S.Container>
      <S.StatusColor color={color}/>
      <S.Content>
        <S.OrderId><strong>Pedido n° {orderId}</strong></S.OrderId>
        <S.TotalPrice><strong>R$ {totalPrice}</strong></S.TotalPrice>
      </S.Content>
    </S.Container>
  );
}

export default OrderCard;
