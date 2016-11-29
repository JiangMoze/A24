

<#include "../commons/top.ftl" encoding="utf-8" parse="true">
<br/>
	<form id="form1" name="form1" action="register"
		  method="post" commandName="user">

	<TABLE cellpadding=10 cellspacing=0 align=center border=1 width="400"
		bgcolor=#dddddd>
		<TR>
			<TD>
				<FONT color=darkgreen>
					<H3>
						用户信息
					</H3>
				</FONT>
				<TABLE border=0  bgcolor=#FFFF88  width="100%">
					<TR bgcolor=#FFFF88>						
						<TD>
						 	用户名：<input type="text" name="username" id="username"/>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>
                            密&nbsp;码：<input type="text" name="password" id="password"/>
							
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						
						<TD>

                            校验密码：<input type="text" name="repassword" id="repassword"/>
							<#if errorPwd??>
							${errorPwd}
							</#if>
						</TD>
					</TR>
				</TABLE>





				<FONT color=darkgreen><H3>
							账户信息
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 
					bgcolor=#FFFF88 width="100%">
					<TR bgcolor=#FFFF88>
						
						<TD>
							 真实姓名：<input type="text" name="xm" id="xm"/>
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						
						<TD>
                            邮&nbsp;&nbsp;箱：<input type="text" name="email" id="email"/>

							<#if errorEmail??>
							${errorEmail}
							</#if>
						</TD>
					</TR>
					
					<TR bgcolor=#FFFF88>
						
						<TD>
                            地&nbsp;&nbsp;址：<input type="text" name="address" id="address"/>
							
						</TD>
					</TR>
					
					
				</TABLE>


				<FONT color=darkgreen><H3>
						 喜爱设置
					</H3>
				</FONT>

				<TABLE bgcolor="#FFFF88" border=0 cellpadding=3 cellspacing=1 width="100%">
					<TR bgcolor=#FFFF88>
						
						<TD>
							语言设置
							<select name="profile.lang">
								<option value="english">

									英语
								</option>
                                <option value="chinese">

                                    汉语
                                </option>

							</select>
						</TD>
					</TR>
					<TR bgcolor=#FFFF88>
						<TD>
							喜爱宠物
                            <select name="profile.catid">
                                <option value="999">
                                    请选择宠物
                                </option>
								<#list clist as category>

                                    <option value="${category.catid}">
                                        ${category.name}
                                    </option>

								</#list>

                            </select>

							<#if errorCate??>
							${errorCate}
							</#if>
						</TD>
					</TR>
					
				</TABLE>
	</TABLE>
        <CENTER>
            <input border=0 type="image" src="../images/button_submit.gif" />
        </CENTER>
    </form>
	<BR>


<#include "../commons/bottom.ftl" encoding="utf-8" parse="true">