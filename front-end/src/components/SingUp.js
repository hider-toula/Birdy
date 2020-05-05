import React, { Component } from 'react'
import '../css/singIn.css';
import{Redirect} from 'react-router-dom'


class SingUp extends Component{
  state = {
    firsName : 'hider toula',
    lastName : 'Hider Toula',
    singin : false
  }


  singIn= event =>{
    event.preventDefault();
    this.setState({singin : true});
  }
	
	render(){

    if(this.state.singin){
      return <Redirect  to={"/"} />
    }
		return(
			<div>  
				<div className='singin'>
					<form id='singin'>
  						<div class="row">
    						<div class="col">
      							<input type="text" class="form-control" placeholder="First name"/>
    						</div>
    						<div class="col">
      							<input type="text" class="form-control" placeholder="Last name"/>
    						</div>
  						</div>

  						<div class="form-group">
    						<label for="exampleInputEmail1" id="singinlab"></label>
    						<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Your Email ..." />
    						<small id="emailHelp" class="form-text text-muted"></small>
  						</div> 

  						<div class="form-group">
    						<label for="exampleInputPassword1" id="singinlab" ></label>
    						<input type="password" class="form-control" id="exampleInputPassword1" placeholder="password" />
  						</div>

  						<div class="form-group form-check">
    						<input type="checkbox" class="form-check-input" id="exampleCheck1" />
    						<label class="form-check-label" for="exampleCheck1" id="singinlab">Check me out</label>
  						</div>

  						<button type="submit" class="btn btn-primary">Sing up</button>
  						<button onClick={this.singIn} type="button" class="btn btn-link create_count"> Sing in</button>
					</form>
				</div>
			 </div>
			)
	}
}

export default SingUp