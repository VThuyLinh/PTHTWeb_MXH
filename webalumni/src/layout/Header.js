import { useContext, useEffect, useState } from 'react';
import { Button, Col, Container,Form,Image,Nav, Navbar, NavDropdown, Row} from 'react-bootstrap';
import { Link, useNavigate } from 'react-router-dom';
import APIs, { endpoints } from '../config/APIs';
import {MyDispatchContext, MyUserContext } from "../config/context";

const Header = () => {
    const [topic, setTopic] = useState([]);
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

    useEffect(() => {
        loadTopic();
      }, []);

    const submit = (e) => {
        e.preventDefault();
        nav(`/?q=${q}`);
    }

    const logout = () => {
        window.localStorage.clear();
        window.location.href="./login";
    };

    return (
        <>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">Ou4Alumni</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    <Link className='nav-link' to="/">Trang chủ</Link>
                    <Nav.Link href="/Post">Bài đăng</Nav.Link>
                    <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                    {topic.map(t => {
                        const url = `/?major=${t.id}`;
                        return <Link to={url} className='dropdown-item' key={t.id}>{t.name}</Link>;
                    })}
                    </NavDropdown>

                    {user===null?<>
                        <Link className='nav-link' to="/login">Đăng nhập</Link>
                        <Link className='nav-link' to="/Register">Đăng ký</Link>
                    </>:<>
                    <Link className='nav-link text-success' to="/">
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
                        />
                    </Col>
                    <Col xs="auto">
                        <Button type="submit">Submit</Button>
                    </Col>
        </Row>
      </Form>
                
                
            </Container>
            </Navbar>
        </>
    );
}

export default Header;