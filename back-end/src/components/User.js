import React, { Component } from 'react'
import '../css/user.css';
import tw from '../tw.png'
import {FaCalendarAlt} from 'react-icons/fa'


class User extends Component{
	render(){
		return(
		<div>
			<div> <h1> Hider Toula </h1> 
					<p> <span class="badge badge-black">0</span> posts</p>
			</div>
			<div className="card-container"> 
				<div className="uper-container">
					<div className="img-container">
						<img src={tw} />
					</div>
				</div>

				<div className="lower-container">
					<div> 
						<h5>Toula Hider</h5>
						<p> <FaCalendarAlt className="glyph" color = 'RGB(59,83,101); 'size='1rem' /> A rejoint birdy le  08/04/2020</p>
						<a href="#" class="stretched-link" className="lien1">followings <span class="badge badge-black">0</span> </a>
						<a href="#" class="stretched-link" className="lien2">fllowers <span class="badge badge-black">0</span> </a>

					</div>
				</div>

				<div className="bar">
					<a href="#" class="stretched-link" className="lien1 bt "> Edit </a>
					<a href="#" class="stretched-link" className="lien2 bt1">Remove  </a>
					<a href="#" class="stretched-link" className="lien1 bt1">Psts  </a>
					<a href="#" class="stretched-link" className="lien2 bt1">Friends  </a>
				</div>

			</div>
		</div>

			)
	}
}

export default User