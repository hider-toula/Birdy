import React , {Component ,Fragment} from 'react';
import Options from './components/Options'
import User from './components/User'
import NavBarFriends from './components/NavBarFriends'
import FormComent from './components/FormComent'
import Logo from './components/Logo'
import Post from './components/Post'
import FreindPost from './components/FreindPost'
import {sampleText} from './sampleText'
import marked from 'marked'
import './index.css'
import {FaReact} from 'react-icons/fa'
import './tw.png'
import Coment from './components/Coment'

class Coments extends Component {

  
  state = {
    pseudo : this.props.match.params.coments
  }
  
  render(){
    return(
      < Fragment>
            <div id='home' className="col-md-2 options">
              <Logo />
              <Options/>
            </div>
            <div id='home' className='col-md-6 posts'>
              <FreindPost/>
              <FormComent/>
              
              <Coment/>
              <Coment/>
              <Coment/>
              <Coment/>
              <Coment/>
              <Coment/>
            </div>
            <div id='home' className='col-md-4 freinds'>
              <NavBarFriends/>
              <h1>friends</h1>
              <h1>friends</h1>
            </div>
      </Fragment>

      );
  }
}
export default Coments;
