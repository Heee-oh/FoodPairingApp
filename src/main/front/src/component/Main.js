const Main = () => {
  return (
    <div className="main_box">
      <div className="main_box_camera">
        <img src={process.env.PUBLIC_URL + "/pizza.jpg"} />
      </div>
      <div className="main_box_shoot">
        <button className="main_btn_shoot">음식 촬영</button>
      </div>
    </div>
  );
};

export default Main;
