import styles from "./Output.module.css";

export const Output = ({ setPage, products, setProducts }) => {

  const handleDelete = (id) => {
    setProducts( prev => prev.filter( item => item.id !== id ));
  }

  return (
    <div className={styles.container}>
      <div className={styles.form}>
        <div className={styles.title}>Output</div>
        <div className={styles.body}>
          <table>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Price</th>
              <th>Del</th>
            </tr>
            {products.map( item => {
              return (
                <tr>
                  <td>{ item.id }</td>
                  <td>{ item.name }</td>
                  <td>{ item.price }</td>
                  <td><button onClick={ () => handleDelete(item.id) }>X</button></td>
                </tr>
              );
            })}
          </table>
        </div>
        <div className={styles.footer}>
          <button onClick={ () => setPage("/") }>첫페이지로</button>
        </div>
      </div>
    </div>
  );
};
