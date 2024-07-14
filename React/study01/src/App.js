import './App.css';

const TableBox = () => {
  return (
    <table border="1" align="center">
      <tr>
        <th colspan="3">리액트 연습</th>
      </tr>
      <tr>
        <th>seq</th>
        <th>name</th>
        <th>price</th>
      </tr>
      <tr>
        <td>1</td>
        <td>apple</td>
        <td>1000</td>
      </tr>
    </table>
  );
}

const App = () => {
  return (
    <div>
      <TableBox />
    </div>
  );
}

export default App;
