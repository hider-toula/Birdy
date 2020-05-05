import React, {Component ,Fragment} from 'react'
import{IoMdSend} from 'react-icons/io'
import '../css/formcoment.css';
import tw from '../tw.png'


class FormComent extends Component{

	state={
		comment : ''
	}

	createComment =()=>{

		const {addComment  }= this.props
		addComment(this.state.comment)
		this.setState({comment :''})
	}

	handleSubmit = event => {
		event.preventDefault()
		this.createComment()
	}

	handleChange = event => {
		const comment = event.target.value
		this.setState({comment})
	}

	render(){
		return(
			<form

				onSubmit={this.handleSubmit}
			>
			<div className="row ">
				<div className="img-contain">
					<img src={tw}  />
				</div>

				<div className="form-group shadow-textarea pr">
  					<label htmlFor="exampleFormControlTextarea6"></label>
  					<textarea 
  						value ={this.state.comment}
  						onChange={this.handleChange}
  						required

  					className="form-control z-depth-1"  id="exampleFormControlTextarea6" rows="1" placeholder="Write something here..."></textarea>
				</div>
				<div >
    				
					<button type = "submit" className=" btn  bout"> Comenter   </button>        
              	</div>
			</div>
		</form>
			)
	}
}

export default FormComent