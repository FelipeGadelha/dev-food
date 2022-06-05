import React, { SelectHTMLAttributes } from 'react';

import { Container, Label, SelectStyle} from './styles';

interface SelectProps extends SelectHTMLAttributes<HTMLSelectElement> {
  label?: string
  name: string
  width?: string
  options: Array<{
    value: string
    label: string
  }>
}

const Select: React.FC<SelectProps> = ({label, name, width, options, ...rest}) => {
  return (
    <Container width={width}>
      {/* <Label htmlFor='category'>Categoria:</Label> */}
      {label && <Label htmlFor={name}>{label}</Label>}
      <SelectStyle value="" id={name} {...rest}>
      {/* <Select> */}
        <option disabled key="disabled" value="">Selecione</option>
        {options.map((opt, i) => (
          <option key={i} value={opt.value}>{opt.label}</option>  
        ))} 
      </SelectStyle>
    </Container>
  );
}

export default Select;