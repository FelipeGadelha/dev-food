import {
    forwardRef,
    ForwardRefRenderFunction,
    SelectHTMLAttributes
  } from 'react';
import { FieldError } from 'react-hook-form';

import { Container, Label, SelectStyle, Error} from './styles';

interface SelectProps extends SelectHTMLAttributes<HTMLSelectElement> {
  label?: string
  name: string
  width?: string
  fieldError?: FieldError | undefined
  options: Array<{
    value: string
    label: string
  }>
}

const Select: ForwardRefRenderFunction<HTMLSelectElement, SelectProps>
  = ({label, name, width, options, fieldError, ...rest}, ref) => {
    return (
    <Container width={width}>
      {label && <Label htmlFor={name}>{label}</Label>}
      {fieldError && <Error>{fieldError.message}</Error>}
      <SelectStyle value="" id={name} name={name} ref={ref} {...rest}>
        <option disabled key="disabled" value="">Selecione</option>
        {options.map((opt, i) => (
          <option key={i} value={opt.value}>{opt.label}</option>
        ))}
      </SelectStyle>
    </Container>
  );
}

export default forwardRef(Select);
