import React , {Component ,Fragment} from 'react';
import Options from './components/Options'
import User from './components/User'
import NavBarFriends from './components/NavBarFriends'
import NavBarPosts from './components/NavBarPosts'
import FormPost from './components/FormPost'
import Freind from './components/Freind'
import Post from './components/Post'
import FreindPost from './components/FreindPost'
import Logo from './components/Logo'
import {sampleText} from './sampleText'
import {FaReact} from 'react-icons/fa'
import './tw.png'
import axios from 'axios'


class Home extends Component {
  state = {
    posts :{},
    user : {},
    key: this.props.match.params.home
  }

  isUser = idUser => idUser=== this.state.user.idUser


  addPost = post =>{

    axios.post('http://localhost:8080/Birdy/posts?key='+this.state.key+'&text='+post);
 
    axios.get('http://localhost:8080/Birdy/posts?key='+this.state.key)
    .then(response =>{
      this.setState({posts : response.data})
    })


    const posts = Object
        .keys(this.state.posts)
        .map(key => (

          <Post 
            isUser={this.isUser}
            key={key}
            clef= {this.state.key}
            nom={ this.state.posts[key].firstName}
            prenom=  { this.state.posts[key].lastName}
            post={this.state.posts[key].text}
            idPost={this.state.posts[key].idPost}
            removePost={this.removePost}
            me = {this.state.posts[key]}
            idUser={this.state.user.idUser}
            like={this.like}
            unlike={this.unlike}
          />))



  }

  removePost = idPost =>{
    axios.delete('http://localhost:8080/Birdy/posts?key='+this.state.key+'&idPost='+idPost);

    axios.get('http://localhost:8080/Birdy/posts?key='+this.state.key)
    .then(response =>{
      this.setState({posts : response.data})
    })

    const posts = Object
      .keys(this.state.posts)
      .map(key => (

        <Post 
          isUser={this.isUser}
          key={key}
          clef= {this.state.key}
          nom={ this.state.posts[key].firstName}
          prenom=  { this.state.posts[key].lastName}
          post={this.state.posts[key].text}
          idPost={this.state.posts[key]._id}
          removePost={this.removePost}
          me = {this.state.posts[key]}
          idUser={this.state.user.idUser}
          like={this.like}
          unlike={this.unlike}
        />))
  }
  componentDidMount(){
    axios.get('http://localhost:8080/Birdy/posts?key='+this.state.key)
    .then(response =>{
      this.setState({posts : response.data})
    })

    axios.get('http://localhost:8080/Birdy/user?key='+this.state.key)
    .then(response =>{
      this.setState({user : response.data})
    })

  }

  like = idPost =>{
    axios.post('http://localhost:8080/Birdy/like?idUser='+this.state.user.idUser+'&idPost='+idPost);
    axios.get('http://localhost:8080/Birdy/posts?key='+this.state.key)
    .then(response =>{
      this.setState({posts : response.data})
    })

    const posts = Object
      .keys(this.state.posts)
      .map(key => (

        <Post 
          isUser={this.isUser}
          key={key}
          clef= {this.state.key}
          nom={ this.state.posts[key].firstName}
          prenom=  { this.state.posts[key].lastName}
          post={this.state.posts[key].text}
          idPost={this.state.posts[key]._id}
          removePost={this.removePost}
          me = {this.state.posts[key]}
          idUser={this.state.user.idUser}
          like={this.like}
          unlike={this.unlike}
        />))
  }


  unlike = idPost =>{
    axios.delete('http://localhost:8080/Birdy/like?idUser='+this.state.user.idUser+'&idPost='+idPost);

    axios.get('http://localhost:8080/Birdy/posts?key='+this.state.key)
    .then(response =>{
      this.setState({posts : response.data})
    })

    const posts = Object
      .keys(this.state.posts)
      .map(key => (

        <Post 
          isUser={this.isUser}
          key={key}
          clef= {this.state.key}
          nom={ this.state.posts[key].firstName}
          prenom=  { this.state.posts[key].lastName}
          post={this.state.posts[key].text}
          idPost={this.state.posts[key]._id}
          removePost={this.removePost}
          me = {this.state.posts[key]}
          idUser={this.state.user.idUser}
          like={this.like}
          unlike={this.unlike}
        />))
  }
  render(){
    const posts = Object
      .keys(this.state.posts)
      .map(key => (

        <Post 
          isUser={this.isUser}
          key={key}
          clef= {this.state.key}
          nom={ this.state.posts[key].firstName}
          prenom=  { this.state.posts[key].lastName}
          post={this.state.posts[key].text}
          idPost={this.state.posts[key]._id}
          removePost={this.removePost}
          me = {this.state.posts[key]}
          idUser={this.state.user.idUser}
          like={this.like}
          unlike={this.unlike}
        />))

    return(
      < Fragment>
            <div id='home' className="col-md-2 options">
              <Logo />
              <Options/>
            </div>
            <div id='home' className='col-md-6 posts'>
              <NavBarPosts />
              <FormPost 
                addPost={this.addPost}
                pseudo ={this.state.pseudo} 
              />
              {posts}
            </div>
            <div id='home' className='col-md-4 freinds'>
              <NavBarFriends/>
              <Freind/>
              <Freind/>
              <Freind/>
              <Freind/>
              <Freind/>
              <Freind/>
              <Freind/>
        
            </div>
      </Fragment>

      );
  }
}
export default Home;
