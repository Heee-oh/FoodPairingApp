// import { useEffect } from "react";

// const Map = (props) => {
//   useEffect(() => {
//     const { kakao } = window;
//     // 마커를 지도 위에 표시
//     var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
//     var options = {
//       //지도를 생성할 때 필요한 기본 옵션
//       center: new kakao.maps.LatLng(37.0175725, 127.2650979), //지도의 중심좌표.
//       level: 8, //지도의 레벨(확대, 축소 정도)
//     };

//     var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
//     let markerPosition = new kakao.maps.LatLng(37.0175725, 127.2650979);

//     // const resClick = () => {
//     // 마커를 생성
//     let marker = new kakao.maps.Marker({
//       position: markerPosition,
//     });
//     // console.log(props.data);
//     props.data.forEach((el) => {
//       // 마커를 생성합니다
//       new kakao.maps.Marker({
//         //마커가 표시 될 지도
//         map: map,
//         //마커가 표시 될 위치
//         position: new kakao.maps.LatLng(
//           el.REFINE_WGS84_LAT,
//           el.REFINE_WGS84_LOGT
//         ),
//         //마커에 hover시 나타날 title
//         title: el.title,
//       });

//       marker.setMap(map);
//     });
//   }, [props.data]);
//   return (
//     <>
//       <div
//         id="map"
//         style={{ width: "500px", height: "400px", margin: "0 auto" }}
//       ></div>
//     </>
//   );
// };

// export default Map;
