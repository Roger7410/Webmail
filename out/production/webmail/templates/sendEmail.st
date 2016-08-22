sendEmail(ea_address,atts,to,subject,content) ::= <<

<div class="wrapper">
    <div class="content clearfix">
        <form novalidate method="post" action="/" enctype="multipart/form-data">
                <input id="from" name="from" type="text" class=""
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;"
                       value=$ea_address$ >
                <input id="to" name="to" type="text" class="" placeholder="To"
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;"
                       value=$to$>
                <input id="subject" name="subject" type="text" class="" placeholder="Subject"
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;"
                       value=$subject$>
                <textarea spellcheck="true" id="content" name="content" cols="30" rows="10" spellcheck="true" placeholder="Content"
                        style="width:100%;height:250px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;"
                        >$content$</textarea>
                <input id="send-button" name="send-button" type="submit" value="Send" class="a-button a-button-submit"
                            style="margin-left:10px;margin-top:10px;margin-right:30px;"  onclick="this.form.action='/sendEmailManager'">
                Add Attachment:<input id="fileName" type="file" name="fileName">
                <input id="add" name="add" type="submit" value="Add"  onclick="this.form.action='/uploadManager'">
        </form>
        <ul>
        $atts:{a|
            <li>
                <p style="color: blue;margin-left:55px;">
                $a$
                </p>
            </li>
        }$
        </ul>

    </div>
</div>
>>