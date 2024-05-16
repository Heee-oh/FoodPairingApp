import { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faHeart,
  faComment,
  faMessage,
  faFloppyDisk,
  faSqurePlus,
} from "@fortawesome/free-regular-svg-icons";
import { faPen } from "@fortawesome/free-solid-svg-icons";

let Community = () => {
  let [good, setGood] = useState([]);

  return (
    <div style={{ padding: "5px" }}>
      <button className="community_btn">
        <FontAwesomeIcon icon={faPen} style={{ color: "#000000" }} size="3x" />
      </button>

      <div className="community_box">
        <div className="community_box_profile">
          <img src={process.env.PUBLIC_URL + "/heineken.jpg"} />
          <span>닉네임</span>
        </div>
        <div className="community_box_img">
          <img src={process.env.PUBLIC_URL + "/heineken.jpg"} />
        </div>
        <div className="community_box_link">
          <button className="btn2">
            {" "}
            <FontAwesomeIcon
              icon={faHeart}
              style={{ color: "black" }}
              size="2x"
            />
          </button>
          <a href="#">
            {" "}
            <FontAwesomeIcon
              icon={faComment}
              style={{ color: "black" }}
              size="2x"
            />
          </a>
        </div>
        <div className="community_box_good">
          <span>좋아요 0개</span>
        </div>
        <div className="community_box_content">
          <span>내용</span>
        </div>
      </div>
      <div className="community_box">
        <div className="community_box_profile">
          <img src={process.env.PUBLIC_URL + "/heineken.jpg"} />
          <span>닉네임</span>
        </div>
        <div className="community_box_img">
          <img src={process.env.PUBLIC_URL + "/heineken.jpg"} />
        </div>
        <div className="community_box_link">
          <button className="btn2">
            {" "}
            <FontAwesomeIcon
              icon={faHeart}
              style={{ color: "black" }}
              size="2x"
            />
          </button>
          <a href="#">
            {" "}
            <FontAwesomeIcon
              icon={faComment}
              style={{ color: "black" }}
              size="2x"
            />
          </a>
        </div>
        <div className="community_box_good">
          <span>좋아요 0개</span>
        </div>
        <div className="community_box_content">
          <span>내용</span>
        </div>
      </div>
    </div>
  );
};

export default Community;
