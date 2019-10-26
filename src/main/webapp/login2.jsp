<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link href="css/bootstrap1.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet"> 
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet"> 
	
    <link rel="stylesheet" type="text/css" href="css/slider-style.css" />
    <link rel="stylesheet" type="text/css" href="css/slider-custom.css" />
	<script type="text/javascript" src="js/modernizr.custom.79639.js"></script>
</head>
<body id="home">
        <header id="header">
        <nav id="main-nav" class="navbar navbar-default navbar-fixed-top" role="banner">
            <div class="container">
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">
                        <li class="scroll active"><a href="${ctx}/login_index.do">主页</a></li>  
                        <li class="scroll"><a href="#services">酒店服务</a></li>
                        <li class="scroll"><a href="#about">关于我们</a></li> 
						<li class="scroll"><a href="#portfolio">酒店图片</a></li>
						<li class="scroll"><a href="#pricing">商品图片</a></li>
                        <li class="scroll"><a href="#contact-us">联系我们</a></li> 
                        <li class="scroll"><a href="login.html">用户登录</a></li>
                        <li class="scroll"><a href="zhuce.html">用户注册</a></li>                    
                    </ul>
                </div>
            </div>
           <!-- <<%-- div style="width:150px;float:right;">
            <c:if test="${userName !=null }">
                <span style="background: rgb(246, 204, 7);">欢迎您：${userName}&nbsp;</span> <a href="${ctx}/login_tuichu.do">退出</a>
            </c:if>
            </div> --%>-->
        </nav>
    </header>

    <section class="demo-2">
           <div id="slider" class="sl-slider-wrapper">

				<div class="sl-slider">
				
					<div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">
						<div class="sl-slide-inner">
							<div class="bg-img bg-img-1">
								<img src="images/1.jpg">
							</div>
							 
						</div>
					</div>
					
					<div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
						<div class="sl-slide-inner">
							<div class="bg-img bg-img-2">
								<img src="images/2.jpg">
							
							</div>
							 
						</div>
					</div>
					
					<div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
						<div class="sl-slide-inner">
							<div class="bg-img bg-img-3">
								<img src="images/3.jpg">
							</div>
							 
						</div>
					</div>					
				</div><!-- /sl-slider -->

				<nav id="nav-dots" class="nav-dots">
					<span class="nav-dot-current"></span>
					<span></span>
					<span></span> 
				</nav>

			</div><!-- /slider-wrapper -->

    </section><!--/#main-slider-->

 <section id="services" >
        <div class="container">

            <div class="section-header">
                <h2 class="section-title wow fadeInDown animated" style="visibility: visible; animation-name: fadeInDown;">我们的服务</h2>
                <p class="wow fadeInDown animated" style="visibility: visible; animation-name: fadeInDown;"></p>
            </div>

            <div class="row">
                <div class="features">
                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="0ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 0ms; animation-name: fadeInUp; height: 194px;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-futbol-o"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">餐厅 &amp; 吧台</h4>
                                <p>多元化的餐厅，让您尽享国内外美食。个性化的吧台，一定能让您的体验得到满足。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="100ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 100ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-compass"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">豪华客房</h4>
                                <p>这里，将一份温温软软，悄然安放于旅行的希冀之中，您定不会失望。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="200ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 200ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-database"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">宴会招待</h4>
                                <p>周全的礼仪，个性化的需求，一定能让您的宾客感到舒适之至。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->
                		
                		<div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 500ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-bullseye"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">客房服务</h4>
                                <p>您可以拨打客房内的电话或者到前台登记您想要的客房服务。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->
                		
                		
                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="300ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 300ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-bar-chart"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">无线覆盖</h4>
                                <p>全店WiFi覆盖，即使身在异地，也不会影响你的随时办公和视频通话。</p>
                            </div>
                        </div>
                    </div><!--/.col-md-4-->

                    <div class="col-md-4 col-sm-6 wow fadeInUp animated" data-wow-duration="300ms" data-wow-delay="400ms" style="visibility: visible; animation-duration: 300ms; animation-delay: 400ms; animation-name: fadeInUp;">
                        <div class="media service-box">
                            <div class="pull-left">
                                <i class="fa fa-paper-plane-o"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">24/7 服务</h4>
                                <p>7天24小时不间断服务，始终如一，为客户着想，是我们不变的理念。</p>
                            </div>
                        </div>
                    </div>

                    
                </div>
            </div><!--/.row-->    
        </div><!--/.container-->
    </section>

  
 <section id="about">
        <div class="container">

            <div class="section-header">
                <h2 class="section-title wow fadeInDown">关于我们</h2>
                <p class="wow fadeInDown">您可以通过以下信息了解以下我们酒店的相关信息</p>
            </div>

            <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                  <img class="img-responsive" src="images/about.jpg">
                </div>

                <div class="col-sm-6 wow fadeInRight">
                    <h3 class="column-title">我们酒店</h3>
                    <p>洲际酒店是全球首个真正意义上的国际酒店品牌，旗下的五星级酒店遍布世界60多个国家，60多年的丰富经验让我们真正深入洞悉地了解每一个目的地。从传统的高贵优雅，到大都会的摩登时尚，再到热带海滨的轻松与恬静，每一间酒店都有各自 独特的风格，为我们品味独到的旅行者们带来万种风情。</p>
 <p>我们为用户提供多种个性化的服务，大致有以下这么几条：</p>

<ul class="listarrow">
<li><i class="fa fa-angle-double-right"></i>人性化的客房服务</li>
<li><i class="fa fa-angle-double-right"></i>客房直拨设备</li>
<li><i class="fa fa-angle-double-right"></i>洗衣服务</li>
<li><i class="fa fa-angle-double-right"></i>旅游问讯咨询</li> 
<li><i class="fa fa-angle-double-right"></i>多元化餐厅和咖啡厅</li>
<li><i class="fa fa-angle-double-right"></i>代客停车服务</li>
<li><i class="fa fa-angle-double-right"></i>叫醒服务</li>
</ul> 

                </div>
            </div>
        </div>
    </section>

   
  <section id="portfolio">
         <div class="container">

            <div class="section-header">
                <h2 class="section-title wow fadeInDown">酒店照片</h2>
                <p class="wow fadeInDown">在这里，您可以欣赏到我们酒店的图片</p>
            </div>
			<div class="portfolio-items">
            <c:forEach items="${findBook}" var="book" varStatus="status">
                <div class="portfolio-item designing">
                    <div class="portfolio-item-inner">
                        <a href="toBook"><img class="img-responsive" src="${book.room.image}" alt=""></a>
                    </div>
                </div>
               
	       </c:forEach>
      
       
       </div>
    </section>


   
    <section id="pricing">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">商品图片</h2>
                <p class="wow fadeInDown">在这里，您可以购买到我们酒店提供商品的图片</p>
            </div>

            <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                  <a href="#"><img class="img-responsive" src="portfolio/04.jpg"></a>
                </div>
                
            <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                  <img class="img-responsive" src="portfolio/05.jpg">
                </div>
    </section>
   

    <section id="business-stats">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">酒店配置</h2>
            </div>

            <div class="row text-center">
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
                        <div class="business-stats" data-digit="1000" data-duration="1000"></div>
                        <strong>可入住客人总数</strong>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
                        <div class="business-stats" data-digit="400" data-duration="1000"></div>
                        <strong>房间数</strong>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="200ms">
                        <div class="business-stats" data-digit="1000" data-duration="1000"></div>
                        <strong>曾举办过婚礼</strong>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-12">
                    <div class="wow fadeInUp" data-wow-duration="400ms" data-wow-delay="300ms">
                        <div class="business-stats" data-digit="3000" data-duration="1000"></div>
                        <strong>曾举办过宴会</strong>
                    </div>
                </div>
            </div>
        </div>
    </section><!--/#business-stats-->

  
  <section id="contact-us">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title wow fadeInDown">联系我们</h2>
                <p class="wow fadeInDown">您可以通过以下方式联系我们，您的任何问题都能解决.</p>
            </div>
        </div>
  
        <div class="container">
            <div class="container contact-info">
                <div class="row">
				  <div class="col-sm-4 col-md-4">
                        <div class="contact-form">
                            <h3>联系方式</h3>

                            <address>
                              <strong>Amazing Hotel, Inc.</strong><br>
                              上海市浦东新区康桥路1605号<br>
                              国际旅游度假区罗山路酒店<br>
                              <abbr title="Phone">TEL:</abbr>  021-33758898<br>
                              <abbr title="Fax">Fax:</abbr>  021-68082638
                            </address>
					</div></div>
                    <div class="col-sm-8 col-md-8">
                        <div class="contact-form">
                            <form id="main-contact-form" name="contact-form" method="post" action="user_fankui.do">
                                <div class="form-group">
                                    <textarea name="aaa" class="form-control" rows="8" placeholder="反馈内容" required></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary">反馈建议</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
   </section><!--/#bottom-->

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap1.min.js"></script> 
    <script src="js/mousescroll.js"></script>
    <script src="js/smoothscroll.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/jquery.isotope.min.js"></script>
    <script src="js/jquery.inview.min.js"></script>
    <script src="js/wow.min.js"></script>
	<script type="text/javascript" src="js/jquery.ba-cond.min.js"></script>
    <script type="text/javascript" src="js/jquery.slitslider.js"></script>
	<script type="text/javascript" src="js/slitslider-custom.js"></script>
    <script src="js/custom-scripts.js"></script>

</body>
</html>