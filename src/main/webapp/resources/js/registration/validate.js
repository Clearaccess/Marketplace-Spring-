jQuery.validator.addMethod("notEqual", function(value, element, params) {
  return this.optional(element) || value != $(params).val();
}, "Please enter value a different about Full Name");

$('#form').validate({
  rules: {
    fullName: {
    required: true
    },
    billingAddress: {
    required: true
    },
    login: {
    required: true,
    notEqual: '#fullName'
    },
    password: {
        minlength: 6,
        required: true
    },
    rePassword: {
        minlength: 6,
        required: true,
        equalTo: '#password'
    }
  },
  messages: {
    fullName: {
    required: "Please enter your full name"
    },
    billingAddress: {
    required: "Please enter your billing address"
    }
  },
  ignore: "#bReset"
});