page(title, body) ::= <<
<html>
<head>
    <title>$title$</title>
    <meta charset="utf-8">
    <!--meta content="width=300, initial-scale=1" name="viewport"-->
    <meta name="description" content="Amail is good.">
    <meta name="keywords" content="LOGIN,LOGOUT,INBOX,REGISTRATION">
    <meta name="author" content="Roger">

    <!--cursor: small hand-->
        <style>
            h1, h2 {
            -webkit-animation-duration: 0.1s;
            -webkit-animation-name: fontfix;
            -webkit-animation-iteration-count: 1;
            -webkit-animation-timing-function: linear;
            -webkit-animation-delay: 0;
            }
            @-webkit-keyframes fontfix {
            from {
            opacity: 1;
            }
            to {
            opacity: 1;
            }
            }
        </style>
        <style>
            html, body {
            font-family: Arial, sans-serif;
            background: #fff;
            margin: 0;
            padding: 0;
            border: 0;
            position: absolute;
            height: 100%;
            min-width: 100%;
            font-size: 13px;
            color: #404040;
            direction: ltr;
            -webkit-text-size-adjust: none;
            }
            .wrapper {
            position: relative;
            min-height: 100%;
            }
            .content {
            padding: 0 44px;
            }
            .main {
            padding-bottom: 100px;
            }
            .clearfix:before,
            .clearfix:after {
            content: "";
            display: table;
            }
            .clearfix:after {
            clear: both;
            }
            .clearfix {
            zoom:1;
            }
            .google-header-bar {
            height: 71px;
            border-bottom: 1px solid #e5e5e5;
            overflow: hidden;
            }
            .header .logo {
            margin: 17px 0 0;
            float: left;
            height: 38px;
            width: 116px;
            }
            button,
            input[type=button],
            input[type=submit] {
            font-family: Arial, sans-serif;
            font-size: 13px;
            }
            a,
            a:hover,
            a:visited {
            color: #427fed;
            cursor: pointer;
            text-decoration: none;
            }
            a:hover {
            text-decoration: underline;
            }
            h1 {
            font-size: 20px;
            color: #262626;
            margin: 0 0 15px;
            font-weight: normal;
            }
            h2 {
            font-size: 14px;
            color: #262626;
            margin: 0 0 15px;
            font-weight: bold;
            }
            input[type=email],
            input[type=number],
            input[type=password],
            input[type=tel],
            input[type=text],
            input[type=url] {
            -moz-appearance: none;
            -webkit-appearance: none;
            appearance: none;
            display: inline-block;
            height: 36px;
            padding: 0 8px;
            margin: 0;
            background: #fff;
            border: 1px solid #d9d9d9;
            border-top: 1px solid #c0c0c0;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            -moz-border-radius: 1px;
            -webkit-border-radius: 1px;
            border-radius: 1px;
            font-size: 15px;
            color: #404040;
            }
            input[type=email]:hover,
            input[type=number]:hover,
            input[type=password]:hover,
            input[type=tel]:hover,
            input[type=text]:hover,
            input[type=url]:hover {
            border: 1px solid #b9b9b9;
            border-top: 1px solid #a0a0a0;
            -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            }
            input[type=email]:focus,
            input[type=number]:focus,
            input[type=password]:focus,
            input[type=tel]:focus,
            input[type=text]:focus,
            input[type=url]:focus {
            outline: none;
            border: 1px solid #4d90fe;
            -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            }
            input[type=checkbox],
            input[type=radio] {
            -webkit-appearance: none;
            display: inline-block;
            width: 13px;
            height: 13px;
            margin: 0;
            cursor: pointer;
            vertical-align: bottom;
            background: #fff;
            border: 1px solid #c6c6c6;
            -moz-border-radius: 1px;
            -webkit-border-radius: 1px;
            border-radius: 1px;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            position: relative;
            }
            input[type=checkbox]:active,
            input[type=radio]:active {
            background: #ebebeb;
            }
            input[type=checkbox]:hover {
            border-color: #c6c6c6;
            -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            }
            input[type=radio] {
            -moz-border-radius: 1em;
            -webkit-border-radius: 1em;
            border-radius: 1em;
            width: 15px;
            height: 15px;
            }
            input[type=checkbox]:checked,
            input[type=radio]:checked {
            background: #fff;
            }
            input[type=radio]:checked::after {
            content: '';
            display: block;
            position: relative;
            top: 3px;
            left: 3px;
            width: 7px;
            height: 7px;
            background: #666;
            -moz-border-radius: 1em;
            -webkit-border-radius: 1em;
            border-radius: 1em;
            }
            input[type=checkbox]:checked::after {
            content: url(//ssl.gstatic.com/ui/v1/menu/checkmark.png);
            display: block;
            position: absolute;
            top: -6px;
            left: -5px;
            }
            input[type=checkbox]:focus {
            outline: none;
            border-color: #4d90fe;
            }
            input[type=checkbox].form-error,
            input[type=email].form-error,
            input[type=number].form-error,
            input[type=password].form-error,
            input[type=text].form-error,
            input[type=tel].form-error,
            input[type=url].form-error {
            border: 1px solid #dd4b39;
            }
            .error-msg {
            margin: .5em 0;
            display: block;
            color: #dd4b39;
            line-height: 17px;
            }
            .help-link {
            background: #dd4b39;
            padding: 0 5px;
            color: #fff;
            font-weight: bold;
            display: inline-block;
            -moz-border-radius: 1em;
            -webkit-border-radius: 1em;
            border-radius: 1em;
            text-decoration: none;
            position: relative;
            top: 0px;
            }
            .help-link:visited {
            color: #fff;
            }
            .help-link:hover {
            color: #fff;
            background: #c03523;
            text-decoration: none;
            }
            .help-link:active {
            opacity: 1;
            background: #ae2817;
            }
            .amail-header-bar.centered {
            border: 0;
            height: 108px;
            }
            .amail-header-bar.centered .header .logo {
            float: none;
            margin: 40px auto 30px;
            display: block;
            }
            .amail-header-bar.centered .header .secondary-link {
            display: none
            }
            .amail-footer-bar {
            position: absolute;
            bottom: 0;
            height: 35px;
            width: 100%;
            border-top: 1px solid #e5e5e5;
            overflow: hidden;
            }
            .footer {
            padding-top: 7px;
            font-size: .85em;
            white-space: nowrap;
            line-height: 0;
            }
            .footer ul {
            float: left;
            max-width: 80%;
            min-height: 16px;
            padding: 0;
            }
            .footer ul li {
            color: #737373;
            display: inline;
            padding: 0;
            padding-right: 1.5em;
            }
            .footer a {
            color: #737373;
            }
            .banner {
            text-align: center;
            }
            .card {
            background-color: #f7f7f7;
            padding: 20px 25px 30px;
            margin: 0 auto 25px;
            width: 304px;
            -moz-border-radius: 2px;
            -webkit-border-radius: 2px;
            border-radius: 2px;
            -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            }
            .card > *:first-child {
            margin-top: 0;
            }
            .rc-button,
            .rc-button:visited {
            display: inline-block;
            min-width: 46px;
            text-align: center;
            color: #444;
            font-size: 14px;
            font-weight: 700;
            height: 36px;
            padding: 0 8px;
            line-height: 36px;
            -moz-border-radius: 3px;
            -webkit-border-radius: 3px;
            border-radius: 3px;
            -o-transition: all 0.218s;
            -moz-transition: all 0.218s;
            -webkit-transition: all 0.218s;
            transition: all 0.218s;
            border: 1px solid #dcdcdc;
            background-color: #f5f5f5;
            background-image: -webkit-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: -moz-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: -ms-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: -o-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: linear-gradient(top,#f5f5f5,#f1f1f1);
            -o-transition: none;
            -moz-user-select: none;
            -webkit-user-select: none;
            user-select: none;
            cursor: default;
            }
            .card .rc-button {
            width: 100%;
            padding: 0;
            }
            .rc-button.disabled,
            .rc-button[disabled] {
            opacity: .5;
            filter: alpha(opacity=50);
            cursor: default;
            pointer-events: none;
            }
            .rc-button:hover {
            border: 1px solid #c6c6c6;
            color: #333;
            text-decoration: none;
            -o-transition: all 0.0s;
            -moz-transition: all 0.0s;
            -webkit-transition: all 0.0s;
            transition: all 0.0s;
            background-color: #f8f8f8;
            background-image: -webkit-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: -moz-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: -ms-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: -o-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: linear-gradient(top,#f8f8f8,#f1f1f1);
            -moz-box-shadow: 0 1px 1px rgba(0,0,0,0.1);
            -webkit-box-shadow: 0 1px 1px rgba(0,0,0,0.1);
            box-shadow: 0 1px 1px rgba(0,0,0,0.1);
            }
            .rc-button:active {
            background-color: #f6f6f6;
            background-image: -webkit-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: -moz-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: -ms-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: -o-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: linear-gradient(top,#f6f6f6,#f1f1f1);
            -moz-box-shadow: 0 1px 2px rgba(0,0,0,0.1);
            -webkit-box-shadow: 0 1px 2px rgba(0,0,0,0.1);
            box-shadow: 0 1px 2px rgba(0,0,0,0.1);
            }
            .rc-button-submit,
            .rc-button-submit:visited {
            border: 1px solid #3079ed;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            background-color: #4d90fe;
            background-image: -webkit-linear-gradient(top,#4d90fe,#4787ed);
            background-image: -moz-linear-gradient(top,#4d90fe,#4787ed);
            background-image: -ms-linear-gradient(top,#4d90fe,#4787ed);
            background-image: -o-linear-gradient(top,#4d90fe,#4787ed);
            background-image: linear-gradient(top,#4d90fe,#4787ed);
            }
            .rc-button-submit:hover {
            border: 1px solid #2f5bb7;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.3);
            background-color: #357ae8;
            background-image: -webkit-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -moz-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -ms-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -o-linear-gradient(top,#4d90fe,#357ae8);
            background-image: linear-gradient(top,#4d90fe,#357ae8);
            }
            .rc-button-submit:active {
            background-color: #357ae8;
            background-image: -webkit-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -moz-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -ms-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -o-linear-gradient(top,#4d90fe,#357ae8);
            background-image: linear-gradient(top,#4d90fe,#357ae8);
            -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            }
            .rc-button-red,
            .rc-button-red:visited {
            border: 1px solid transparent;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            background-color: #d14836;
            background-image: -webkit-linear-gradient(top,#dd4b39,#d14836);
            background-image: -moz-linear-gradient(top,#dd4b39,#d14836);
            background-image: -ms-linear-gradient(top,#dd4b39,#d14836);
            background-image: -o-linear-gradient(top,#dd4b39,#d14836);
            background-image: linear-gradient(top,#dd4b39,#d14836);
            }
            .rc-button-red:hover {
            border: 1px solid #b0281a;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.3);
            background-color: #c53727;
            background-image: -webkit-linear-gradient(top,#dd4b39,#c53727);
            background-image: -moz-linear-gradient(top,#dd4b39,#c53727);
            background-image: -ms-linear-gradient(top,#dd4b39,#c53727);
            background-image: -o-linear-gradient(top,#dd4b39,#c53727);
            background-image: linear-gradient(top,#dd4b39,#c53727);
            }
            .rc-button-red:active {
            border: 1px solid #992a1b;
            background-color: #b0281a;
            background-image: -webkit-linear-gradient(top,#dd4b39,#b0281a);
            background-image: -moz-linear-gradient(top,#dd4b39,#b0281a);
            background-image: -ms-linear-gradient(top,#dd4b39,#b0281a);
            background-image: -o-linear-gradient(top,#dd4b39,#b0281a);
            background-image: linear-gradient(top,#dd4b39,#b0281a);
            -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            }
            .secondary-actions {
            text-align: center;
            }
            .hidden {
            height: 0px;
            width: 0px;
            overflow: hidden;
            visibility: hidden;
            display: none !important;
            }
            .stacked-label {
            display: block;
            font-weight: bold;
            margin: .5em 0;
            }
            .hidden-label {
            position: absolute !important;
            clip: rect(1px 1px 1px 1px); /* IE6, IE7 */
            clip: rect(1px, 1px, 1px, 1px);
            height: 0px;
            width: 0px;
            overflow: hidden;
            visibility: hidden;
            }

        </style>
        <style>
            .banner h1 {
            font-family: 'Open Sans', arial;
            -webkit-font-smoothing: antialiased;
            color: #555;
            font-size: 42px;
            font-weight: 300;
            margin-top: 0;
            margin-bottom: 20px;
            }
            .banner h2 {
            font-family: 'Open Sans', arial;
            -webkit-font-smoothing: antialiased;
            color: #555;
            font-size: 18px;
            font-weight: 400;
            margin-bottom: 20px;
            }
            .signin-card {
            width: 274px;
            padding: 40px 40px;
            }
            .signin-card .profile-img {
            width: 96px;
            height: 96px;
            margin: 0 auto 10px;
            display: block;
            -moz-border-radius: 50%;
            -webkit-border-radius: 50%;
            border-radius: 50%;
            }
            .signin-card .profile-name {
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            margin: 10px 0 0;
            min-height: 1em;
            }
            .signin-card .profile-email {
            font-size: 16px;
            text-align: center;
            margin: 10px 0 20px 0;
            min-height: 1em;
            }
            .signin-card input[type=email],
            .signin-card input[type=password],
            .signin-card input[type=text],
            .signin-card input[type=submit] {
            width: 100%;
            display: block;
            margin-bottom: 10px;
            z-index: 1;
            position: relative;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            }
            .one-amail p {
            margin: 0 0 10px;
            color: #555;
            font-size: 14px;
            text-align: center;
            }
            .one-amail p.create-account,
            .one-amail p.switch-account {
            margin-bottom: 60px;
            }
            .one-amail img {
            display: block;
            width: 210px;
            height: 17px;
            margin: 10px auto;
            }
        </style>
        <style>
            .need-help-reverse {
            float: right;
            }
            .remember .bubble-wrap {
            position: absolute;
            padding-top: 3px;
            -o-transition: opacity .218s ease-in .218s;
            -moz-transition: opacity .218s ease-in .218s;
            -webkit-transition: opacity .218s ease-in .218s;
            transition: opacity .218s ease-in .218s;
            left: -999em;
            opacity: 0;
            width: 314px;
            margin-left: -20px;
            }
            .remember:hover .bubble-wrap,
            .remember input:focus ~ .bubble-wrap,
            .remember .bubble-wrap:hover,
            .remember .bubble-wrap:focus {
            opacity: 1;
            left: inherit;
            }
            .bubble-pointer {
            border-left: 10px solid transparent;
            border-right: 10px solid transparent;
            border-bottom: 10px solid #fff;
            width: 0;
            height: 0;
            margin-left: 17px;
            }
            .bubble {
            background-color: #fff;
            padding: 15px;
            margin-top: -1px;
            font-size: 11px;
            -moz-border-radius: 2px;
            -webkit-border-radius: 2px;
            border-radius: 2px;
            -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            }
            #stay-signed-in {
            float: left;
            }
        </style>
        <style media="screen and (max-width: 800px), screen and (max-height: 800px)">
            .amail-header-bar.centered {
            height: 83px;
            }
            .amail-header-bar.centered .header .logo {
            margin: 25px auto 20px;
            }
            .card {
            margin-bottom: 20px;
            }
        </style>
        <style media="screen and (max-width: 580px)">
            html, body {
            font-size: 14px;
            }
            .amail-header-bar.centered {
            height: 73px;
            }
            .amail-header-bar.centered .header .logo {
            margin: 20px auto 15px;
            }
            .content {
            padding-left: 10px;
            padding-right: 10px;
            }
            .hidden-small {
            display: none;
            }
            .card {
            padding: 20px 15px 30px;
            width: 270px;
            }
            .footer ul li {
            padding-right: 1em;
            }
            .lang-chooser-wrap {
            display: none;
            }
        </style>
        <style media="screen and (max-width: 800px), screen and (max-height: 800px)">
            .banner h1 {
            font-size: 38px;
            margin-bottom: 15px;
            }
            .banner h2 {
            margin-bottom: 15px;
            }
            .one-amail p.create-account,
            .one-amail p.switch-account {
            margin-bottom: 30px;
            }

        </style>
        <style media="screen and (max-width: 580px)">
            .banner h1 {
            font-size: 22px;
            margin-bottom: 15px;
            }
            .signin-card {
            width: 260px;
            padding: 20px 20px;
            margin: 0 auto 20px;
            }
            .signin-card .profile-img {
            width: 72px;
            height: 72px;
            -moz-border-radius: 72px;
            -webkit-border-radius: 72px;
            border-radius: 72px;
            }
        </style>
        <!--registration page header -->
        <style>
            .amail-registration-header-bar {
            height: 71px;
            background: #fffff0;
            border-bottom: 1px solid #e5e5e5;
            overflow: hidden;
            }
            .main h1 {
            text-align: center;
            color: #555;
            font-size: 38px;
            font-weight: 300;
            margin-top: 50px;
            margin-bottom: 50px;
            }
            .sign-up {
            width: 500px;
            margin:0px auto;
            }
            .signup-box {
            margin: 0;
            border: 0;
            padding: 25px;
            background: #faebd7;
            border: 1px solid #e5e5e5;
            }
            .errormsg {
            margin: .5em 0 0;
            display: block;
            color: #dd4b39;
            line-height: 17px;
            }
        </style>
        <style>
            .header .signin,
            .header .signup {
            margin: 28px 0 0;
            float: right;
            font-weight: bold;
            }
            .header .signin-button,
            .header .signup-button {
            margin: 22px 0 0;
            float: right;
            }
            .header .signin-button a {
            font-size: 13px;
            font-weight: normal;
            }
            .header .signup-button a {
            position: relative;
            top: -1px;
            margin: 0 0 0 1em;
            }
            .a-button {
            display: inline-block;
            min-width: 46px;
            text-align: center;
            color: #444;
            font-size: 11px;
            font-weight: bold;
            height: 27px;
            padding: 0 8px;
            line-height: 27px;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border-radius: 2px;
            -webkit-transition: all 0.218s;
            -moz-transition: all 0.218s;
            -ms-transition: all 0.218s;
            -o-transition: all 0.218s;
            transition: all 0.218s;
            border: 1px solid #dcdcdc;
            background-color: #f5f5f5;
            background-image: -webkit-gradient(linear,left top,left bottom,from(#f5f5f5),to(#f1f1f1));
            background-image: -webkit-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: -moz-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: -ms-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: -o-linear-gradient(top,#f5f5f5,#f1f1f1);
            background-image: linear-gradient(top,#f5f5f5,#f1f1f1);
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
            cursor: default;
            }
            .a-button:hover {
            border: 1px solid #c6c6c6;
            color: #333;
            text-decoration: none;
            -webkit-transition: all 0.0s;
            -moz-transition: all 0.0s;
            -ms-transition: all 0.0s;
            -o-transition: all 0.0s;
            transition: all 0.0s;
            background-color: #f8f8f8;
            background-image: -webkit-gradient(linear,left top,left bottom,from(#f8f8f8),to(#f1f1f1));
            background-image: -webkit-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: -moz-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: -ms-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: -o-linear-gradient(top,#f8f8f8,#f1f1f1);
            background-image: linear-gradient(top,#f8f8f8,#f1f1f1);
            -webkit-box-shadow: 0 1px 1px rgba(0,0,0,0.1);
            -moz-box-shadow: 0 1px 1px rgba(0,0,0,0.1);
            box-shadow: 0 1px 1px rgba(0,0,0,0.1);
            }
            .a-button:active {
            background-color: #f6f6f6;
            background-image: -webkit-gradient(linear,left top,left bottom,from(#f6f6f6),to(#f1f1f1));
            background-image: -webkit-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: -moz-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: -ms-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: -o-linear-gradient(top,#f6f6f6,#f1f1f1);
            background-image: linear-gradient(top,#f6f6f6,#f1f1f1);
            -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
            }
            .a-button:visited {
            color: #666;
            }
            .a-button-submit {
            border: 1px solid #3079ed;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            background-color: #4d90fe;
            background-image: -webkit-gradient(linear,left top,left bottom,from(#4d90fe),to(#4787ed));
            background-image: -webkit-linear-gradient(top,#4d90fe,#4787ed);
            background-image: -moz-linear-gradient(top,#4d90fe,#4787ed);
            background-image: -ms-linear-gradient(top,#4d90fe,#4787ed);
            background-image: -o-linear-gradient(top,#4d90fe,#4787ed);
            background-image: linear-gradient(top,#4d90fe,#4787ed);
            }
            .a-button-submit:hover {
            border: 1px solid #2f5bb7;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.3);
            background-color: #357ae8;
            background-image: -webkit-gradient(linear,left top,left bottom,from(#4d90fe),to(#357ae8));
            background-image: -webkit-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -moz-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -ms-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -o-linear-gradient(top,#4d90fe,#357ae8);
            background-image: linear-gradient(top,#4d90fe,#357ae8);
            }
            .a-button-submit:active {
            background-color: #357ae8;
            background-image: -webkit-gradient(linear,left top,left bottom,from(#4d90fe),to(#357ae8));
            background-image: -webkit-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -moz-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -ms-linear-gradient(top,#4d90fe,#357ae8);
            background-image: -o-linear-gradient(top,#4d90fe,#357ae8);
            background-image: linear-gradient(top,#4d90fe,#357ae8);
            -webkit-box-shadow: inset 0 1px 2px rgb	a(0,0,0,0.3);
            -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            box-shadow: inset 0 1px 2px rgba(0,0,0,0.3);
            }
            .a-button-red:visited,
            .a-button-share:visited,
            .a-button-submit:visited {
            color: #fff;
            }
            .a-button-submit:focus,
            .a-button-share:focus,
            .a-button-red:focus {
            -webkit-box-shadow: inset 0 0 0 1px #fff;
            -moz-box-shadow: inset 0 0 0 1px #fff;
            box-shadow: inset 0 0 0 1px #fff;
            }
        </style>
        <style>
            .form-element {
            position: relative;
            margin: 0 0 1.5em;
            }
            .form-element label {
            display: inline-block;
            width: 100%;
            position: relative;
            }
            .form-element strong {
            margin: 0 0 .5em;
            display: inline-block;
            width: 100%;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
            }
            .form-element.multi-field label strong {
            display: none;
            }
            .form-element .placeholder-text {
            position: absolute;
            top: 8px;
            left: 10px;
            color: #999;
            display: none;
            }
            .form-element.nextstep-button {
            text-align: right;
            margin: 0;
            }
            input[type=text].form-error,
            input[type=password].form-error{
            border: 1px solid #dd4b39;
            }
        </style>


        <!--registration page !!!  few fun() for now, may be change later!!!!!!!-->
        <script type="text/javascript">
        function usernameCheck(username)
        {
        var xmlhttp_u;
        xmlhttp_u=new XMLHttpRequest();
        xmlhttp_u.onreadystatechange=function(){
        if (xmlhttp_u.readyState==4 && xmlhttp_u.status==200)
          {
          document.getElementById("errormsg_username").innerHTML=xmlhttp_u.responseText;
          }
        }
        xmlhttp_u.open("GET","/usernameManager?username="+username+"&t="+Math.random(),true);
        xmlhttp_u.send();
        }

        function passwordCheck(password,confirm,onStatu)
        {
        var xmlhttp_p;
        xmlhttp_p=new XMLHttpRequest();
        xmlhttp_p.onreadystatechange=function(){
        if (xmlhttp_p.readyState==4 && xmlhttp_p.status==200)
          {
          document.getElementById("errormsg_password").innerHTML=xmlhttp_p.responseText;
          }
        }
        xmlhttp_p.open("GET","/passwordManager?password="+password+"&confirm="+confirm+"&onStatu="+onStatu+"&t="+Math.random(),true);
        xmlhttp_p.send();
        }

        function confirmCheck(password,confirm,onStatu)
        {
        var xmlhttp_c;
        xmlhttp_c=new XMLHttpRequest();
        xmlhttp_c.onreadystatechange=function(){
        if (xmlhttp_c.readyState==4 && xmlhttp_c.status==200)
          {
          document.getElementById("errormsg_confirm").innerHTML=xmlhttp_c.responseText;
          }
        }
        xmlhttp_c.open("GET","/confirmManager?password="+password+"&confirm="+confirm+"&onStatu="+onStatu+"&t="+Math.random(),true);
        xmlhttp_c.send();
        }
        <!--   --------->
        function nextStep(username,password,confirm)
        {
        var xmlhttp_n;
        xmlhttp_n=new XMLHttpRequest();
        if (username == ""){
        usernameCheck(username);
        alert("please input your username");
        }
        xmlhttp_n.onreadystatechange=function(){
        if (xmlhttp_n.readyState==4 && xmlhttp_n.status==200)
          {
          document.getElementById("errormsg_nextStep").innerHTML=xmlhttp_n.responseText;
          }
        }
        xmlhttp_n.open("GET","/submitButtonManager?username="+username+"&password="+password+"&confirm="+confirm+"&t="+Math.random(),true);
        xmlhttp_n.send();
        }
        </script>


        <!-- welcomePage -->
        <style>
            .logout-button{
            float: right;
            margin: 22px 0 0;
            }
            .welcome-username{
            float: right;
            margin: 28px 10px 10px;
            }
            .action-card{
            width: 290px;
            padding: 5px;
            margin:0px auto;
            }
            .action-card ul {
            width: 100%;
            margin: 0;
            list-style: none;
            padding: 0;
            }
            .action-card ul.dual-action li {
            width: 49%;
            display: inline-block;
            }
            .action-card ul.dual-action li:first-child {
            border-right: 1px solid #d5d5d5;
            }
            .action-card ul li a{
            color: #427fed;
            cursor: pointer;
            text-decoration: none;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            width: 100%;
            display: inline-block;
            background: none;
            text-align: center;
            padding: 12px 0;
            outline: none;
            text-decoration: none;
            border: 0;
            }
            .email-choose-card {
            padding: 0;
            width: 354px;
            }
            .email-choose-card ol {
            width: 100%;
            margin: 0;
            list-style: none;
            padding: 0;
            }
            .email-choose-card ol li {
            height: 76px;
            border-bottom: 1px solid #d5d5d5;
            }
            .email-choose-card ol li.removed-all-notice {
            padding: 15px;
            height: auto;
            padding-left: 28px;
            background: #F0F8FF 5px 12px no-repeat;
            background-size: 24px 24px;
            }
            .email-choose-card ol li button,
            .email-choose-card ol li .remove-entry {
            padding: 15px 20px;
            display: block;
            width: 100%;
            height: 100%;
            outline: none;
            border: 0;
            cursor: pointer;
            text-align: left;
            background: #F0F8FF right center no-repeat;
            background-size: 21px 21px;
            background-position: 308px center;
            text-overflow: ellipsis;
            }
            .email-choose-card ol li button {
            border-left: 4px solid transparent;
            }
            .email-choose-card ol li button:focus {
            border-left: 4px solid #4c8aff;
            }
            .email-choose-card ol li .remove-entry {
            height: 46px;
            text-decoration: none;
            }
            .email-choose-card ol li a.remove-entry {
            width: 304px;
            }
            .email-choose-card ol.edit-list li button,
            .email-choose-card ol.edit-list li .remove-entry {
            background: #F0F8FF 308px center no-repeat;
            background-size: 21px 21px;
            }
            .email-choose-card ol li button img,
            .email-choose-card ol li .remove-entry img {
            float: left;
            -moz-border-radius: 50%;
            -webkit-border-radius: 50%;
            border-radius: 50%;
            height: 46px;
            width: 46px;
            }
            .email-choose-card ol li button span,
            .email-choose-card ol li .remove-entry span {
            display: block;
            margin-left: 58px;
            padding-right: 20px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            }
            .email-choose-card ol li button span.account-name,
            .email-choose-card ol li .remove-entry span.account-name {
            font-weight: bold;
            font-size: 16px;
            padding-top: 3px;
            color: #427fed;
            }
            .email-choose-card ol li button span.account-email,
            .email-choose-card ol li .remove-entry span.account-email {
            font-size: 14px;
            color: #404040
            }
            .email-choose-card ol li .email-only span.account-email {
            padding-top: 14px;
            }
            .email-choose-card ol li .remove-entry .simple-email {
            color: #404040;
            line-height: 46px;
            margin: 0;
            }
            .accountchooser-tooltip {
            -moz-box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
            -webkit-box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
            box-shadow: 0px 1px 2px rgba(0, 0, 0, 0.2);
            left: 50%;
            top: 90px;
            margin-left: 160px;
            }
            .action-card ul li a:hover,
            .action-card ul li a:visited,
            .action-card ul li input[type="submit"]:hover,
            .action-card ul li a:focus {
            text-decoration: underline;
            }

        </style>


        <!-- email main page-->
            <!--  search  -->
        <style>
            .search-part{
            float: left;
            margin: 28px 10px 10px;
            }
        </style>
            <!-- main part-->
        <style>
            .email-page-main-part-float {
            float: left;
            }
            .nn {
            min-height: 1px;
            float:left;
            }
            .L3{
            }
            .L4{
            float:left;
            }
            .nright {
            min-height: 1px;
            float: right;
            margin-top:35px;
            }
            .amI{
            width: 21px;
            height: 21px;
            }
        </style>
            <!-- main left part-->
        <style>
            .aeN {
            position: relative;
            margin-top: 0;
            }
            .oo {
            margin-right: 16px;
            }
            .aj9, .aib {
            margin-left: 0!important;
            }
            .pp {
            margin-left: 20px;
            }
            .nM {
            position: relative;
            font-size: 80%;
            }
            .aic, .n6 {
            margin-left: 20px;
            }
            .aki {
            padding: 60px 16px 19px 1px;
            }
            .aeN .ajl {
            overflow: hidden;
            }
            .aeN .ajl {
            overflow-y: auto;
            }
            .aj9, .aib {
            margin-left: 0!important;
            }
            .TK {
            width: 100%;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            }
            div.ain {
            padding-left: 28px!important;
            }
            div.aim {
            padding-left: 28px;
            }
            .aim {
            margin-top:5px;
            padding-left: 28px;
            }
            .ain {
            border-left: 4px solid #dd4b39;
            }
            .TO {
            padding-left: 0px;
            padding-right: 4px;
            }
            .TN {
            position: relative;
            padding-top: 6px;
            padding-bottom: 6px;
            }
            .aio {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            margin-left: 17px;
            color: #222;
            }
            .nU {
            cursor: pointer;
            margin-right: 4px;
            vertical-align: middle;
            }
            .n0 {
            cursor: pointer;
            color: #222;
            text-decoration: none;
            text-shadow: none;
            }
            .TO .n0 {
            color: #222;
            }
            div.aiq {
            margin-left: -4px;
            }
            .aiq {
            margin-left: -4px;
            }
            .nZ {
            background: transparent;
            }
            .nZ .nU, .nZ .n0 {
            color: #dd4b39!important;
            font-weight: bold;
            }
        </style>
        <style>
            .z0, .MX {
            margin-left: 8px;
            padding-top: 0;
            }
            .z0 {
            padding-left: 0;
            }
            .z0 {
            padding: 2px 4px 8px 17px;
            font-size: medium;
            }
            .z0 .T-I {
            min-width: 97px;
            margin-right: 0;
            }
            .T-I-KE {
            background-color: #d14836;
            background-image: -webkit-linear-gradient(top,#dd4b39,#d14836);
            background-image: linear-gradient(top,#dd4b39,#d14836);
            color: #fff;
            border: 1px solid transparent;
            border: 1px solid transparent;
            }
            .T-I-KE {
            -webkit-box-shadow: none;
            box-shadow: none;
            background-color: #d14836;
            background-image: -webkit-linear-gradient(top,#dd4b39,#d14836);
            background-image: linear-gradient(top,#dd4b39,#d14836);
            border: 1px solid transparent;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            text-transform: uppercase;
            }
            .T-I-KE:hover {
            -webkit-box-shadow: none;
            box-shadow: none;
            background-color: #c53727;
            background-image: -webkit-linear-gradient(top,#c53727,#c53727);
            background-image: linear-gradient(top,#c53727,#c53727);
            border: 1px solid transparent;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            text-transform: uppercase;
            }
            .T-I-KM {
            -webkit-box-shadow: none;
            box-shadow: none;
            background-color: #0000FF;
            background-image: -webkit-linear-gradient(top,#0000FF,#0000FF);
            background-image: linear-gradient(top,#0000FF,#0000FF);
            border: 1px solid transparent;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            text-transform: uppercase;
            }
            .T-I-KM:hover {
            -webkit-box-shadow: none;
            box-shadow: none;
            background-color: #0000CD;
            background-image: -webkit-linear-gradient(top,#0000CD,#0000CD);
            background-image: linear-gradient(top,#0000CD,#0000CD);
            border: 1px solid transparent;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            text-transform: uppercase;
            }
            .T-I-KD {
            -webkit-box-shadow: none;
            box-shadow: none;
            background-color: #FF8000;
            background-image: -webkit-linear-gradient(top,#FF8000,#FF8000);
            background-image: linear-gradient(top,#FF8000,#FF8000);
            border: 1px solid transparent;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            text-transform: uppercase;
            }
            .T-I-KD:hover {
            -webkit-box-shadow: none;
            box-shadow: none;
            background-color: #9F5000;
            background-image: -webkit-linear-gradient(top,#9F5000,#9F5000);
            background-image: linear-gradient(top,#9F5000,#9F5000);
            border: 1px solid transparent;
            color: #fff;
            text-shadow: 0 1px rgba(0,0,0,0.1);
            text-transform: uppercase;
            }
            .J-J5-Ji {
            position: relative;
            display: inline-block;
            }
            .T-I {
            -webkit-border-radius: 2px;
            border-radius: 2px;
            cursor: default;
            font-size: 11px;
            font-weight: bold;
            text-align: center;
            white-space: nowrap;
            margin-right: 16px;
            height: 27px;
            line-height: 27px;
            min-width: 54px;
            outline: 0;
            padding: 0 8px;
            }
            .J-J5-Ji {
            position: relative;
            display: -moz-inline-box;
            display: inline-block;
            }
        </style>
        <script type="text/javascript">
            function sendEmail() {
                window.open ("/sendEmail", "Send email", "height=550, width=600,top=400px,left=600px,toolbar=no, menubar=no, scrollbars=no, resizable=yes, location=no, status=no")
            }
            function checkEmail(){
            location.href="/checkEmailManager";
            }
        </script>

<!--show mail part -->
<style>
    .AO {
    }
    .aeJ {
    background: white;
    overflow-y: scroll;
    padding-right: 5px;
    }
    .aeF {
    padding: 0;
    vertical-align: bottom;
    }
    .table{
    position: relative;
    display: table;
    border-spacing: 2px;
    border-color: gray;
    }
    .cf {
    border-collapse: collapse;
    }
    .F {
    table-layout: fixed;
    width: 100%;
    border-spacing: 0;
    padding: 0;
    }
    .sc{

    }
    .ctbody {
    text-align:left;
    }
    .th1{
    height:50px;
    width:200px;
    }
    .th2{
    height:50px;
    width:600px;
    }
    .th3{
    height:50px;
    width:166px;
    padding-right:50px;
    }
    .th4{
    height:50px;
    width:100px;
    }
    .th11{
    height:50px;
    width:150px;
    }
    .th22{
    height:50px;
    width:200px;
    }
    .th33{
    height:50px;
    width:150px;
    }
    .th44{
    height:50px;
    width:200px;
    }
    .tdall{
    empty-cells: show;
    font-size: 80%;
    white-space: nowrap;
    overflow: hidden;
    height:30px;
    border: 1px solid #e5e5e5;
    border-right:none;
    border-left:none;
    }
    .td1{
    width:200px;
    }
    .td2{
    width:600px;
    padding-right:50px;
    }
    .td3{
    width:166px;
    }
    .td4{
    width:100px;
    }
    .td11{
    width:150px;
    }
    .td22{
    width:200px;
    }
    .td33{
    width:150px;
    }
    .td44{
    width:200px;
    }
    .tdoh{
    overflow: hidden;
    }
    .readed{
    background: #EAEAEE;
    }
    .unread{
    background: #FFFFFF;
    }
    .tdcanpoint{
    cursor: pointer;
    }
</style>

<!--view mail-->
<style>
    .vmborder{
    border: 1px solid #e5e5e5;
    border-right:none;
    border-left:none;
    }
    .vmFTSD{
    height:25px;
    }
    .rftext{
    border: 2px solid #e5e5e5;
    width:50%;height:195px;
    margin: 10px 10px 10px 10px;
    }
    .fform{
    border: 2px solid #e5e5e5;
    width:50%;
    height:308px;
    margin: 10px 10px 10px 10px;
    }
    .rfbutton{
    margin-left:2px;margin-top:25px;
    }
    .rffix{
    height:23px;
    }
    .vmFTSDtest{
    color: gray;
    }
    .amn {
    color: #999;
    height: 64px;

    border: 1px solid #e5e5e5;
    width:50%;
    margin-top:25px;
    }
    .amnn{
    padding: 8px 0 0 12px;
    }
    .ams {
    cursor: pointer;
    text-decoration: underline;
    }
    .select * {
      margin: 0;
      padding: 0;
    }
    .select {
      border:4px solid #B3D9D9;
      display: inline;
      }


</style>


</head>
<body>
$body$
</body>
</html>
>>
