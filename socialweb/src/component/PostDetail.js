import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import { Button, Card, Col, Collapse, Container, Form, Image, InputGroup, Navbar, Row, Spinner, Table } from "react-bootstrap";
import { Link, useNavigate, useParams, useSearchParams } from "react-router-dom";
import moment from 'moment';
import { Icon } from "@mui/material";
import cookie from "react-cookies";


const PostDetail=() =>{
    const [post, setPost]=useState([]);
    const [cmt, setCmt]=useState([]);
    const [like, setLike]= useState([]);
    const [likeAll, setLikeAll]= useState([]);
    const [user, setUser] = useState(cookie.load("user") || null)
    const [load, setLoad]= useState(false);
    const [Datetime, setDatetime]=useState([]);
    const [useridforPost, setuseridforPost]= useState([]);
    const [useridforCmt, setuseridforCmt]= useState([]);
    const {postId}= useParams();
    const nav = useNavigate();
    const [open, setOpen] = useState(false);
    const [openn, setOpenn] = useState(false);
    console.info(postId);
    
    const loadPost = async ()=>{
        try{

            
            console.info(Datetime);
            let url=`${endpoints['Post'](postId)}`
            console.info(url);
            let res= await APIs.get(url);
            setuseridforPost(res.data.useridforPost);
            
            setPost(res.data);
            console.info(post);
            console.info(post.createdDate);
            const timestamp = post.createdDate; // This would be the timestamp you want to format

            setDatetime(new Intl.DateTimeFormat('en-GB', {year: 'numeric', month: '2-digit',day: '2-digit'}).format(timestamp));
            console.info(Datetime);

        }
        catch(ex)
        {
            console.error(ex);
        }
        finally
        {
            setLoad(false);
        }
        }


    const loadCMT = async ()=>{
            try{
                let url=`${endpoints['comment'](postId)}`
                console.info(url);
                let res= await APIs.get(url);
                setCmt(res.data);
                console.info(cmt);
                setuseridforCmt(res.data.userId);
                console.info(useridforCmt);
            }
            catch(ex)
            {
                console.error(ex);
            }
            finally
            {
                setLoad(false);
            }
            }

        const loadLike = async ()=>{
            try{
                let url=`${endpoints['like'](postId)}`
                console.info(url);
                let res= await APIs.get(url);
                setLike(res.data);
                console.info(like);
            }
            catch(ex)
            {
                console.error(ex);
            }
            finally
            {
                setLoad(false);
            }
            }

            const loadAllLike = async ()=>{
                try{
                    let url=`${endpoints['likeAll'](postId)}`
                    console.info(url);
                    let res= await APIs.get(url);
                    setLikeAll(res.data);
                    console.info(likeAll);
                }
                catch(ex)
                {
                    console.error(ex);
                }
                finally
                {
                    setLoad(false);
                }
                }

    
            const addCmt = async (e) => {
                e.preventDefault();
                    let form = new FormData();
                    for (let f in cmt)
                        {
                            form.append(f, cmt[f]);
                        }
                   
                    console.info(form);
                    console.info(cmt);
                    
                    let res = await APIs.post(endpoints['addCMT'], form, {
                        headers: {
                            'Content-Type': "multipart/form-data"
                        }
                    });
                    console.info(res.data);
        
                    nav("/Post");
                }
        // const create_like= async() =>{
        //     setLoad(true);
        //     try {
        //         setActive(active? false: true);
        //         await APIs.post(endpoints["like_tour"](tour_id));
        //     } catch (ex) {
        //         console.log(ex.request);
        //     } finally {
        //         setLoad(false);
        //     }
        //}


    useEffect(()=>{
        setLoad(true);
        loadPost();
        loadCMT();
        loadLike();
        loadAllLike();
    },[]);

    const change = (value, field) => {
        setCmt((current) => {return {...current, [field]: value}})
    }

    if(load===true || post===null)
        return <Spinner animation="border" role="status"></Spinner>
   

    return (
        <>
          
           <Card style={{height:'610px', width:'700px', marginTop:'30px',marginBottom:'30px',borderColor: 'black', marginLeft:'18rem'}}>
                <Card.Header style={{backgroundColor:'white', height:'90px'}}>
                    <Table style={{width:'270px'}} >
                        
                            <tbody >
                            <tr style={{borderBlock:'none'}}>
                                <td style={{border:'none'}} rowspan="2"><Image src={useridforPost.avatar} style={{width:'50px'}} roundedCircle/></td>
                                <td  style={{borderBlock:'none'}}>{useridforPost.firstname} {useridforPost.lastname}</td>
                            </tr>
                            <tr style={{borderBlock:'none'}}>
                                
                                <td style={{border:'none'}}> 
                                    <div>{Datetime}</div>
                                    
                                    
                                    
                                    </td>
                            </tr>
                            </tbody>
                    </Table>
                </Card.Header>
                <Card.Body>
                    <Image src={post.image} style={{height:'350px', width:'650px', marginLeft:'10px'}}/>
                    <Card.Text style={{height:'40px', marginTop:'10px'}}>{post.content}</Card.Text>
                    <Card.Text style={{height:'10px', marginTop:'10px'}}><h6>{like}&#129505; </h6></Card.Text>
                    <Row>
                         <Col  style={{marginTop:'20px', marginLeft:'10px'}}>
                         {likeAll.map(l=> 
                            <><div>
                                    {l.userId.id!==user.id?<></>:
                                        <><h4>&#129293;</h4></>
                                    }
                            </div></>)}
                         </Col>
                         <Col>
                            <Button onClick={() => setOpen(!open)} aria-controls="show-comment" aria-expanded={open} 
                    style={{textDecoration:'none', color:'black', marginTop:'10px', backgroundColor:'white', width:'120px', fontSize:'20px', borderColor:'white'}}>Bình luận</Button></Col>
                    </Row>
                    
                    
                  
                </Card.Body>
               
             </Card>


            
             
                        <Collapse in={open}>
                            
                            <div id="show-comment">
                            

                       
                            <Table >
                               
                               {cmt.map(c=>
                               
                                
                                < div style={{height:'200px'}} >
                                   
                                    <tbody >
                                <tr style={{border:'none',}}>
                                    <td style={{border:'none'}} rowspan="5"><Image src={c.userId.avatar} style={{width:'80px'}} roundedCircle/></td>
                                    
                                </tr>
                                <tr style={{border:'none',}}>
                                    <td style={{borderBlock:'none', paddingLeft:'80px'}}><h4>{c.userId.firstname} {c.userId.lastname}</h4></td>
                                </tr>
                                <tr style={{borderBlock:'none'}}>
                                    <td style={{border:'none', paddingLeft:'80px'}}> 
                                        <h6>{c.content}</h6>
                                        </td>
                                </tr>
                                <tr style={{borderBlock:'none'}}>
                                    <td style={{border:'none', paddingLeft:'80px'}}> 
                                        <p style={{fontSize:'12px'}}>{moment(c.createdDate).fromNow()}</p>
                                        </td>
                                </tr>
                                <tr style={{borderBlock:'none'}}>
                                    <td style={{border:'none', paddingLeft:'80px'}}> 
                                        {c.image===null?<>
                                            
                                        </>:<>
                                        <Image src={c.image} style={{width:'150px'}}></Image>
                                        </>}
                                        </td>
                                </tr>
                                </tbody>
                                </div>
                               )}
                                <Link  className='nav-link text-success' to={`/AddComment/${post.id}`}>
                                <Button style={{textDecoration:'none',marginLeft:'63rem', color:'white', marginTop:'10px', backgroundColor:'#3E7494', width:'200px', fontSize:'18px', borderColor:'white'}}>Thêm bình luận &#128172;</Button></Link>
                                
                             </Table>

                            </div>
                            
                        </Collapse>

                       

                        
        </>
    );
}
export default PostDetail;