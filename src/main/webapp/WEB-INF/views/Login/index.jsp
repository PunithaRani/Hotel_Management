<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xml:lang="en">
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Citadines Hotel</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/fontawesome.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
        <link href="https://fonts.googleapis.com/css?family=Lobster|Lobster+Two|Noto+Serif" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
		<link rel = "shortcut icon" href="<%= request.getContextPath() %>/imgs/hotel_images-removebg-preview.png"/>
        <title>Index</title>
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-light bg-light text-capitalize main-font-family">
            <div class="container">
                <a class="navbar-brand" href="/"><img src="<%= request.getContextPath() %>/imgs/logo.png" alt="#" /></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#show-menu" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="show-menu">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#home">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#contact">contacts</a>
                        </li>
                        <li class="nav-item book d-flex align-items-center">
                            <a class="nav-link" href="/login/userLogin">Book Now</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <header id="home">
            <div class="small-container">
                <form class="main-font-family text-center">
                    <input type="search">
                    <em class="fas fa-search"></em>
                    <input type="submit" value="Search">
                </form>
                <div class="row">
                    <div class="col-lg-4 col-12 lobster-font-family d-flex align-items-center">
                        <h2>Experience the unparalled luxury in the comfort of our hotel</h2>
                        <button><a href="#">About hotel</a></button>
                    </div>
                </div>
                <div class="h-slider roboto-font-family welcome d-flex align-items-center justify-content-center">
                    <h1 class="text-capitalize">Welcome to <br><span>citadines</span></h1>
                    <div id="headerslider" class="carousel slide" data-ride="carousel">
                      <div class="carousel-inner">
                        <div class="carousel-item carousel-three active"></div>
                        <div class="carousel-item carousel-two"></div>
                        <div class="carousel-item carousel-one"></div>
                      </div>
                      <a class="carousel-control-prev" href="#headerslider" role="button" data-slide="prev">
                        <em class="fas fa-angle-double-left"></em>
                        <span class="sr-only">Previous</span>
                      </a>
                      <a class="carousel-control-next" href="#headerslider" role="button" data-slide="next">
                        <em class="fas fa-angle-double-right"></em>
                        <span class="sr-only">Next</span>
                      </a>
                    </div>
                </div>
            </div>
            <div class="st-rec"></div>
            <div class="rd-rec"></div>
        </header>
        
        <div class="about lobster-font-family">
            <div class="container">
                <h2 class="text-center text-capitalize">About our hotel</h2>
                <img src="<%= request.getContextPath() %>/imgs/shape.png" alt="Hotel">
                <div class="row">
                    <div class="col-lg-6 col-12">
                        <h4>A best place to enjoy your life</h4>
                        <p>Spread across 4.8 acres of peaceful land, the luxurious Citadines Chennai offers an outdoor pool and a fitness centre. Its grand and well-designed rooms enjoy 24-hour room services. Other dining options include Jamavar Indian Restaurant, China XO Chinese restaurant and Library Blu bar.The hotel also provides a florist, concierge desk and meeting rooms</p>
                        <button><a href="#">Read more</a></button>
                    </div>
                    <div class="col-lg-6 col-12">
                        <div class="img"></div>
                    </div>
                </div>
                <h2 class="text-capitalize" id="room">rooms & suits</h2>
                <div class="row">
                    <div class="col-lg-4 col-12">
                        <div class="img"></div>
                    </div>
                    <div class="col-lg-8 col-12">
                        <div class="block">
                            <div>
                                <img src="<%= request.getContextPath() %>/imgs/shape.png" alt="Hotel">
                                <strong>$405</strong>
                                <h5>luxury rooms</h5>
                                <p>Featuring grand decor in rich warm colors, this air-conditioned room has a flat-screen TV, sofa and a well-stocked mini-bar. Private bathroom comes with a spa mood lighting, bathtub and hot-water showers. Yoga mat and an anti-skid mat are provided on request.</p>
                                <button><a href="#" class="text-capitalize">Read more</a></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="gallery lobster-font-family" id="blog">
            <div class="container">
                <h2 class="text-calitalize text-center">Our gallery</h2>
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="pic-one"><h4>Relaxed swimming</h4></div>
                        <div class="pic-two"><h4>Spacious Accommodtion</h4></div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="pic-three active"><h4>Yoga Wellness</h4></div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-12">
                        <div class="pic-four"><h4>Romantic dinner</h4></div>
                        <div class="pic-five"><h4>Apa & Wellness</h4></div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="slider main-font-family">
            <h2 class="text-center text-capitalize main-font-family">what our clients say</h2>
          <div id="slideToNext" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#slideToNext" data-slide-to="0" class="active"></li>
              <li data-target="#slideToNext" data-slide-to="1"></li>
              <li data-target="#slideToNext" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <div class="carousel-caption d-block">
                    <img src="<%= request.getContextPath() %>/imgs/pic7.png" alt="Hotel">
                  <h5>John Due</h5>
                  <p>Tastefully done rooms with a beautiful sea view
 thatâ??s hard to tire of. Staff were extremely courteous and ensured all my requirements were met. Overall, an excellent stay and will definitely be coming back</p>
                </div>
              </div>
              <div class="carousel-item">
                <div class="carousel-caption d-block">
                    <img src="<%= request.getContextPath() %>/imgs/pic71.png" alt="picture ">
                  <h5>Steve Rogers</h5>
                  <p>Everything was perfect, exceptionally helpful a
nd polite staff, we had a beautiful room with a lovely view, it was sparkling clean and cleaned every day. I would highly recommend this hotel</p>
                </div>
              </div>
              <div class="carousel-item">
                <div class="carousel-caption d-block">
                    <img src="<%= request.getContextPath() %>/imgs/pic72.png" alt="image">
                  <h5>Mary Jan</h5>
                  <p>Excellent Professional service delivered by all
 staff. I've and above service at poolside. Place is glitzy and glamorous. My first choice in Chennai</p>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <div class="contact main-font-family text-center">
            <div class="container">
                <h2 id="contact">Get in touch</h2>
                <div class="row">
                    <div class="col-6">
                        <div class="contact-form">
                            <form>
                                <input type="text" placeholder="Name">
                                <input type="email" placeholder="Email">
                                <input type="text" placeholder="Phone">
                                <textarea placeholder="Message"></textarea>
                                <input type="submit" value="submit">
                            </form>
                        </div>
                    </div>
                    <div class="col-6">
                        <h2 class="text-right">Book Your Holiday Best for relaxed retreats and cultural encounters</h2>
                        <img src="<%= request.getContextPath() %>/imgs/shape.png" alt="Shape">
                    </div>
                </div>
            </div>
            <div></div>
        </div>
        
        <footer class="noto-font-family">
            <div class="overlay">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-6 col-12">
                            <h3>Useful links</h3>
                            <ul class="text-capitalize">
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Contacts</a></li>
                            </ul>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12">
                            <h3>Find us</h3>
                            <p>Vacation Center, 176 W OMR Street,<br>
                                Chennai, TamilNadu 600119, India<br>
                                (+91) 987 654 3210<br>
                                (+91) 987 654 3211<br>
                                citadinesinfo@gmail.com
                            </p>
                        </div>
                        <div class="col-lg-4 col-md-6 col-12 form">
                            <h3>News letter</h3>
                            <form>
                                <input type="email" placeholder="Email">
                                <input type="submit">
                            </form>
                            <ul>
                                <li><a href="#"><em class="fab fa-facebook-f"></em></a></li>
                                <li><a href="#"><em class="fab fa-twitter"></em></a></li>
                                <li><a href="#"><em class="fab fa-instagram"></em></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        
        <div class="copyright noto-font-family">
            <p>Â© 2021 All Rights Reserved.<p>
        </div>
        
        <script src="<%= request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
        <script src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
        
</body>
</html>