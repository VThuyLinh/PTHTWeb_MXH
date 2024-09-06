import firebase from "../firebase/config"
import firebases from 'firebase/compat/app'; 

export const addDocument=(collection,data)=>{
    const query=firebases.firestore.collection(collection);
    query.add({
        ...data,
        createdAt: firebase.firestore.FieldValue.serverTimestamp(),
    })
}