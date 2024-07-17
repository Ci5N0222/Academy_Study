import styles from "./Index.module.css";

export const Index = ({ setPage }) => {

  return (
    <div className={styles.container}>
      <div className={styles.form}>
        <div className={styles.title}>index</div>
        <div className={styles.body}>
          <div>
            <button onClick={ () => setPage("input") }>toInput</button>
          </div>
          <div>
            <button onClick={ () => setPage("output") }>toOutput</button>
          </div>
        </div>
      </div>
    </div>
  );
};
