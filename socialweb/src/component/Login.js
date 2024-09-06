import { useContext, useState } from "react";
import { Button, Form } from "react-bootstrap";
import cookie from "react-cookies";
import { Navigate } from "react-router";
import APIs, { authAPIs, endpoints } from "../config/APIs";
import { MyDispatchContext, MyUserContext } from "../config/context";
import  firebase, { db } from '../firebase/config';
import { getAuth, onAuthStateChanged, ProviderId, signInWithCustomToken } from "firebase/auth";
import firebases from 'firebase/compat/app';
import { addDocument } from "./service";
// import { addDoc, collection } from "firebase/firestore";
import { getFirestore, doc, setDoc } from "firebase/firestore";
const Login = () => {
    // const auth = getAuth();
    // signInWithCustomToken(auth, token)
    //   .then((userCredential) => {
    //     // Signed in
    //     const user = userCredential.user;
    //     // ...
    //   })
    //   .catch((error) => {
    //     const errorCode = error.code;
    //     const errorMessage = error.message;
    //     // ...
    //   });
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const user = useContext(MyUserContext);
    const dispatch = useContext(MyDispatchContext);


    const login = async (e) => {
        e.preventDefault();

       try {
            let res = await APIs.post(endpoints['login'], {
                "username": username, 
                "password": password
            });
            console.info(res.data);
        
            cookie.save("access-token", res.data)

            let user = await authAPIs().get(endpoints['current-user']);
            console.info(user.data);
            console.info(user.data.email);
            console.info(user.data.password);
            cookie.save("user", user.data);

            dispatch({
                "type": "login",
                "payload": user.data
            });

            const userd= await firebase.auth().signInWithEmailAndPassword(user.data.email,user.data.password)
            console.info(userd);
            const additionalUserInfo= await firebase.auth().signInWithEmailAndPassword(user.data.email,user.data.password)
            console.info(userd);
            console.info();
            if(userd)
            {
                alert("Login successfully");
            }
            // try{
            //     const docRef= await addDoc(,{
            //         email: userd.email,
            //       });
            //     console.log("Document written with ID: ", docRef.id);}
            //     catch(e)
            //     {
            //         console.error("Error adding document: ",e)
            //     }

            
            console.info(user);
            const docRef = doc(db, "UserInChat", "User" );
            const data = {
                firstname: user.data.firstname,
                lastname: user.data.lastname,
                avatar: user.data.avatar,
             };
             
             setDoc(docRef, data)
             .then(() => {
                 console.log("Document has been added successfully");
             })
             .catch(error => {
                 console.log(error);
             })
       } 
       catch(ex) {
           console.error(ex);
       }
    }

    if (user !== null)
        return <Navigate to="/" />

    return (<>
        <h1 className="text-center text-info mt-1">ĐĂNG NHẬP NGƯỜI DÙNG</h1>

        <Form method="post" onSubmit={login}>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>Tên đăng nhập</Form.Label>
                <Form.Control type="text" placeholder="Tên đăng nhập..." value={username} onChange={e => setUsername(e.target.value)} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>Mật khẩu</Form.Label>
                <Form.Control type="password" placeholder="Mật khẩu..." value={password} onChange={e => setPassword(e.target.value)}  />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Button type="submit" variant="success">Đăng nhập</Button>
            </Form.Group>
        </Form>
        <a href="/Register">Don't have account</a>
    </>);
}

export default Login;

