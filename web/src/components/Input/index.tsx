import {
    InputHTMLAttributes,
    forwardRef,
    ForwardRefRenderFunction
  } from 'react';
import { FieldError } from 'react-hook-form';

import { Container, InputStyle, Label, Error } from './styles';

interface InputProps extends InputHTMLAttributes<HTMLInputElement> {
  name: string
  label?: string
  width?: string
  fieldError?: FieldError | undefined
}

const Input: ForwardRefRenderFunction<HTMLInputElement, InputProps>
  = ({name, label, width, fieldError, ...rest}, ref) => {
  return (
    <Container width={width}>
      {label && <Label htmlFor={name}>{label}</Label>}
      {fieldError && <Error>{fieldError.message}</Error>}
      <InputStyle id={name} name={name} ref={ref} {...rest}/>
    </Container>
  );
}

export default forwardRef(Input);
