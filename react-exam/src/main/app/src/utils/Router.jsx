import React from 'react';
import { HashRouter, Route, Switch } from 'react-router-dom';
import {HashHistory} from 'react-history';
import BookContainer from '../Containers/BookContainer';
import CreateContainer from '../Containers/CreateContainer';


const Router = () => (
    <HashRouter history={HashHistory}>
        <div className="container">
            <Switch>
                <Route exact path="/" component={BookContainer}/>
                <Route path="/create" component={CreateContainer}/>
            </Switch>
        </div>
    </HashRouter>
);

export default Router;
