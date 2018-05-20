<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<title>榜单</title>
<c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/>

<style type="text/css">
#navhead{
background-color: #34495e;
}
#rank{
margin-top: 10px;
}
#r_nav{
padding-left: 0px;
}
#navs .list-group-item span{
float: right;
}
#navs button:first-child{
color:red;
}
.adress ol{
background-color: #fff;
}
.adress ol li a{
color:#666;
}
.title h3{
font-weight: bolder;
}

.bookinfo{
color:#000;
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
.author{
float:left;
}
.price{
float:right; 
}
.price b{
color:red;
}
</style>

<script type="text/javascript">

//对菜单栏进行处理，包括生成相应的链接，相应的显示视图等
function showNav(data){
	var nav = $("#navs");//存放HTML标签以及相关数据
	var len;
	len = data.length;
	if(len>0){
		for(var i = 0; i<len; i++){
			var clazz = data[i];//class类型
			var clid = clazz.id - 1;
			nav.append("<button onclick='bookslist("+clid+","+"b"+clid+")' class='list-group-item' style='cursor:pointer'><b  id='b"+clid+"'>" + clazz.name +"</b><span>></span>"+ "</button>");
		}
		
	}
}

var orderId = 0;//榜单编号

function bookslist(order,ordtitle){
	orderId = order;
	$(":focus").css("color","red");
	$(":focus").children().css("color","red");
	$(":focus").siblings("button").css("color","#666");
	$(":focus").siblings("button").children().css("color","#666");
	
	var title = $(ordtitle).text();
	$("#titltname").text(title);
	
	var uri = "${ctp}/rank/list?ord="+order;
	$.getJSON(uri,function(data){
		booksShow(data);
	});
}

//菜单栏显示
function navJsonList(){
	$.getJSON("${ctp}/rank/nav",function(data){
		showNav(data);
	});
}


//books列表的显示方式和分页信息处理，
//返回的data为Map类型，包含books列表、总页数、总的book数量、当前页码、是否有前后页、前后页的页码等信息
function booksShow(data){
	var bookslist = $("#bookslist");
	var row = "";
	var booksL = data.list;//books列表
	var size = booksL.length;//本页books列表的长度
	var i = 0;
	var colsize=0;//用于标识row中包含book列表的个数,一行有5个数据
	var book;
	
	//处理books列表的展示
	if(size != 0){
		for(;i < size; i++){
			colsize = i%6;
			book = booksL[i];
			if(colsize == 0){
				row =  row + "<div class='row'>";
			}
			
			row=row + "<div class='col-lg-2 col-md-2' style='cursor:pointer'><a class='bookinfo' href='${ctp}/ebook?id="+book.id+"' target='_blank'><img src='http://localhost:8080/iAdmin/images/book/${bk.cover}" + book.cover +"' class='img-responsive img-rounded'/> <ul class='list-unstyled'><li class='book_name'>"+book.title+"</li><li><span class='author'>"+book.writer.name+"</span><span class='price'><b>￥</b>"+book.price+"</span></li></ul></a> </div>";
			
			if(colsize == 5){
				row=row+"</div>";
			}
			
		}
		bookslist.html(row);
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
	
	/* 只排列前300个数据（book），每一页30个数据，所以不大于10页 */
	if(pages > 10){pages = 10;}
	
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

function pagebooks(page){
	var uri = "${ctp}/rank/list?ord=" + orderId + "&p=" + page;
	$.getJSON(uri,function(data){	
		booksShow(data);
	});
}

//判断和显示前一页按钮
function prePage(hasPreviousPage,pre){
	var p = "";//“前一页按钮HTML代码”
	if(hasPreviousPage == true){
		p = "<li style='cursor:pointer' onclick='pagebooks("+pre+")'><a>上一页</a></li>";
	}
	return p;
}

/* //分页获取books列表,i表示页码
function pagebooks(i){
	var u = orderBooks(orderId,i);//获取带参数的链接
	getDataByURL(u);//根据URL获取相关的json数据(不存在数据则刷新)，并展示
} */


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

function getAllBooks(){
	$.getJSON("${ctp}/rank/list",function(data){	
		booksShow(data);
	});
}


$(document).ready(function(){
	navJsonList();
	getAllBooks();
});
</script>

</head>
<body>
<c:import url="top.jsp"/>


<div class="container main" id="rank_cont">
	<div class="row" id="rank">
	
		<div class="col-lg-2 col-md-2" id="r_nav">
			
			<a class="list-group-item active" id="navhead"  href="${ctp}/rank">
					<h4 class="list-group-item-heading">排行榜</h4>
			</a>
			
			<div id="navs">
				
			</div>
			
		</div>
		
		<div class="col-lg-10 col-md-10" id="b_list">
			
			<%-- <div class="row adress">
				<ol class="breadcrumb">
				  <li><a href="${ctp}">iread阅读</a></li>
				  <li><a href="${ctp}/rank" class="active">排行榜</a></li>
				</ol>
				<hr>
			</div> --%>
			
			<div class="row">
				<ul class="nav nav-tabs">
				 	<li class="active title"><h3 id="titltname">畅销榜</h3></li>
				</ul>
			</div>
			
			<div class="row" id="bookslist" style="margin-top:20px;">
				
			</div>
			
			<div class="row" id="page"></div>
			
		</div>
	</div>
</div>

<c:import url="bottom.jsp"/>
</body>
</html>