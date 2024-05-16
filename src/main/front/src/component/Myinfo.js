const Myinfo = () => {
  return (
    <div className="info_box">
      <div className="info_box_profile">
        <img src={process.env.PUBLIC_URL + "/pizza.jpg"} />
      </div>
      <div className="info_box_setting">
        <div className="info_box_ex">
          <h4>닉네임</h4>
        </div>
        <div className="info_box_set">
          <p>asdffg</p>
        </div>
        <div className="info_box_btn">
          <button className="bttn">수정</button>
        </div>
      </div>
      <div className="info_box_setting">
        <div className="info_box_ex">
          <h4>비밀번호</h4>
        </div>
        <div className="info_box_set">
          <p>********</p>
        </div>
        <div className="info_box_btn">
          <button className="bttn">수정</button>
        </div>
      </div>
      <div className="info_box_setting">
        <div className="info_box_ex">
          <h4>선호 주류</h4>
        </div>
        <div className="info_box_set">
          <p>소주</p>
        </div>
        <div className="info_box_btn">
          <button className="bttn">수정</button>
        </div>
      </div>
    </div>
  );
};

export default Myinfo;
