import { Link } from 'react-router-dom';
import styled, { css } from 'styled-components';

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
  padding: 3rem 6rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export const HeaderLeft = styled.div`
  width: 50%;
  > h1 {
    color: #000000;
  }
`;

export const Actions = styled.div`
  width: 50%;
  display: flex;
  justify-content: end;
`;

export const Back = styled(Link)`
  padding: 1rem;
  text-decoration: none;
  color: #E02041;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 600;
  border-radius: 1rem;
`;

export const Content = styled.form`
  display: flex;
  flex-direction: column;
  width: 80%;
  margin: 0 auto;
  > label {
    font-size: 2rem;
    margin-left: 1.5rem;
    color: #9E9E9E;
  }
`;

export const ContentRow = styled.div`
  display: inline-flex;
`;

const sharedStyle = css`
  font-size: 1.8rem;
  height: 12rem;
  padding: 1rem;
  border-radius: 0.8rem;
  border: none;
  outline: none;
  color: #333;
  box-shadow: 0.1rem 0.1rem 0.4rem rgba(0, 0, 0, 0.25);
  margin-top: 0.5rem;
  resize: none;
  &:not(:last-child) {
    margin-bottom: 2rem;
  }
`;

export const TextArea = styled.textarea`
  ${sharedStyle}
`;