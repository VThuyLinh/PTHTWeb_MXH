import { useState, useEffect, useRef } from "react";
import { database, ref, push, onValue } from "../firebase/config";
function Message({ name }) {
  const [inpMessage, setIptMessage] = useState("");
  const [messages, setMessages] = useState([]);
  const input = useRef();
  useEffect(() => {
    onValue(ref(database, "tngan"), (data) => {
      let getMsg = [];
      data.forEach((d) => {
        getMsg.push(d.val());
      });
      setMessages(getMsg);
    });
  }, []);
  const handleSendMessage = () => {
    push(ref(database, "tngan"), {
      name: name,
      message: inpMessage,
    });
    setIptMessage("");
    const inputElement = document.getElementById("message-input");
    if (inputElement) {
    inputElement.focus();
    }
    
  };
  return (
    <div>
      <h1 style={{marginLeft:'20px'}}>Chào mừng bạn quay lại! {name}</h1>
      <ul>
        {messages.map((msg, index) => {
          return (
            <li key={index} style={{listStyle:'none', backgroundColor:'pink'}}>
              <span>{msg.name}: </span>
              <span>{msg.message}</span>
            </li>
          );
        })}
      </ul>
      <input style={{borderColor:'blue', marginLeft:'50px', width:'300px', height:'40px'}} id="message-input"  type="text"value={inpMessage}
        onChange={(e) => {setIptMessage(e.target.value);}}
        ref={input}
      />
      <button onClick={handleSendMessage} style={{backgroundColor:'green', width:'120px', height:'40px'}}>Gửi</button>
    </div>
  );
}

export default Message;