<form class="form-inline" method="POST" action="makeBid">
    <div class="form-group">
        <label class="sr-only" for="cost">cost</label>
        <div class="input-group">
            <input name="bid" type="number" class="form-control" id="cost" min="<jsp:expression> items.get(i).getStartPrice() </jsp:expression>" value="<jsp:expression> items.get(i).getStartPrice() </jsp:expression>" step="<jsp:expression> items.get(i).getBidIncrement() </jsp:expression>" required>
        </div>
    </div>
    <input type="hidden" name="itemId" value="<jsp:expression> items.get(i).getItemId() </jsp:expression>" />
    <button type="submit" class="btn btn-primary">Bid</button>
</form>