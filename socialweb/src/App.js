// import 'bootstrap/dist/css/bootstrap.min.css';

// import Post from './component/Post';
// import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import Header from './layout/Header';
// import Footer from './layout/Footer';
// import { Container } from 'react-bootstrap';
// import Login from './component/Login';
// import { createContext,useReducer } from 'react';
// import MyUserReducer from './reducer/MyUserReducer';


// export const MyUserContext=createContext();
// export const MyDispatchContext= createContext();

// const App = () => {

  
//   const [user, dispatch] = useReducer(MyUserReducer, null);

 
//   return (
//     <MyUserContext.Provider value={user}>
//       <MyDispatchContext.Provider value={dispatch}>
//           <BrowserRouter>
//           <Header/>
//             <Container>
//               <Routes>
//                   <Route path="/" element={<Post/>}></Route>
//                   <Route path="/login" element={<Login/>}></Route>
//               </Routes>
//             </Container>
//           <Footer/>
//           </BrowserRouter>
//       </MyDispatchContext.Provider>
//     </MyUserContext.Provider>
    
//   );
// }

// export default App;








import 'bootstrap/dist/css/bootstrap.min.css';

import { Container } from 'react-bootstrap';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './component/Login';
import Product from './component/Post';
import Footer from './layout/Footer';
import Header from './layout/Header';
import MyUserReducer from './reducer/MyUserReducer';
import Notification from './component/Notification';
import { MyDispatchContext, MyUserContext } from './config/context';
import { useReducer } from 'react';




const App = () => {

  const [user, dispatch]= useReducer(MyUserReducer, null);

  return (
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={dispatch}>
          <BrowserRouter>
            <Header />
            <Container>
              <Routes>
                <Route path='/' element={<Product />} />
                <Route path='/login' element={<Login />} />
                <Route path='/Notification' element={<Notification />} />
              </Routes>
            </Container>
            <Footer />
          </BrowserRouter>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
    
  );
}

export default App;