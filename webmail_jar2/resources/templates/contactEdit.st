contactEdit(username,ea_address,contact) ::= <<

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
        <div class="main content clearfix">
            <div>
                <h1>
                    Edit Your Contact
                </h1>
            </div>
            <div class="clearfix">
                <div class="sign-up">
                    <div class="signup-box">
                        $contact:{c|
                        <form class="" id="editContact" name="editContact"
                              action="/editContactManager" method="post">
                              <input name="cid" type="hidden" value="$c.contactID$">
                            <div class="form-element" id="username-form-element">
                                <label id="amail-username-label">
                                    <strong>
                                        Name
                                    </strong>
                                    <input type="text" maxlength="30" name="name" id="name" value="$c.cName$" spellcheck="false"
                                    class=" form-error" aria-invalid="true">
                                </label>
                            </div>
                            <div class="form-element" id="old-password-form-element">
                                <label id="password-label">
                                    <strong>Email</strong>
                                    <input type="text" name="email" id="email" value="$c.cEmail$" class=" form-error" aria-invalid="true">
                                </label>
                            </div>
                            <div class="form-element" id="new-password-form-element">
                                <label id="confirm-password-label">
                                    <strong>Phone</strong>
                                    <input type="text" name="phone" id="phone" value="$c.cPhone$" class=" form-error" aria-invalid="true">
                                </label>
                            </div>
                            <div class="form-element nextstep-button">
                                <input id="submitbutton" name="submitbutton" type="submit" value="Commit" class="a-button a-button-submit">
                                <a class="T-I J-J5-Ji T-I-KD L3" href="/contactDeleteManager?contactID=$c.contactID$">DEL</a>
                            </div>
                        </form>
                        }$
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