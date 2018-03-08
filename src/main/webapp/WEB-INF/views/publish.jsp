<!-- 本页页面复制自writer页面，暂不做修改了 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/viewport.jsp"/>
<c:import url="common/content_type.jsp"/>
<c:import url="common/common.jsp"/>
<title>出版社</title>
<style>
.breadcrumb{
background-color: inherit;
margin: 8px; 
padding:0px;
}
.breadcrumb li a{
color:#666;
}
#worders,#worders #word .btn-group button,#worders #word .btn-group button span,#wshow,#wshow button,#wshow button span{
background-color: #f5f4f2;
border:0px;
color:#666;
}
.writerslist{
margin:10px 0px;
}

.infos_div{
background-color:#e8e8e5;
color:#666;
}
.winfos{
padding:15px 0px;
}
#page{
text-align: center;
}
.wname,.icon{
font-size: 10px;
}
.w_name{
text-align: center;
font-size: 14px;
font-weight: bold;
}
.pubimg{
padding: 20px 10px;
/* background-color: #fff;
border: thin 1px #666; */
}

</style>

<script type="text/javascript">

	//展示列表和分页
	function writershow(data){
		//展示作者列表
		var wlist = $("#writerslist");
		var size = data.list.length;//列表数量
		var writersL = data.list;//作家列表
		var row;//表示一行 
		var colsize=0;//用于标识row中包含writer列表的个数,一行有4个数据
		var writer;
		var i = 0;
		
		
		if(size != 0){
			for(; i<size; i++){
				colsize = i%4;
				writer = writersL[i];
				if(colsize == 0){
					row="<div class='row writerslist'>";
				}
				var readernum = 0;
				var saless = 0;
				if(writer.sales != undefined && writer.sales != null){readernum = writer.sales;}
				if(writer.readers != undefined && writer.readers != null){saless = writer.readers;}
				row = row + "<div class='col-lg-3 col-sm-3' ><div class='infos_div'><div class='row'>"+
						"<a target='_blank' href='${ctp}/publishs/bookofpub?id="+writer.id+"'><img style='cursor:pointer' src='${ctp}/resources/imgs/publishs/"+writer.cover+"' class='img-responsive col-lg-12 col-sm-12 pubimg'></a></div><div class='row w_name'>"+writer.name+"</div><div class='winfos row'>" + 
						"<span class='col-lg-1 col-sm-1'></span><span class='wname col-lg-4 col-sm-4'>销量: "
						+ readernum +"</span><span class='col-lg-2 col-sm-2'></span><span class='wname col-lg-4 col-sm-4'>阅读量: "+saless+"</span></div></div></div>";
				if(colsize == 4){
					row = row + "</div>";
				}
			}
			
			wlist.html(row);
		}else{
			wlist.html("");
			}
		
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
		
		var startPage = "<ul class='pagination'>";//关于分页按钮的HTML开始位置代码
		var endPage = "</ul>";//关于分页按钮的HTML结束位置代码
		var pa = "";//分页按钮的HTML代码
		var pagediv = $("#page");
		
		if(total > 0 && pages > 1){
			pa = startPage
				+ firstPage(isFirstPage,pageNum)
				+ prePage(hasPreviousPage,pre)
				+ NumPage(pageNum, pages)
				+ nextPage(hasNextPage,next)
				+ lastPage(isLastPage,pages,pageNum)
				+ endPage;
				
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
		var u = orderWriters(orderId,i);//获取带参数的链接
		getDataByURL(u);//根据URL获取相关的json数据(不存在数据则刷新)，并展示
	}
	
	var url = null; //请求的URL
	var orderId = 0;//排序的方式
	
	//根据URL链接用get方法跳转页面
	function getDataByURL(url){
		if(url != null){
			$.getJSON(url, function(data){
				writershow(data);
			});
		}else{
			 window.location.reload();
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
	function orderWriters(order, page){
		$(":focus").css("color","#4CAF50");
		$(":focus span").css("color","#4CAF50");
		$(":focus").siblings("button").css("color","#666");
		$(":focus").siblings("button").children().css("color","#666");
		if(order != -1){orderId = order;}
		if(url ==null || url == ""){
			url = hasUrlChars(window.location.pathname + "/list");
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
	
	function listWriters(){
		$.getJSON("${ctp}/publishs/list",function(data){
			writershow(data);
		});
	}
	
	var gender = true;//价格变量，用于控制价格排序（升序、降序），TRUE表示升序、FALSE表示降序
	
	//用于价格的排序处理,url表示取出参数的URL
	function  ordergender(){
		$(":focus").css("color","#4CAF50");
		$(":focus span").css("color","#4CAF50");
		$(":focus").siblings("button").css("color","#666");
		$(":focus").siblings("button").children().css("color","#666");
		if(gender == true){
			getDataByURL(orderWriters(4,1));
			gender = false;//表示下一次点击要进行降序
		}else{getDataByURL(orderWriters(5,1));gender = true;}
	}

	$(document).ready(function(){
		listWriters();
	});
	
</script>


</head>
<body>
<c:import url="top.jsp"/>
	<div id="writers" class="container main">
	
	
		<div class="row" id="adress">
				<ol class="breadcrumb">
				  <li><a href="${ctp}">iread阅读</a></li>
				  <li><a href="${ctp}/publishs" class="active">出版社专栏</a></li>
				</ol>
				
			</div>
	
		<!-- 排序 -->
		<div id="worders" class="row">
			<div id="word" class="col-sm-10 col-lg-10 pull-left">
				
				<div class="btn-group btn-group-lg">
					<button type="button" class="btn btn-default" onclick="getDataByURL(orderWriters(0,1));">全部出版社</button>
					<!-- <button type="button" class="btn btn-default" onclick="getDataByURL(orderWriters(1,1));">推荐人数<span class="glyphicon glyphicon-arrow-down"></span></button> -->
					<button type="button" class="btn btn-default" onclick="getDataByURL(orderWriters(2,1));">销量排行<span class="glyphicon glyphicon-arrow-down"></span></button>
					<button type="button" class="btn btn-default" onclick="getDataByURL(orderWriters(4,1));">阅读排行<span class="glyphicon glyphicon-arrow-down"></span></button>
					<!-- <button type="button" class="btn btn-default" onclick="getDataByURL(orderWriters(3,1));">访问量<span class="glyphicon glyphicon-arrow-down"></span></button> -->
				</div>
				
			</div>
			<div id="wshow" class="col-sm-2 col-lg-2 pull-right btn-group btn-group-lg">
				<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-th-large"></span></button>
				<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-th-list"></span></button>
			</div>
		</div>
	
		<!-- 作家列表 -->
		<div id="writerslist">
			<!-- 一行数据 -->
		</div>
		
		<!-- 分页栏 -->
		<div class="row" id="page">
			
		</div>
		
	</div>
<c:import url="bottom.jsp"/>
</body>
</html>