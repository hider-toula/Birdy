import 'bootstrap/dist/css/bootstrap.min.css'
import React from 'react'
import ReactDOM from 'react-dom'
import Home from './Home'
import Profil from './Profil'
import Coments from './Coments'

import SingUp from './components/SingUp'
import SingIn from './components/SingIn'
import User from './components/User'

import * as serviceWorker from './serviceWorker'
import {BrowserRouter , Route,Switch} from 'react-router-dom'

const Root = ()=>(
	<BrowserRouter>
		<Switch>
			<Route exact path='/SingUp' component={SingUp}></Route>
			<Route  path='/profile/:profile' component={Profil}></Route>
			<Route  path='/home/:home' component={Home}></Route>
			<Route exact path='/coments/:coments' component={Coments}></Route>
			<Route  path='/' component={SingIn}></Route>

		</Switch>
	</BrowserRouter>
	)
ReactDOM.render(< Root />, document.getElementById('root'))

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister()
