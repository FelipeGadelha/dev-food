import React from 'react';
import InvoiceCard from '../../components/InvoiceCard';

import * as S from './styles';

const Invoice: React.FC = () => {
  return (
    <S.Container>
      <S.Header>
        <S.Title>
          <h1>Faturamento</h1>
        </S.Title>
        <S.TotalSales>
          <strong>total das vendas:</strong>
          <S.TotalValue><strong>R$ 40.152,45</strong></S.TotalValue>
        </S.TotalSales>
      </S.Header>
      <S.Content>
        <InvoiceCard date='junho 2021' totalMonth='170,30'/>
        <InvoiceCard date='junho 2021' totalMonth='125,50'/>
        <InvoiceCard date='junho 2021' totalMonth='90,50'/>
        <InvoiceCard date='junho 2021' totalMonth='30,15'/>
        <InvoiceCard date='junho 2021' totalMonth='30,15'/>
        <InvoiceCard date='junho 2021' totalMonth='30,15'/>
        <InvoiceCard date='junho 2021' totalMonth='30,15'/>
      </S.Content>
    </S.Container>
  );
}

export default Invoice;
