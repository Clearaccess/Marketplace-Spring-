$('#form').validate({
  rules: {
    fullName: {
    required: true
    },
    billingAddress: {
    required: true
    },
    login: {
    email: true,
    required: true
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