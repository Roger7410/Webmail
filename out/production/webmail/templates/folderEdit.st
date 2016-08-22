folderEdit(username,ea_address,folder) ::= <<

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
                    Edit Your Folder
                </h1>
            </div>
            <div class="clearfix">
                <div class="sign-up">
                    <div class="signup-box">
                        $folder:{f|
                        <form class="" id="editFolder" name="editFolder"
                              action="/editFolderManager" method="post">
                              <input name="fid" type="hidden" value="$f.folderID$">
                            <div class="form-element" id="username-form-element">
                                <label id="amail-username-label">
                                    <strong>
                                        FolderName
                                    </strong>
                                    <input type="text" maxlength="30" name="name" id="name" value="$f.folderName$" spellcheck="false"
                                    class=" form-error" aria-invalid="true">
                                </label>
                            </div>
                            <div class="form-element nextstep-button">
                                <input id="submitbutton" name="submitbutton" type="submit" value="Commit" class="a-button a-button-submit">
                                <a class="T-I J-J5-Ji T-I-KD L3" href="/folderDeleteManager?folderID=$f.folderID$">DEL</a>
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