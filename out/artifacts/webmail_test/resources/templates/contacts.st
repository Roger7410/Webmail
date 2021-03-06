contacts(username,ea_address,infolder,contacts,folders) ::= <<
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
                            <div class="ajl aib aZ6 aji" aria-labelledby=":6k" role="navigation" style="height: 450px;">
                                <div style="width: auto;">
                                    <div class="TK">
                                        <div class="aim">
                                            <div class="TO" id="inbox">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU ">
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
                                        <div class="aim ain" style="margin-top:30px;">
                                            <div class="TO nZ aiq" id="contacts">
                                                <div class="TN" style="margin-left:0px">
                                                    <div class="aio">
                                                        <span class="nU n1">
                                                            <a href="/contacts" target="_top" class="n0"
                                                               tabindex="-1" style="font-size: 130%;font-weight:bold;">Contacts</a>
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
                    <div style="margin-top:23px;">
                        <Strong>Contacts</Strong>
                    </div>
                </div>
                <div class="AO">
                    <div id="show-contacts-part" class="aeJ" style="height: 520px;">
                        <div id="clear-element-bottom" class="aeF">
                            <div id="useless-now" class="nH" >
                                <table id="tbbb" class="table cf F" cellpadding="0" style="width:60%;">
                                    <tbody class="ctbody">
                                    <tr>
                                        <th class="th11">Name</th>
                                        <th class="th22">Email</th>
                                        <th class="th33">Phone</th>
                                        <th class="th44">Oper</th>
                                    </tr>
                                    $contacts:{c|
                                    <tr class="unread">
                                        <td class="tdall td11">$c.cName$</td>
                                        <td id="tdto" name="tdto" class="tdall td22">$c.cEmail$</td>
                                        <td class="tdall td33">$c.cPhone$</td>
                                        <td class="tdall td44">
                                        <a class="T-I J-J5-Ji T-I-KD L3" href="/contactEdit?contactID=$c.contactID$">EDIT</a>
                                        <a class="T-I J-J5-Ji T-I-KD L3" href="/sendEmailWithTo?to=$c.cEmail$">SEND</a>
                                        </td>
                                    </tr>
                                    }$
                                    </tbody>
                                </table>
                                <a class="a-button a-button-submit rfbutton rffix" href="/addContact">ADD</a>
                                <a class="a-button a-button-submit rfbutton rffix" href="/$infolder$">RETURN</a>

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