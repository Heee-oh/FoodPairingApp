const Record = () => {
  return (
    <div className="record_box">
      <div className="record_box_item">
        <div className="record_box_myphoto">
          <p>음식 사진</p>
          <img src={process.env.PUBLIC_URL + "/pizza.jpg"} />
        </div>
        <div className="record_box_rcphoto">
          <p>주류 사진</p>
          <img src={process.env.PUBLIC_URL + "/heineken.jpg"} />
        </div>
        <div className="record_box_btn">
          <button className="record_btn_share">
            <img src={process.env.PUBLIC_URL + "/share.png"} />
          </button>
          <button className="record_btn_delete">
            <img src={process.env.PUBLIC_URL + "/delete.png"} />
          </button>
        </div>
        <div className="record_box_content">
          <p>추천받은 메뉴는 하이네켄 입니다.</p>
        </div>
        <div style={{ clear: "both" }}></div>
      </div>
      <div className="record_box_item">
        <div className="record_box_myphoto">
          <p>음식 사진</p>
          <img src={process.env.PUBLIC_URL + "/pizza.jpg"} />
        </div>
        <div className="record_box_rcphoto">
          <p>주류 사진</p>
          <img src={process.env.PUBLIC_URL + "/heineken.jpg"} />
        </div>
        <div className="record_box_btn">
          <button className="record_btn_share">
            <img src={process.env.PUBLIC_URL + "/share.png"} />
          </button>
          <button className="record_btn_delete">
            <img src={process.env.PUBLIC_URL + "/delete.png"} />
          </button>
        </div>
        <div className="record_box_content">
          <p>추천받은 메뉴는 하이네켄 입니다.</p>
        </div>
        <div style={{ clear: "both" }}></div>
      </div>
    </div>
  );
};

export default Record;
