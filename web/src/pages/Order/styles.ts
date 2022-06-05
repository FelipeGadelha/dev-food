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

export const Filters = styled.div`
  display: flex;
`;

export const DatePicker = styled.input`
  padding: 0.5rem;
  border-radius: 0.5rem;
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
`;

export const Status = styled.div`
  display: flex;
  justify-content: center;
`;

export const StatusContent = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: 2rem;
  &:last-child {
    margin-left: 2rem;
  }
`;

type StatusColorProps = {
  color: string
}

export const StatusColor = styled.div<StatusColorProps>`
  margin-top: 0.4rem;
  width: 5rem;
  height: 1rem;
  background-color: ${({ color }) => (color)};
`;
