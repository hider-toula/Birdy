import React, {Component ,Fragment} from 'react'
import{IoMdSend} from 'react-icons/io'
import tw from '../tw.png'
import{AiOutlineEdit} from 'react-icons/ai'
import{MdDelete} from 'react-icons/md'
import{FaHeart} from 'react-icons/fa'
import{FaComment} from 'react-icons/fa'



import '../css/mypost.css';


class FreindPost extends Component{
	render(){
		return(
		<div className="container">
			<div className="row">
				<div className="img-containe">
					<img src={tw}  />
				</div>
				<h2>Hider toula</h2>
			</div>

				<div className="le_post">
  					<p> bonjour je suis hider toula, 
  					bon cette semaine je finis le front avec html css 
  					puis la semaine @prochaine je commence bien avec java 
  					et je le termine pui je finis java
  					et le reste du temps sera pour data science CV et biens sur trouver une alternance .....</p>
				</div>
				<div class="tweet-button-container">
					<button  class="stretched-link" className="lien10 "> Like <FaHeart className="glyph" color = '#BF3030 'size='1.5rem' /><span className="badge badge" >23</span> </button>
					<button  class="stretched-link" className="lien20 ">Coment <FaComment className="glyph" color = '#3A8EBA'size='1.5rem' /><span className="badge badge">14</span> </button>
    			</div>     
    		</div>
			)
	}
}

export default FreindPost
