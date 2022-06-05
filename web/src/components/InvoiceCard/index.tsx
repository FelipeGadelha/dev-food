import React from 'react';

import * as S from './styles';

type RevenueCardTypes = {
  date: string,
  totalMonth: string
}

const RevenueCard: React.FC<RevenueCardTypes> = ({date, totalMonth}) => {
  return (
    <S.Container>
      <S.Date><strong>{date}</strong></S.Date>
      <S.TotalMonth><strong>R$ {totalMonth}</strong></S.TotalMonth>
    </S.Container>
  );
}

export default RevenueCard;
