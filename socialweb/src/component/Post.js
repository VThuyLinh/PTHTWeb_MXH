import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import { Button, Card, Col, Image, Row, Spinner } from "react-bootstrap";
import { Link, useSearchParams } from "react-router-dom";


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
        return <Spinner animation="border" role="status" variant="warning"></Spinner>

    return (
        <>
           

            {post.map( p=>
                <Card style={{height:'520px', width:'700px', marginTop:'30px',marginBottom:'30px',borderColor: 'black', marginLeft:'18rem'}}>
                <Card.Body>
                    <Image src={p.image} style={{height:'350px', width:'650px', marginLeft:'10px'}}/>
                    <Card.Text style={{height:'60px', marginTop:'10px'}}>{p.content}</Card.Text>
                    <Link style={{marginLeft:'500px', width:'120px', backgroundColor:"#274038", borderColor:"#274038"}} to={`/Post/${p.id}`}>Xem thêm</Link>
                </Card.Body>
               
             </Card>)}
             
             
             <div className="mt-2 text-center" >
                <Button onClick={loadPage} style={{marginTop:'60px',width:'200px', backgroundColor:"#87DF2C", borderColor:"white", fontSize:'18px'}} >Xem tiếp &#128301;</Button>
             </div>
        </>
    );
}
export default Post;