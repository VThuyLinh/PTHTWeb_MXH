

import 'firebase/compat/auth';
import firebase from 'firebase/compat/app';
import { getDatabase, ref,push,onValue } from "firebase/database"
import { getFirestore } from "firebase/firestore";



const firebaseConfig = {
  apiKey: "AIzaSyChHEKMnRPLZacNCgIX9OQCpnYeinhNbFg",
  authDomain: "ou4alumni.firebaseapp.com",
  databaseURL: "https://ou4alumni-default-rtdb.asia-southeast1.firebasedatabase.app/",
  projectId: "ou4alumni",
  storageBucket: "ou4alumni.appspot.com",
  messagingSenderId: "941230631798",
  appId: "1:941230631798:web:f7f244ac817de91cc46857",
  measurementId: "G-VP4DNYRH10"
};





const app = firebase.initializeApp(firebaseConfig);
export const db = getFirestore(app);
const database = getDatabase(app);
export { database, ref, push, onValue };
export default app;