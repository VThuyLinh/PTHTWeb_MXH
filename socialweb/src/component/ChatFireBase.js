import React, { useState } from 'react'
import {Row, Col} from 'antd';


import Message from './Message';
import cookie from "react-cookies";
import { useSearchParams } from 'react-router-dom';
import APIs, { endpoints } from '../config/APIs';
import { useEffect } from 'react';
import { Button, Form, Image, Spinner } from 'react-bootstrap';


const ChatFireBase=()=>{
        const [user, setUser] = useState(cookie.load("user") || null)
        const [listuser, setListUser]=useState([]);
        const [page, setPage]= useState(1);
        const [load, setLoad]= useState(false);
        const[q]=useSearchParams();
        const loaduser=async ()=>{
            try{
                let url=`${endpoints['user']}?page=${page}`
    
                let k= q.get("q");
                if(k!==null)
                {
                    setPage(1);
                    url=`${url}&q=${k}`;
                }
    
                let res= await APIs.get(url);
    
                console.info(res.data);
    
                if(page===1)
                    setListUser(res.data);
                else
                    setListUser(current =>[...current, ...res.data]);
                console.info(listuser);
            }catch(ex){
                console.error(ex);
            }
            finally{
                setLoad(false);
        }
    }
    
        useEffect(()=>{
            loaduser();
            setLoad(true);
        },[page,q]);
    
        const loadPage=()=>{
            setPage(page+1);
        }

        if(load===true || listuser===null)
            return <Spinner animation="border" role="status" variant="warning"></Spinner>
    
      
    
    if(user===null)
    {
        alert("Vui lòng đăng nhập để chat ")
    }
    return(
        <div>
            
            <Row>
                    <Col span={6} style={{backgroundColor:'#e6e5e3'}}>
                    <Form.Select>
                    {listuser.map(lu=>
                     
                     <option value={lu.username} style={{marginLeft:'4px',marginTop:'8px'}}>{lu.username}</option>
                    )}</Form.Select>
                    
                    </Col>
                    <Col span={18}><Message name={user.username} /></Col>
                    <div className="mt-2 text-center" >
                <Button onClick={loadPage} style={{marginTop:'60px',width:'200px', backgroundColor:"#87DF2C", borderColor:"white", fontSize:'18px'}} >Tải user </Button>
             </div>
               
            </Row>
        </div>
    );
}
export default ChatFireBase;