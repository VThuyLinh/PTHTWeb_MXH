
import React, { useState } from "react";
import { Button, Collapse, Dropdown, Row } from "react-bootstrap";
import { Link } from "react-router-dom";



const RoomList=()=>{
    const [open, setOpen] = useState(false);
    return(
        <>
            <Button variant='dark'
            onClick={() => setOpen(!open)}
            aria-controls="showroom"
            aria-expanded={open}
            style={{color:'white', marginLeft:'12px'}}
            >
            Danh sách phòng
            </Button>
            <Collapse in={open}>
            <div id="showroom" style={{marginBottom:'5px'}}>
            <Row><Link style={{ marginLeft:'60px',textDecoration:'none',color:'black',marginTop:'5px'}}>Room 1</Link></Row>
            <Row><Link style={{ marginLeft:'60px',textDecoration:'none',color:'black'}}>Room 2</Link></Row>
            <Row><Link style={{ marginLeft:'60px',textDecoration:'none',color:'black'}}>Room 3</Link></Row>
            <Row style={{marginTop:'10px', marginLeft:'20px'}}><Button style={{width:'8rem', fontSize:'14px',color:'white'}} variant='secondary' type='text'>+ Thêm phòng</Button></Row>
            </div>
            </Collapse>
        </>
    );
}
export default RoomList;