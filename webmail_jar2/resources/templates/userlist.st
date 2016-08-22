userlist(users) ::= <<
<p>
Call another template:
<table>
$users:userrow()$
</table>

<p>
OR in-line the template application:

<table>
$users:{u|
<tr>
  <td>$u.username$</td>
</tr>
}$
</table>
>>
