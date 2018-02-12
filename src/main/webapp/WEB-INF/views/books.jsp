<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>分类</title>
<c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/>
<style type="text/css">
#books{
margin-top: 10px;
}
#navlist{
padding-left: 0px;
}
#lists .list-group-item{
background-color: #f5f4f2;
}
#lists .list-group-item{
text-align: left;
}
#listhead{
background-color: #34495e;
}
#lists .list-group-item span{
float: right;
}
#actions a{
border-width: 0em;
padding-left: 0px;
float: left;
}
#bookslist .row .btn,#bookslist .row .btn span{
color:#666;
font-size: 1em;
text-align: left;
}
#booksorder,#booksorder .btn-group button{
background-color: #f5f4f2;
border: 0px;
}
#books_infos{
margin-top: 20px;
}
.book_name{
text-align: center;
font-size: 14px;
font-weight: bold;
}
#books_infos div div ul li .author{
float: left;
}
#books_infos div div ul li .price{
float:right;
color:red;
}
#books_infos div div ul{
margin-top:10px; 
height: 60px;
}
#page{
text-align: center;
}
#actions{
margin-top:10px; 
}
/* #lists .clazz{

} */
#lists .type{
display:none;
}
.bookinfo{
color:#000;
}
.breadcrumb li a{
color:#666;
}
.breadcrumb{
background-color: inherit;
margin: 8px; 
padding:0px;
}
</style>
<script type="text/javascript">

//books列表的显示方式和分页信息处理，
//返回的data为Map类型，包含books列表、总页数、总的book数量、当前页码、是否有前后页、前后页的页码等信息
function booksShow(data){
	var bookslist = $("#books_infos");
	var row;
	var booksL = data.list;//books列表
	var size = booksL.length;//本页books列表的长度
	var i = 0;
	var colsize=0;//用于标识row中包含book列表的个数,一行有6个数据
	var book;
	
	//处理books列表的展示
	if(size != 0){
		for(;i < size; i++){
			colsize = i%6;
			book = booksL[i];
			if(colsize == 0){
				row = $("<div class='row'>");
			}
			
			row.append("<div class='col-lg-2 col-md-2' style='cursor:pointer'><a class='bookinfo'><img src='${ctp}/resources/imgs/books/" + book.cover +"' class='img-responsive img-rounded'/> <ul class='list-unstyled'><li class='book_name'>"+book.title+"</li><li><span class='author'>"+book.writer.name+"</span><span class='price'><b>￥</b>"+book.price+"</span></li></ul></a> </div>");
			
			if(colsize == 5){
				row.append("</div>");
			}
			bookslist.html(row);
		}
	}else{bookslist.html(""); }
	
	
	//处理分页
	pages(data);
	
}

//处理分页函数
function pages(data){
	var startPage = "<ul class='pagination'>";//关于分页按钮的HTML开始位置代码
	var endPage = "</ul>";//关于分页按钮的HTML结束位置代码
	var pa = "";//分页按钮的HTML代码
	var pagediv = $("#page");
	
	var total = data.total;//查询的总book数量；不是当前页面的总数，是根据条件查找到的数据库中的总数
	var pageNum = data.pageNum; //当前页码
	var pages = data.pages;//总页数
	var pre = data.pre;//前一页页码
	var next = data.next;//下一页页码
	var isFirstPage = data.isFirstPage;//是否为第一页
	var isLastPage = data.isLastPage;//是否为最后一页
	var hasPreviousPage = data.hasPreviousPage;//是否有前一页
	var hasNextPage = data.hasNextPage;//是否有后一页
	//1.判断是否查询得到结果,并且判断是否需要分页
	if(total > 0 && pages > 1){
		pa = startPage
		+ firstPage(isFirstPage,pageNum)
		+ prePage(hasPreviousPage,pre)
		+ NumPage(pageNum, pages)
		+ nextPage(hasNextPage,next)
		+ lastPage(isLastPage,pages,pageNum) + endPage;
	} 
	pagediv.html(pa);
}

//包含页码分页按钮
function NumPage(pageNum, pages){
	var p = "";
	if(pages <= 10 && pages > 1){
		for(var i=1; i<=pages;i++){
			if(i == pageNum){
				p = p + "<li style='cursor:pointer' class='active' onclick='pagebooks("+i+")'><a>"+i+"</a></li>";
			}else{
				p = p + "<li style='cursor:pointer' onclick='pagebooks("+i+")'><a>"+i+"</a></li>";
			}
		}
	}else if(pages > 10){
		if(pageNum > 5){
			var start = pageNum-4;
			var end = pageNum+5 < pages ? pageNum+5:pages;
			for(var i = start;i <=end;i++){
				if(i == pageNum){
					p = p + "<li style='cursor:pointer' class='active' onclick='pagebooks("+i+")'><a>"+i+"</a></li>";
				}else{
					p = p + "<li style='cursor:pointer' onclick='pagebooks("+i+")'><a>"+i+"</a></li>";
				}
			}
		}
	}
	return p;
}

//判断和显示前一页按钮
function prePage(hasPreviousPage,pre){
	var p = "";//“前一页按钮HTML代码”
	if(hasPreviousPage == true){
		p = "<li style='cursor:pointer' onclick='pagebooks("+pre+")'><a>上一页</a></li>";
	}
	return p;
}

//分页获取books列表,i表示页码
function pagebooks(i){
	var u = orderBooks(orderId,i);//获取带参数的链接
	getDataByURL(u);//根据URL获取相关的json数据(不存在数据则刷新)，并展示
}

//判断和显示后一页按钮
function nextPage(hasNextPage,next){
	var p="";//“后一页按钮HTML代码”
	if(hasNextPage == true){
		return p = "<li style='cursor:pointer' onclick='pagebooks("+next+")'><a>下一页</a></li>";
	}
	return p;
}
//判断和显示第一页按钮;isFirstPage:判断是否是第一页;pageNum:大于5显示
function firstPage(isFirstPage,pageNum){
	var p = "";//“首页按钮HTML代码”
	if(isFirstPage == false && pageNum > 5){
		return p = "<li style='cursor:pointer' onclick='pagebooks("+1+")'><a>首页</a></li>";
	}
	return p;
}
//判断和显示最后一页按钮;pages:总页数也是最后一页;pageNum:小于pages-5时显示
function lastPage(isLastPage,pages,pageNum){
	var p = "";//“尾页按钮HTML代码”
	if(isLastPage == false && (pageNum < pages - 5)){
		p = "<li style='cursor:pointer' onclick='pagebooks("+pages+")'><a>尾页</a></li>";
	}
	return p;
}

var url = null; //请求的URL
var orderId = 0;//排序的方式
var page = 1;//分页

//处理菜单栏的点击显示books列表
function bookslist(id,ifclass){
	if(ifclass == true){
		clazz = true;
		url = hasUrlChars(window.location.pathname) + "/" + id +"/0";
		$.getJSON(url, function(data){
			 booksShow(data);
		});
	}else{
		clazz = false;
		url = hasUrlChars(window.location.pathname) + "/"  + id +"/1";
		$.getJSON(url, function(data){	
			 booksShow(data);
		});
	}
}

//截取URL不包含参数部分
function hasUrlChars(uri){
	var chars = new Array("#","?");
	for(ind = 0; ind < chars.length; ind++){
		if(uri.indexOf(chars[ind],0) != -1){
			uri = uri.substring(0, uri.indexOf(chars[ind],0));
		}
	}
	return uri;
}


//排序和分页;生成有参数的链接，若传入的order值为-1，表示用orderId来进行排序；
function orderBooks(order, page){
	$(":focus").css("color","#4CAF50");
	$(":focus span").css("color","#4CAF50");
	$(":focus").siblings("button").css("color","#666");
	$(":focus").siblings("button").children().css("color","#666");
	if(order != -1){orderId = order;}
	if(url ==null || url == ""){
		url = hasUrlChars(window.location.pathname) + "/0/1" ;
	}
	var u;//获取URL链接
	//if(orderId != 0 || page != 1){
		u = url + "?";
		if(orderId != 0 && page != 1){
			u = u + "ord=" + orderId + "&p=" + page;
		}
		if(orderId == 0 && page != 1){
			u= u + "p=" + page;
		}
		if(orderId != 0 && page == 1){
			u= u + "ord=" + orderId;
		}
		return u;
	//}else{return null;}
}

//根据URL链接用get方法跳转页面
function getDataByURL(url){
	if(url != null){
		$.getJSON(url, function(data){
			booksShow(data);
		});
	}else{
		 window.location.reload();
	}
}

var price = true;//价格变量，用于控制价格排序（升序、降序），TRUE表示升序、FALSE表示降序

//用于价格的排序处理,url表示取出参数的URL
function  orderprice(){
	/* $("#price").css("color","#4CAF50");
	$("#price  span").css("color","#4CAF50");
	$("#price ~ button").css("color","#000"); */
	$(":focus").css("color","#4CAF50");
	$(":focus span").css("color","#4CAF50");
	$(":focus").siblings("button").css("color","#666");
	$(":focus").siblings("button").children().css("color","#666");
	if(price == true){
		getDataByURL(orderBooks(4,1));
		price = false;//表示下一次点击要进行降序
	}else{getDataByURL(orderBooks(5,1));price = true;}
}


var ifshow = false;//判断是否展开
function showTypes(id){
	var tar = "#type" + id;
	var sp = "#sp" + id;
	$(tar).slideToggle(500);
	if(ifshow == false){
		ifshow = true;
		$(sp).html("∨");
	}else{
		ifshow = false;
		$(sp).html(">");
	}
}

//菜单栏显示
function navJsonList(){
	$.getJSON("${ctp}/nav",function(data){
		showNav(data);
	});
}

//对菜单栏进行处理，包括生成相应的链接，相应的显示视图等
function showNav(data){
	var html = $("#lists");//存放HTML标签以及相关数据
	var len;
	len = data.length;
	if(len>0){
		for(var i = 0; i<len; i++){
			var clazz = data[i];//class类型
			var clid = i;//用于表示div的ID
			html.append("<a class='list-group-item clazz' onclick='showTypes("+clid+")'><b style='cursor:pointer' onclick='bookslist(" + clazz.id + "," + true + ")'>" + clazz.name +"</b><span id='sp"+clid+"'>></span>"+ "</a>");
			
			var types = clazz.types;//获取此class中的type类型数组
			var t_len = types.length;//获取types数组的长度
			if(t_len>0){
				var div= $("<div class='type' id=type"+ clid +">");//存放type(详细类型)的数据
				for(var j = 0; j < t_len; j++){
					var type = types[j];
					div.append("<a class='list-group-item' " + "onclick=" + "'bookslist(" + type.id +"," + false + ")'>" + type.name + "</a>");
				}
				div.append("</div>");
				html.append(div);
			}
		}
		
	}
}


function getAllBooks(){
	$.getJSON("${ctp}/books/0/1",function(data){	
		booksShow(data);
	});
}

$(document).ready(function(){
	navJsonList();
	getAllBooks();
	//bookslist(0,true);
	//pages(null);
});
</script>
</head>
<body>
<c:import url="top.jsp"/>

<div id="books" class="container main" >
	<div id="navlistrow" class="row" >
		<!-- 目录菜单 -->
		<div id="navlist" class="col-lg-3 col-md-3">
				<a class="list-group-item active" id="listhead"  href="${ctp}/books">
					<h4 class="list-group-item-heading"  style="cursor:pointer">全部图书</h4>
				</a>
				<div id="lists">
				</div>
				<div id="actions">
					<a class="list-group-item"><img alt="活动推荐" src="${ctp}/resources/imgs/books/action1 (1).jpg"></a>
					<a class="list-group-item"><img alt="活动推荐" src="${ctp}/resources/imgs/books/action1 (2).jpg"></a>
				</div>
		</div>
		
		
		
		
		
		<!-- 左边电子书列表 -->
		<div id="bookslist" class="col-lg-9 col-md-9">
			<div class="row" id="adress">
				<%-- <a type="button" class="btn btn-link"  href="${ctp}">iread阅读</a><span> ></span>
				<a type="button" class="btn btn-link" href="${ctp}/books">全部图书</a><span> ></span> --%>
				<ol class="breadcrumb">
				  <li><a href="${ctp}">iread阅读</a></li>
				  <li><a href="${ctp}/books" class="active">全部图书</a></li>
				</ol>
				
			</div>
			
			<!-- 排序控制按钮 -->
			<div class="row" id="booksorder">
				<div class="btn-group">
					<button id="host" type="button" class="btn btn-default" style="color:#4CAF50;" onclick="getDataByURL(orderBooks(0,1));">热度<span class="glyphicon glyphicon-arrow-down" style="color:#4CAF50;"></span></button>
					<button id="nums" type="button" class="btn btn-default" onclick="getDataByURL(orderBooks(1,1));">销量<span class="glyphicon glyphicon-arrow-down" ></span></button>
					<button id="news" type="button" class="btn btn-default" onclick="getDataByURL(orderBooks(2,1));">最新<span class="glyphicon glyphicon-arrow-down"></span></button>
					<button id="grade"  type="button" class="btn btn-default" onclick="getDataByURL(orderBooks(3,1));">评分<span class="glyphicon glyphicon-arrow-down"></span></button>
					<button id="price"  type="button" class="btn btn-default" onclick="orderprice();">价格<span class="glyphicon glyphicon-resize-vertical"></span></button>
				</div>
			</div>
			
			
			<div class="row" id="books_infos">
				
			</div>
			<div class="row" id="page">
					<!-- <ul class="pagination">
					  <li><a href="">&laquo;上一页</a></li>
					  <li class="active"><a href="">1</a></li>
					  <li><a href="">2</a></li>
					  <li class="disabled"><a href="#">3</a></li>
					  <li><a href="#">4</a></li>
					  <li><a href="#">5</a></li>
					  <li><a href="">&raquo;下一页</a></li>
					</ul> -->
				</div>
		</div>
	</div>
</div>

<c:import url="bottom.jsp"/>
</body>
</html>