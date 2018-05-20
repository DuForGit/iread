<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/>
<title>图书列表</title>

<script type="text/javascript">
/* 将book数据进行展示 */
function showBook(data){
	var con = $(".main");
	var books = data.list;//电子书表单列表
	var book;//包含电子书的内容
	var len = books.length;//数据长度
	var bhtml = "";//列表HTML代码
	
	//展示分页栏
	var total = data.total;//查询的总book数量；不是当前页面的总数，是根据条件查找到的数据库中的总数
	var pageNum = data.pageNum; //当前页码
	var pages = data.pages;//总页数
	var pre = data.pre;//前一页页码
	var next = data.next;//下一页页码
	var isFirstPage = data.isFirstPage;//是否为第一页
	var isLastPage = data.isLastPage;//是否为最后一页
	var hasPreviousPage = data.hasPreviousPage;//是否有前一页
	var hasNextPage = data.hasNextPage;//是否有后一页
	
	
	var startPage = "<div class='row' id='page'><ul class='pagination'>";//关于分页按钮的HTML开始位置代码
	var endPage = "</ul></div>";//关于分页按钮的HTML结束位置代码
	var pa = "";//分页按钮的HTML代码
	//var pagediv = $("#page");
	
//	if(data != null){alert(books);}
	if(len > 0){
		bhtml += "<span class='booksnum' style='color:#aaa; font-size:12px;'>为您找到相关的电子书"+total+"本</span>";
		for(var i = 0; i < len; i++){
			book = books[i];
			
			bhtml += "<div class='row search' >"
			+"<div class='col-lg-9 col-md-9'>"
			+"<div class='row'>"
			+"<div  class='col-lg-2 col-md-2' id='bimg'>"
			+"<img src='http://localhost:8080/iAdmin/images/book/"+book.cover+"' class='img-responsive img-rounded' /></div>"
			+"<div  class='col-lg-10 col-md-10' id='binfos'>"
			+"<div class='row'><span class='stitle'>"+book.title+"</span><span class='color'>("+book.publish.name+")</span></div>"
			+"<div class='row stars'>";
			
			for(var j=0;(j<book.grade) && (book.grade > 0);j++){
				bhtml += "<span class='glyphicon glyphicon-star'></span>";
			}
			bhtml += "<span class='color'>  "+book.grade+"</span><span class='color'>   |   </span><span class='color'>"+book.valuator+"</span></div>";
			bhtml += "<div class='row summary'><span class='inf'>介绍  </span><span class='color'>"+book.summary+"</span></div>";
			bhtml += "<div class='row'><span class='inf'>作者  </span><span class='color'>"+book.writer.name+"</span></div>";
			bhtml += "<div class='row'><div class='col-lg-4 col-md-4 pull-left price'><b class='b'>￥</b><span>"+book.price
			+"</span></div><div class='col-lg-2 col-md-2 pull-right'><a class='btn btn-success btn-xs' href='${ctp}/ebook?id="+book.id+"' target='_blank'>了解更多...</a></div></div></div></div></div><div class='col-lg-3 col-md-3'></div></div>";
			if(len > 1){bhtml += "<hr>";}
		}
	}
	
	
 	if(total > 0 && pages > 1){
		pa = startPage
			+ firstPage(isFirstPage,pageNum)
			+ prePage(hasPreviousPage,pre)
			+ NumPage(pageNum, pages)
			+ nextPage(hasNextPage,next)
			+ lastPage(isLastPage,pages,pageNum)
			+ endPage;
			
	}
	bhtml += pa;
	con.html(bhtml);
}

//包含页码分页按钮
function NumPage(pageNum, pages){
	var p = "";
	if(pages <= 10 && pages > 1){
		for(var i=1; i<=pages;i++){
			if(i == pageNum){
				p = p + "<li style='cursor:pointer' class='active' onclick='showThePage("+i+")'><a>"+i+"</a></li>";
			}else{
				p = p + "<li style='cursor:pointer' onclick='showThePage("+i+")'><a>"+i+"</a></li>";
			}
		}
	}else if(pages > 10){
		if(pageNum > 5){
			var start = pageNum-4;
			var end = pageNum+5 < pages ? pageNum+5:pages;
			for(var i = start;i <=end;i++){
				if(i == pageNum){
					p = p + "<li style='cursor:pointer' class='active' onclick='showThePage("+i+")'><a>"+i+"</a></li>";
				}else{
					p = p + "<li style='cursor:pointer' onclick='showThePage("+i+")'><a>"+i+"</a></li>";
				}
			}
		}
	}
	return p;
}
pid=${id};
function showThePage(p){
	//var uri = "${ctp}/search?types=" + type +"&info="+info + "&page=" + page;
	$.post("${ctp}/publishs/bookofpublish",{id:pid,page:p},function(data){
		showBook(data);
	},"json");
} 

//判断和显示前一页按钮
function prePage(hasPreviousPage,pre){
	var p = "";//“前一页按钮HTML代码”
	if(hasPreviousPage == true){
		p = "<li style='cursor:pointer' onclick='showThePage("+pre+")'><a>上一页</a></li>";
	}
	return p;
}

//判断和显示后一页按钮
function nextPage(hasNextPage,next){
	var p="";//“后一页按钮HTML代码”
	if(hasNextPage == true){
		return p = "<li style='cursor:pointer' onclick='showThePage("+next+")'><a>下一页</a></li>";
	}
	return p;
}
//判断和显示第一页按钮;isFirstPage:判断是否是第一页;pageNum:大于5显示
function firstPage(isFirstPage,pageNum){
	var p = "";//“首页按钮HTML代码”
	if(isFirstPage == false && pageNum > 5){
		return p = "<li style='cursor:pointer' onclick='showThePage("+1+")'><a>首页</a></li>";
	}
	return p;
}
//判断和显示最后一页按钮;pages:总页数也是最后一页;pageNum:小于pages-5时显示
function lastPage(isLastPage,pages,pageNum){
	var p = "";//“尾页按钮HTML代码”
	if(isLastPage == false && (pageNum < pages - 5)){
		p = "<li style='cursor:pointer' onclick='showThePage("+pages+")'><a>尾页</a></li>";
	}
	return p;
}
$(document).ready(function(){
	showThePage(1);
});

</script>

</head>
<body>
<c:import url="top.jsp"/>
<div id="books" class="container main" ></div>
<c:import url="bottom.jsp"/>

</body>
</html>