<#include "../commons/top.ftl" encoding="utf-8" parse="true"/>
<form method="post" action="login" commandName="user">
    <table align="center" border="0">
        <tr>
            <td colspan="2">
                <font color="red">
                    <#if error??>
                        ${error}
                    </#if>
                </font>
                <br/>
                &nbsp;
            </td>
        </tr>
        <tr>

            <td>
                用户名：
                <input type="text" name="username" id="username"/>
            </td>
        </tr>
        <tr>

            <td>
                密&nbsp;码：
                <input type="text" name="password" id="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="image" border="0" src="../images/button_submit.gif"/>
                <a href="rmain"><img border="0"
                                                  src="../images/button_register_now.gif"/>
                </a>
            </td>
            <td>

            </td>
        </tr>
    </table>
</form>
<center>

</center>
<#include "../commons/bottom.ftl" encoding="utf-8" parse="true"/>