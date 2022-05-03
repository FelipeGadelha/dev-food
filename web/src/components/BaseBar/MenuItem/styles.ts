import { Link } from "react-router-dom";
import styled from "styled-components";

export const Container = styled(Link)`
  font-size: 2.2rem;
  cursor: pointer;

  list-style: none;
  text-decoration: none;
  display: flex;
  align-items: center;
  padding: 0.5rem 4rem;
  color: rgba(255, 255, 255, 0.5);
  transition: .2s ease-in;
  &:hover {
    color: #FFFFFF;
  }
`;

export const MenuIcon = styled.div`
  color: #E02041;
  margin-right: 1rem;
  display: flex;
  align-items: center;
`;