import React, {Component ,Fragment} from 'react'
import{IoMdSend} from 'react-icons/io'
import tw from '../tw.png'
import{TiUserAdd} from 'react-icons/ti'
import '../css/freind.css';

class Friend extends Component{
	render(){
		return(
			<div className="row containe">
				<div className="img-containe">
					<img src={tw}  />
				</div>
				<h4>Hider toula</h4>
				<div class="tweet-button-container">
					<button  class="stretched-link" className="lien400 "> Follow<TiUserAdd className="glyph" color = 'RGB(20,31,42);'size='1.5rem' />  </button>
    			</div> 
    
			</div>
			)
	}
}

export default Friend