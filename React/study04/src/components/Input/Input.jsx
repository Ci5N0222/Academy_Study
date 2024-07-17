import { useState } from 'react';
import styles from './Input.module.css';

export const Input = ({ setPage, id, setProducts }) => {

    const [ product, setProduct ] = useState({id, name: "", price: 0});

    const handleData = (e) => {
        let { name, value } = e.target;
        if(name === "price") value = parseInt(value);
        setProduct( prev => ({ ...prev, [ name ]: value }));
    }

    const handleAddProduct = () => {
        if(product.name === ""){
            alert("메뉴 이름이 없음");
            return false;
        }
        if(isNaN(product.price) || product.price === 0){
            alert("가격이 잘못 작성함");
            return false;
        } 

        setProducts( prev => {
            return [ ...prev, product ];
        });
        setPage("output");
    }

    return (
        <div className={ styles.container }>           
           <div className={ styles.form }>
                <div>Input Form</div>
                <div><input  type="text" name="name" onChange={ handleData } value={ product.name } placeholder="Input Name"/></div>
                <div><input  type="text" name="price" onChange={ handleData } value={ product.price || "" } placeholder="Input Price"/></div>
                <div className={styles.btn_box}>
                    <button onClick={ handleAddProduct }>추가</button>
                    <button onClick={ () =>  setPage("/") }>취소</button>
                </div>
           </div>
        </div>
    );
}