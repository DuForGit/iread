<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE>
<html>
<head>
<style type="text/css">
.container{
margin-top: 2px;
}
 .carousel-inner img{
text-align: center;
}
.carousel-caption{
font-size: 20px;
font-weight: bold;
}
#home{
background-color: #f6f5ee;
}
.row .book_name{
text-align: center;
}
.book_name_mob{
font-size: small;
text-align: left;
color:#000;
}
.writer_mob,.program_mob,.price_mob{
color:#000;
text-align: left;
font-size:xx-small;
}
.book_name{
color:#000;
}
#hot,#hot a{
margin-top: 5px;
}
#hot h1{
text-align: center;
}

</style>
</head>
<body>
<div id="home" class="container main">


<%-- <span class='booksnum' style='color:#aaa; font-size:12px;'>为您找到相关的电子书100本</span>
<div class="row search" >
	<div class="col-lg-9 col-md-9">
	<div class="row">
		<div  class="col-lg-2 col-md-2" id="bimg"><img src='${ctp}/resources/imgs/books/别输在说话上.jpg' class='img-responsive img-rounded' /></div>
		<div  class="col-lg-10 col-md-10" id="binfos">
			<div class='row'><span class='stitle'>无证之罪</span><span class='color'>(湖南人民出版社)</span></div>
			<div class='row stars'>
				<span class="glyphicon glyphicon-star"></span>
				<span class="glyphicon glyphicon-star"></span>
				<span class="glyphicon glyphicon-star-empty"></span>
				<span class='color'>3</span>
				<span class='color'> | </span><span class='color'>397条</span>
			</div>
			<div class='row'>
				<span class='inf'>介绍  </span>
				<span class='color'>故事发生在繁华都市，凶案现场，罪犯总是故意留下一枚指纹和一张字条—“请来抓我”，...</span>
			</div>
			<div class='row'>
				<span class='inf'>作者</span>
				<span class='color'>刘慈欣</span>
			</div>
			<div class='row'>
				<div class='col-lg-4 col-md-4 pull-left price' ><b>￥</b><span>28</span></div>
				<div class='col-lg-2 col-md-2 pull-right'><button class='btn btn-success btn-sm'>详细了解...</button></div>
			</div>
		</div>
	</div>
	</div>

	<div class="col-lg-3 col-md-3"></div>
	
</div>
<hr> --%>



<div class="row">
<!-- <div class="col-lg-1 col-md-1" style="float:left;"></div> -->
<div id="caro" class="carousel slide" data-ride="carousel"  style="margin:auto 1px;">
<ul class="carousel-indicators">
    <li data-target="#caro" data-slide-to="0" class="active"></li>
    <li data-target="#caro" data-slide-to="1"></li>
    <li data-target="#caro" data-slide-to="2"></li>
 </ul>
<div class="carousel-inner">
<div class="item active">
<img alt="你的人生終將閃耀" src="resources/imgs/caro/1509950504291.jpg" />
 
</div>
<div class="item">
<img alt="微笑向往，安之若素" src="resources/imgs/caro/1509951313802.jpg" /> 
<!-- <div class="carousel-caption">微笑向往，安之若素</div> -->
</div>
<div class="item">
<img alt="新書推薦" src="resources/imgs/caro/1509951848823.jpg" />
<!-- <div class="carousel-caption">新書推薦</div> -->
 </div>
</div>
<a class="carousel-control left" href="#caro" 
        data-slide="prev">&lsaquo;
    </a>
    <a class="carousel-control right" href="#caro" 
        data-slide="next">&rsaquo;
    </a>
</div>
<!-- <div class="col-lg-1 col-md-1" style="float:left;"></div> -->
</div>

<div id="hot" class="row">
<h1>热门推荐</h1>
	<a id=""  class="col-lg-2 col-md-2 col-xs-12 col-sm-12">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-4 col-sm-4">
				<img src="resources/imgs/books/santi.jpg" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">三体</li>
				<li class="writer_mob">作者: 刘培慈</li>
				<li class="program_mob">评分</li>
				<li class="price_mob">价格</li>
				</ul>
			</div>
		</div>
		<div id="" class="row hidden-xs hidden-sm book_name"><span>三体</span></div>
	</a>
	
	<a id=""  class="col-lg-2 col-md-2 col-xs-12 col-sm-12">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-4 col-sm-4">
				<img src="resources/imgs/books/santi.jpg" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">三体</li>
				<li class="writer_mob">作者: 刘培慈</li>
				<li class="program_mob">简介</li>
				<li class="price_mob">价格</li>
				</ul>
			</div>
		</div>
		<div id="" class="row hidden-xs hidden-sm book_name"><span>三体</span></div>
	</a>
	
	<a id=""  class="col-lg-2 col-md-2 col-xs-12 col-sm-12">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-4 col-sm-4">
				<img src="resources/imgs/books/santi.jpg" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">三体</li>
				<li class="writer_mob">作者: 刘培慈</li>
				<li class="program_mob">简介</li>
				<li class="price_mob">价格</li>
				</ul>
			</div>
		</div>
		<div id="" class="row hidden-xs hidden-sm book_name"><span>三体</span></div>
	</a>
	
	<a id=""  class="col-lg-2 col-md-2 col-xs-12 col-sm-12">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-4 col-sm-4">
				<img src="resources/imgs/books/santi.jpg" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">三体</li>
				<li class="writer_mob">作者: 刘培慈</li>
				<li class="program_mob">简介</li>
				<li class="price_mob">价格</li>
				</ul>
			</div>
		</div>
		<div id="" class="row hidden-xs hidden-sm book_name"><span>三体</span></div>
	</a>
	
	<a id=""  class="col-lg-2 col-md-2 col-xs-12 col-sm-12">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-4 col-sm-4">
				<img src="resources/imgs/books/santi.jpg" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">三体</li>
				<li class="writer_mob">作者: 刘培慈</li>
				<li class="program_mob">简介</li>
				<li class="price_mob">价格</li>
				</ul>
			</div>
		</div>
		<div id="" class="row hidden-xs hidden-sm book_name"><span>三体</span></div>
	</a>
	
	<a id=""  class="col-lg-2 col-md-2 col-xs-12 col-sm-12">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-xs-4 col-sm-4">
				<img src="resources/imgs/books/santi.jpg" class="img-responsive"/>
			</div>
			<div class="hidden-lg hidden-md col-xs-8 col-sm-8">
			<ul class="list-unstyled">
				<li class="book_name_mob">三体</li>
				<li class="writer_mob">作者: 刘培慈</li>
				<li class="program_mob">简介</li>
				<li class="price_mob">价格</li>
				</ul>
			</div>
		</div>
		<div id="" class="row hidden-xs hidden-sm book_name"><span>三体</span></div>
	</a>
	
</div>
<div id="new" class="row">
	<div></div>
</div>
<div id="comment" class="row">
	<div></div>
</div>
<div id="writer" class="row">
	<div></div>
</div>
<div id="publish" class="row">
	<div></div>
</div>

</div>
</body>
</html>