<form class="form-inline" method="POST" action="buyItem">
    <input type="hidden" name="itemId" value="<jsp:expression> items.get(i).getItemId() </jsp:expression>"/>
    <button type="submit" class="btn btn-primary">Buy</button>
</form>