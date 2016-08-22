templeeeeet(username) ::= <<

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
    <div>
        <h1>Welcome to Amail~$username$</h1>
        <!--use button for now -->

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