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
  justify-content: space-between;
  padding: 3rem;
  box-shadow: 0rem 0.4rem 2rem rgba(0, 0, 0, 0.25);
  border-radius: 1rem;
  &:not(:first-child) {
    margin-top: 2rem;
  }
  &:last-child {
    margin-bottom: 2rem;
  }
`;

export const Date = styled.div`
    font-size: 1.8rem;
`;

export const TotalMonth = styled.div`
    font-size: 2.2rem;
`;
