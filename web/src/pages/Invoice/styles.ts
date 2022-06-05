import styled from 'styled-components';

export const Container = styled.div`
  grid-area: main;
  color: #000000;
  overflow-y: auto;
  ::-webkit-scrollbar {
    width: 0.6rem;
  }
  ::-webkit-scrollbar-track {
    box-shadow: inset 0 0 0.6rem rgba(0, 0, 0, 0.3);
  }
  ::-webkit-scrollbar-thumb {
    box-shadow: inset 0 0 0.6rem rgba(0, 0, 0, 0.3);
  }
`;

export const Header = styled.div`
  padding: 1.5rem 6rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export const Title = styled.div`
  width: 50%;
  > h1 {
    font-size: 3.5rem;
    color: #000000;
  }
`;

export const TotalSales = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  > strong {
    font-size: 1.6rem;
    color: #E02041;
  }

`;
export const TotalValue = styled.div`
  background: #E02041;
  margin-top: 0.4rem;
  padding: 0.4rem 2rem;
  text-decoration: none;
  color: #FFF;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 2rem;
  box-shadow: 0rem 0.4rem 2rem rgba(0, 0, 0, 0.25);
  border-radius: 0.6rem;
`;
export const Content = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 5rem;
`;

