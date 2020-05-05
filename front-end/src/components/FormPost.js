import React, {Component ,Fragment} from 'react'
import{IoMdSend} from 'react-icons/io'
import '../css/formpost.css';
import tw from '../tw.png'

class FormPost extends Component{
	state={
		post : ''
	}

	createPost =()=>{
		const {addPost , pseudo }= this.props
		addPost(this.state.post)
		this.setState({post :''})
	}
	handleSubmit = event => {
		
		event.preventDefault()
		this.createPost()
	}

	handleChange = event => {
		const post = event.target.value
		this.setState({post})
	}
	render(){
		return(
			<form
				onSubmit={this.handleSubmit}
			>
			<div className="row formulaire">
				<div className="img-containe">
					<img src={tw}  />
				</div>

				<div className="form-group shadow-textarea">
  					<label htmlFor="exampleFormControlTextarea6"></label>
  					<textarea 
  						value ={this.state.post}
  						onChange={this.handleChange}
  						required
  						className="form-control z-depth-1"  id="exampleFormControlTextarea6" rows="4" placeholder="Write something here..."></textarea>
				</div>
				</div>
    				
					<button type = "submit"  id="option" className=" btn  bout"> poster   </button>        
              		
  				
			</form>
			)
	}
}

export default FormPost