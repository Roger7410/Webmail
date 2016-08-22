welcome(username,emailAccounts) ::= <<

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
                Choose An Email
            </h3>
        </div>
        <div id="email-choose-card" class="card email-choose-card">

            <form id="email-login" action="/afterWelcomeBeforeInboxManager" method="post">
            $emailAccounts:{ea|
                <ol class="accounts " id="account-list">
                    <li id="">
                        <button type="submit" id="" name="form-ea-address" value=$ea.ea_address$>
                            <span class="account-name">$username$</span>
                            <span class="account-email" id="">
                            $ea.ea_address$
                            </span>
                        </button>
                    </li>
                </ol>
                }$
            </form>

        </div>
        <div class="action-card">
            <ul id="account-chooser-options" class="dual-action">
                <li>
                    <a id="account-chooser-add-account" href="/addAccount" class="">
                        Add account
                    </a>
                </li>
                <!-- no delete now-->
                <li><a id="edit-account-list">Delete</a></li>
            </ul>
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
