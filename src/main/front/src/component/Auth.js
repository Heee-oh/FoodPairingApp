import { useEffect, useState } from "react";
import axios from "axios";

const Auth = () => {
  const [code, setCode] = useState(null); // 인가코드 상태 추가
  useEffect(() => {
    const code = new URL(window.location.href).searchParams.get("code");
    console.log(code);
    setCode(code);
  }, []);

  useEffect(() => {
    if (code) { // code가 null이 아닌 경우에만 axios.post를 실행합니다.
      axios
        .post(
          "api/Auth",
          { code: code },
          { headers: { "Content-Type": "application/json" } }
        )
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.error("에러 발생:", error);
        });
    }
  }, [code]); 
  return <div>카카오 인가코드 받아서 넘기고 토큰 받아오는 과정</div>;
};

export default Auth;
