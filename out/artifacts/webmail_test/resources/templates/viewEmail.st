viewEmail(username,ea_address,email,infolder,folders,attachments,containsatt) ::= <<
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
                            <div class="ajl aib aZ6 aji" aria-labelledby=":6k" role="navigation" style="height: 450px;">
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
                                        $folders:{f|
                                        <div class="aim">
                                            <div class="TO" id="trash">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU ">
                                                            <a href="/userFolder?folder=$f.folderName$" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;">$f.folderName$</a>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        }$
                                        <div class="aim" style="margin-top:20px;">
                                            <div class="TO" id="new folder">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="folder">
                                                        <span class="nU ">
                                                            <a href="/folder?infolder=inbox" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;">New Folder</a>
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
                    <div id="unread-mail" class="nn">
                        <div class="T-I J-J5-Ji T-I-KM L3" role="button" id="check-mail-button" name="check-mail-button"
                             onclick="unreadButton('$email.emailID$', '$infolder$')" style="margin-top:15px;-webkit-user-select: none;">
                            Unread Mail
                        </div>
                    </div>
                    <div id="folder_moving" class="nn">
                        <div id="folder-part" style="margin-left:50px;margin-top:17px;">
                            <form class="" id="folder-part-form" name="folder-part-form"
                                  action="/moveFolderManager?folder=inbox" method="post">
                                  <select class="select" id="folderselect" name="folderselect" style="height:27px;"
                                      onchange="move_email('$email.emailID$','$infolder$',this.value)">
                                      <option id="default" name="move to" value="INBOX">move to</option>
                                      <option id="INBOX" name="INBOX" value="INBOX">inbox</option>
                                      $folders:{f|
                                        <option id="$f.folderID$" name="$f.folderName$" value="$f.folderName$">$f.folderName$</option>
                                        }$
                                  </select>
                            </form>
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
                                    <div class="vmFTSD vmFTSDtest"><strong>Subject:&nbsp;&nbsp;</strong><span>$e.subject$</span></div>
                                    <div class="vmFTSD vmFTSDtest"><strong>Date:&nbsp;&nbsp;</strong><span>$e.date$</span></div>
                                    <div><p>$e.contentHTML$</p></div>
                                    <div><strong>Content:</strong><br><p>$e.contentTEXT$</p></div>
                                    $if(containsatt)$
                                    <div><strong>Attachments:</strong>
                                    <ul>
                                    $attachments:{a|
                                        <li>
                                            <a href="/files/attachments/$ea_address$/$email.uniqueID$/$a.attName$" download="$a.attName$" style="color: blue;">
                                            $a.attName$
                                            </a>
                                        </li>
                                    }$
                                    </ul>
                                    </div>
                                    $else$
                                    $endif$
                                </div>
                                <div id="view-reply-forward" class="amn">
                                    <div class="amnn" style="height:60px;">
                                    Click here to
                                    <a class="ams" style="color: #999;" href="/reply?emailID=$e.emailID$&infolder=$infolder$">Reply</a>
                                    or
                                    <a class="ams" style="color: #999;" href="/forward?emailID=$e.emailID$&infolder=$infolder$">Forward</a>
                                    </div>
                                    <div>
                                        <a class="a-button a-button-submit rfbutton rffix" href="/returnManager?folder=$infolder$">
                                            RETURN
                                        </a>
                                    </div>
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