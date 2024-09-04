
import 'bootstrap/dist/css/bootstrap.min.css';

import { Container } from 'react-bootstrap';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './component/Login';
import Register from './component/Register';
import Product from './component/Post';
import Footer from './layout/Footer';
import Header from './layout/Header';
import MyUserReducer from './reducer/MyUserReducer';
import Notification from './component/Notification';
import { MyDispatchContext, MyUserContext } from './config/context';
import { useReducer } from 'react';
import Account from './component/Account';




const App = () => {

  const [state, dispatch] = useReducer(MyUserReducer, null);
  

  return (
    <MyUserContext.Provider value={state}>
      <MyDispatchContext.Provider value={dispatch}>
          <BrowserRouter>
            <Header />
            <Container>
              <Routes>
                <Route path='/' element={<Product />} />
                <Route path='/login' element={<Login />} />
                <Route path='/Notification' element={<Notification />} />
                <Route path='/Register' element={<Register />} />
                <Route path='/Account/:userId' element={<Account />} />
              </Routes>
            </Container>
            <Footer />
          </BrowserRouter>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
    
  );
}

export default App;