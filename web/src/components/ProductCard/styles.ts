import { Link } from 'react-router-dom';
import styled, { css } from 'styled-components';

export const Container = styled.div`
  /* display: flex; */
  background: #FFFFFF;
  width: 90%;
  margin: 0 auto;
  height: 14rem;
  overflow: hidden;
  display: flex;
  align-items: center;
  padding: 1rem;
  box-shadow: 0rem 0.4rem 2rem rgba(0, 0, 0, 0.25);
  border-radius: 1rem;
  &:not(:first-child) {
    margin-top: 2rem;
  }
  &:last-child {
    margin-bottom: 2rem;
  }

`;
// type ImageProps = {
//   url: string
// }

// export const Image = styled.div<ImageProps>`
    
//     width: 10rem;
//     height: 19rem;
//     background-image: url(${props => props.url});
// `;

export const Image = styled.img`
  width: 20rem;
  height: 11rem;
  border-radius: 1rem;
`;

export const Data = styled.div`
  width: 70%;
  margin: 0 auto;
  > strong {
    color: #9E9E9E;
  }
`;

export const Header = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 0.8rem;
`;

export const Title = styled.h1`
  color: #E02041;
  font-size: 2rem;
`;

export const Actions = styled.div`
  justify-content: space-around;
`;

const sharedStyle = css`
  text-decoration: none;
  padding: 1rem;
  color: #E02041;
  border-radius: 1rem;
  display: inline-flex;
  align-items: stretch;
`;

export const EditLink = styled(Link)`
  ${sharedStyle}
`; 

export const DeleteLink = styled(Link)`
  ${sharedStyle}
`;

export const Description = styled.p`
  color: #9E9E9E;
`;