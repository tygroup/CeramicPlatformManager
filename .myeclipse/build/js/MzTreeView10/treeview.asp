<%@ Language=VBScript codepage=936  %>
<%  Option Explicit %>
<%
  Dim Conn, rs
  Set Conn  = Server.CreateObject("ADODB.Connection")
  Set rs    = Server.CreateObject("ADODB.Recordset")

  Conn.Open  "Provider=Microsoft.Jet.OLEDB.4.0; Data Source="& Server.MapPath("./") &"\tree.mdb;"
  rs.open "Select ID, parentId, text, hint, icon, data, url, target, method From treeview order by ID", Conn
%>
<html>
  <head>
    <title>÷��ѩ������ - ��ҳ�ű��ؼ��� MzTreeView10</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <meta name="author" content="�Ʒ���(meizz��÷��ѩ)://www.meizz.com">
    <script language="JavaScript" src="MzTreeView10.js"></script>
    <link href="http://www.meizz.com/Scripts/Global.css" type="text/css" rel="stylesheet">
    <style>
    A.MzTreeview
    {
      font-size: 9pt;
      padding-left: 3px;
    }
    </style>
  </head>

  <body class=frame>
    <SCRIPT LANGUAGE="JavaScript">
    <!--
    window.tree = new MzTreeView("tree");

    tree.icons["property"] = "property.gif";
    tree.icons["css"] = "collection.gif";
    tree.icons["book"]  = "book.gif";
    tree.iconsExpand["book"] = "bookopen.gif"; //չ��ʱ��Ӧ��ͼƬ
    tree.setIconPath("http://www.meizz.com/Icons/TreeView/"); //�������·��
<%
  Dim node
  Dim reg : set reg = new RegExp : reg.global=True : reg.pattern=";"
  Dim id, parentId, text, hint, icon, data, url, target, method
  do while not rs.eof
    '����������Ŀ�Ƚ϶��ʱ��(�������1000)��������ȶ���ʱ����Щ�������ɾ�̬��ҳ������
    node = VBCrLf &"    tree.nodes["""& rs("parentId") &"_"& rs("id") &"""] = """
    node = node &"text:"& reg.replace(rs("text"), chr(15)) &";"
    if rs("hint")<>"" then node = node &"hint:"& reg.replace(rs("hint"), chr(15)) &";"
    if rs("icon")<>"" then node = node &"icon:"& rs("icon") &";"
    if rs("data")<>"" then node = node &"data:"& reg.replace(rs("data"), chr(15)) &";"
    if rs("url")<>""  then node = node &"url:"&  reg.replace(rs("url"), chr(15)) &";"
    if rs("target")<>"" then node = node &"target:"& rs("target") &";"
    if rs("method")<>"" then node = node &"method:"& reg.replace(rs("method"), chr(15)) &";"
    response.write node &"""" '���ɽڵ���Ϣ
    rs.movenext
  loop
%>
    tree.setURL("Catalog.asp");
    tree.setTarget("MzMain");
    document.write(tree.toString());    //����� obj.innerHTML = tree.toString();
    //-->
    </SCRIPT>
  </body>
</html>
<%
  rs.close : set rs = nothing : Conn.close : set Conn = nothing
%>