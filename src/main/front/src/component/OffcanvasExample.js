import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import Offcanvas from "react-bootstrap/Offcanvas";
import { useNavigate } from "react-router-dom";

function OffcanvasExample() {
  const navigate = useNavigate();
  return (
    <>
      <Navbar key="lg" expand="lg" className="bg-body-tertiary navbar">
        <Container fluid>
          <Navbar.Brand>어플 이름</Navbar.Brand>
          <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-lg`} />
          <Navbar.Offcanvas
            id={`offcanvasNavbar-expand-lg`}
            aria-labelledby={`offcanvasNavbarLabel-expand-lg`}
            placement="end"
          >
            <Offcanvas.Header closeButton>
              <Offcanvas.Title id={`offcanvasNavbarLabel-expand-lg`}>
                어플 이름
              </Offcanvas.Title>
            </Offcanvas.Header>
            <Offcanvas.Body>
              <Nav className="pe-3">
                <Nav.Link
                  onClick={() => {
                    navigate("/main");
                  }}
                >
                  음식촬영
                </Nav.Link>
                <Nav.Link
                  onClick={() => {
                    navigate("/recommend");
                  }}
                >
                  추천기록
                </Nav.Link>
                <Nav.Link
                  onClick={() => {
                    navigate("/community");
                  }}
                >
                  커뮤니티
                </Nav.Link>
              </Nav>
              <Nav className="justify-content flex-grow-1"></Nav>
              <Nav className="pe-3">
                <Nav.Link
                  onClick={() => {
                    navigate("/login");
                  }}
                >
                  로그인
                </Nav.Link>
              </Nav>
            </Offcanvas.Body>
          </Navbar.Offcanvas>
        </Container>
      </Navbar>
    </>
  );
}

export default OffcanvasExample;
