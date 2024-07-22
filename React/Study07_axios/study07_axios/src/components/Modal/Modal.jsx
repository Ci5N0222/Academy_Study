import styles from './Modal.module.css';

export const Modal = ({ isOpen, onClose, children, data }) => {
    if (!isOpen) return null;

    return (
        <div className={ styles.overlay } onClick={onClose}>
            <div className={ styles.content } onClick={(e) => e.stopPropagation()}>
                <button className={ styles.close } onClick={onClose}>X</button>

                Title: { data.title } <br />
                Singer: { data.singer } <br />

                {children}
            </div>
        </div>
    );
}