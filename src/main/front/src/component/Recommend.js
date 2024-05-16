import Card from "react-bootstrap/Card";

const Recommend = () => {
  return (
    <div className="recommend_box">
      <div className="recommend_box_photo">
        <img src={process.env.PUBLIC_URL + "/heineken.jpg"} />
      </div>
      <div className="recommend_box_content">
        <h3>추천 주류: 헤이네켄</h3>
        <p>촬영하신 음식은 헤이네켄과 잘 어울려요!</p>
        <div className="recommend_box_btn">
          <button className="bttn">다시찍기</button>
          <button
            className="bttn"
            style={{ marginLeft: "20px", marginRight: "20px" }}
          >
            공유하기
          </button>
          <button className="bttn">콜키지 찾기</button>
        </div>
      </div>
    </div>
  );
};

export default Recommend;
