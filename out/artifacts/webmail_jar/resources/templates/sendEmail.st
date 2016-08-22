sendEmail(ea_address,atts) ::= <<

<div class="wrapper">
    <div class="content clearfix">
        <form novalidate method="post" action="/sendEmailManager">
            <div>
                <input id="from" name="from" type="text" class="" value=$ea_address$
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;">
            </div>
            <div>
                <input id="to" name="to" type="text" class="" placeholder="To"
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;">
            </div>
            <div>
                <input id="subject" name="subject" type="text" class="" placeholder="Subject"
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;">
            </div>
            <div>
                <textarea id="content" name="content" cols="30" rows="10" spellcheck="true" placeholder="Content"
                 style="width:100%;height:250px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;"></textarea>
            </div>
            <div style="float:left;margin: 10px 10px 10px 10px;">
            <input id="send-button" name="send-button" type="submit" value="Send" class="a-button a-button-submit"
                            style="margin-left:10px;margin-top:10px;">
            </div>
        </form>
        <div style="float:left;margin: 10px 10px 10px 10px;">
        <form method="post" action="/uploadManager" enctype="multipart/form-data">
            Add Attachment:<input id="fileName" type="file" name="fileName">
            <input type="submit" value="Add">
        </form>
        <ul>
        $atts:{a|
            <li>
                <p style="color: blue;">
                $a$
                </p>
            </li>
        }$
        </ul>
        </div>

    </div>
</div>
>>