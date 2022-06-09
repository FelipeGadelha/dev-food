import styled from 'styled-components';

type InputProps = {
  width?: string
}

export const Container = styled.div<InputProps>`
  display: flex;
  flex-direction: column;
  width: ${({ width }) => (width ? width : "100%")};
  &:not(:last-child) {
    margin-bottom: 0.5rem;
  }
  &:last-child {
    margin-left: 2rem;
  }
`;

export const InputStyle = styled.input`
  font-size: 1.8rem;
  padding: 0.8rem;
  border-radius: 0.6rem;
  border: none;
  outline: none;
  color: #333;
  background-color: #FFF;
  box-shadow: 0.1rem 0.1rem 0.4rem rgba(0, 0, 0, 0.25);
  margin-top: 0.5rem;
`;

export const Label = styled.label`
    font-size: 1.8rem;
    margin-left: 1.5rem;
    color: #9E9E9E;
`;

export const Error = styled.span`
    font-size: 1.4rem;
    margin-left: 1.5rem;
    color: #E02041;
`;
