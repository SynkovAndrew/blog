import React from 'react'
import './styles.css'
import 'bootstrap/dist/css/bootstrap.css';
import {HashRouter, NavLink, Route} from "react-router-dom";
import UsersPage from "./UsersPage";
import TopicsPage from "./TopicsPage";

export default class MainPage extends React.Component {
    render() {
        return (
            <HashRouter>
                <div>
                    <nav className="navbar navbar-expand-lg navbar-dark bg-dark ">
                        <div className="collapse navbar-collapse" id="navbarNav">
                            <ul className="navbar-nav header-menu">
                                <li className="nav-item">
                                    <NavLink className="nav-link" to="/">Topics</NavLink>
                                </li>
                                <li className="nav-item">
                                    <NavLink className="nav-link" to="/users">Users</NavLink>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <div className="content main-div">
                        <Route exact path="/" component={TopicsPage}/>
                        <Route path="/users" component={UsersPage}/>
                    </div>
                </div>
            </HashRouter>
        )
    }
}


