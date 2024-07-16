import { Section } from './Section/Section.jsx';
import { Side } from './Side/Side.jsx';
import styles from './Body.module.css';

export const Body = () => {
  return (
    <div className = { styles.body }>
      <Section />
      <Side />
    </div>
  );
}