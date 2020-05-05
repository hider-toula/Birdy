import React, { Component } from 'react'
import '../css/singIn.css';
import{Redirect} from 'react-router-dom'
import axios from 'axios'



class SingIn extends Component{
  

	state = {

    login : '',
    password : '',
    data:{}
  }

  changeLogin = event => {
    const val = event.currentTarget.value;
    const val1 = event.currentTarget.type
    this.setState({login : val})
  }
  changePassword = event => {
    const val = event.currentTarget.value;
    this.setState({password : val})
  }

  handleSubmit = (event) =>{
    
    event.preventDefault();
    const login='http://localhost:8080/Birdy/authentification?login='+this.state.login+'&password='+this.state.password
    axios.post(login)
    .then(response =>{
      this.setState({data : response.data})
    })

  }

  singUp= event =>{
    event.preventDefault();
    this.setState({singup : true});
  }


	render(){
    if(this.state.data.code === 1){
      return <Redirect  to={`/home/${this.state.data.key}`} />
    }
    if(this.state.singup){
      return <Redirect push to={`/singUp`} />
    }
		return(
			<div>  
				<div className='singin'>
					<form id='singin' onSubmit={this.handleSubmit}>
  						
    						<label for="exampleInputEmail1" id="singinlab">Email address</label>
    						<input value={this.state.login} onChange={this.changeLogin} type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your Email ..." />
  						

  						
    						<label for="exampleInputPassword1" id="singinlab" >Password</label>
    						<input value={this.state.password} onChange={this.changePassword} type="password" class="form-control" id="exampleInputPassword1" placeholder="password" />
  						

  						<div class="form-group form-check">
    						<input type="checkbox" class="form-check-input" id="exampleCheck1" />
    						<label class="form-check-label" for="exampleCheck1" id="singinlab">Check me out</label>
  						</div>

  						<button type="submit" className="btn btn-primary">Sing in</button>
  						<button onClick={this.singUp} type="button" className="btn btn-link create_count"> Create Count</button>
					</form>
				</div>
			 </div>
			)
	}
}

export default SingIn