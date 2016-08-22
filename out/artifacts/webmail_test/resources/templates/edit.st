edit(username,ea_address) ::= <<

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
                    Change Your Password
                </h1>
            </div>
            <div class="clearfix">
                <div class="sign-up">
                    <div class="signup-box">
                        <form class="" id="createaccount" name="createaccount"
                              action="/changePwdManager" method="post">
                            <div class="form-element" id="username-form-element">
                                <label id="amail-username-label">
                                    <strong>
                                        Username
                                    </strong>
                                    <input type="text" maxlength="30" name="username" id="username" value="$username$" spellcheck="false"
                                    class=" form-error" aria-invalid="true">
                                </label>
                            </div>
                            <div class="form-element" id="old-password-form-element">
                                <label id="password-label">
                                    <strong>Old Password</strong>
                                    <input type="password" name="password" id="password" class=" form-error" aria-invalid="true">
                                </label>
                            </div>
                            <div class="form-element" id="new-password-form-element">
                                <label id="confirm-password-label">
                                    <strong>New Password(hint:len>=6)(havn't use ajax for this part now)</strong>
                                    <input type="password" name="new-pwd" id="confirm" class=" form-error" aria-invalid="true">
                                </label>
                            </div>
                            <div class="form-element nextstep-button">
                                <input id="submitbutton" name="submitbutton" type="submit" value="Commit" class="a-button a-button-submit">
                            </div>
                        </form>
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