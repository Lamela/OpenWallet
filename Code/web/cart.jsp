<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="./include/Header.jsp"%>

<script>
var deleteOrderItem = false;
var deleteOrderItemid = 0;
$(function(){

	$("a.deleteOrderItem").click(function(){
		deleteOrderItem = false;
		var oiid = $(this).attr("oiid")
		deleteOrderItemid = oiid;
		$("#deleteConfirmModal").modal('show');	   
	});
	$("button.deleteConfirmButton").click(function(){
		deleteOrderItem = true;
		$("#deleteConfirmModal").modal('hide');
	});
	
	$('#deleteConfirmModal').on('hidden.bs.modal', function (e) {
		if(deleteOrderItem){
			var page="foredeleteOrderItem";
			$.post(
				    page,
				    {"oiid":deleteOrderItemid},
				    function(result){
						if("success"==result){
							$("tr.cartProductItemTR[oiid="+deleteOrderItemid+"]").hide();
						}
						else{
							location.href="login.jsp";
						}
				    }
				);
			
		}
	})	
	
	$("img.cartProductItemIfSelected").click(function(){
		var selectit = $(this).attr("selectit")
		if("selectit"==selectit){
			$(this).attr("src","img/site/cartNotSelected.png");
			$(this).attr("selectit","false")
			$(this).parents("tr.cartProductItemTR").css("background-color","#fff");
		}
		else{
			$(this).attr("src","img/site/cartSelected.png");
			$(this).attr("selectit","selectit")
			$(this).parents("tr.cartProductItemTR").css("background-color","#FFF8E1");
		}
		syncSelect();
		syncCreateOrderButton();
		calcCartSumPriceAndNumber();
	});
	$("img.selectAllItem").click(function(){
		var selectit = $(this).attr("selectit")
		if("selectit"==selectit){
			$("img.selectAllItem").attr("src","img/site/cartNotSelected.png");
			$("img.selectAllItem").attr("selectit","false")
			$(".cartProductItemIfSelected").each(function(){
				$(this).attr("src","img/site/cartNotSelected.png");
				$(this).attr("selectit","false");
				$(this).parents("tr.cartProductItemTR").css("background-color","#fff");
			});			
		}
		else{
			$("img.selectAllItem").attr("src","img/site/cartSelected.png");
			$("img.selectAllItem").attr("selectit","selectit")
			$(".cartProductItemIfSelected").each(function(){
				$(this).attr("src","img/site/cartSelected.png");
				$(this).attr("selectit","selectit");
				$(this).parents("tr.cartProductItemTR").css("background-color","#FFF8E1");
			});				
		}
		syncCreateOrderButton();
		calcCartSumPriceAndNumber();
		

	});
	
	$(".orderItemNumberSetting").keyup(function(){
		var pid=$(this).attr("pid");
		var stock= $("span.orderItemStock[pid="+pid+"]").text();
		var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
		
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
		num = parseInt(num);
		if(isNaN(num))
			num= 1;
		if(num<=0)
			num = 1;
		if(num>stock)
			num = stock;
		
		syncPrice(pid,num,price);
	});

	$(".numberPlus").click(function(){
		
		var pid=$(this).attr("pid");
		var stock= $("span.orderItemStock[pid="+pid+"]").text();
		var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();

		num++;
		if(num>stock)
			num = stock;
		syncPrice(pid,num,price);
	});
	$(".numberMinus").click(function(){
		var pid=$(this).attr("pid");
		var stock= $("span.orderItemStock[pid="+pid+"]").text();
		var price= $("span.orderItemPromotePrice[pid="+pid+"]").text();
		
		var num= $(".orderItemNumberSetting[pid="+pid+"]").val();
		--num;
		if(num<=0)
			num=1;
		syncPrice(pid,num,price);
	});	
	
	$("button.createOrderButton").click(function(){
		var params = "";
		$(".cartProductItemIfSelected").each(function(){
			if("selectit"==$(this).attr("selectit")){
				var oiid = $(this).attr("oiid");
				params += "&oiid="+oiid;
			}
		});
		params = params.substring(1);
		location.href="forebuy?"+params;
	});
	
	
	
})

function syncCreateOrderButton(){
	var selectAny = false;
	$(".cartProductItemIfSelected").each(function(){
		if("selectit"==$(this).attr("selectit")){
			selectAny = true;
		}
	});
	
	if(selectAny){
		$("button.createOrderButton").css("background-color","#C40000");
		$("button.createOrderButton").removeAttr("disabled");
	}
	else{
		$("button.createOrderButton").css("background-color","#AAAAAA");
		$("button.createOrderButton").attr("disabled","disabled");		
	}
		
}
function syncSelect(){
	var selectAll = true;
	$(".cartProductItemIfSelected").each(function(){
		if("false"==$(this).attr("selectit")){
			selectAll = false;
		}
	});
	
	if(selectAll)
		$("img.selectAllItem").attr("src","img/site/cartSelected.png");
	else
		$("img.selectAllItem").attr("src","img/site/cartNotSelected.png");
	
	
	
}
function calcCartSumPriceAndNumber(){
	var sum = 0;
	var totalNumber = 0;
	$("img.cartProductItemIfSelected[selectit='selectit']").each(function(){
		var oiid = $(this).attr("oiid");
		var price =$(".cartProductItemSmallSumPrice[oiid="+oiid+"]").text();
		price = price.replace(/,/g, "");
		price = price.replace(/￥/g, "");
		sum += new Number(price);	
		
		var num =$(".orderItemNumberSetting[oiid="+oiid+"]").val();
		totalNumber += new Number(num);	
		
	});
	
	$("span.cartSumPrice").html("￥"+formatMoney(sum));
	$("span.cartTitlePrice").html("￥"+formatMoney(sum));
	$("span.cartSumNumber").html(totalNumber);
}
function syncPrice(pid,num,price){
	$(".orderItemNumberSetting[pid="+pid+"]").val(num);
	var cartProductItemSmallSumPrice = formatMoney(num*price); 
	$(".cartProductItemSmallSumPrice[pid="+pid+"]").html("￥"+cartProductItemSmallSumPrice);
	calcCartSumPriceAndNumber();
	
	var page = "forechangeOrderItem";
	$.post(
		    page,
		    {"pid":pid,"number":num},
		    function(result){
				if("success"!=result){
					location.href="login.jsp";
				}
		    }
		);

}
</script>	

<title>Shopping Cart</title>
<div class="cartDiv">
	<div class="cartTitle pull-right">
		<span style="color: red;">Products selected</span>
		<span class="cartTitlePrice" style="color: red;">$0.00</span>
		<button class="createOrderButton" href="forebuy" style="color: red;">Pay</button>
	</div>
	
	
	<div class="cartProductList">
		<table class="short-table white" style="width: 95%" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th class="selectAndImage">
							<img selectit="false" class="selectAllItem" src="img/site/cartNotSelected.png">				
					All Selected
					
					</th>
					<th>Product Name</th>
					<th>Price per unity</th>
					<th>Number</th>
					<th width="120px">Price</th>
					<th class="operation">Operation</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ois}" var="oi">
					<tr oiid="${oi.id_item_order}" class="cartProductItemTR">
						<td>
							<img selectit="false" oiid="${oi.id_item_order}" class="cartProductItemIfSelected" src="img/site/cartNotSelected.png">
							<a style="display:none" href="#nowhere"><img src="img/site/cartSelected.png"></a>
							<img class="cartProductImg"  src="img/product/${oi.product.id_product}.jpg" height="40px" width="40px">
						</td>
						<td>
							<div class="cartProductLinkOutDiv">
								<a href="foreproduct?pid=${oi.product.id_product}" class="cartProductLink">${oi.product.name_product}</a>
							</div>
							
						</td>
						<td>
							<span class="cartProductItemOringalPrice">$ ${oi.product.price}</span>
						</td>
						<td>
						
							<div class="cartProductChangeNumberDiv">
								<!-- <span class="hidden orderItemStock " pid="${oi.product.id_product}">${oi.product.stock}</span>
								<span class="hidden orderItemPromotePrice " pid="${oi.product.id_product}">${oi.product.price}</span> -->
								<a  pid="${oi.product.id_product}" class="numberMinus" href="#nowhere">-</a>
								<input pid="${oi.product.id_product}" oiid="${oi.id_item_order}" class="orderItemNumberSetting" autocomplete="off" value="${oi.number_item_order}">
								<a  stock="${oi.product.stock}" pid="${oi.product.id_product}" class="numberPlus" href="#nowhere">+</a>
							</div>					
						
						 </td>
						<td >
							<span class="cartProductItemSmallSumPrice" oiid="${oi.id_item_order}" pid="${oi.product.id_product}" >
							$<fmt:formatNumber type="number" value="${oi.product.price*oi.number_item_order}" minFractionDigits="2"/>
							</span>
						
						</td>
						<td>
							<a class="deleteOrderItem" oiid="${oi.id_item_order}"  href="#nowhere">Delete</a>
						</td>
					</tr>
				</c:forEach>				
			</tbody>
		
		</table>
	</div>
	
	<div class="cartFoot">
		<img selectit="false" class="selectAllItem" src="img/site/cartNotSelected.png">
		<span style="color: black;">All select</span>
<!-- 		<a href="#">Delete</a> -->
		
		<div class="pull-right">
			<span style="color: red;">Products selected <span class="cartSumNumber" >0</span> Items</span>
			
			<span style="color: red;">Total Price: </span> 
			<span class="cartSumPrice" style="color: red;">$ 0.00</span>
			<button class="createOrderButton" href="forebuy" style="color: red;">Pay</button>
		</div>
		
	</div>
	
</div>
<%@include file="./include/Footer.jsp"%>