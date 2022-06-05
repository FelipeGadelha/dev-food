import styled from 'styled-components';

export const Container = styled.div`
  /* display: flex; */
  background: #FFFFFF;
  width: 90%;
  margin: 0 auto;
  height: 6rem;
  overflow: hidden;
  display: flex;
  align-items: center;
  /* padding: 1rem; */
  box-shadow: 0rem 0.4rem 2rem rgba(0, 0, 0, 0.25);
  border-radius: 1rem;
  &:not(:first-child) {
    margin-top: 2rem;
  }
  &:last-child {
    margin-bottom: 2rem;
  }
`;

export const Content = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex: 1;
  padding: 0 2rem;
`;

type StatusColorProps = {
  color: string
}

export const StatusColor = styled.div<StatusColorProps>`
  margin-top: 0.4rem;
  width: 1.4rem;
  height: 4rem;
  border-radius: 0.2rem;
  background-color: ${({ color }) => (color)};
`;

export const OrderId = styled.div`
    font-size: 1.8rem;
`;

export const TotalPrice = styled.div`
    font-size: 2.2rem;
`;
