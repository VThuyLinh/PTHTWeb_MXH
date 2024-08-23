import { Button } from "react-bootstrap";


const Logout =(navigation)=>{
    return (
        <Button title="Log out" onPress={()=>navigation.navigate("login")}/>
    )
}
export default Logout;