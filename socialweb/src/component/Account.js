import { Alert, Button, Card, Col, Image, Row, Table } from "react-bootstrap";
import { useEffect, useState } from "react";
import APIs, { endpoints } from "../config/APIs";
import cookie from "react-cookies";
import { Link, useParams } from "react-router-dom";
import { Timeline, TimelineConnector, TimelineContent, TimelineDot, TimelineItem, TimelineOppositeContent, TimelineSeparator } from '@mui/lab';
import { Typography } from "@mui/material";
import Timestamp from "react-timestamp";



const Account = () => {
    const [postU, setPostU]=useState([]);
    const { userId } = useParams();
    const [user, setUser] = useState(cookie.load("user") || null)
  
    const loadPostByUserId=async ()=>{
      
        try{

            let url=`${endpoints['account'](userId)}`
            let res= await APIs.get(url);
            console.info(res.data);
            setPostU(res.data);
           
           
        
        }catch(ex){
        console.error(ex);
         }
   
}

    useEffect (() =>{
        loadPostByUserId();
    },[]);
    
   

    return (
        <>
    <Image style={{width:"100%", height:"500px"}} src={user.cover}  />
<Table striped >
      <thead>
        <tr>
          <th>Ảnh đại diện</th>
          <th>Họ</th>
          <th>Tên</th>
          <th>SĐT</th>
          <th>Email</th>
          <th>Username</th>
          {user.studentId? <th>MSSV</th>:<th>Học vị</th>}
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><Image style={{width:"120px"}} src={user.avatar} roundedCircle /></td>
          <td>{user.firstname}</td>
          <td>{user.lastname}</td>
          <td>{user.phone}</td>
          <td>{user.email}</td>
          <td>{user.username}</td>
          {user.studentId? <td>{user.studentId}</td>: <td>{user.degree}</td>}
        </tr>
      </tbody>
    </Table>
    <Link className='nav-link text-success' to="/AddPost">
    <button className="btn btn-success mt-3" style={{marginLeft:'70rem'}}>+ Thêm bài đăng</button></Link>
        <h2>Các bài viết bạn đã đăng</h2>
        {postU.map( p=> 
        <Timeline style={{marginRight:'60rem', marginTop:'6rem'}}>
                <TimelineItem>
                    <TimelineSeparator>
                    <TimelineDot color="success" />
                    <TimelineConnector />
                    </TimelineSeparator>
                    
                    <TimelineContent style={{width:'80px'}}><Timestamp relative date={`${p.createdDate}`} options={{ includeDay: true, twentyFourHour:false}}/></TimelineContent>
                    <Typography>
                            <Card key={p.id} style={{height:'470px', marginTop:'30px',marginBottom:'30px',borderColor: 'black', width:'800px', marginLeft:'8rem'}}>
                                <Card.Img variant="top" src={p.image} style={{height:'300px', width:'44rem', marginTop:'20px', marginLeft:'30px'}}/>
                                <Card.Body>
                                    <Card.Text style={{height:'50px'}}><h4>{p.content}</h4></Card.Text>
                                    <Button variant="primary" style={{marginLeft:'35rem', width:'150px'}}>Xem thêm</Button>
                                </Card.Body>
                            </Card>
                            </Typography>
                </TimelineItem>
                </Timeline>)}

        </>
       
    );
}



export default Account;


