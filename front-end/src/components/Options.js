import React, { Component } from 'react'
import {IoLogoGameControllerB} from 'react-icons/io'
import {MdMessage} from 'react-icons/md'
import {IoMdNotifications} from 'react-icons/io'
import {IoMdExit} from 'react-icons/io'
import {FaUserCircle} from 'react-icons/fa'
import {IoIosOptions} from 'react-icons/io'
import {GoSync} from 'react-icons/go'
import '../index.css'
import{Redirect} from 'react-router-dom'



class Options extends Component{

	state = {

    name : 'hider toula',
    pseudo : 'Hider Toula',
    user : false,
    singin : false }

	singOut= event =>{

    	event.preventDefault();
    	this.setState({singin : true});
  	}

  	getUser= event =>{

    	event.preventDefault();
    	this.setState({user : true});
  	}

	render(){


		if(this.state.user){
      		return <Redirect  to={`/profile/${this.state.name}`} />
    	}

    	if(this.state.singin){
      		return <Redirect  to={`/singIn}`} />
    	}

		return(
			<div>  
	   
              	<button onClick={this.getUser}  id="options" className="btn btn-default glyph">  <FaUserCircle className="glyph" color = 'white'size='2rem' />   </button>        
              	<button  id="options" className="btn btn-default">  <MdMessage className="glyph" color = 'white'size='2rem' /> <span class="badge badge-dark">4</span>  </button>
              	<button  id="options" className="btn btn-default">  <IoMdNotifications className="glyph" color = 'white'size='2rem' />  <span class="badge badge-dark">4</span></button>
				<button  id="options" className="btn btn-default">  <GoSync  className="glyph" color = 'white'size='2rem' />   </button>              	
              	<button  id="options" className="btn btn-default">  <IoLogoGameControllerB className="glyph" color = 'white'size='2rem' />   </button>
              	<button  id="options" className="btn btn-default">  <IoIosOptions className="glyph" color = 'white'size='2rem' />   </button>
              	<button  onClick={this.singOut} id="options" className="btn btn-default">  <IoMdExit className="glyph" color = 'white'size='2rem' />   </button>

           
            </div>
			)
	}
}

export default Options