import { useEffect, useState } from "react"
import { useNavigate } from "react-router-dom";

export default function Login() {

  const [userIsLogin, setUserIsLogin] = useState(false);
  const [inputIsValid, setInputIsValid] = useState(true);
  const [login, setLogin] = useState({userName: "", password:""})
  const [user, setUser] = useState(null);
  const [badRequest, setBadRequest] = useState(false);
  const navigate = useNavigate();

  const handleChange = (value,input) => {
    setLogin(prev => {
      return {...prev,
        [input]: value}});
  }

  const validatedInput = () => {
    let valid = true;
    if (login.userName.trim().length < 3) {
      valid = false;
    }
    if (login.password.trim().length < 3) {
      valid = false;
    }
    return valid;
  }

  const sendData =  async () => {
    try {
      const response = await fetch(process.env.REACT_APP_BASE_URL + "/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(login)
      })
      if (response.status === 200) {
        setBadRequest(false);
        const data = await response.json();
        setUser(data);
        setUserIsLogin(true);
      } else {
        setBadRequest(true);
      }
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    sessionStorage.setItem("user",JSON.stringify(user))
  },[user])

  const sendLogin = () => {
    if (validatedInput()) {
      setInputIsValid(true);
      sendData();
    } else {
      setInputIsValid(false);
    };
  };

  const logout = () => {
    setUser(undefined);
    setUserIsLogin(false);
    sessionStorage.clear();
  }

  const gotToProduct = () => {
    navigate('/products')
  }



  return (
    <div className="login container d-flex flex-column justify-content-center align-items-center">
      {userIsLogin ?<>
       <h1>Welcome {user.userName}</h1>
       <button type="submit" className="btn btn-primary shadow-sm my-4" onClick={logout}>logout</button>
       <button type="submit" className="btn btn-primary shadow-sm my-4" onClick={gotToProduct}>go to product page</button>
      </>
       :
      <>
       <h1>Please login</h1>
      <div className="col-4 card p-3 bg-body-tertiary my-4 shadow">
        <div className="mb-3">
          <label className="form-label">User name</label>
          <input type="userName" className="form-control shadow-sm" id="exampleInputEmail1" aria-describedby="emailHelp" value={login.userName} onChange={(e) => handleChange(e.target.value,"userName")}/>
        </div>
        <div className="mb-3">
          <label className="form-label">Password</label>
          <input type="password" className="form-control shadow-sm" id="exampleInputPassword1" value={login.password}  onChange={(e) => handleChange(e.target.value,"password")}/>
        </div>
        {!inputIsValid && <label className="text-danger fst-italic">user name and password must be min 3 characters long</label>}
        {badRequest && <label className="text-danger fst-italic">bad request, wrong user name or pasword</label>}
        <button type="submit" className="btn btn-primary shadow-sm my-4" onClick={sendLogin}>login</button>
      </div>
        </>}
    </div>
  )
}
