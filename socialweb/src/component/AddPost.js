import { useEffect, useReducer, useRef, useState } from "react";
import { Alert, Button, Form} from "react-bootstrap";
import { useNavigate } from "react-router";
import APIs, { endpoints } from "../config/APIs";
import cookie from "react-cookies";


const AddPost = () => {
    const [topic, setTopic] = useState([]);
    const [major, setMajor] = useState([]);
    const [user, setUser] = useState(cookie.load("user") || null)
    const [post, setPost] = useState({});
    const [error, setError] = useState();
    const nav = useNavigate();
    const image = useRef();

    const loadTopic= async () => {
        try {
          let res = await APIs.get(endpoints['topic']);
          console.info(res.data)
          setTopic(res.data);
        } catch (ex) {
          console.error(ex);
        }
      }
      const loadMajor= async () => {
        try {
          let res = await APIs.get(endpoints['major']);
          setMajor(res.data);
        } catch (ex) {
          console.error(ex);
        }
      }
    const addpost = async (e) => {
        e.preventDefault();
            let form = new FormData();
            for (let f in post)
                {
                    form.append(f, post[f]);
                }

            form.append('image', image.current.files[0]);
           
            console.info(form);
            console.info(post);
            
            let res = await APIs.post(endpoints['addPost'], form, {
                headers: {
                    'Content-Type': "multipart/form-data"
                }
            });
            console.info(res.data);

            nav("/");
        }
        useEffect(() => {
            loadTopic();
            loadMajor();
          }, []);

    const change = (value, field) => {
        setPost((current) => {return {...current, [field]: value}})
    }
   

    return (
        <>
            <h1 className="text-center text-info mt-1">Thêm bài đăng</h1>
            {error && <Alert variant="danger">{error}</Alert>}
            <Form method="post" onSubmit={addpost}>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Chủ đề</Form.Label>
                    <Form.Select  value={post["topicidforPost"]} onChange = {(e) => change(e.target.value, "topicidforPost")}>
                    {topic.map(t=><option value={t.id}>{t.name}</option>)}
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>Nội dung</Form.Label>
                    <Form.Control type="text" placeholder="Nội dung..." value={post["content"]} onChange={e => change(e.target.value, "content")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput2">
                    <Form.Label>User</Form.Label>
                    <Form.Control type="text" placeholder={user.username} value={post["userid"]} onChange={e => change(e.target.value, "userid")}  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                    <Form.Label>Ngành</Form.Label>
                    <Form.Select  value={post["majoridforPost"]} onChange = {(e) => change(e.target.value, "majoridforPost")}>
                    {major.map(m=><option  value={m.id}>{m.name}</option>)}
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea2">
                    <Form.Label>Ảnh</Form.Label>
                    <Form.Control accept=".png,.jpg" type="file" ref={image}   />
                </Form.Group>

                <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea11">
                    <Button type="submit" variant="success">Đăng bài</Button>
                </Form.Group>
                <Form.Group hidden className="mb-3" controlId="exampleForm.ControlTextarea11">
                    <Form.Control type="text" value={user.id} onChange={e=> change(e, "useridforPost")}/>
                </Form.Group>
            </Form>
        </>
    );
}


export default AddPost;