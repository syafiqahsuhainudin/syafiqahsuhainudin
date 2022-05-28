<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);

  if(session.getAttribute("currentSessionUser")==null)
      response.sendRedirect("/carwash/login.jsp");

%>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--=== Favicon ===-->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

    <title>Cardoor - Car Rental HTML Template</title>

    <!--=== Bootstrap CSS ===-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!--=== Slicknav CSS ===-->
    <link href="assets/css/plugins/slicknav.min.css" rel="stylesheet">
    <!--=== Magnific Popup CSS ===-->
    <link href="assets/css/plugins/magnific-popup.css" rel="stylesheet">
    <!--=== Owl Carousel CSS ===-->
    <link href="assets/css/plugins/owl.carousel.min.css" rel="stylesheet">
    <!--=== Gijgo CSS ===-->
    <link href="assets/css/plugins/gijgo.css" rel="stylesheet">
    <!--=== FontAwesome CSS ===-->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <!--=== Theme Reset CSS ===-->
    <link href="assets/css/reset.css" rel="stylesheet">
    <!--=== Main Style CSS ===-->
    <link href="style.css" rel="stylesheet">
    <!--=== Responsive CSS ===-->
    <link href="assets/css/responsive.css" rel="stylesheet">


    <!--[if lt IE 9]>
        <script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="loader-active">

    <!--== Preloader Area Start ==-->
    <div class="preloader">
        <div class="preloader-spinner">
            <div class="loader-content">
                <img src="assets/img/preloader.gif" alt="JSOFT">
            </div>
        </div>
    </div>
    <!--== Preloader Area End ==-->

    <!--== Header Area Start ==-->
    <header id="header-area" class="fixed-top">
        <!--== Header Top Start ==-->
        <div id="header-top" class="d-none d-xl-block">
            <div class="container">
                <div class="row">
                    <!--== Single HeaderTop Start ==-->
                    <div class="col-lg-3 text-left">
                        <i class="fa fa-map-marker"></i>   NO 16 JALAN 8/23E TAMAN DANAU KOTA, 53300 Kuala Lumpur, Malaysia
                    </div>
                    <!--== Single HeaderTop End ==-->

                    <!--== Single HeaderTop Start ==-->
                    <div class="col-lg-3 text-center">
                        <i class="fa fa-mobile"></i>  +019 9706745
                    </div>
                    <!--== Single HeaderTop End ==-->

                    <!--== Single HeaderTop Start ==-->
                    <div class="col-lg-3 text-center">
                        <i class="fa fa-clock-o"></i> Mon-Fri 09.00 - 17.00
                    </div>
                    <!--== Single HeaderTop End ==-->

                    <!--== Social Icons Start ==-->
                    <div class="col-lg-3 text-right">
                        <div class="header-social-icons">
                            <a href="#"><i class="fa fa-behance"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                        </div>
                    </div>
                    <!--== Social Icons End ==-->
                </div>
            </div>
        </div>
        <!--== Header Top End ==-->

        <!--== Header Bottom Start ==-->
        <div id="header-bottom">
            <div class="container">
                <div class="row">
                    <!--== Logo Start ==-->
                    <div class="col-lg-4">
                        <a href="index.html" class="logo">
                            <img src="assets/img/logo.png" alt="JSOFT">
                        </a>
                    </div>
                    <!--== Logo End ==-->

                    <!--== Main Menu Start ==-->
                     <%	String cust_email = (String)session.getAttribute("currentSessionUser");%>
                       <%		Integer cust_id = (Integer) session.getAttribute("is_new");%>
                    <div class="col-lg-8 d-none d-xl-block">
                        <nav class="mainmenu alignright">
                            <ul>
                                <li ><a href="index.jsp">Home</a>
                                   
                                </li>
                                
                                <li class="active"><a href="package.jsp">Package</a></li>
								<li><a href="bookingdetail.jsp">Booking Detail</a></li>
                            
                                
                                    
                                </li>
                              
                                <li><a href="logout.jsp">logout</a></li>
                            </ul>
                        </nav>
                    </div>
                    <!--== Main Menu End ==-->
                </div>
            </div>
        </div>
        <!--== Header Bottom End ==-->
    </header>
    <!--== Header Area End ==-->

    <!--== Slider Area Start ==-->
    <section id="slider-area">
        <!--== slide Item One ==-->
        <div class="single-slide-item overlay">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="book-a-car">
                            <form action="checkavailability" method="post">
                              
                                <!--== BOOKING DETAIL ==-->

                                <!--==  Date Time ==-->
                                 <div class="pick-up-date book-item">
                                   
                                    <input  type = "hidden" placeholder="Date"name="cust_id" value="<c:out value="<%=cust_id%>"/>" />
                                
                                <div class="pick-up-date book-item">
                                    <h4>DATE:</h4>
                                    <input  type = "date" placeholder="Date"name="book_date" required oninvalid="this.setCustomValidity('Please choose date')"/>

                                    <div class="return-car">
                                        <h4>TIME:</h4>
                                        <input type="time" placeholder="  Time" name="book_time"required oninvalid="this.setCustomValidity('Please Enter your time')"/>
                                    </div>
                                </div>
                                <!--== Date Time==-->
        <!--== Package Choose ==-->

				<!--== car plate num ==-->
                                <div class="pick-up-date book-item">
                                    <h4>PLATE NUMBER:</h4>
                                    <input type="text" id="plate" name="car_plateno" placeholder=" Plate Num.."required oninvalid="this.setCustomValidity('Please Enter your car plate number')">

                                    <div class="return-car">
                                        <h4>CAR NAME:</h4>
                                        <input type="text" id="carname" name="car_name" placeholder=" Your car name.."required oninvalid="this.setCustomValidity('Please Enter your car name')">
                                    </div>
                                <!--== Car Choose ==-->
                                <div class="choose-car-type book-item">
                                    <h4>CHOOSE CAR TYPE:</h4>
                                    <select class="custom-select"name="cartype"required oninvalid="this.setCustomValidity('Please choose car type')">
                                      <option selected>Select</option>
                                      <option value="SEDAN" name="SEDAN">SEDAN</option>
                                      <option value="MPV"name="MPV">MPV</option>
                                      <option value="SUV"name="SUV">SUV</option>
                                       <option value="COMPACT"name="COMPACT">COMPACT</option>
					<option value="4">MOTORCYCLE</option>
                                    </select>
                                </div>
                                <!--== Car Choose ==-->

				 <!--== Package Choose ==-->
                                <div class="choose-car-type book-item">
                                    <h4>CHOOSE PACKAGE TYPE:</h4>
                                    <select class="custom-select"name="car_package"required oninvalid="this.setCustomValidity('Please choose package type')">
                                      <option selected>Select</option>
                                      <option value="MINI WASH">MINI WASH</option>
                                      <option value="STANDARD WASH">STANDARD WASH</option>
                                      <option value="LUXURY WASH">LUXURY WASH</option>
										 
                                    </select>
                                </div>
                        
                                <div class="book-button text-center">
<br><br>
                          <button class="book-now-btn" type="submit" value="Submit">Book Now</button>
                                </div>
                            </form>


                        </div>
                    </div>

                    
                        <div class="display-table">
                            <div class="display-table-cell">
                                <div class="slider-right-text">
                                    <h1></h1>
                                    <p></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--== slide Item One ==-->
    </section>
    <!--== Slider Area End ==-->



            
    <!--== Choose Car Area Start ==-->
    <section id="choose-car" class="section-padding">
        <div class="container">
            <div class="row">
                <!-- Section Title Start -->
                <div class="col-lg-12">
                    <div class="section-title  text-center">
                        <h2>Choose your Car Package</h2>
                        <span class="title-line"><i class="fa fa-car"></i></span>
                        <p></p>
                    </div>
                </div>
                <!-- Section Title End -->
            </div>

            <div class="row">
                <!-- Choose Area Content Start -->
                <div class="col-lg-12">
                    <div class="choose-content-wrap">
                   

                        <!-- Choose Area Tab content -->
                        <div class="tab-content" id="myTabContent">
                            <!-- Popular Cars Tab Start -->
                            <div class="tab-pane fade show active" id="popular_cars" role="tabpanel" aria-labelledby="home-tab">
                                <!-- Popular Cars Content Wrapper Start -->
                                <div class="popular-cars-wrap">
                                    <!-- Filtering Menu -->
                                    <div class="popucar-menu text-center">
                                        <a href="#" data-filter="*" class="active">all</a>
                                    
                                        <a href="#" data-filter=".mpv">MPV</a>
                                        <a href="#" data-filter=".sedan">Sedan</a>
                                        <a href="#" data-filter=".suv">SUV</a>
                                         <a href="#" data-filter=".suv">COMPACT</a>
                                    </div>

                                    <!-- Filtering Menu -->

                                    <!-- PopularCars Tab Content Start -->
                                    <div class="row popular-car-gird">
                                        <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 con mpv">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-1.jpg">
                                                      <img src="assets/img/car/car-1.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">MINI WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 10</span>
                                                    </h3>

                                                   

                                                    <div class="p-car-feature">
                                                        <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->

                                        <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 hat sedan">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-2.jpg">
                                                      <img src="assets/img/car/car-2.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">STANDARD WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i> RM 20</span>
                                                    </h3>

                                                    
                                                    <div class="p-car-feature">
                                                       <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->

                                     

                                        <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 con sedan">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-4.jpg">
                                                      <img src="assets/img/car/car-4.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">LUXURY WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 30</span>
                                                    </h3>

                                                

                                                    <div class="p-car-feature">
                                                       <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->
    <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 con sedan">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-4.jpg">
                                                      <img src="assets/img/car/car-4.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">MINI WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 15</span>
                                                    </h3>

                                                

                                                    <div class="p-car-feature">
                                                       <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->
                                        <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 con mpv ">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-5.jpg">
                                                      <img src="assets/img/car/car-5.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">LUXURY WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 40</span>
                                                    </h3>

                                                  

                                                    <div class="p-car-feature">
                                                        <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->

                            

                                        <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 hat mpv">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-6.jpg">
                                                      <img src="assets/img/car/car-6.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">STANDARD WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 25</span>
                                                    </h3>

                                                    

                                                    <div class="p-car-feature">
                                                        <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->
										
                                        <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 hat suv">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-6.jpg">
                                                      <img src="assets/img/car/car-6.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">MINI WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 35</span>
                                                    </h3>

                                                    

                                                    <div class="p-car-feature">
                                                        <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->
										  <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 hat suv">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-6.jpg">
                                                      <img src="assets/img/car/car-6.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">STANDARD WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 40</span>
                                                    </h3>

                                                    

                                                    <div class="p-car-feature">
                                                        <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->
										  <!-- Single Popular Car Start -->
                                        <div class="col-lg-4 col-md-6 hat suv">
                                            <div class="single-popular-car">
                                                <div class="p-car-thumbnails">
                                                    <a class="car-hover" href="assets/img/car/car-6.jpg">
                                                      <img src="assets/img/car/car-6.jpg" alt="JSOFT">
                                                   </a>
                                                </div>

                                                <div class="p-car-content">
                                                    <h3>
                                                        <a href="#">LUXURY WASH</a>
                                                        <span class="price"><i class="fa fa-tag"></i>RM 45</span>
                                                    </h3>

                                                    

                                                    <div class="p-car-feature">
                                                        <a href="#">Exterior Wash</a>
                                                        <a href="#">Interior Wash</a>
                                                        <a href="#">Waxing</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Single Popular Car End -->
                                    </div>
                                    <!-- PopularCars Tab Content End -->
                                </div>
                                <!-- Popular Cars Content Wrapper End -->
                            </div>
                            <!-- Popular Cars Tab End -->

                            <!-- Newest Cars Tab Start -->
                            <div class="tab-pane fade" id="newest_cars" role="tabpanel" aria-labelledby="profile-tab">
                                <!-- Newest Cars Content Wrapper Start -->
                                <div class="popular-cars-wrap">
                                    <!-- Filtering Menu -->
                                    <div class="newcar-menu text-center">
                                        <a href="#" data-filter="*" class="active">all</a>
                                        <a href="#" data-filter=".toyota">toyota</a>
                                        <a href="#" data-filter=".bmw">bmw</a>
                                        <a href="#" data-filter=".audi">audi</a>
                                        <a href="#" data-filter=".tata">Tata</a>
                                    </div>

                                    <!-- Filtering Menu -->

                                    <!-- NewestCars Tab Content Start -->
                                    <div class="row newest-car-gird">
                                     

                        

                                    </div>
                                    <!-- NewestCars Tab Content End -->
                                </div>
                                <!-- Newest Cars Content Wrapper End -->
                            </div>
                            <!-- Newest Cars Tab End -->

                            <!-- Office Map Tab -->
                            <div class="tab-pane fade" id="office_map" role="tabpanel" aria-labelledby="contact-tab">
                                <div class="map-area">
                                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3650.6538067244583!2d90.37092511435942!3d23.79533919297639!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3755c0cce3251ab1%3A0x7a2aa979862a9643!2sJSoft!5e0!3m2!1sen!2sbd!4v1516771096779"></iframe>
                                </div>
                            </div>
                            <!-- Office Map Tab -->
                        </div>
                        <!-- Choose Area Tab content -->
                    </div>
                </div>
                <!-- Choose Area Content End -->
            </div>
        </div>
    </section>
    <!--== Choose Car Area End ==-->




      <!--== Footer Area Start ==-->
    <section id="footer-area">
        <!-- Footer Widget Start -->
        <div class="footer-widget-area">
            <div class="container">
                <div class="row">
                    <!-- Single Footer Widget Start -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-footer-widget">
                            <h2>About Us</h2>
                            <div class="widget-body">
                                <img src="assets/img/logo.png" alt="JSOFT">
                                <p>Boy 21 Auto SPA is expanding its business activities from just engaging in car wash service car wash materials and car wash machines. Boy 21 Auto SPA is providing several types of car wash services in their car wash center . Such as washing, vacuuming, waxing and polishing cars, and also engine cleaning in their car wash center. Boy 21 Auto SPA is specialized in car washing machine. We provide the right solution, services and products to take care of your car. They have five co-worker in the company 
</p>

                                <div class="newsletter-area">
                                    <form action="index.html">
                                        <input type="email" placeholder="Subscribe Our Newsletter">
                                        <button type="submit" class="newsletter-btn"><i class="fa fa-send"></i></button>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                    <!-- Single Footer Widget End -->

                    <!-- Single Footer Widget Start -->
                   
                    <!-- Single Footer Widget End -->

                    <!-- Single Footer Widget Start -->
                    <div class="col-lg-4 col-md-6">
                        <div class="single-footer-widget">
                            <h2>get touch</h2>
                            <div class="widget-body">
                                <p>Car Wash Boy21 AutoSpa info based on information below </p>

                                <ul class="get-touch">
                                    <li><i class="fa fa-map-marker"></i> NO 16 JALAN 8/23E TAMAN DANAU KOTA, 53300 Kuala Lumpur</li>
                                    <li><i class="fa fa-mobile"></i>+019 9706745 </li>
                                 
                                </ul>
                                <a href="https://www.google.com.bd/maps/place/16,+Jalan+8%2F23e,+Taman+Danau+Kota,+53300+Kuala+Lumpur,+Wilayah+Persekutuan+Kuala+Lumpur/@3.2065774,101.71806,17z/data=!3m1!4b1!4m5!3m4!1s0x31cc38123875baa7:0xbcc8a6aae10b4055!8m2!3d3.206572!4d101.7202487?hl=en" class="map-show" target="_blank">Show Location</a>
                            </div>
                        </div>
                    </div>
                    <!-- Single Footer Widget End -->
                </div>
            </div>
        </div>
        <!-- Footer Widget End -->

        <!-- Footer Bottom Start -->
        <div class="footer-bottom-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Bottom End -->
    </section>
    <!--== Footer Area End ==-->

        <!-- Footer Bottom Start -->
        <div class="footer-bottom-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Bottom End -->
    </section>
    <!--== Footer Area End ==-->

    <!--== Scroll Top Area Start ==-->
    <div class="scroll-top">
        <img src="assets/img/scroll-top.png" alt="JSOFT">
    </div>
    <!--== Scroll Top Area End ==-->

    <!--=======================Javascript============================-->
    <!--=== Jquery Min Js ===-->
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <!--=== Jquery Migrate Min Js ===-->
    <script src="assets/js/jquery-migrate.min.js"></script>
    <!--=== Popper Min Js ===-->
    <script src="assets/js/popper.min.js"></script>
    <!--=== Bootstrap Min Js ===-->
    <script src="assets/js/bootstrap.min.js"></script>
    <!--=== Gijgo Min Js ===-->
    <script src="assets/js/plugins/gijgo.js"></script>
    <!--=== Vegas Min Js ===-->
    <script src="assets/js/plugins/vegas.min.js"></script>
    <!--=== Isotope Min Js ===-->
    <script src="assets/js/plugins/isotope.min.js"></script>
    <!--=== Owl Caousel Min Js ===-->
    <script src="assets/js/plugins/owl.carousel.min.js"></script>
    <!--=== Waypoint Min Js ===-->
    <script src="assets/js/plugins/waypoints.min.js"></script>
    <!--=== CounTotop Min Js ===-->
    <script src="assets/js/plugins/counterup.min.js"></script>
    <!--=== YtPlayer Min Js ===-->
    <script src="assets/js/plugins/mb.YTPlayer.js"></script>
    <!--=== Magnific Popup Min Js ===-->
    <script src="assets/js/plugins/magnific-popup.min.js"></script>
    <!--=== Slicknav Min Js ===-->
    <script src="assets/js/plugins/slicknav.min.js"></script>

    <!--=== Mian Js ===-->
    <script src="assets/js/main.js"></script>

</body>

</html>