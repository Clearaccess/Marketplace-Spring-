'use strict';
var view = (function (win) {

    var user,
        items;

    var init = function () {

        $('.panes').click(function (event) {
            $('.panes').removeClass('active');
            $(this).addClass('active');
        });

        _subscribeEvents();

        $.ajax({
            url: "http://localhost:8888/items",
            type: "GET",
            dataType: "json",
        })
            .done(function (data, status, jqxhr) {
                items = data;
                $.ajax({
                    url: "http://localhost:8888/user",
                    type: "GET",
                    dataType: "json",
                })
                    .done(function (data, status, jqxhr) {
                        user = data;
                        _showItems(items, user);
                    })
                    .fail(function (data, status, jqxhr) {
                        console.log("ERROR: No get user");
                        _showItems(items, user);
                    });
            })
            .fail(function (data, status, jqxhr) {
                console.log("ERROR: No get items");
            });
    };

    var _showItems = function (items, user) {
        var i,
            len = items.length;

        for (i = 0; i < len; i++) {
            _showItem(items[i], user);
        }
    };

    var _showItemsBySubstring=function(items,user, field, keyWord){
        var i,
            len = items.length,
            reg=new RegExp(keyWord.toLowerCase(),"g");

        _clearTable();

        for (i = 0; i < len; i++) {
            if(field==1 && reg.test(items[i].itemId)){
                _showItem(items[i], user);
                continue;
            }
            if(field==2 && reg.test(items[i].title.toLowerCase())){
                _showItem(items[i], user);
                continue;
            }
            if(field==3 && reg.test(items[i].description.toLowerCase())){
                _showItem(items[i], user);
                continue;
            }
        }
    };

    var _showItem = function (item, user) {
        var el = '<tr>' +
            '<td class="text-center">' +
            item.itemId +
            '</td>' +
            '<td class="text-center">' +
            item.title +
            '</td>' +
            '<td class="text-center">' +
            ((item.description != null) ? item.description : '') +
            '</td>' +
            '<td class="text-center">' +
            item.fullNameSeller +
            '</td>' +
            '<td class="text-center">' +
            item.startPrice +
            '</td>' +
            '<td class="text-center">' +
            ((item.bidIncrement != 0.0) ? item.bidIncrement : '') +
            '</td>' +
            '<td class="text-center">' +
            ((item.bestOffer != 0.0) ? item.bestOffer : '') +
            '</td>' +
            '<td class="text-center">' +
            ((item.fullNameBidder != null) ? item.fullNameBidder : '') +
            '</td>' +
            '<td class="text-center">' +
            ((!item.buyItNow) ? item.stopDate : '') +
            '</td>' +
            ((item.buyItNow) ? '<td class="text-center">' + ((user != undefined && user.userId != item.sellerId) ? _renderBiddingBuy(item) : '') + '</td>' : '') +
            ((!item.buyItNow) ? '<td class="text-center">' + ((user != undefined && user.userId != item.sellerId) ? _renderBiddingDoBid(item) : '') + '</td>' : '') +
            '</tr>';

        $("#tBody").append(el);
    }

    var _renderBiddingBuy = function (item) {
        var el = '<form class="form-inline" method="POST" action="buyItem">' +
            '<input type="hidden" name="itemId" value="' +
            item.itemId +
            '" />' +
            '<button type="submit" class="btn btn-primary">Buy</button>' +
            '</form>';
        return el;
    };

    var _renderBiddingDoBid = function (item) {
        var el = '<form class="form-inline" method="POST" action="makeBid">' +
            '<div class="form-group">' +
            '<label class="sr-only" for="cost">cost</label>' +
            '<div class="input-group">' +
            '<input name="bid" type="number" class="form-control" id="cost" min="' +
            item.startPrice +
            '" value="' +
            item.startPrice +
            '" step="' +
            item.bidIncrement +
            '" required>' +
            '</div>' +
            '</div>' +
            '<input type="hidden" name="itemId" value="' +
            item.itemId +
            '" />' +
            '<button type="submit" class="btn btn-primary">Bid</button>' +
            '</form>';

        return el;
    };

    var _clearTable=function(){
        $('#tBody').children().remove();
    };

    var _subscribeEvents = function () {
        $("#bSearch").on("click", _searchBySubstr);
    };

    var _searchBySubstr = function () {
        var searchField = $("#sSearchField").val(),
            keyWord = $("#inputKeyWord").val();
        console.log("sf: " + searchField + " kw: " + keyWord);

        _showItemsBySubstring(items,user,searchField,keyWord);
    };

    init();

    return {
        init: init
    };
})(window);