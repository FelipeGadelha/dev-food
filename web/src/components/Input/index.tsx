import React, { InputHTMLAttributes } from 'react';

import { Container, InputStyle, Label } from './styles';

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
  label: string
  name: string
  width?: string
}

const Input: React.FC<InputProps> = ({label, name, width, ...rest}) => {
  return (
    <Container width={width}>
      <Label htmlFor={name}>{label}</Label>
      <InputStyle id={name} {...rest}/>
    </Container>
  );
}

export default Input;