import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import { Button, Card, Spinner } from "react-bootstrap";
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
        return <Spinner animation="border" role="status"><span className="visually-hidden">Loading...</span></Spinner>

    return (
        <>
            {post.map( p=>  
                <div key={p.id} style={{marginLeft:250, marginBottom:20, marginTop:20}}>
                <Card style={{ width: '50rem' }}>
                <Card.Img variant="top" src={p.image}/>
                <Card.Body>
                    <Card.Title>{p.topic}</Card.Title>
                    <Card.Text>{p.content}</Card.Text>
                    <Button variant="primary">Xem thêm</Button>
                </Card.Body>
             </Card>
             </div>
             )}
             
             <div className="mt-2 text-center">
                <Button onClick={loadPage} variant="primary">Trang tiếp</Button>
             </div>
        </>
    );
}
export default Post;