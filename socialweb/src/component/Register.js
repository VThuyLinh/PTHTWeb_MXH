import { useReducer, useRef, useState } from "react";
import { Alert, Button, Form} from "react-bootstrap";
import { useNavigate } from "react-router";
import APIs, { endpoints } from "../config/APIs";
import firebase from '../firebase/config';

const Register = () => {
    const [user, setUser] = useState({});
    const [error, setError] = useState();
    const nav = useNavigate();
    const avatar = useRef();
    const cover = useRef();

    const register = async (e) => {
        e.preventDefault();

        if (user.password === undefined || user.password !== user.confirm)
            setError("Mật khẩu KHÔNG khớp!");
        else {
            let form = new FormData();
            for (let f in user)
                if (f !== 'confirm') {
                    form.append(f, user[f]);
                }

            form.append('avatar', avatar.current.files[0]);
            form.append('cover', cover.current.files[0]);

            let res = await APIs.post(endpoints['register'], form, {
                headers: {
                    'Content-Type': "multipart/form-data"
                }
            });
            console.info(res.data.email);
            console.info(res.data.password);
            const userd= await firebase.auth().createUserWithEmailAndPassword(res.data.email,res.data.password)
            if(userd)
            {
                alert("Account Created Succcessfully")
            }
            console.info(res.data);
            console.info(res.data.email);

            nav("/login");
        }
    }

    const change = (e, field) => {
        setUser({...user, [field]: e.target.value})
    }

    return (
        <>
            <h1 className="text-center text-info mt-1">ĐĂNG KÝ</h1>
            {error && <Alert variant="danger">{error}</Alert>}
            <Form method="post" onSubmit={register}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Họ và tên lót</Form.Label>
                    <Form.Control type="text" placeholder="Họ và tên lót..." value={user["firstname"]} onChange={e => change(e, "firstname")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Tên</Form.Label>
                    <Form.Control type="text" placeholder="Tên..." value={user["lastname"]} onChange={e => change(e, "lastname")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput3">
                    <Form.Label>SĐT</Form.Label>
                    <Form.Control type="phone" placeholder="SĐT..." value={user["phone"]} onChange={e => change(e, "phone")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput4">
                    <Form.Label>Email</Form.Label>
                    <Form.Control type="email" placeholder="Email..." value={user["email"]} onChange={e => change(e, "email")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                    <Form.Label>Ảnh đại diện</Form.Label>
                    <Form.Control accept=".png,.jpg" type="file" ref={avatar}   />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea2">
                    <Form.Label>Ảnh bìa</Form.Label>
                    <Form.Control accept=".png,.jpg" type="file" ref={cover}   />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput8">
                    <Form.Label>Tên đăng nhập</Form.Label>
                    <Form.Control type="text" placeholder="Tên đăng nhập..." value={user["username"]} onChange={e => change(e, "username")}   />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput9">
                    <Form.Label>Mật khẩu</Form.Label>
                    <Form.Control type="password" placeholder="Mật khẩu..." value={user["password"]} onChange={e => change(e, "password")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput10">
                    <Form.Label>Xác nhận mật khẩu</Form.Label>
                    <Form.Control type="password" placeholder="Xác nhận mật khẩu..." value={user["confirm"]} onChange={e => change(e, "confirm")}   />
                </Form.Group>
                <h3>Đây là phần đăng ký dành cho sinh viên</h3>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput6">
                    <Form.Label>MSSV</Form.Label>
                    <Form.Control type="text" placeholder="Nhập MSSV (bỏ qua nếu bạn là giảng viên)" value={user["studentId"]} onChange={e => change(e, "studentId")}  />
                </Form.Group>
                
                <h3>Đây là phần đăng ký dành cho giảng viên</h3>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput7">
                    <Form.Label>Học vị</Form.Label>
                    <Form.Control type="text" placeholder="Học vị.." value={user["degree"]} onChange={e => change(e, "degree")}  />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea11">
                    <Button  type="submit" variant="success">Đăng ký</Button>
                </Form.Group>
            </Form>
        </>
    );
}

export default Register;