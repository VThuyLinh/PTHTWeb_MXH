import { Avatar, Form, Input } from 'antd';
import React, { useState } from 'react'
import { Button, Tooltip } from 'react-bootstrap';
import Message from './Message';
import cookie from "react-cookies";

const ChatWindow=()=>{
    const [user, setUser] = useState(cookie.load("user") || null)

    return(
        <div  style={{height:'100vh'}}>
            <div className='Header'style={{display:'flex', justifyContent:'space-between',height:'56px', padding: '0 16px',alignItems:'center',borderBottom:'1px solid rgb(230,230,230)'}}>
                
                <div style={{display:'flex',alignItems:'center'}}>
                    <Button type='text' style={{display:'flex',alignItems:'center'}}>+ Mời</Button>
                    <Avatar.Group size='small' max={{ count: 2 }}>
                        <Tooltip title="A">
                        <Avatar>A</Avatar>
                        </Tooltip>
                        <Tooltip title="B">
                        <Avatar>B</Avatar>
                        </Tooltip>
                        <Tooltip title="C">
                        <Avatar>C</Avatar>
                        </Tooltip>
                    </Avatar.Group>
                </div>
            </div>           
            <div className='Content'  style={{height:'calc(100%-56px)', justifyContent:'flex-end',padding:'11px', display:'flex',flexDirection:'column'}}>
                <div className='message' style={{maxHeight:'100%',overflowY:'auto'}}>
                <Message text="test" displayName={user.username} createdDate="2024-09-03"
                    photoURL="https://res.cloudinary.com/dqcjhhtlm/image/upload/v1724654384/Screenshot_2024-08-26_133916_jrxg9b.png">   
                    </Message>
                    <Message text="test1" displayName={user.username} createdDate="2024-09-03"
                    photoURL="https://res.cloudinary.com/dqcjhhtlm/image/upload/v1724654384/Screenshot_2024-08-26_133916_jrxg9b.png">   
                    </Message>
                    <Message text="test2" displayName={user.username} createdDate="2024-09-03"
                    photoURL="https://res.cloudinary.com/dqcjhhtlm/image/upload/v1724654384/Screenshot_2024-08-26_133916_jrxg9b.png">   
                    </Message>
                    <Message text="test3" displayName={user.username} createdDate="2024-09-03"
                    photoURL="https://res.cloudinary.com/dqcjhhtlm/image/upload/v1724654384/Screenshot_2024-08-26_133916_jrxg9b.png">   
                    </Message>
                    <Message text="test4" displayName={user.username} createdDate="2024-09-03"
                    photoURL="https://res.cloudinary.com/dqcjhhtlm/image/upload/v1724654384/Screenshot_2024-08-26_133916_jrxg9b.png">   
                    </Message>
                
                </div>
            
                
            </div>
       </div>
    );
}
export default ChatWindow;