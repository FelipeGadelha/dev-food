import React from 'react';

import { Container, Input, Label } from './styles';

type InputStyleProps = {
  title: string
  name: string
  type: string
  placeholder?: string
  width?: string
}

const InputStyle: React.FC<InputStyleProps> = ({title, name, type, placeholder, width}) => {
  return (
    <Container width={width}>
      <Label htmlFor={name}>{title}</Label>
      <Input type={type} placeholder={placeholder}/>
    </Container>
  );
}

export default InputStyle;