import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import './index.css';
//ReactDOM.render(<App />,document.getElementById('root'));
import { createStore, applyMiddleware } from 'redux';
import {Provider} from 'react-redux';
import thunk from 'redux-thunk';

import postReducer from './reducers/postReducer';
import {fetchAllPosts} from './action/data';

const store = createStore(postReducer, applyMiddleware(thunk));
store.dispatch(fetchAllPosts());

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>, document.getElementById('root')
);
