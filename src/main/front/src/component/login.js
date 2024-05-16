import axios from "axios";
import { useEffect, useState } from "react";

const Login = () => {
  const Rest_api_key = process.env.REACT_APP_REST_API_KEY; //REST API KEY
  const redirect_uri = "http://localhost:3000/Auth"; //Redirect URI
  // oauth 요청 URL
  const kakaoURL = `https://kauth.kakao.com/oauth/authorize?client_id=${Rest_api_key}&redirect_uri=${redirect_uri}&response_type=code`;
  const handleLogin = () => {
    window.location.href = kakaoURL;
  };

  return (
    <div className="login_box">
      <div className="login_box_card">
        <h1>반주 추천 어플</h1>
        <div className="login_box_btn">
          <button className="login_btn_login" onClick={handleLogin}>
            <img
              style={{ width: "28px", height: "28px", paddingRight: "10px" }}
              src={process.env.PUBLIC_URL + "/kakaotalk.png"}
            />
            카카오로 시작하기
          </button>
        </div>
      </div>
    </div>
  );
};

export default Login;
