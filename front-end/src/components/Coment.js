import React, {Component ,Fragment} from 'react'
import{IoMdSend} from 'react-icons/io'
import tw from '../tw.png'
import{AiOutlineEdit} from 'react-icons/ai'
import{MdDelete} from 'react-icons/md'
import{FaHeart} from 'react-icons/fa'
import{FaComment} from 'react-icons/fa'



import '../css/mypost.css';
import '../css/coment.css';



class Coment extends Component{
	render(){
		return(
		<div className="contain">
	
				<h6>{this.props.nom}  {this.props.prenom}</h6>

				<div className="coment">
  					<p className="coment" > {this.props.comment}</p>
				</div>    
    		</div>
			)
	}
}

export default Coment
