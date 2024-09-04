import { useContext, useEffect, useState } from 'react';
import { Button, Col, Container,Form,Image,Nav, Navbar, NavDropdown, Row} from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';
import APIs, { endpoints } from '../config/APIs';
import {MyDispatchContext, MyUserContext } from "../config/context";

const Header = () => {
    const [topic, setTopic] = useState([]);
    const [major, setMajor] = useState([]);
    const [q, setQ] = useState("");
    const nav = useNavigate();

    const dispatch = useContext(MyDispatchContext);
    const user=useContext(MyUserContext);

    const loadTopic= async () => {
        try {
          let res = await APIs.get(endpoints['topic']);
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

    useEffect(() => {
        loadTopic();
        loadMajor();
      }, []);

    const submit = (e) => {
        e.preventDefault();
        nav(`/?q=${q}`);
    }

    

    return (
        <>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="/" style={{fontSize:"30px"}}>Ou4Alumni</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    <Link className='nav-link' to="/">Trang chủ</Link>
                    <Nav.Link href="/Post">Bài đăng</Nav.Link>
                    <NavDropdown title="Tìm bài đăng theo cụm ngành" id="basic-nav-dropdown">
                    {major.map(m => {
                        const url = `/Post/?major=${m.id}`;
                        return <Link to={url} className='dropdown-item' key={m.id}>{m.name}</Link>;
                    })}
                    </NavDropdown>
                    <NavDropdown title="Tìm bài đăng theo chủ đề" id="basic-nav-dropdown">
                    {topic.map(t => {
                        const url = `/Post/?topic=${t.id}`;
                        return <Link to={url} className='dropdown-item' key={t.id}>{t.name}</Link>;
                    })}
                    </NavDropdown>

                    {user===null?<>
                        <Link className='nav-link' to="/login">Đăng nhập</Link>
                        <Link className='nav-link' to="/Register">Đăng ký</Link>
                    </>:<>
                    <Link className='nav-link text-success' to={`/Account/${user.id}`}>
                         <Image src={user.avatar} width="25" roundedCircle /> {user.username}!</Link>
                    <Link to="/login"><Button variant='danger' onClick={() => dispatch({"type": "logout"})}>Đăng xuất</Button></Link> </>
}

                   
                </Nav>
                </Navbar.Collapse>
                <Form inline onSubmit={submit}>
                    <Row>
                    <Col xs="auto">
                        <Form.Control
                        type="text"
                        placeholder="Tìm từ khóa bài đăng..."
                        className=" mr-sm-2"
                        value={q}
                        onChange={e=>setQ(e.target.value)}
                        style={{borderColor:"black"}}
                        />
                    </Col>
                    <Col xs="auto">
                        <Button type="submit" style={{backgroundColor:"#B4B4B2", borderColor:"#B4B4B2", color:"black"}}>Submit</Button>
                    </Col>
        </Row>
      </Form>
                
                
            </Container>
            </Navbar>
        </>
    );
}

export default Header;