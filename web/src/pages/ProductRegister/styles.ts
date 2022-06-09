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
  padding: 1.5rem 6rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export const HeaderLeft = styled.div`
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

export const Back = styled.div`
  padding: 1rem;
  text-decoration: none;
  color: #E02041;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 600;
  border-radius: 1rem;
  cursor: pointer;
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
  height: 8rem;
  padding: 1rem;
  border-radius: 0.6rem;
  border: none;
  outline: none;
  color: #333;
  box-shadow: 0.1rem 0.1rem 0.4rem rgba(0, 0, 0, 0.25);
  margin-top: 0.5rem;
  resize: none;
  &:not(:last-child) {
    margin-bottom: 3rem;
  }
`;

export const TextArea = styled.textarea`
  ${sharedStyle}
`;

export const Error = styled.span`
    font-size: 1.4rem;
    margin-left: 1.5rem;
    color: #E02041;
`;

export const Groups = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: flex-end;
`;

type ButtonProps = {
  color?: string
  background?: string
}

export const Button = styled.button<ButtonProps>`
  width: 20%;
  padding: 1rem;
  border: none;
  border-radius: 0.6rem;
  background: ${({ background }) => (background)};
  color: ${({ color }) => (color)};
  transition: 0.2s ease-in-out;
  &:hover {
    filter: brightness(90%);
  }
  &:not(:last-child) {
    margin-right: 2rem;
  }
`;
