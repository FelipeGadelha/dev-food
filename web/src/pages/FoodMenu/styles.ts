import { Link } from "react-router-dom";
import styled from "styled-components";
import * as GoIcons from 'react-icons/go';

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

export const Search = styled.div`
  background: #FFF;
  display: flex;
  justify-content: center;
  align-items: center;
  box-shadow: 0rem 0.4rem 2rem rgba(0, 0, 0, 0.25);
  border-radius: 0.6rem;
  overflow: hidden;
  padding: 0.8rem;
  margin-right: 2rem;
  color: #000;
`;

export const Icon = styled(GoIcons.GoSearch)`
  cursor: pointer;
  /* width: 10%;
  height: 100%; */
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
  text-decoration: none;
  color: #FFF;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 600;
  box-shadow: 0rem 0.4rem 2rem rgba(0, 0, 0, 0.25);
  border-radius: 0.6rem;
  transition: 0.2s ease-in-out;
  &:hover {
    filter: brightness(90%);
  }
`;

export const Content = styled.div`
  display: flex;
  flex-direction: column;
  padding-top: 5rem;
  /* width: 100%; */
  /* overflow-y: auto;
  ::-webkit-scrollbar {
    width: 0.6rem;
  }
  ::-webkit-scrollbar-track {
    box-shadow: inset 0 0 0.6rem rgba(0, 0, 0, 0.3);
  }
  ::-webkit-scrollbar-thumb {
    box-shadow: inset 0 0 0.6rem rgba(0, 0, 0, 0.3);
  } */
`;

// export const ProductCard = styled.div`
//   background: #FFFFFF;
//   width: 90%;
//   margin: 0 auto;
//   height: 10rem;
//   box-shadow: 0rem 0.4rem 2rem rgba(0, 0, 0, 0.25);
//   border-radius: 1rem;
//   &:not(:first-child) {
//     margin-top: 2rem;
//   }
// `;

