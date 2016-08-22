inbox(username,ea_address,emails) ::= <<
<div class="wrapper">
    <div class="amail-registration-header-bar" style="min-width: 750px;">
        <div class="header content clearfix">
            <div id="left-img" style="min-width:300px;max-width:302px;">
                <img class="logo" src="files/images/amail.png">
            </div>
            <div id="search-part" class="search-part" style="margin-left:50px;">
                <form class="" id="search-part-form" name="search-part-form"
                      action="/searchPage" method="post">
                      <select class="select" name="search-select" style="height:27px;">
                        <option value ="from">from</option>
                        <option value ="to">to</option>
                        <option value="subject">subject</option>
                        <option value="content">content</option>
                      </select>
                      <input type="text" maxlength="30" name="search-input" id="search-input" style="height:27px;" value="">
                      <input id="searchbutton" name="searchbutton" type="submit" value="Search" class="a-button a-button-submit">
                </form>
            </div>
            <div id="right-user-account" style="min-width: 75px;display:inline;float:right;">
                <form novalidate method="get" action="/userLogoutManager">
                    <input id="Logout" name="logout" class="logout-button a-button a-button-submit" type="submit" value="Logout">
                    <a class="logout-button a-button a-button-submit" style="height:25px;margin-right:5px;" href="/edit">Edit</a>
                    <span class="welcome-username">Welcome:$username$ & $ea_address$</span>
                </form>
            </div>
        </div>
    </div>
    <div id="email-page-main-part" class="nH">
        <div class="email-page-main-part-float" style="float:left;width:100%;">
            <div class="nH nn aeN" style="width:202px;height:602px;">
                <div class="aki aj9 pp" style="-webkit-user-select: none;">
                    <div id="for-margin-left-1" class="oo">
                        <div class="nM">
                            <div id=":6e" class="aic">
                                <div class="z0">
                                    <div class="T-I J-J5-Ji T-I-KE L3" role="button" id="compose-button" name="compose-button" value=$ea_address$
                                         onclick="sendEmail()" style="-webkit-user-select: none;">
                                        COMPOSE
                                    </div>
                                </div>
                            </div>
                            <div style="height: 15px;">
                            </div>
                            <div class="ajl aib aZ6 aji" aria-labelledby=":6k" role="navigation" style="height: 200px;">
                                <div style="width: auto;">
                                    <div class="TK">
                                        <div class="aim ain">
                                            <div class="TO nZ aiq" id="inbox">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU n1">
                                                            <!--titile IIIInbox  (x)-->
                                                            <a href="/inbox" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;font-weight:bold;">Inbox</a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="aim">
                                            <div class="TO" id="sent-email">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU ">
                                                            <a href="/sent" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;">Sent Mail</a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="aim">
                                            <div class="TO" id="draft">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU ">
                                                            <a href="/draft" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;">Draft</a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="aim">
                                            <div class="TO" id="trash">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU ">
                                                            <a href="/trash" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;">Trash</a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="aim" style="margin-top:30px;">
                                            <div class="TO" id="contacts">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU ">
                                                            <a href="/contacts?infolder=inbox" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;">Contacts</a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="nH" style="margin-left:210px;min-width:800;height:602px;">
                <div style="height:60px;">
                    <div id="check-mail" class="nn">
                        <div class="T-I J-J5-Ji T-I-KM L3 L4" role="button" id="check-mail-button" name="check-mail-button"
                             onclick="checkEmail()" style="margin-top:15px;-webkit-user-select: none;">
                            Check Mail
                        </div>
                        <div style="float:left;">
                        <div id="order-part" style="margin-left:90px;margin-top:17px;">
                            <form class="" id="order-part-form" name="order-part-form"
                                  action="/orderbyManager?folder=inbox" method="post">
                                  <select class="select" id="orderselect" name="orderselect" style="height:27px;">
                                    <option id="time" name="time" value="date">time</option>
                                    <option id="from" name="from" value="from">from</option>
                                    <option id="to" name="to" value="to">to</option>
                                    <option id="subject" name="subject" value="subject">subject</option>
                                  </select>
                                  <input id="orderbutton" name="orderbutton" type="submit" value="Order" class="a-button a-button-submit">
                            </form>
                        </div>
                        </div>
                        <div id="change-page" class="nright">
                            <div>
                                <a style="margin-left:530px;-webkit-user-select: none;" href="/leftManager?folder=inbox"><img class="amI" src="files/images/left.png" alt=""></a>
                                <a style="margin-right:100px;-webkit-user-select: none;" href="/rightManager?folder=inbox"><img class="amI" src="files/images/right.png" alt=""></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="AO">
                    <div id="show-email-part" class="aeJ" style="height: 520px;">
                        <div id="clear-element-bottom" class="aeF">
                            <div id="useless-now" class="nH">
                                <table class="table cf F" cellpadding="0">
                                    <tbody class="ctbody">
                                    <tr>
                                        <th class="th1">From</th>
                                        <th class="th2">Subject&nbsp;<font color="#A9A9A9">-&nbsp;Content</font></th>
                                        <th class="th3">DateTime</th>
                                        <th class="th4">Oper</th>
                                    </tr>
                                    $emails:{e|
                                    $if(e.alreadyRead)$
                                    <tr class="readed">
                                        <td class="tdall td1">$e.from$</td>
                                        <td class="tdall td2">
                                        <div style="overflow: hidden;">
                                            <a class="tdoh" style="color:black;" href="/viewEmail?emailID=$e.emailID$&infolder=inbox">
                                                $e.subject$&nbsp;<font color="#6C6C6C">-&nbsp;$e.contentTEXT$</font>
                                            </a>
                                        </div>
                                        </td>
                                        <td class="tdall td3">$e.date$</td>
                                        <td class="tdall td4">
                                        <a class="T-I J-J5-Ji T-I-KD L3" href="/deleteManager?emailID=$e.emailID$&folder=inbox">DEL</a></td>
                                    </tr>
                                    $else$
                                    <tr class="unread">
                                        <td class="tdall td1">$e.from$</td>
                                        <td class="tdall td2">
                                        <div style="overflow: hidden;">
                                            <a class="tdoh" style="color:black;" href="/viewEmail?emailID=$e.emailID$&infolder=inbox">
                                                $e.subject$&nbsp;<font color="#6C6C6C">-&nbsp;$e.contentTEXT$</font>
                                            </a>
                                        </div>
                                        </td>
                                        <td class="tdall td3">$e.date$</td>
                                        <td class="tdall td4">
                                        <a class="T-I J-J5-Ji T-I-KD L3" href="/deleteManager?emailID=$e.emailID$&folder=inbox">DEL</a></td>
                                    </tr>
                                    $endif$
                                    }$
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
    <div class="amail-footer-bar">
        <div class="footer content clearfix">
            <ul>
                <li>
                    <a href="/aboutAmail">
                        About Amail
                    </a>
                </li>
                <li>
                    <a href="/service">
                        Service
                    </a>
                </li>
                <li>
                    <a href="/help">
                        Help
                    </a>
                </li>

            </ul>
        </div>
    </div>
</div>
>>