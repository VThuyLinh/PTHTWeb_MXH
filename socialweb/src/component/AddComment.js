
import { useEffect, useReducer, useRef, useState } from "react";
import { Alert, Button, Form} from "react-bootstrap";
import { useNavigate, useParams } from "react-router";
import APIs, { endpoints } from "../config/APIs";
import cookie from "react-cookies";

const AddComment= () =>{
    const [user, setUser] = useState(cookie.load("user") || null)
    const [cmt, setCMT] = useState({});
    const [error, setError] = useState();
    const {postId}= useParams();
    const image = useRef();
    const nav = useNavigate();


    const field =[
        {
            "postId": {postId},
            "userid": `${user.username}`,
            "name": "content"
           
        }];
    
    const addcmt = async (e) => {
        e.preventDefault();
            let form = new FormData();
            for (let f in cmt)
                {
                    form.append(f, cmt[f]);
                }

            form.append('image', image.current.files[0]);
           
            console.info(form);
            console.info(cmt);
                
            
            let res = await APIs.post(endpoints['addCMT'](postId), form, {
                headers: {
                    'Content-Type': "multipart/form-data"
                }
            });
            
            console.info(res.data);

           nav("/");
        }
        
       
    const change = (value, field) => {
        setCMT( t => {
            return { ...t, [field]: value }
        })
        console.log(cmt);
   
    }
    
   

    return (
        <>
            <h1 className="text-center text-info mt-1">Thêm bình luận</h1>
            {error && <Alert variant="danger">{error}</Alert>}
            <Form method="post" onSubmit={addcmt}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>User</Form.Label>
                    <Form.Control type="text" placeholder={postId} defaultValue={postId} value={cmt["postId"]} onChange={e => change(e.target.value, "postId")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>User</Form.Label>
                    <Form.Control type="text" placeholder={user.username} defaultValue={user.username} value={cmt["userid"]} onChange={e => change(e.target.value, "userid")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Nội dung</Form.Label>
                    <Form.Control type="text" placeholder="Nội dung..." value={cmt["content"]} onChange={e => change(e.target.value, "content")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea2">
                    <Form.Label>Ảnh</Form.Label>
                    <Form.Control accept=".png,.jpg" type="file" ref={image}   />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea11">
                    <Button type="submit" variant="success">Đăng bài</Button>
                </Form.Group>
            </Form>
        </>
    );
}
export default AddComment



