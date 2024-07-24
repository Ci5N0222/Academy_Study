import { useNavigate } from 'react-router-dom';
import styles from './SignUp.module.css'
import { useState } from 'react';
import axios from 'axios';

export const SignUp = () => {

const navi = useNavigate();
const defaultData = { id: "", pw: "", name: "" };
const [ inputData, setInputData ] = useState(defaultData);

const handleData = (e) => {
    const { name, value } = e.target;
    setInputData(prev => ({ ...prev, [name]: value }));
}

const handleJoinMember = async() => {
    const res = await axios.post("http://192.168.1.7/member", inputData);
    if(res.status === 200) {
        setInputData(defaultData);
        alert("회원가입 완료");
        navi("/");
    }
}

    return (
        <div className={styles.container}>
            <table>
                <thead>
                    <tr>
                        <th>회원가입</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" name="id" onChange={ handleData } placeholder="Input ID" /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="pw" onChange={ handleData } placeholder="Input Password" /></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="name" onChange={ handleData } placeholder="Input Name" /></td>
                    </tr>
                    <tr>
                    <td>
                        <button onClick={ handleJoinMember }>확인</button>
                        <button onClick={ () => navi("/") }>취소</button>
                    </td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}