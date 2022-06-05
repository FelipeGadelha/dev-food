import { BrowserRouter as Browser, Routes, Route } from 'react-router-dom';

import GlobalStyle, { Grid } from './styles/global';
import BaseBar from './components/BaseBar';
import Header from './components/Header';
import FoodMenu from './pages/FoodMenu';
import Dashboard from './pages/Dashboard';
import ProductRegister from './pages/ProductRegister';
import Order from './pages/Order';
import Invoice from './pages/Invoice';

function App() {
  return (
    <Grid>
      <GlobalStyle />
      <Browser>
        <BaseBar />
        <Header />
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/food-menu" element={<FoodMenu />} />
          <Route path="/product-register" element={<ProductRegister />} />
          <Route path="/order" element={<Order />} />
          <Route path="/invoice" element={<Invoice />} />
        </Routes>
      </Browser>
    </Grid>
  )
}

export default App
