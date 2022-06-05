import styled, { createGlobalStyle } from "styled-components";

export default createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  html {
    font-size: 62.5%;
  }
  html, body {
    background: #E5E5E5;
    width: 100vw;
    height: 100vh;
  }
  
  body, input, textarea, button {
    font: 500 1.6rem Inter, sans-serif;
    color: #000000;
  }
  h1, h2, h3, h4, h5, h6 {
    font-weight: 600;
    font-family: 'Poppins', sans-serif;
    color: #000000;
  }
  h1 {
    font-size: 4rem;
  }
  h2 {
    font-size: 3rem;
  }
  button {
    cursor: pointer;
  };
`;

export const Grid = styled.div`
  display: grid;
  height: 100vh;
  grid-template-columns: minmax(8rem, max-content) auto;
  grid-template-rows: minmax(7rem, max-content) auto;
  grid-template-areas:  "baseBar header header header header"
                        "baseBar main main main main"
                        "baseBar main main main main"
                        "baseBar main main main main";
`;