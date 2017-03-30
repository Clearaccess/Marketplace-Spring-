<form class="form-inline" method="POST" action="makeBid">
    <div class="form-group">
        <label class="sr-only" for="cost">cost</label>
        <div class="input-group">
            <input name="bid" type="number" class="form-control" id="cost" min="${item.getStartPrice()}" value="${item.getStartPrice()}" step="${item.getBidIncrement()}" required>
        </div>
    </div>
    <input type="hidden" name="itemId" value="${item.getItemId()}" />
    <button type="submit" class="btn btn-primary">Bid</button>
</form>