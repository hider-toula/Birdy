import React , {Component ,Fragment} from 'react';
import Options from './components/Options'
import User from './components/User'
import NavBarFriends from './components/NavBarFriends'
import NavBarPosts from './components/NavBarPosts'
import Logo from './components/Logo'
import {sampleText} from './sampleText'
import marked from 'marked'
import './index.css'
import {FaReact} from 'react-icons/fa'
import './tw.png'
import Freind from './components/Freind'
import Coment from './components/Coment'


class Profil extends Component {
  
  render(){
    return(
      < Fragment>
            <div id='home' className="col-md-2 options">
              <Logo />
              <Options/>
            </div>
            <div id='home' className='col-md-6 posts'>
              <User/>
            </div>
            <div id='home' className='col-md-4 freinds'>
              <NavBarFriends/>
              <Freind/>
              <Freind/>
            </div>
      </Fragment>

      );
  }
}
export default Profil;
