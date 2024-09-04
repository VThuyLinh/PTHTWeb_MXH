import { Alert, Button, Card, Col, Image, Row } from "react-bootstrap";
import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import cookie from "react-cookies";
import styles from '../css/timeline.css'; 
import { useParams } from "react-router-dom";



const Account = () => {
    const [postU, setPostU]=useState([]);
    const { userId } = useParams();
    const [user, setUser] = useState(cookie.load("user") || null)
    const loadPostByUserId=async ()=>{
        try{

            let url=`${endpoints['account'](userId)}`
            console.info(url);
            let res= await APIs.get(url);
            console.info(res.data);
            setPostU(res.data);
            console.info("Đây là postU:"+postU);
        
        }catch(ex){
        console.error(ex);
         }
   
}

    useEffect (() =>{
        loadPostByUserId();
    },[]);
    
   

    return (
        <>
         
        <Row  style={{marginTop:"50px",border: '2px solid'}}>
            <Col md={2} >
                <Image style={{width:"100px"}} src={user.avatar} roundedCircle />
            </Col>
            <Col md={1} style={{marginLeft:"5px"}}>
                <label>Họ</label>
                <td>{user.firstname}</td>
            </Col>
            <Col md={1}>
                <label>Tên</label>
                <td>{user.lastname}</td>
            </Col>
            <Col md={2}>
                <label>Username</label>
                <td>{user.username}</td>
            </Col>
            <Col md={3}>
                <label>Email</label>
                <td>{user.email}</td>
            </Col>
            <Col md={2}>
                <label>MSSV</label>
                {user.studentId? <td>{user.studentId}</td>: <></>}
            </Col> 
            <Col md={1}>
                
                {user.degree? <><label>Học vị</label><td>
                    {user.degree}</td></>: <></>}
            </Col>     
        </Row>

        <Row className="mt-2">
            {postU.map( p=> 
            <Col className="p-1" key={p.id} md={4} xs={12}> 
                <Card style={{height:'500px', marginTop:'30px',marginBottom:'30px',borderColor: 'black'}}>
                <Card.Img variant="top" src={p.image} style={{height:'250px', marginTop:'20px'}}/>
                <Card.Title style={{marginTop:'20px', marginLeft:'5px'}}>{p.createdDate}</Card.Title>
                <Card.Body>
                    <Card.Text style={{height:'80px'}}>{p.content}</Card.Text>
                    <Button variant="primary" style={{marginLeft:'230px', width:'100px'}}>Xem thêm</Button>
                </Card.Body>
             </Card>
            
             </Col>)}
             </Row>

             {/* <div className={timeline}>
  <div className={container}>
    <div className={content}>
      <h2>2017</h2>
      <p>Lorem ipsum..</p>
    </div>
  </div>
  <div className={{container,right}}>
    <div className={timeline.content}>
      <h2>2016</h2>
      <p>Lorem ipsum..</p>
    </div>
  </div>
</div> */}
<button className={styles.haha}></button>
        </>
       
    );
}



export default Account;


