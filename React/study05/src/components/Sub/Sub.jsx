import styles from './Sub.module.css';

export const Sub = ({ content }) => {
    return (
        <div className={ styles.container }>
            { content }
        </div>
    );
}
