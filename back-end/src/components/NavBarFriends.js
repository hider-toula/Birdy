import React, {Component ,Fragment} from 'react'
import {GoSearch} from 'react-icons/go'

class NavBarFriends extends Component{
	render(){
		return(
			<Fragment>
			<form className="navbar-form navbar " role="search">
  				<div class="form-group">
    				<input type="text" className="form-control fr" placeholder="Search Freiend"></input>
  				</div>
    			<button  className="btn btn-default">  <GoSearch color = 'white'size='2rem' />   </button>
			</form>
			</Fragment>
			)
	}
}

export default NavBarFriends