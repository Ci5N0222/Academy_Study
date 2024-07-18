## React Router

### Start
``` bash
// Install
$ npm install react-router-dom

// Import
import { BrowserRouter as Router Routes, Route, useNavigate } from 'react-router-dom';

// Structure
<Router>
    <Routes>
        <Route path="/" element={ <Home /> } />
        <Route path="/board" element={ <Board /> } />
    </Routes>
</Router>
```