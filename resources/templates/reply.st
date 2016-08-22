reply(username,ea_address,email,infolder) ::= <<
<div class="wrapper">
    <div class="amail-registration-header-bar" style="min-width: 750px;">
        <div class="header content clearfix">
            <div id="left-img" style="min-width:300px;max-width:302px;">
                <img class="logo" src="files/images/amail.png">
            </div>
            <div id="search-part" class="search-part">
                <span>Search item here!</span>
            </div>
            <div id="right-user-account" style="min-width: 75px;display:inline;float:right;">
                <form novalidate method="get" action="/userLogoutManager">
                    <input id="Logout" name="logout" class="logout-button a-button a-button-submit" type="submit" value="Logout">
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
                            <div class="ajl aib aZ6 aji" aria-labelledby=":6k" role="navigation" style="height: 214px;">
                                <div style="width: auto;">
                                    <div class="TK">
                                        <div class="aim">
                                            <div class="TO" id="inbox">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU ">
                                                            <!--titile IIIInbox  (x)-->
                                                            <a href="/inbox" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;">Inbox</a>
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
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="nH" style="margin-left:210px;min-width:800;height:602px;">
                <div style="height:60px;">
                    <div id="check-mail" class="nn">
                        <div class="T-I J-J5-Ji T-I-KM L3" role="button" id="check-mail-button" name="check-mail-button"
                             onclick="checkEmail()" style="margin-top:15px;-webkit-user-select: none;">
                            Check Mail
                        </div>
                    </div>
                </div>
                <div class="AO">
                    <div id="show-email-part" class="aeJ" style="height: 520px;">
                        <div id="clear-element-bottom" class="aeF">
                            <div id="useless-now" class="nH">
                                <div id="view-index" style="height:59px;">
                                    <strong style="font-size:150%;">$infolder$</strong>
                                </div>
                                $email:{e|
                                <div id="view-body" class="vmborder" style="height:261px;">
                                    <div class="vmFTSD vmFTSDtest"><strong>From:&nbsp;&nbsp;</strong><span>$e.from$</span></div>
                                    <div class="vmFTSD vmFTSDtest"><strong>To:&nbsp;&nbsp;</strong><span>$e.to$</span></div>
                                    <div class="vmFTSD vmFTSDtest"><strong>Subject:&nbsp;&nbsp;</strong><span>$e.subject$</span></div>
                                    <div class="vmFTSD vmFTSDtest"><strong>Date:&nbsp;&nbsp;</strong><span>$e.date$</span></div>
                                    <div><strong>Content:</strong><br><p>$e.contentTEXT$</p></div>
                                </div>
                                <div id="view-reply-forward" style="height:200px;">
                                    <form novalidate method="post" action="/replyManager">
                                        <input name="emailID" type="hidden" value="$e.emailID$">
                                        <div>
                                            <textarea  class="rftext" id="rftextarea" name="rftextarea" cols="30" rows="10" spellcheck="true" placeholder="Reply to: $e.from$"></textarea>
                                        </div>
                                        <div>
                                            <input id="reply-button" name="reply-button" type="submit" value="REPLY" class="a-button a-button-submit rfbutton">
                                            <a class="a-button a-button-submit rfbutton rffix" href="/$infolder$">
                                                RETURN
                                            </a>
                                        </div>
                                    </form>
                                </div>
                                }$
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