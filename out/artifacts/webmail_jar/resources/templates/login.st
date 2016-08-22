login() ::= <<

<div class="wrapper">
    <div class="amail-header-bar  centered">
        <div class="header content clearfix">
            <img alt="Amail" class="logo" src="files/images/amail.png">
        </div>
    </div>
    <div class="main content clearfix">
        <div class="banner">
            <h1>
                Having fun at Amail
            </h1>
            <h2 class="hidden-small">
                Sign in to continue to Amail
            </h2>
        </div>
        <div class="card signin-card clearfix">
            <img class="profile-img" src="files/images/blank_person.png" alt="">
            <p class="profile-name"></p>
            <!--novalidate?-->
            <form novalidate method="post" action="/userLoginManager">

                <label class="hidden-label" for="username">Username</label>
                <input id="username" name="username" type="text" placeholder="Username" value="" spellcheck="false" class="" autocomplete="off">
                <label class="hidden-label" for="password">Password</label>
                <input id="password" name="password" type="password" placeholder="Password" class="">
                <input id="signIn" name="signIn" class="rc-button rc-button-submit" type="submit" value="Sign in">
                <label class="remember">
                    <input id="PersistentCookie" name="PersistentCookie" type="checkbox" value="yes" checked="checked">
                      <span>
                      Stay signed in
                      </span>
                    <div class="bubble-wrap" role="tooltip">
                        <div class="bubble-pointer"></div>
                        <div class="bubble">
                            For your convenience, keep this checked. On shared devices, additional precautions are recommended.
                            <a href="https://localhost" target="_blank">Learn more</a>
                        </div>
                    </div>
                </label>
                <input type="hidden" name="rmShown" value="1">
                <a href="/help" class="need-help-reverse">
                                    Need help?
                </a>


            </form>
        </div>
        <div class="one-amail">
            <p class="create-account">
                <a href="/registration">
                    Create an account
                </a>
            </p>
            <p>
                Need something here. Might a picture.
            </p>
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