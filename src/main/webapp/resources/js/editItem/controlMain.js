$( document ).ready(function() {

    function acceptDisabled(){
        var isCheckbox=$('#buyItNow').is(':checked');
                if(isCheckbox){
                    $('fieldset').prop('disabled',true);
                }else{
                    $('fieldset').prop('disabled',false);
                }
    }

    $('#buyItNow').change(
        function(event){
            var isCheckbox=$(this).is(':checked');
            if(isCheckbox){
                $('fieldset').prop('disabled',true);
            }else{
                $('fieldset').prop('disabled',false);
            }
        }
    );

    $('#reset').click(
        function(event){
            //$('#form')[0].reset();
            $('fieldset').prop('disabled',false);
        }
    );

    acceptDisabled();
});
