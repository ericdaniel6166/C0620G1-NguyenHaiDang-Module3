<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/05/2020
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <link rel="manifest" href="site.webmanifest">
  <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

  <!-- CSS here -->
  <link rel="stylesheet" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
  <link rel="stylesheet" href="assets/css/flaticon.css">
  <link rel="stylesheet" href="assets/css/slicknav.css">
  <link rel="stylesheet" href="assets/css/animate.min.css">
  <link rel="stylesheet" href="assets/css/magnific-popup.css">
  <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
  <link rel="stylesheet" href="assets/css/themify-icons.css">
  <link rel="stylesheet" href="assets/css/slick.css">
  <link rel="stylesheet" href="assets/css/nice-select.css">
  <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<!-- Preloader Start -->
<div id="preloader-active">
  <div class="preloader d-flex align-items-center justify-content-center">
    <div class="preloader-inner position-relative">
      <div class="preloader-circle"></div>
      <div class="preloader-img pere-text">
        <img src="assets/img/logo/logo.png" alt="">
      </div>
    </div>
  </div>
</div>
<!-- Preloader Start -->

<header>
  <!-- Header Start -->
  <div class="header-area">
    <div class="main-header ">
      <div class="header-bottom  header-sticky">
        <div class="container-fluid">
          <div class="row align-items-center">
            <!-- Logo -->
            <div class="col-xl-1 col-lg-1 col-md-1 col-sm-3">
              <div class="logo">
                <a href="index.html"><img src="assets/img/logo/logo.png" s alt=""></a>
              </div>
            </div>
            <div class="col-xl-6 col-lg-8 col-md-7 col-sm-5">
              <!-- Main-menu -->
              <div class="main-menu f-right d-none d-lg-block">
                <nav>
                  <ul id="navigation">
                    <%--                                        ***--%>
                    <li><a href="index.html">Home</a></li>
                    <li><a href="/list_employee">Employee</a></li>
                    <li><a href="Catagori.html">Customer</a></li>
                    <li><a href="Catagori.html">Service</a></li>
                    <li><a href="Catagori.html">Contract</a></li>
                  </ul>
                </nav>
              </div>
            </div>
            <div class="col-xl-5 col-lg-3 col-md-3 col-sm-3 fix-card">
              <ul class="header-right f-right d-none d-lg-block d-flex justify-content-between">
                <li class="d-none d-xl-block">
                  <div class="form-box f-right ">
                    <input type="text" name="Search" placeholder="Input name">
                    <div class="search-icon">
                      <i class="fas fa-search special-tag"></i>
                    </div>
                  </div>
                </li>
                <li class="d-none d-lg-block"> <a href="#" class="btn header-btn">Sign in</a></li>
              </ul>
            </div>
            <!-- Mobile Menu -->
            <div class="col-12">
              <div class="mobile_menu d-block d-lg-none"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Header End -->
</header>

<main>
  <!-- slider Area Start -->
  <div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="slider-active">
      <div class="single-slider slider-height" data-background="assets/img/hero/h1_hero.jpg">
        <div class="container">
          <div class="row d-flex align-items-center justify-content-between">
            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 d-none d-md-block">
              <div class="hero__img" data-animation="bounceIn" data-delay=".4s">
                <img src="assets/img/hero/hero_man.png" alt="">
              </div>
            </div>
            <div class="col-xl-5 col-lg-5 col-md-5 col-sm-8">
              <div class="hero__caption">
                <span data-animation="fadeInRight" data-delay=".4s">60% Discount</span>
                <h1 data-animation="fadeInRight" data-delay=".6s">Best <br> Resort</h1>
                <p data-animation="fadeInRight" data-delay=".8s">Best Resort By 2020!</p>
                <!-- Hero-btn -->
                <div class="hero__btn" data-animation="fadeInRight" data-delay="1s">
                  <a href="industries.html" class="btn hero-btn">Book Now</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="single-slider slider-height" data-background="assets/img/hero/h1_hero.jpg">
        <div class="container">
          <div class="row d-flex align-items-center justify-content-between">
            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 d-none d-md-block">
              <div class="hero__img" data-animation="bounceIn" data-delay=".4s">
                <img src="assets/img/hero/hero_man.png" alt="">
              </div>
            </div>
            <div class="col-xl-5 col-lg-5 col-md-5 col-sm-8">
              <div class="hero__caption">
                <span data-animation="fadeInRight" data-delay=".4s">60% Discount</span>
                <h1 data-animation="fadeInRight" data-delay=".6s">Best <br> Resort</h1>
                <p data-animation="fadeInRight" data-delay=".8s">Best Resort By 2020!</p>
                <!-- Hero-btn -->
                <div class="hero__btn" data-animation="fadeInRight" data-delay="1s">
                  <a href="industries.html" class="btn hero-btn">Book Now</a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- slider Area End-->


</main>

<footer>

  <!-- Footer Start-->
  <div class="footer-area footer-padding">
    <div class="container">
      <div class="row d-flex justify-content-between">
        <div class="col-xl-3 col-lg-3 col-md-5 col-sm-6">
          <div class="single-footer-caption mb-50">
            <div class="single-footer-caption mb-30">
              <!-- logo -->
              <div class="footer-logo">
                <a href="index.html"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
              </div>
              <div class="footer-tittle">
                <div class="footer-pera">
                  <p>Furama is a premier base for exploring one of Asia’s most exciting new destinations. Just a short drive from Danang lay four UNESCO-listed World Heritage Sites</p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-2 col-lg-3 col-md-3 col-sm-5">
          <div class="single-footer-caption mb-50">
            <div class="footer-tittle">
              <h4>Quick Links</h4>
              <ul>
                <li><a href="#">About</a></li>
                <li><a href="#"> Offers & Discounts</a></li>
                <li><a href="#"> Get Coupon</a></li>
                <li><a href="#">  Contact Us</a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-7">
          <div class="single-footer-caption mb-50">
            <div class="footer-tittle">
              <h4>Furama Resort</h4>
              <ul>
                <li><a href="#">News</a></li>
                <li><a href="#">Rack Rate</a></li>
                <li><a href="#">Lifestyle Blog</a></li>
                <li><a href="#">Work with us</a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-xl-3 col-lg-3 col-md-5 col-sm-7">
          <div class="single-footer-caption mb-50">
            <div class="footer-tittle">
              <h4>Support</h4>
              <ul>
                <li><a href="#">Frequently Asked Questions</a></li>
                <li><a href="#">Terms & Conditions</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Report a Payment Issue</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <!-- Footer bottom -->
      <div class="row">
        <div class="col-xl-7 col-lg-7 col-md-7">
          <div class="footer-copy-right">
            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
              Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
              <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>                   </div>
        </div>
        <div class="col-xl-5 col-lg-5 col-md-5">
          <div class="footer-copy-right f-right">
            <!-- social -->
            <div class="footer-social">
              <a href="#"><i class="fab fa-twitter"></i></a>
              <a href="#"><i class="fab fa-facebook-f"></i></a>
              <a href="#"><i class="fab fa-behance"></i></a>
              <a href="#"><i class="fas fa-globe"></i></a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Footer End-->

</footer>

<!-- JS here -->

<!-- All JS Custom Plugins Link Here here -->
<script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
<!-- Jquery, Popper, Bootstrap -->
<script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
<script src="./assets/js/popper.min.js"></script>
<script src="./assets/js/bootstrap.min.js"></script>
<!-- Jquery Mobile Menu -->
<script src="./assets/js/jquery.slicknav.min.js"></script>

<!-- Jquery Slick , Owl-Carousel Plugins -->
<script src="./assets/js/owl.carousel.min.js"></script>
<script src="./assets/js/slick.min.js"></script>

<!-- One Page, Animated-HeadLin -->
<script src="./assets/js/wow.min.js"></script>
<script src="./assets/js/animated.headline.js"></script>
<script src="./assets/js/jquery.magnific-popup.js"></script>

<!-- Scroll up, nice-select, sticky -->
<script src="./assets/js/jquery.scrollUp.min.js"></script>
<script src="./assets/js/jquery.nice-select.min.js"></script>
<script src="./assets/js/jquery.sticky.js"></script>

<!-- contact js -->
<script src="./assets/js/contact.js"></script>
<script src="./assets/js/jquery.form.js"></script>
<script src="./assets/js/jquery.validate.min.js"></script>
<script src="./assets/js/mail-script.js"></script>
<script src="./assets/js/jquery.ajaxchimp.min.js"></script>

<!-- Jquery Plugins, main Jquery -->
<script src="./assets/js/plugins.js"></script>
<script src="./assets/js/main.js"></script>

</body>
</html>
