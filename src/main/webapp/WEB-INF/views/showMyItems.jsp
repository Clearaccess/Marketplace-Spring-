<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Items</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/showItems.css">
</head>

<body>
    <jsp:directive.include file="toolbar.jsp"/>

    <div class="container-fluid">

        <div class="row">
            <div class="col-sm-offset-1 col-sm-11">
                <form class="form-inline">
                    <h3 class="form-signin-heading">Search parameters</h3>
                    <h5 class="form-signin-heading">Keyword:</h5>
                    <div class="form-group">
                        <label class="sr-only" for="inputKeyWord">Key word</label>
                        <input type="text" class="form-control" id="inputKeyWord" placeholder="Key word">
                    </div>
                    <select class="form-control">
                        <option>Category</option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                    </select>
                    <button type="submit" class="btn btn-primary">Search</button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12" id="pane">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="panes"><a href="showItems">Show All Items</a></li>
                    <li role="presentation" class="active panes"><a href="showMyItems">Show My Items</a></li>
                </ul>
            </div>
        </div>
        <div class="row"></div>
        <div class="row">
            <div class="col-sm-12">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <tbody>
                            <tr>
                                <td class="text-center">2</td>
                                <td class="text-center">3</td>
                                <td class="text-center">4</td>
                                <td class="text-center">5</td>
                                <td class="text-center">6</td>
                                <td class="text-center">7</td>
                                <td class="text-center">8</td>
                                <td class="text-center">9</td>
                                <td class="text-center">
                                    <p class=""> bid </p>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center">2</td>
                                <td class="text-center">3</td>
                                <td class="text-center">4</td>
                                <td class="text-center">5</td>
                                <td class="text-center">6</td>
                                <td class="text-center">7</td>
                                <td class="text-center">8</td>
                                <td class="text-center">9</td>
                                <td class="text-center">
                                    <form class="form-inline">
                                        <div class="form-group">
                                            <label class="sr-only" for="cost">cost</label>
                                            <div class="input-group">
                                                <input type="number" class="form-control" id="cost" min="0" step="0.05" required>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Bid</button>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center">2</td>
                                <td class="text-center">3</td>
                                <td class="text-center">4</td>
                                <td class="text-center">5</td>
                                <td class="text-center">6</td>
                                <td class="text-center">7</td>
                                <td class="text-center">8</td>
                                <td class="text-center">9</td>
                                <td class="text-center">
                                    <form class="form-inline">
                                        <div class="form-group">
                                            <label class="sr-only" for="cost">cost</label>
                                            <div class="input-group">
                                                <input type="number" class="form-control" id="cost" min="0" step="0.05" required>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Bid</button>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center">2</td>
                                <td class="text-center">3</td>
                                <td class="text-center">4</td>
                                <td class="text-center">5</td>
                                <td class="text-center">6</td>
                                <td class="text-center">7</td>
                                <td class="text-center">8</td>
                                <td class="text-center">9</td>
                                <td class="text-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary">Buy</button>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="text-center">2</td>
                                <td class="text-center">3</td>
                                <td class="text-center">4</td>
                                <td class="text-center">5</td>
                                <td class="text-center">6</td>
                                <td class="text-center">7</td>
                                <td class="text-center">8</td>
                                <td class="text-center">9</td>
                                <td class="text-center">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary">Buy</button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                        <thead>
                            <tr class="info">
                                <th class="text-center">Items</th>
                                <th/>
                                <th/>
                                <th/>
                                <th/>
                                <th/>
                                <th/>
                                <th/>
                                <th/>
                                <th/>
                            </tr>
                            <tr>
                                <th class="text-center">
                                    Title
                                </th>
                                <th class="text-center">
                                    Description
                                </th>
                                <th class="text-center">
                                    Seller
                                </th>
                                <th class="text-center">
                                    Start price
                                </th>
                                <th class="text-center">
                                    Bid inc
                                </th>
                                <th class="text-center">
                                    Best offer
                                </th>
                                <th class="text-center">
                                    Bidder
                                </th>
                                <th class="text-center">
                                    Stop date
                                </th>
                                <th class="text-center">
                                    Action
                                </th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script src="../js/jquery-3.1.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/showItems/controlMain.js"></script>
</body>

</html>