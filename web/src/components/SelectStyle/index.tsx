import React, { SelectHTMLAttributes } from 'react';

import { Container, Label, Select} from './styles';

interface SelectProps extends SelectHTMLAttributes<HTMLSelectElement> {
  label: string
  name: string
  options: Array<{
    value: string
    label: string
  }>
}

const SelectStyle: React.FC<SelectProps> = ({label, name, options, ...rest}) => {
  return (
    <Container>
      {/* <Label htmlFor='category'>Categoria:</Label> */}
      <Label htmlFor={name}>{label}</Label>
      <Select value="" id={name} {...rest}>
      {/* <Select> */}
        <option disabled value="">Selecione uma opção</option>
        {options.map((opt, i) => (
          <option key={i} value={opt.value}>{opt.label}</option>  
        ))} 
      </Select>
    </Container>
  );
}

export default SelectStyle;