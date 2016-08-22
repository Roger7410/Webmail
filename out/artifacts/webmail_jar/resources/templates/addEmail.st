addEmail(username) ::= <<

<div class="wrapper">
    <div class="amail-registration-header-bar">
        <div class="header content clearfix">
            <img class="logo" src="files/images/amail.png">
            <form novalidate method="get" action="/userLogoutManager">
                <input id="Logout" name="logout" class="logout-button a-button a-button-submit" type="submit" value="Logout">
                <span class="welcome-username">Welcome:$username$</span>
            </form>

        </div>
    </div>
    <div class="main content clearfix">
        <div class="banner">
            <h3>
                Add An Email
            </h3>
        </div>
        <div class="clearfix">
            <div class="sign-up">
                <div class="signup-box">
                    <form class="" id="addemail" name="addemail" action="/userAddEmailManager" method="post">
                        <div class="form-element" id="email-address-form-element">
                            <label id="amail-email-label">
                                <strong>
                                    Email
                                </strong>
                                <input type="text" maxlength="30" name="email-address" id="email-address" value="" spellcheck="false"
                                class=" form-error" aria-invalid="true" autocomplete="off" >
                            </label>
                            <div id="email-errormsg">
                                <span role="alert" class="errormsg" id="errormsg_email_address"></span>
                            </div>
                        </div>
                        <div class="form-element" id="email-password-form-element">
                            <label id="email-password-label">
                                <strong>Password</strong>
                                <input type="password" name="email-password" id="email-password" class=" form-error" aria-invalid="true">
                            </label>
                            <span role="alert" class="errormsg" id="errormsg_email_password"></span>
                        </div>
                        <div class="form-element nextstep-button">
                            <input id="submitbutton-addemail" name="submitbutton-addemail" type="submit" value="Add" class="a-button a-button-submit">
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