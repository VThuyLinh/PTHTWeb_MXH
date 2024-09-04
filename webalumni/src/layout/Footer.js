import { Image, Nav } from "react-bootstrap";


const Footer = () => {
    return (
        <>

    <Nav class="container"  style={{marginTop:"100px"}}>
        <Nav class="row">
            <Nav class="col-lg-7 col-md-12 col-12">
                <Nav class="row">
                    <Nav class="col-sm-6 col-lg-6 col-12 footer-nav-logo widget">
                        <a href="/" class="logo-wrapper" title="Evo Tools">
                            <Image width="90"  height="57" src="https://res.cloudinary.com/dqcjhhtlm/image/upload/v1722954846/Screenshot_2024-08-06_213319_dbimlk.png"  alt="socialnetwork" class="lazy loaded" data-was-processed="true"/>
                        </a>
                        <p>ALUMNI</p>
                    </Nav>
                    <Nav class="col-sm-6 col-lg-6 col-12 footer-nav-info widget">


                        <p class="evo-in"><strong>Địa chỉ: xã Nhơn Đức, huyện Nhà Bè, TpHCM </strong></p>

                        <p class="evo-in">

                            <strong>Email: </strong><a href="mailto:support@sapo.vn" title="support@sapo.vn">alumniofOU@gmail.com</a>

                        </p>


                    </Nav>
                </Nav>
            </Nav>

        </Nav>
    </Nav>


    <Nav class="copyright text-center">

        © Bản quyền thuộc về AlumniOfOU <span class="s480-f">|</span> Cung cấp bởi <a href="https://ou.edu.vn/" title="OU"  rel="nofollow">OU</a>


       

    </Nav>
     
        </>
    );
}

export default Footer;