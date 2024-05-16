import React, { useEffect, useState } from "react";
import logo from "./logo.svg";
import "./App.css";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";
import Button from "react-bootstrap/Button";
import ButtonGroup from "react-bootstrap/ButtonGroup";
import ButtonToolbar from "react-bootstrap/ButtonToolbar";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import { Route, Routes, useNavigate } from "react-router-dom";
import Login from "./component/login";
import OffcanvasExample from "./component/OffcanvasExample";
import Main from "./component/Main";
import Recommend from "./component/Recommend";
import Record from "./component/Record";
import Community from "./component/Community";
import Myinfo from "./component/Myinfo";
import Map from "./component/Map";
import Auth from "./component/Auth";

function App() {
  const navigate = useNavigate();
  
  return (
    <div id="root">
      <div className="navbarr">
        <OffcanvasExample />
      </div>
      <div className="Container">
        <Routes>
          <Route path="/main" element={<Main />}></Route>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/recommend" element={<Recommend />}></Route>
          <Route path="/record" element={<Record />}></Route>
          <Route path="/community" element={<Community />}></Route>
          <Route path="/myinfo" element={<Myinfo />}></Route>
          {/* <Route path="/map" element={<Map data={data} />}></Route> */}
          <Route path="/Auth" element={<Auth />}></Route>
        </Routes>
      </div>
      <div className="footer">
        <ButtonToolbar
          className="bottom-bar"
          aria-label="Toolbar with Button groups"
        >
          <ButtonGroup className="bottom-bar-group" aria-label="First group">
            <Button
              className="bottom-bar-menu"
              variant="link"
              onClick={() => {
                navigate("/main");
              }}
            >
              <img src={process.env.PUBLIC_URL + "/main.png"} />
            </Button>
            <Button
              className="bottom-bar-menu"
              variant="link"
              onClick={() => {
                navigate("/recommend");
              }}
            >
              <img src={process.env.PUBLIC_URL + "/record.png"} />
            </Button>
            <Button
              className="bottom-bar-menu"
              variant="link"
              onClick={() => {
                navigate("/community");
              }}
            >
              <img src={process.env.PUBLIC_URL + "/comunity.png"} />
            </Button>
            <Button
              className="bottom-bar-menu"
              variant="link"
              onClick={() => {
                navigate("/myinfo");
              }}
            >
              <img src={process.env.PUBLIC_URL + "/info.png"} />
            </Button>
          </ButtonGroup>
        </ButtonToolbar>
      </div>
    </div>
  );
}

export default App;