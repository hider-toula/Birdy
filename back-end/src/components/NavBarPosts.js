import React, {Component ,Fragment} from 'react'
import {GoSearch} from 'react-icons/go'
import{FaHome} from 'react-icons/fa'


class NavBarPosts extends Component{
	render(){
		return(
			<Fragment>
			<form className="navbar-form navbar nvps " role="search">
				<button  className="btn btn-default mybutton">  <FaHome color = 'white' size='2rem'/> </button>
  				<div class="form-group">
    				<input type="text" className="form-control ps" placeholder="Search Birdy"></input>
  				</div>
    			<button  className="btn btn-default">  <GoSearch color = 'white' size='2rem' />   </button>
			</form>
			</Fragment>
			)
	}
}

export default NavBarPosts