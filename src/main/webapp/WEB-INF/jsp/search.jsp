<html>
<head>
    <title>Search books</title>
</head>
<body>

<h2>Form for book search</h2>
<form method="GET" action="search">
    <table>
        <tr>
            <td>Authors:</td><td><input name="authors" /></td>
        </tr>
        <tr>
            <td>Name of book:</td><td><input name="name" /></td>
        </tr>
        <tr>
            <td>Tags:</td><td><input name ="tags" /></td>
        </tr>
        <tr>
            <td>Publishing year:</td><td><input name="year" /></td>
        </tr>
        <tr>
            <td>Serial number of book:</td><td><input name="num" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>