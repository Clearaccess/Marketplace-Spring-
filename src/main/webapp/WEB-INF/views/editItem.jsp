<!DOCTYPE html>

<jsp:directive.page import="to.Item" />

<html>

<head>
    <title>Edit Item</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/editItem.css">
</head>

<body>
    <jsp:directive.include file="toolbar.jsp"/>

    <div class="container">
        <form class="form-horizontal" id="form" action="edit" method="POST">
            <jsp:scriptlet>
                <![CDATA[
                    if(request.getAttribute("item")!=null) { 
                ]]>
            </jsp:scriptlet>
            <jsp:scriptlet>
                <![CDATA[
                    Item item=(Item)request.getAttribute("item");
                ]]>
            </jsp:scriptlet>
            <div class="form-group">

                <div class="row">
                    <label for="titleOfItem" class="col-sm-2 control-label">Title of item:</label>
                    <div class="col-sm-10">
                        <input name="title" value="<jsp:expression> item.getTitle() </jsp:expression>" form="form" type="text" class="form-control" id="titleOfItem" placeholder="Title of item" required autofocus>
                    </div>
                </div>
                <div class="row">
                    <label for="description" class="col-sm-2 control-label">Description:</label>
                    <div class="col-sm-10">
                        <jsp:scriptlet>
                            <![CDATA[
                                if(item.getDescription()!=null) { 
                            ]]>
                        </jsp:scriptlet>

                        <textarea name="description" value="<jsp:expression> item.getDescription() </jsp:expression>" form="form" class="form-control" rows="5" id="description"></textarea>

                        <jsp:scriptlet>
                            <![CDATA[
                                } else {
                            ]]>
                        </jsp:scriptlet>

                        <textarea name="description" value="" form="form" class="form-control" rows="5" id="description"></textarea>
                            
                        <jsp:scriptlet>
                            <![CDATA[
                                }
                            ]]>
                        </jsp:scriptlet>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <label for="startPrice" class="col-sm-2 control-label">Start price: </label>
                    <div class="col-sm-6">
                        <input name="startPrice" form="form" type="number" class="form-control" id="startPrice" placeholder="Start price" min="1" value="<jsp:expression>item.getStartPrice()</jsp:expression>" step="<jsp:expression>item.getBidIncrement() </jsp:expression>" required>
                    </div>
                </div>
                <fieldset>
                    <jsp:scriptlet>
                        <![CDATA[
                            if(item.isBuyItNow()) { 
                        ]]>
                    </jsp:scriptlet>

                    <div class="row">
                        <label for="bidIncrement" class="col-sm-2 control-label">Bid increment: </label>
                        <div class="col-sm-6">
                            <input name="bidIncrement" form="form" type="number" class="form-control" id="bidIncrement" placeholder="Bid increment" min=0.05 value="0.05" step="0.05" required>
                        </div>
                    </div>
                    <div class="row">
                        <label for="timeLeft" class="col-sm-2 control-label">Time left: </label>
                        <div class="col-sm-6">
                            <input name="time" min=00:00 value="00:00" form="form" type="time" class="form-control" id="timeLeft" placeholder="Time left" required>
                        </div>
                    </div>

                    <jsp:scriptlet>
                        <![CDATA[
                            } else {
                        ]]>
                    </jsp:scriptlet>

                    <div class="row">
                        <label for="bidIncrement" class="col-sm-2 control-label">Bid increment: </label>
                        <div class="col-sm-6">
                            <input name="bidIncrement" form="form" type="number" class="form-control" id="bidIncrement" placeholder="Bid increment" min=0.05 value="<jsp:expression>item.getBidIncrement()</jsp:expression>" step="0.05" required>
                        </div>
                    </div>
                    <div class="row">
                        <label for="timeLeft" class="col-sm-2 control-label">Time left: </label>
                        <div class="col-sm-6">
                            <input name="time" min=00:00 value="<jsp:expression>item.getTimeLeft()/3600</jsp:expression>:<jsp:expression>item.getTimeLeft()%3600/60</jsp:expression>" form="form" type="time" class="form-control" id="timeLeft" placeholder="Time left" required>
                        </div>
                    </div>

                    <jsp:scriptlet>
                        <![CDATA[
                            }
                        ]]>
                    </jsp:scriptlet>

                </fieldset>
            </div>
            <div class="form-group">
                <label for="buyItNow" class="col-sm-2 control-label">Buy It Now: </label>
                <div class="checkbox col-sm-1">
                    <label>
                        <jsp:scriptlet>
                            <![CDATA[
                                if(item.isBuyItNow()) { 
                            ]]>
                        </jsp:scriptlet>

                        <input name="buy" form="form" type="checkbox" value="buyItNow" id="buyItNow" checked>
                        
                        <jsp:scriptlet>
                            <![CDATA[
                                } else {
                            ]]>
                        </jsp:scriptlet>
                        
                        <input name="buy" form="form" type="checkbox" value="buyItNow" id="buyItNow">

                        <jsp:scriptlet>
                            <![CDATA[
                                }
                            ]]>
                        </jsp:scriptlet>
                    </label>
                </div>
            </div>
            <input name="itemId" form="form" type="hidden" value="<jsp:expression> item.getItemId() </jsp:expression>" id="buyItNow">
            <jsp:scriptlet>
                <![CDATA[
                    } else {
                ]]>
            </jsp:scriptlet>

            <div class="form-group">

                <div class="row">
                    <label for="titleOfItem" class="col-sm-2 control-label">Title of item:</label>
                    <div class="col-sm-10">
                        <input name="title" value="" form="form" type="text" class="form-control" id="titleOfItem" placeholder="Title of item" required autofocus>
                    </div>
                </div>
                <div class="row">
                    <label for="description" class="col-sm-2 control-label">Description:</label>
                    <div class="col-sm-10">
                        <textarea name="description" value="" form="form" class="form-control" rows="5" id="description"></textarea>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <label for="startPrice" class="col-sm-2 control-label">Start price: </label>
                    <div class="col-sm-6">
                        <input name="startPrice" form="form" type="number" class="form-control" id="startPrice" placeholder="Start price" min="1" value="1" step="0.05" required>
                    </div>
                </div>
                <fieldset>
                    <div class="row">
                        <label for="bidIncrement" class="col-sm-2 control-label">Bid increment: </label>
                        <div class="col-sm-6">
                            <input name="bidIncrement" form="form" type="number" class="form-control" id="bidIncrement" placeholder="Bid increment" min=0.05 value=0.05 step="0.05" required>
                        </div>
                    </div>
                    <div class="row">
                        <label for="timeLeft" class="col-sm-2 control-label">Time left: </label>
                        <div class="col-sm-6">
                            <input name="time" min=00:00 value="00:00" form="form" type="time" class="form-control" id="timeLeft" placeholder="Time left" required>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="form-group">
                <label for="buyItNow" class="col-sm-2 control-label">Buy It Now: </label>
                <div class="checkbox col-sm-1">
                    <label>
                        <input name="buy" form="form" type="checkbox" value="1" id="buyItNow">
                    </label>
                </div>
            </div>
            <input name="itemId" form="form" type="hidden" value="" id="buyItNow">

            <jsp:scriptlet>
                <![CDATA[
                    }
                ]]>
            </jsp:scriptlet>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <button type="submit" class="btn btn-primary btn-lg" id="save">Publish/ Save</button>
                    <button type="reset" class="btn btn-primary btn-lg" id="reset">Reset</button>
                </div>
            </div>
        </form>

    </div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/editItem/controlMain.js"></script>
</body>

</html>