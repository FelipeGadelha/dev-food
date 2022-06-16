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

export const Actions = styled.div`
  width: 50%;
  display: flex;
  justify-content: end;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 5rem;
`;
