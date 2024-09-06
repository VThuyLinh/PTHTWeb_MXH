import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import { Button, Card, Col, Form, Row, Spinner } from "react-bootstrap";
import { useNavigate, useSearchParams } from "react-router-dom";




const Notification=() =>{
    const [notification, setNotification]=useState(null);
    const [page, setPage]= useState(1);
    const [load, setLoad]= useState(false);
    const [content, setContent] = useState("");
    const nav = useNavigate();
    const[m]=useSearchParams();
    const loadNotification=async ()=>{
        try{
            let url=`${endpoints['notification']}?page=${page}`

            let k= m.get("content");
            if(k!==null)
            {
                setPage(1);
                url=`${url}&content=${k}`;
            }

            let res= await APIs.get(url);

            console.info(res.data);

            if(page===1)
                setNotification(res.data);
            else
                setNotification(current =>[...current, ...res.data]);
            console.info(notification);
        }catch(ex){
            console.error(ex);
        }
        finally{
            setLoad(false);
    }
}

    useEffect(()=>{
        setLoad(true);
        loadNotification();
    },[page,m]);

    const loadPage=()=>{
        setPage(page+1);
    }
    const submit = (e) => {
        let url=`${endpoints['notification']}`
        e.preventDefault();
        nav(`${url}/?content=${content}`);
    }


    if(load===true || notification===null)
        return <Spinner animation="border" role="status"><span className="visually-hidden">Loading...</span></Spinner>

    return (
        <>

            <Form inline onSubmit={submit}>
                                <Row>
                                <Col xs="auto">
                                    <Form.Control
                                    type="text"
                                    placeholder="Tìm từ khóa cho thông báo..."
                                    className=" mr-sm-2"
                                    value={content}
                                    onChange={e=>setContent(e.target.value)}
                                    />
                                </Col>
                                <Col xs="auto">
                                    <Button type="submit">Submit</Button>
                                </Col>
                    </Row>
                </Form>

        <Row className="mt-2">
        {notification.map( n=>  <Col className="p-1" key={n.id} md={3} xs={12}>
            <Card style={{height:'500px'}}>
                <Card.Img variant="top" src={n.image} width="200" height="300px"/>
                <Card.Body>
                    <Card.Title style={{height:"70px"}}>{n.content}</Card.Title>
                    <Card.Text>{n.address}</Card.Text>
                    <Button variant="primary" style={{marginLeft:'150px'}}>Xem chi tiết</Button>
                </Card.Body>
             </Card>
                        </Col>)}
                        
                    </Row>

            
            
         
             
             
             <div className="mt-2 text-center">
                <Button onClick={loadPage} variant="primary">Trang tiếp</Button>
             </div>
        </>
    );
}
export default Notification;