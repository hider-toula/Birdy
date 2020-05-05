import React, {Component ,Fragment} from 'react'
import{IoMdSend} from 'react-icons/io'
import tw from '../tw.png'
import{AiOutlineEdit} from 'react-icons/ai'
import{MdDelete} from 'react-icons/md'
import{FaHeart} from 'react-icons/fa'
import{FaComment} from 'react-icons/fa'
import Coment from './Coment'
import FormComent from './FormComent'

import{Redirect} from 'react-router-dom'

import axios from 'axios'

import '../css/mypost.css';


class Post extends Component{

	state = {

    	comment : false,
    	comments : {}
    	}

    addComment = comment =>{

    		axios.post('http://localhost:8080/Birdy/comments?idPost='+this.props.me._id+'&key='+this.props.clef+'&firstname='+this.props.nom+'&lastname='+this.props.prenom+'&text='+comment)

       		axios.get('http://localhost:8080/Birdy/comments?idPost='+this.props.me._id)
    		.then(response =>{
      		this.setState({comments : response.data})
    		})	

    		const comments = Object
      		.keys(this.state.comments)
      		.map(key => (

        	<Coment 
          		key={key}
          		nom={ this.props.me.firstName}
          		prenom=  { this.props.me.lastName}
          		idPost={this.props.me._id}
          		comment={this.state.comments[key].text}
          		
        	/>))
    	
    }

	comment = event=>{
		event.preventDefault();

		if(this.state.comment){
    		this.setState({comment : false});
		}
		else{
			this.setState({comment : true});

    		axios.get('http://localhost:8080/Birdy/comments?idPost='+this.props.me._id)
    		.then(response =>{
      		this.setState({comments : response.data})
    		})	

    		const comments = Object
      		.keys(this.state.comments)
      		.map(key => (

        	<Coment 
          		key={key}
          		nom={ this.props.me.firstName}
          		prenom=  { this.props.me.lastName}
          		idPost={this.props.me._id}
          		comment={this.state.comments[key].text}
        	/>))
		}
	}


	componentDidMount(){
    	axios.get('http://localhost:8080/Birdy/comments?idPost='+this.props.me._id)
    	.then(response =>{
      	this.setState({comments : response.data})
    	})
    	console.log(this.state.comments)

  	}

	like = event =>{
		

		const {idUser, like , unlike  }= this.props
		if(this.props.me.likes.indexOf(idUser)>-1){
			
			unlike(this.props.me._id)
		}
		else{
			like(this.props.me._id)
		}
		
	}

	remove = () =>{
		const {removePost , idPost  }= this.props
		removePost(idPost)
	}

	render(){
    const comments = Object
    	.keys(this.state.comments)
      	.map(key => (

        	<Coment 
          		key={key}
          		nom={ this.props.me.firstName}
          		prenom=  { this.props.me.lastName}
          		idPost={this.props.me._id}
          		addComment= {this.addComment}
          		comment={this.state.comments[key].text}
       />))
	if(! this.state.comment){
		if(this.props.isUser(this.props.me.id_user)){
			return(

			<div className="container">
				<div className="row">
					<div className="img-containe">
						<img src={tw}  />
					</div>
					<h2>{this.props.nom}  {this.props.prenom}</h2>
					<div class="tweet-button-container">
						<button  class="stretched-link" className="lien100 "> <AiOutlineEdit className="glyph" color = 'RGB(20,31,42);'size='1.5rem' />  </button>
						<button  onClick={this.remove} class="stretched-link" className="lien200 "><MdDelete className="glyph" color = 'RGB(20,31,42);'size='1.5rem' /> </button>
    				</div> 
    
				</div>

					<div className="le_post">
  						<p>  {this.props.post}  </p>
					</div>
					<div class="tweet-button-container">
						<button  onClick={this.like} class="stretched-link" className="lien10 "> Like <FaHeart className="glyph" color = '#BF3030 'size='1.5rem' /><span className="badge badge" >{this.props.me.nb_likes}</span> </button>
						<button  onClick={this.comment} class="stretched-link" className="lien20 ">Coment <FaComment className="glyph" color = '#3A8EBA'size='1.5rem' /><span className="badge badge">14</span> </button>
    				</div>     
    			</div>
				)
		}

		else{
			return(

				<div className="container">
					<div className="row">
						<div className="img-containe">
							<img src={tw}  />
						</div>
						<h2>{this.props.nom}  {this.props.prenom}</h2>

    
				</div>

					<div className="le_post">
  						<p>  {this.props.post}  </p>
					</div>
					<div class="tweet-button-container">
						<button  onClick={this.like} class="stretched-link" className="lien10 "> Like <FaHeart className="glyph" color = '#BF3030 'size='1.5rem' /><span className="badge badge" >{this.props.me.nb_likes}</span> </button>
						<button  onClick={this.comment} class="stretched-link" className="lien20 ">Coment <FaComment className="glyph" color = '#3A8EBA'size='1.5rem' /><span className="badge badge">14</span> </button>
    				</div>     
    			</div>
			)
	}
}

//===============================================COMENTAIRE=============================================================

	else{
		if(this.props.isUser(this.props.me.id_user)){
			return(
				<Fragment>
				<div className="container">
					<div className="row">
					<div className="img-containe">
						<img src={tw}  />
					</div>
					<h2>{this.props.nom}  {this.props.prenom}</h2>
					<div class="tweet-button-container">
						<button  class="stretched-link" className="lien100 "> <AiOutlineEdit className="glyph" color = 'RGB(20,31,42);'size='1.5rem' />  </button>
						<button  onClick={this.remove} class="stretched-link" className="lien200 "><MdDelete className="glyph" color = 'RGB(20,31,42);'size='1.5rem' /> </button>
    				</div> 
    
				</div>

					<div className="le_post">
  						<p>  {this.props.post}  </p>
					</div>
					<div class="tweet-button-container">
						<button  onClick={this.like} class="stretched-link" className="lien10 "> Like <FaHeart className="glyph" color = '#BF3030 'size='1.5rem' /><span className="badge badge" >{this.props.me.nb_likes}</span> </button>
						<button  onClick={this.comment} class="stretched-link" className="lien20 ">Coment <FaComment className="glyph" color = '#3A8EBA'size='1.5rem' /><span className="badge badge">14</span> </button>
    				</div>     
    			</div>
    			<FormComent
    				addComment= {this.addComment}
    			/>
    			{comments}
    			</Fragment>
				)
	}
	else{
		return(
			<Fragment>
			<div className="container">
				<div className="row">
					<div className="img-containe">
						<img src={tw}  />
					</div>
					<h2>{this.props.nom}  {this.props.prenom}</h2>

    
				</div>

					<div className="le_post">
  						<p>  {this.props.post}  </p>
					</div>
					<div class="tweet-button-container">
						<button  onClick={this.like} class="stretched-link" className="lien10 "> Like <FaHeart className="glyph" color = '#BF3030 'size='1.5rem' /><span className="badge badge" >{this.props.me.nb_likes}</span> </button>
						<button  onClick={this.comment} class="stretched-link" className="lien20 ">Coment <FaComment className="glyph" color = '#3A8EBA'size='1.5rem' /><span className="badge badge">14</span> </button>
    				</div>     
    			</div>
    			<FormComent
					addComment= {this.addComment}
    			/>
    			{comments}
    			</Fragment>
				)
		}
		}
	}
}

export default Post