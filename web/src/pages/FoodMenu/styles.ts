import { Link } from "react-router-dom";
import styled from "styled-components";
import * as GoIcons from 'react-icons/go';

export const Container = styled.div`
  grid-area: main;
  color: #000000;
`;

export const Header = styled.div`
  padding: 3rem 5rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export const HeaderLeft = styled.div`
  /* background-color: red; */
  width: 50%;
  > h1 {
    color: #000000;
  }
`;


export const Actions = styled.div`
  /* background-color: blue; */
  width: 50%;
  display: flex;
  justify-content: end;

`;

export const Search = styled.div`
  background: #FFF;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 0.8rem;
  overflow: hidden;
  padding: 0.8rem;
  margin-right: 2rem;
  color: #000;
`;


export const Icon = styled(GoIcons.GoSearch)`
  cursor: pointer;
  width: 10%;
  height: 100%;
  color: #000000;
  border-radius: 50%;
`;

export const SearchInput = styled.input.attrs({ 
  type: 'text',
})`
  width: 90%;
  outline: none;
  border: none;
  color: #000;
`;

export const New = styled(Link)`
  background: #E02041;
  padding: 1rem;
  border-radius: 0.8rem;
  text-decoration: none;
  color: #FFF;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 600;
`;

export const Content = styled.div`
  display: flex;
  width: 100%;
  max-height: max-content;
  background: gray;
`;