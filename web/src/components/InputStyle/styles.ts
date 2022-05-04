import styled from 'styled-components';

type InputProps = {
  width?: string
}

export const Container = styled.div<InputProps>`
  display: flex;
  flex-direction: column;
  width: ${({ width }) => (width ? width : "100%")};
  &:not(:last-child) {
    margin-bottom: 1.5rem;
  }
  &:last-child {
    margin-left: 2rem;
  }
`;

export const Input = styled.input`
  font-size: 1.8rem;
  padding: 1rem;
  border-radius: 0.8rem;
  border: none;
  outline: none;
  color: #333;
  box-shadow: 0.1rem 0.1rem 0.4rem rgba(0, 0, 0, 0.25);
  margin-top: 0.5rem;
`;

export const Label = styled.label`
    font-size: 2rem;
    margin-left: 1.5rem;
    color: #9E9E9E;
`;