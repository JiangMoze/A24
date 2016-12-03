<#include "../commons/top.ftl" encoding="utf-8" parse="true"/>
<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td valign="top" width="20%" align="left">
			<table align="left" bgcolor="#008800" border="0" cellspacing="2"
				cellpadding="2">
				<tr>
					<td bgcolor="#FFFF88">
						<a href="main.xhtml"><b><font color="BLACK" size="2">&lt;&lt; 主菜单</font>
				</b></a>
					</td>
				</tr>
			</table>
		</td>
		<td valign="top" align="center">
			<h2 align="center">
				
			</h2>
			<form name="form1" method="post"
				action="cartupdate.xhtml">
				
				<table align="center" bgcolor="#008800" border="0" cellspacing="2"
					cellpadding="5" >
					<tr bgcolor="#cccccc">
						<td>
							宠物编号
						</td>
						<td>
							产品序号
						</td>
						<td>
							宠物描述
						</td>
						<td>
							<b>是否有宠物</b>
						</td>
						<td width="100">
							宠物单价
						</td>
						<td>
							宠物数量
						</td>
						<td>
							合计
						</td>
						<td>
							&nbsp;
						</td>
					</tr>

			
					<#list clist as cart>
					
						<#list cart.ilist as item>
					<tr bgcolor="#FFFF88">
						<td>
							<b> 
							
							
							<a href="">${item.itemid}</a>
							
							</b>
						</td>
						<td>
							${item.product.productid}
						
						</td>
						<td>
							${item.attr1}
							${item.product.name}
							
						</td>
						<td align="center">
							是
							
						</td>
						<td>
							${item.listprice}
														
						</td>
						<td align="right">
							${cart.quantity}
							<br/>
						</td>
						<td align="right">
						${item.listprice*cart.quantity}
							
						</td>
						<td>
							<a href=""><img border="0"
									src="/images/button_remove.gif" />
							</a>
						</td>
					</tr>
						</#list>
					</#list>
			
					<tr bgcolor="#FFFF88">
						<td colspan="7" align="right">
							<b>
							</b>							
							
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
				<center>


				</center>
			</form>


			<br />
			<center>
				<a href="cartcheckout.xhtml"><img border="0"
						src="../images/button_checkout.gif" />
				</a>
			</center>


		</td>




	</tr>
</table>

<br>

<#include "../commons/bottom.ftl" encoding="utf-8" parse="true"/>