import styled from 'styled-components'
import { BrowserRouter as Browser, Routes, Route } from 'react-router-dom';

import GlobalStyle from './styles/global';
import BaseBar from './components/BaseBar';
import Header from './components/Header';
import FoodMenu from './pages/FoodMenu';

function App() {

  const Grid = styled.div`
    display: grid;
    height: 100vh;
    grid-template-columns: minmax(8rem, max-content) auto;
    grid-template-rows: minmax(7rem, max-content) auto;
    grid-template-areas:  "baseBar header header header header"
                          "baseBar main main main main"
                          "baseBar main main main main"
                          "baseBar main main main main";
  `;
  return (
    <Grid>
      <GlobalStyle />
      <Browser>
        <BaseBar />
        <Header />
        <Routes>
          <Route path="/food-menu" element={<FoodMenu />} />
        </Routes>
      </Browser>
    </Grid>
  )
}

export default App