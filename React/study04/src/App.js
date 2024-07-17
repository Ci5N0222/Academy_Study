import './App.css';
import { useState } from 'react';
import styles from './App.module.css';
import { Index } from './components/Index/Index';
import { Input } from './components/Input/Input';
import { Output } from './components/Output/Output';

function App() {
  const [products, setProducts] = useState([
    { id: 1001, name: "Americano", price: 2000 },
    { id: 1002, name: "Cafe Latte", price: 3500 },
    { id: 1003, name: "Cafe Mocha", price: 4000 },
    { id: 1004, name: "Orange Juice", price: 5000 },
    { id: 1005, name: "Mango Juic", price: 6000 },
  ]);

  const [ page, setPage ] = useState("/");

  return (
    <div className={ styles.container }>
      <div className={ styles.box }>
        { page === "/" && <Index setPage={ setPage } /> }
        { page === "input" && <Input setPage={ setPage } id={ products[products.length-1].id+1 } setProducts={ setProducts } /> }
        { page === "output" && <Output setPage={ setPage } products={ products } setProducts={ setProducts }/> }
      </div>
    </div>
  );
}

export default App;