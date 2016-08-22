sendEmailWithTo(ea_address,to) ::= <<

<div class="wrapper">
    <div class="content clearfix">
        <form novalidate method="post" action="/sendEmailManager">
            <div>
                <input id="from" name="from" type="text" class="" value=$ea_address$
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;">
            </div>
            <div>
                <input id="to" name="to" type="text" class="" value=$to$
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;">
            </div>
            <div>
                <input id="subject" name="subject" type="text" class="" placeholder="Subject"
                       style="width:100%;height:30px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;">
            </div>
            <div>
                <textarea id="content" name="content" cols="30" rows="10" spellcheck="true" placeholder="Content"
                 style="width:100%;height:300px;border: 1px solid gray;margin: 10px 10px 10px 10px;margin-right:10px;"></textarea>
            </div>
            <div>
                <input id="send-button" name="send-button" type="submit" value="Send" class="a-button a-button-submit"
                style="margin-left:10px;margin-top:10px;">
            </div>
        </form>
    </div>
</div>
>>