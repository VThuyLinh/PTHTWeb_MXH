
import 'bootstrap/dist/css/bootstrap.min.css';

import { Container } from 'react-bootstrap';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './component/Login';
import Register from './component/Register';
import Post from './component/Post';
import Footer from './layout/Footer';
import Account from './component/Account';
import Header from './layout/Header';
import MyUserReducer from './reducer/MyUserReducer';
import Notification from './component/Notification';
import { MyDispatchContext, MyUserContext } from './config/context';
import { useReducer } from 'react';
import AddPost from './component/AddPost';
import AddComment from './component/AddComment';
import PostDetail from './component/PostDetail';




const App = () => {

  const [user, dispatch]= useReducer(MyUserReducer, null);

  return (
    <MyUserContext.Provider value={user}>
      <MyDispatchContext.Provider value={dispatch}>
          <BrowserRouter>
            <Header />
            <Container>
              <Routes>
                <Route path='/' element={<Post />} />
                <Route path='/Post' element={<Post />} />
                <Route path='/login' element={<Login />} />
                <Route path='/Notification' element={<Notification />} />
                <Route path='/Register' element={<Register />} />
                <Route path='/Account/:userId' element={<Account />} />
                <Route path='/AddPost/' element={<AddPost />} />
                <Route path='/AddComment/:postId' element={<AddComment />} />
                <Route path='/Post/:postId' element={<PostDetail />} />
                <Route path='/Comment/:postId' element={<PostDetail />} />
                <Route path='/LikeHaha/:postId' element={<PostDetail />} />
                <Route path='/Like/:postId' element={<PostDetail />} />
              </Routes>
            </Container>
            <Footer />
          </BrowserRouter>
      </MyDispatchContext.Provider>
    </MyUserContext.Provider>
    
  );
}

export default App;