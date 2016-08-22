registration() ::= <<

<div class="wrapper">
        <div class="amail-registration-header-bar">
            <div class="header content clearfix">
                <img class="logo" src="files/images/amail.png">
                  <span class="signin-button">
                  <a id="link-signin" class="a-button a-button-submit" href="/login">Sign in</a>
                  </span>
            </div>
        </div>
        <div class="main content clearfix">
            <div>
                <h1>
                    Creater Your Amail Account
                </h1>
            </div>
            <div class="clearfix">
                <div class="sign-up">
                    <div class="signup-box">
                        <form class="" id="createaccount" name="createaccount"
                              action="/userCreationManager" method="post">
                            <div class="form-element" id="username-form-element">
                                <label id="amail-username-label">
                                    <strong>
                                        Username
                                    </strong>
                                    <input type="text" maxlength="30" name="username" id="username" value="" spellcheck="false"
                                    class=" form-error" aria-invalid="true" onkeyup="usernameCheck(this.value)"
                                    onblur="usernameCheck(document.createaccount.username.value)" autocomplete="off" >
                                </label>
                                <div id="username-errormsg">
                                    <span role="alert" class="errormsg" id="errormsg_username"></span>
                                </div>
                            </div>
                            <div class="form-element" id="password-form-element">
                                <label id="password-label">
                                    <strong>Create a password</strong>
                                    <input type="password" name="password" id="password" class=" form-error" aria-invalid="true"
                                    onfocus="passwordCheck(this.value,document.createaccount.confirm.value,'onfocus')"
                                    onblur="passwordCheck(this.value,document.createaccount.confirm.value,'onblur')"
                                    onchange"passwordCheck(this.value,document.createaccount.confirm.value,'onchange')">
                                </label>
                                <span role="alert" class="errormsg" id="errormsg_password"></span>
                            </div>
                            <div class="form-element" id="confirm-password-form-element">
                                <label id="confirm-password-label">
                                    <strong>Confirm your password</strong>
                                    <input type="password" name="confirm" id="confirm" class=" form-error" aria-invalid="true"
                                    onfocus="confirmCheck(document.createaccount.password.value,this.value,'onfocus')"
                                    onblur="confirmCheck(document.createaccount.password.value,this.value,'onblur')">
                                </label>
                                <span role="alert" class="errormsg" id="errormsg_confirm"></span>
                            </div>
                            <div class="form-element nextstep-button">
                                <input id="submitbutton" name="submitbutton" type="submit" value="Next step" class="a-button a-button-submit">
                                <!--not right now     onclick="nextStep(document.createaccount.username.value,document.createaccount.password.value,document.createaccount.confirm.value)">
                                <span role="alert" class="errormsg" id="errormsg_nextStep"></span>-->
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