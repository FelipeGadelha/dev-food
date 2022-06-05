import React, { useEffect, useState } from 'react';
import OrderCard from '../../components/OrderCard';

import * as S from './styles';

const Order: React.FC = () => {

  const [startDate, setStartDate] = useState(new Date().toString());

  useEffect(() => {
    console.log(startDate)
  }, [startDate])

  return (
    <S.Container>
      <S.Header>
      <S.Title>
        <h1>Pedidos</h1>
      </S.Title>
      <S.Filters>
        <S.DatePicker
          type="date"
          onChange={(e) => setStartDate(e.target.value)}
          value={startDate}
        />
      </S.Filters>
    </S.Header>
    <S.Content>
      <S.Status>
        <S.StatusContent>
          <h3>Entregues</h3>
          <S.StatusColor color='#9E9E9E'/>
        </S.StatusContent>
        <S.StatusContent>
          <h3>Não entregues</h3>
          <S.StatusColor color='#E02041'/>
        </S.StatusContent>
      </S.Status>
      <OrderCard color='#E02041' orderId='1' totalPrice='170,30'/>
      <OrderCard color='#E02041' orderId='2' totalPrice='125,50'/>
      <OrderCard color='#E02041' orderId='3' totalPrice='90,50'/>
      <OrderCard color='#E02041' orderId='4' totalPrice='30,15'/>
      <OrderCard color='#E02041' orderId='4' totalPrice='30,15'/>
      <OrderCard color='#E02041' orderId='4' totalPrice='30,15'/>
      <OrderCard color='#E02041' orderId='4' totalPrice='30,15'/>
    </S.Content>
  </S.Container>
  );
}

export default Order;
