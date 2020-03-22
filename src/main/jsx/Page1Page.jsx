import '../resources/static/css/custom.css';
 
import React from 'react';
import ReactDOM from 'react-dom';
import { Button } from '@material-ui/core';
import SignUp from './component/signup';
 
class Page1Page extends React.Component {
 
    render() {
        return <div>로그인 페이지<SignUp/></div>;
    }
 
}
 
ReactDOM.render(<Page1Page/>, document.getElementById('root'));