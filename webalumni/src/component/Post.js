import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import { Button, Card, Col, Row, Spinner } from "react-bootstrap";
import { useSearchParams } from "react-router-dom";


const Post=() =>{
    const [post, setPost]=useState(null);
    const [page, setPage]= useState(1);
    const [load, setLoad]= useState(false);
    const[q]=useSearchParams();
    const loadPost=async ()=>{
        try{
            let url=`${endpoints['post']}?page=${page}`

            let mId= q.get("major");
            if(mId !==null)
            {
                setPage(1);
                url=`${url}&major=${mId}`;
            }

            let k= q.get("q");
            if(k!==null)
            {
                setPage(1);
                url=`${url}&q=${k}`;
            }

            let res= await APIs.get(url);

            console.info(res.data);

            if(page===1)
                setPost(res.data);
            else
                setPost(current =>[...current, ...res.data]);
            console.info(post);
        }catch(ex){
            console.error(ex);
        }
        finally{
            setLoad(false);
    }
}

    useEffect(()=>{
        setLoad(true);
        loadPost();
    },[page,q]);

    const loadPage=()=>{
        setPage(page+1);
    }


    if(load===true || post===null)
        return <Spinner animation="border" role="status"></Spinner>

    return (
        <>



<Row className="mt-2">
            {post.map( p=> 
            <Col className="p-1" key={p.id} md={4} xs={12}> 
               
                <Card style={{height:'450px', marginTop:'30px',marginBottom:'30px',borderColor: 'black'}}>
                <Card.Img variant="top" src={p.image} style={{height:'250px', marginTop:'20px'}}/>
                <Card.Body>
                    <Card.Text style={{height:'80px'}}>{p.content}</Card.Text>
                    <Button variant="primary" style={{marginLeft:'230px', width:'100px'}}>Xem thêm</Button>
                </Card.Body>
             </Card>
            
             </Col>)}
             </Row>
             
             <div className="mt-2 text-center" >
                <Button onClick={loadPage} style={{marginTop:'100px'}} variant="primary">Trang tiếp</Button>
             </div>
        </>
    );
}
export default Post;