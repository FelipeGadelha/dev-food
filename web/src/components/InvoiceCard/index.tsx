import React from 'react';

import * as S from './styles';

type InvoiceCardTypes = {
  date: string,
  totalMonth: string
}

const InvoiceCard: React.FC<InvoiceCardTypes> = ({date, totalMonth}) => {
  return (
    <S.Container>
      <S.Date><strong>{date}</strong></S.Date>
      <S.TotalMonth><strong>R$ {totalMonth}</strong></S.TotalMonth>
    </S.Container>
  );
}

export default InvoiceCard;
